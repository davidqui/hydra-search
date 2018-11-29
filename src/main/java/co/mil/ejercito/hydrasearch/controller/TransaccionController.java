package co.mil.ejercito.hydrasearch.controller;

import co.mil.ejercito.hydrasearch.entities.*;
import co.mil.ejercito.hydrasearch.repositories.AmenazaRepository;
import co.mil.ejercito.hydrasearch.repositories.AmenazaTransaccionRepository;
import co.mil.ejercito.hydrasearch.repositories.FactEstabilidadRepository;
import co.mil.ejercito.hydrasearch.repositories.FactorTransaccionRepository;
import co.mil.ejercito.hydrasearch.services.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    @Autowired
    private TransicionService transicionService;
    @Autowired
    private DocumentoService documentoService;


    @Autowired
    private AmenazaRepository amenazaRepository;
    @Autowired
    private FactEstabilidadRepository factEstabilidadRepository;
    @Autowired
    private AmenazaTransaccionRepository amenazaTransaccionRepository;
    @Autowired
    private FactorTransaccionRepository factorTransaccionRepository;


      
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
    public String saves(Transaccion transaccion, Documento documento, String login, RedirectAttributes redirectAttributes, @RequestParam("docFile") MultipartFile files) {
        try {
        String subDirectorio = generarCodigoSubDirectorio();
        String directorioFinal=documentoService.generarEstructuraRoot(directorioRoot);
        documentoService.crearDirectorios(directorioFinal, subDirectorio);
        String ubicacionFile=documentoService.guardarArchivo(files, directorioFinal, subDirectorio);
        Documento documentoData = documentoService.create(documento, files, ubicacionFile);

        Transaccion transaccionData= transaccionService.create(transaccion,documentoData);

        Usuario usuarioCreador= usuarioService.findByLogin(login);
        Usuario usuarioAsignado= usuarioService.findByLogin(transaccionData.getUsuarioValidador());
        
        transicionService.createTransicionUserCreador(transaccionData,usuarioCreador);
        transicionService.createTransicionUserAsignado(transaccionData, usuarioAsignado);

        } catch (IOException ex) {
            Logger.getLogger(TransaccionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/list";
    }
    

    @RequestMapping(path = "/list/{keylog}", method = RequestMethod.GET)
    public ResponseEntity <List<Object>> list(@PathVariable("keylog") String login) {
        System.out.println("<<<<<<<<<<Valor recibido  = >>>>>>>>>>>>>>" + login);
        List<Object> transaccions = transaccionService.findAllByTransicionActivo(login);
//        model.addAttribute("transacciones", transaccions);
//        return "/transaccion/list";
        return new ResponseEntity <> (transaccions,HttpStatus.OK);
    }
    
    @RequestMapping(path = "/edit/{key}", method = RequestMethod.GET)
    public ResponseEntity <TransaccionDTO> editarTrasaccion(@PathVariable("key") Long idTransaccion) {

        TransaccionDTO transaccionDTO= new TransaccionDTO();

        Transaccion transaccionOne=transaccionService.findById(idTransaccion);
        Transicion transicionData=transaccionService.findTransicionActiva(transaccionOne);

        Transaccion transaccionData=transaccionService.findById(idTransaccion);

        Documento documentoData=documentoService.findOneDocumento(transaccionData.getIdDocumento().getIdDocumento());
        
        transaccionDTO.setIdTransaccion(idTransaccion);
        transaccionDTO.setFechaTransaccion(transaccionData.getFechaTransaccion());
        transaccionDTO.setCalificacionCalculada(transaccionData.getCalificacionCalculada());
        transaccionDTO.setDescripcion(transaccionData.getDescripcion());
        transaccionDTO.setIdCredibilidad(transaccionData.getIdCredibilidad());
        transaccionDTO.setIdExactitud(transaccionData.getIdExactitud());
        transaccionDTO.setEstado(transicionData.getEstado());
        transaccionDTO.setActivo(transicionData.getActivo());
        transaccionDTO.setLoginUsuario(transicionData.getLoginUsuario());
        transaccionDTO.setIdDocumento(documentoData.getIdDocumento());
        transaccionDTO.setNombreDoc(documentoData.getNombreDoc());
        transaccionDTO.setUrlDocumento(documentoData.getUrlDocumento());
        transaccionDTO.setAccesoPrivado(documentoData.getAccesoPrivado());
        transaccionDTO.setIdClasificacion(documentoData.getIdClasificacion());
        transaccionDTO.setIdTipoDoc(documentoData.getIdTipoDoc());
//        transaccionDTO.setFactoresCollection(transaccionData);
//        transaccionDTO.setAmenazaCollection(transaccionData.getFactoresCollection());

        return new ResponseEntity <> (transaccionDTO,HttpStatus.OK);
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
     * Metodo que permite descargar un archivo.
     * 
     * @param response Representa la respuesta del servidor
     * @param codigo Valor recibido desde el formulario que contiene el numero que identifica el archivo
     * @throws IOException 
     */
    @RequestMapping(path = "/descargar/{codigo}", method = RequestMethod.GET)
    public void descargarArchivo(HttpServletResponse response, @PathVariable("codigo") Long codigo) throws IOException {
        Documento documentoData=documentoService.findOneDocumento(codigo);
        try {
            String nombreFichero = documentoData.getNombreDoc();
            String url = documentoData.getUrlDocumento();
            response.setContentType(documentoData.getExtension());
            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + url.replace(url,nombreFichero)+ "\"");
            InputStream archivoLeido = new FileInputStream(url);
            IOUtils.copy(archivoLeido, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            throw ex;
        }
    }

}
