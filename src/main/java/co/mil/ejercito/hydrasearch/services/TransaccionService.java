package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.*;

import java.util.Calendar;
import java.util.List;

import co.mil.ejercito.hydrasearch.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;
    @Autowired
    private AmenazaRepository amenazaRepository;
    @Autowired
    private FactEstabilidadRepository factEstabilidadRepository;
    @Autowired
    private AmenazaTransaccionRepository amenazaTransaccionRepository;
    @Autowired
    private FactorTransaccionRepository factorTransaccionRepository;
    
    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private TransicionRepository transicionRepository;

    /**
     * Permite crear el objeto Transaccion. 
     * @param transaccion Metadata de la transacion a crear.
     * @param documento Id del documento creado. 
     * @return Objeto Transaccion creado. 
     */
    public Transaccion create(Transaccion transaccion, Documento documento) {
        Calendar fechaActual = Calendar.getInstance();
        transaccion.setFechaTransaccion(fechaActual.getTime());
        transaccion.setIdDocumento(documento);

        return transaccionRepository.saveAndFlush(transaccion);
    }

    /**
     * Metodo para crear actualizar un registro del objeto Transaccion.
     * 
     * @param transaccion Coleccion de atributos y valores del objeto transaccion.
     * @return El objeto Transaccion modelado y listo para hacer persistencia con la base de datos.
     */   
    public Transaccion update(Transaccion transaccion) {
        //       Modificar el objeto a guardar segun metadata automatica
        return transaccionRepository.save(transaccion);
    }
    
    /**
     * Metodo para listar todos las transacciones ralizadas..
     * 
     * @param sort
     * @return 
     */
    public List <Transaccion> findAll(Sort sort) {
        return transaccionRepository.findAll(sort);
    }
    
    /**
     * Permite buscar una transaccion por su clave primaria.
     * @param id ID de la clasificacion a buscar.
     * @return Datos de la transaccion consultada.
     */
    public Transaccion findById(Long id) {
        return transaccionRepository.findByidTransaccion(id);
    }

}
