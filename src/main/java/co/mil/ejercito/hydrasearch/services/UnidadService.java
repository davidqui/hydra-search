package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Unidad;
import co.mil.ejercito.hydrasearch.repositories.UnidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos Unidad
     */
    public List <Unidad> findAll(Sort sort) {
        return unidadRepository.findAll(sort);
    }
    
}
