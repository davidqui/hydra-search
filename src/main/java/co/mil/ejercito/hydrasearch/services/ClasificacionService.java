package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Clasificacion;
import co.mil.ejercito.hydrasearch.repositories.ClasificacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ClasificacionService {

    @Autowired
    private ClasificacionRepository clasificacionRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos Clasificacion
     */
    public List <Clasificacion> findAll(Sort sort) {
        return clasificacionRepository.findAll(sort);
    }
    
}
