package co.mil.ejercito.hydrasearch.controller;

import co.mil.ejercito.hydrasearch.entities.Amenaza;
import co.mil.ejercito.hydrasearch.entities.Clasificacion;
import co.mil.ejercito.hydrasearch.entities.Credibilidad;
import co.mil.ejercito.hydrasearch.entities.Exactitud;
import co.mil.ejercito.hydrasearch.entities.FactoresInestabilidad;
import co.mil.ejercito.hydrasearch.entities.TipoDoc;
import co.mil.ejercito.hydrasearch.entities.Unidad;
import co.mil.ejercito.hydrasearch.entities.Usuario;
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
    @RequestMapping(path = "/usuario", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listUsuario() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "login"));
        List<Usuario> usuario = usuarioService.findAll(sort);
        return new ResponseEntity <> (usuarioService.findAll(sort),HttpStatus.OK);
    }
    
}
