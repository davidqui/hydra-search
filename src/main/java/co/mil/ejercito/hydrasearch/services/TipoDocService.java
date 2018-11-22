package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.TipoDoc;
import co.mil.ejercito.hydrasearch.repositories.TipoDocRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TipoDocService {

    @Autowired
    private TipoDocRepository tipoDocRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos TipoDoc
     */
    public List <TipoDoc> findAll(Sort sort) {
        return tipoDocRepository.findAll(sort);
    }
    
}
