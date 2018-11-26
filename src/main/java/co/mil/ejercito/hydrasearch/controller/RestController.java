package co.mil.ejercito.hydrasearch.controller;

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
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * Controlador para proveer el servicio de exposicion de datos al FrontEnd.
 * @author aherreram@imi.mil.co
 * @since Noviembre 21, 2018 feature_1 (HYDRA-GETDE)
 */
//@RestController
@Controller
@RequestMapping("")
public class RestController {

    private static final Logger LOG = Logger.getLogger(RestController.class.getName());
       
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
    
    /**
     * Servicio para la publicacion de datos entidad TipoDoc
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/tipoDoc", method = RequestMethod.GET)
    public ResponseEntity<List<TipoDoc>> listTipoDoc() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "tipo"));
        return new ResponseEntity <> (tipoDocService.findAll(sort),HttpStatus.OK);
    }
    
    /**
     * Servicio para la publicacion de datos entidad Amenaza
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/amenaza", method = RequestMethod.GET)
    public ResponseEntity<List<Amenaza>> listAmenaza() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "tipo"));
        return new ResponseEntity <> (amenazaService.findAll(sort),HttpStatus.OK);
    }
    
    /**
     * Servicio para la publicacion de datos entidad Clasificacion
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/clasificacion", method = RequestMethod.GET)
    public ResponseEntity<List<Clasificacion>> listClasificacion() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "tipo"));
        return new ResponseEntity <> (clasificacionService.findAll(sort),HttpStatus.OK);
    }
    
    /**
     * Servicio para la publicacion de datos entidad Credibilidad
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/credibilidad", method = RequestMethod.GET)
    public ResponseEntity<List<Credibilidad>> listCredibilidad() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "nombre"));
        return new ResponseEntity <> (credibilidadService.findAll(sort),HttpStatus.OK);
    }
    
    /**
     * Servicio para la publicacion de datos entidad Exactitud
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/exactitud", method = RequestMethod.GET)
    public ResponseEntity<List<Exactitud>> listExactitud() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "nombre"));
        return new ResponseEntity <> (exactitudService.findAll(sort),HttpStatus.OK);
    }
    
    /**
     * Servicio para la publicacion de datos entidad FactoresInestabilidad
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/factoresInestabilidad", method = RequestMethod.GET)
    public ResponseEntity<List<FactoresInestabilidad>> listFactoresInestabilidad() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "nombre"));
        return new ResponseEntity <> (factEstabilidadService.findAll(sort),HttpStatus.OK);
    }
    
    /**
     * Servicio para la publicacion de datos entidad Unidad
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/unidad", method = RequestMethod.GET)
    public ResponseEntity<List<Unidad>> listUnidad() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "unidad"));
        return new ResponseEntity <> (unidadService.findAll(sort),HttpStatus.OK);
    }
    
    /**
     * Servicio para la publicacion de datos entidad Usuario
     * 2018-11-21 Issue #1 HydraSearch HYDRA-GETDE feature-9 aherreram@imi.mil.co
     * @return JSON con data del objeto invocado en el path.
     */
    @RequestMapping(path = "/usuarioUnidad", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listUsuarioByUnidad() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "login"));
        List<Usuario> usuario = usuarioService.findAllByUnidad(sort);
        return new ResponseEntity <> (usuario,HttpStatus.OK);
    }

    /**
     * Metodo que permite mediante el modelo enviar a una vista el listado de los datos requeridos para el formulario.
     *
     * @param model Apuntador Clase Model de Spring
     * @return Vista ftl
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public String list(Model model) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "fechaTransaccion"));
        List<Transaccion> transaccions = transaccionService.findAll(sort);
        model.addAttribute("transacciones", transaccions);

        Sort sort1 = new Sort(new Sort.Order(Sort.Direction.DESC, "tipo"));
        List<Amenaza> amenaza = amenazaService.findAll(sort1);
        model.addAttribute("amenazas", amenaza);

        Sort sort2 = new Sort(new Sort.Order(Sort.Direction.DESC, "tipo"));
        List<Clasificacion> clasificacion = clasificacionService.findAll(sort2);
        model.addAttribute("clasificaciones", clasificacion);

        Sort sort3 = new Sort(new Sort.Order(Sort.Direction.DESC, "nombre"));
        List<Credibilidad> credibilidad = credibilidadService.findAll(sort3);
        model.addAttribute("credibilidades", credibilidad);

        Sort sort4 = new Sort(new Sort.Order(Sort.Direction.DESC, "nombre"));
        List<Exactitud> exactitud = exactitudService.findAll(sort4);
        model.addAttribute("exactitudes", exactitud);

        Sort sort5 = new Sort(new Sort.Order(Sort.Direction.DESC, "nombre"));
        List<FactoresInestabilidad> FactoresInestabilidad = factEstabilidadService.findAll(sort5);
        model.addAttribute("factoresInestabilidad", FactoresInestabilidad);

        Sort sort6 = new Sort(new Sort.Order(Sort.Direction.DESC, "tipo"));
        List<TipoDoc> tipoDoc = tipoDocService.findAll(sort6);
        model.addAttribute("tipoDocs", tipoDoc);

        Sort sort7 = new Sort(new Sort.Order(Sort.Direction.DESC, "unidad"));
        List<Unidad> unidad = unidadService.findAll(sort7);
        model.addAttribute("unidades", unidad);

        Sort sort8 = new Sort(new Sort.Order(Sort.Direction.DESC, "login"));
        List<Usuario> usuario = usuarioService.findAllByUnidad(sort8);
        model.addAttribute("usuarios", usuario);

        return "/index";
    }
    
}
