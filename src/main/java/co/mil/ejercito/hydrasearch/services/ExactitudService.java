package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Exactitud;
import co.mil.ejercito.hydrasearch.repositories.ExactitudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ExactitudService {

    @Autowired
    private ExactitudRepository exactitudRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos Exactitud
     */
    public List <Exactitud> findAll(Sort sort) {
        return exactitudRepository.findAll(sort);
    }
    
}
