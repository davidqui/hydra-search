package co.mil.ejercito.hydrasearch.controller;

//import static co.mil.ejercito.controller.ControllerInterface.MSG_ERROR;
//import static co.mil.ejercito.controller.ControllerInterface.MSG_OK;
import co.mil.ejercito.hydrasearch.entities.*;
import co.mil.ejercito.hydrasearch.services.AmenazaService;
import co.mil.ejercito.hydrasearch.services.ClasificacionService;
import co.mil.ejercito.hydrasearch.services.CredibilidadService;
import co.mil.ejercito.hydrasearch.services.ExactitudService;
import co.mil.ejercito.hydrasearch.services.FactEstabilidadService;
import co.mil.ejercito.hydrasearch.services.TipoDocService;
import co.mil.ejercito.hydrasearch.services.TransaccionService;
import co.mil.ejercito.hydrasearch.services.UnidadService;
import co.mil.ejercito.hydrasearch.services.UsuarioService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controlador para {@link Transaccion}.
 * @author aherreram@imi.mil.co
 * @since Noviembre 21, 2018 feature_1 (HYDRA-GETDE)
 */
//@RestController
@Controller
@RequestMapping("/transaccion")
public class TransaccionController {

    private static final Logger LOG = Logger.getLogger(TransaccionController.class.getName());
       
    @Autowired
    private TransaccionService transaccionService;
    @Autowired
    private FactEstabilidadService factEstabilidadService;
    @Autowired
    private AmenazaService amenazaService;
    @Autowired
    private UnidadService unidadService;
    @Autowired
    private ClasificacionService clasificacionService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TipoDocService tipoDocService;
    @Autowired
    private CredibilidadService credibilidadService;
    @Autowired
    private ExactitudService exactitudService;
        
      
    @Value("${co.mil.ejercito.hydrasearch.archivos.root}")
    private String directorioRoot;
    
    /**
     * Metodo que devuelve la hora actual del sistema en milisegundos, sumado con un numero 
     * aleatorio de tres digitos que identifica el directorio 
     * en donde se almacenan los archivos y parte del nombre de los documentos.
     * 
     * @return Codigo de 13 digitos
     */
    public String generarCodigoSubDirectorio(){
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(100, 999);
        String codigo=String.valueOf(System.currentTimeMillis()+numeroAleatorio);
        System.out.println("<<<<<<<Nombre del Subdirectorio = " + codigo);
        return codigo;
    }


    
    /**
     * Metodo que permite guardar en la base de datos la totalidad 
     * de los datos que requiere un evento.
     * 
     * @param transaccion Objeto Evento modelado con los datos del formulario.
     * @param redirectAttributes Apuntador Clase Spring.
     * @param files Lista de los archivos anexos que envia el formulario.
     * @return Redirecciona hacia ftl que lista la totalidad de los eventos creados.
     */
//    @Transactional
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saves(Transaccion transaccion, Documento documento, Transicion transicion, String login, RedirectAttributes redirectAttributes, @RequestParam("docFile") MultipartFile files) {
        try {
        String subDirectorio = generarCodigoSubDirectorio();
        String directorioFinal=transaccionService.generarEstructuraRoot(directorioRoot);
        transaccionService.crearDirectorios(directorioFinal, subDirectorio);
        String ubicacionFile=transaccionService.guardarArchivo(files, directorioFinal, subDirectorio);
        Documento documentoData = transaccionService.create(documento, files, ubicacionFile);


        Transaccion transaccionData= transaccionService.create(transaccion,documentoData);

        Usuario usuarioCreador= new Usuario();
        usuarioCreador.setLogin(login);
        Usuario usuarioAsignado= new Usuario();
        usuarioCreador.setLogin(transaccionData.getUsuarioValidador());
        transaccionService.createTransicionUserCreador(transaccionData,usuarioCreador);
        transaccionService.createTransicionUserAsignado(transaccionData, usuarioAsignado);

////        redirectAttributes.addFlashAttribute(MSG_OK, "Ha creado exitosamente el Evento No.: " + " "
////                + nuevo.getId());


        } catch (IOException ex) {
            Logger.getLogger(TransaccionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/index";
    }
    
      
    /**
     * Metodo que permite buscar un evento en especial por medio de su PrimaryKey.
     * 
     * @param id PrimaryKey del Evento
     * @param model Apuntador Clase Model Spring
     * @return Redirecciona hacia ftl que visualiza la informacion de determinado evento.
     */
    @RequestMapping(path = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, Model model) {
        Transaccion transaccion = transaccionService.findById(id);
        return "/index";
    }
    
    /**
     * Metodo que permite descargar un archivo anexo al evento.
     * 
     * @param response Representa la respuesta del servidor
     * @param codigo Valor recibido desde el formulario que contiene el numero que identifica el archivo
     * @throws IOException 
     */
//    @RequestMapping(path = "/descargar/{codigo}", method = RequestMethod.GET)
//    public void descargarArchivo(HttpServletResponse response,@PathVariable("codigo") String codigo) throws IOException {
//        Documento anexoData=anexoService.find(codigo);
//        try {
//            String nombreFichero = codigo;
//            String subDirectorio = anexoData.getUbicacionDisco();
//            response.setContentType(anexoData.getContentType());
//            response.setHeader("Content-Disposition", "attachment; filename=\""
//                    + nombreFichero.replace(nombreFichero, anexoData.getNombreFinal())+ "\"");
//            InputStream archivoLeido = new FileInputStream(subDirectorio+File.separator+nombreFichero);
//            IOUtils.copy(archivoLeido, response.getOutputStream());
//            response.flushBuffer();
//        } catch (IOException ex) {
//            throw ex;
//        }
//    }
    
        
    /**
     * Metodo para mostrar por consola la informacion que esta enviando un formulario.
     * Depende de la clase ControllerUtilities
     * @param request
     * @return 
     */
//    @RequestMapping(path = "/util", method = RequestMethod.POST)
//    public String savee(HttpServletRequest request) {
//        String params = ControllerUtilities.viewHTTPParameters(request);
//        LOG.info(params);
//        return "valorCualquiera";
//    }
      
    
}
