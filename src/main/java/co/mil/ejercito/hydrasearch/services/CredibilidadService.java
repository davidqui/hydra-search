package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Credibilidad;
import co.mil.ejercito.hydrasearch.repositories.CredibilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CredibilidadService {

    @Autowired
    private CredibilidadRepository credibilidadRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos Credibilidad
     */
    public List <Credibilidad> findAll(Sort sort) {
        return credibilidadRepository.findAll(sort);
    }
    
}
