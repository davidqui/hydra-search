package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Transaccion;
import co.mil.ejercito.hydrasearch.entities.Transicion;
import co.mil.ejercito.hydrasearch.entities.Usuario;
import co.mil.ejercito.hydrasearch.repositories.TransicionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TransicionService {

    @Autowired
    private TransicionRepository transicionRepository;

    /**
     * Metodo para listar todos los registros disponibles...
     *
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos Transicion
     */
    public List <Transicion> findAll(Sort sort) {
        return transicionRepository.findAll(sort);
    }

    /**
     * Permite crear un registro de instancia, que determina quien fue el usario creador del registro.
     * @param transaccionData Informacion del objeto transicion.
     * @param usuarioCreador Informacion del objeto usuario que crea.
     * @return Informacion del registro creado.
     */
    public Transicion createTransicionUserCreador(Transaccion transaccionData, Usuario usuarioCreador) {

        Transicion transicionCreacion = new Transicion();
        transicionCreacion.setIdTransaccion(transaccionData);
        transicionCreacion.setLoginUsuario(usuarioCreador);
        transicionCreacion.setEstado("Creado");
        transicionCreacion.setActivo(Boolean.FALSE);

        return transicionRepository.save(transicionCreacion);
    }

    /**
     * Permite crear un registro de instancia, que determina a que usuario le es asigando el documento.
     * @param transaccionData Informacion del objeto transicion.
     * @param usuarioAsignado Informacion del objeto usuario al que se le asigna.
     * @return Informacion del registro creado.
     */
    public Transicion createTransicionUserAsignado(Transaccion transaccionData, Usuario usuarioAsignado) {

        Transicion transicionAsignacion = new Transicion();
        transicionAsignacion.setIdTransaccion(transaccionData);
        transicionAsignacion.setLoginUsuario(usuarioAsignado);
        transicionAsignacion.setEstado("Asignado");
        transicionAsignacion.setActivo(Boolean.TRUE);

        return transicionRepository.save(transicionAsignacion);
    }

    /**
     * Permite buscar una transicion activa por Id de Transacción.
     * @param idTransaccion Identificador de la transaccion.
     * @return Data de la transicion Activa que corresponde al Id de Transaccion indicado.
     */
    public Transicion findTransicionActiva(Transaccion idTransaccion) {
        return transicionRepository.findByIdTransaccionAndActivoTrue(idTransaccion);

    }

    /**
     * Permite listar las transacciones asignadas a un usuario por su login.
     * @param login Nombre de usuario a consultar.
     * @return Lista de Transiciones asignadas al usuario que posea dicho login.
     */
    public List <Transicion> findTransicionByUsuario(Usuario login) {
        return transicionRepository.findByLoginUsuarioAndActivoTrue(login);

    }


}
