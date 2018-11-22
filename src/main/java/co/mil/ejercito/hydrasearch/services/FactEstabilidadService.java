package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.FactoresInestabilidad;
import co.mil.ejercito.hydrasearch.repositories.FactEstabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class FactEstabilidadService {

    @Autowired
    private FactEstabilidadRepository factEstabilidadRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos FactoresInestabilidad
     */
    public List <FactoresInestabilidad> findAll(Sort sort) {
        return factEstabilidadRepository.findAll(sort);
    }
    
}
