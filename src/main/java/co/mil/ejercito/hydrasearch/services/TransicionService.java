package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Transicion;
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
    
}
