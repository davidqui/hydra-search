package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Amenaza;
import co.mil.ejercito.hydrasearch.repositories.AmenazaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AmenazaService {

    @Autowired
    private AmenazaRepository amenazaRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos Amenaza
     */
    public List <Amenaza> findAll(Sort sort) {
        return amenazaRepository.findAll(sort);
    }
    
}
