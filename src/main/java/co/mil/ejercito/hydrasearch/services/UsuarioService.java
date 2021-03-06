package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Usuario;
import co.mil.ejercito.hydrasearch.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    /**
     * Metodo para listar todos los registros disponibles...
     * 
     * @param sort Criterio de ordenamiento
     * @return Lista de Objetos Amenaza
     */
    public List <Usuario> findAllByUnidad(Sort sort) {
//        return usuarioRepository.findAllOrOrderByIdUnidadIsNotNull(sort);
        return usuarioRepository.findAllGroupByIdUnidadIsNotNull(sort);
        
    }
    
    /**
     * Permite buscar un usuario mediante el login.
     * @param login String a buscar.
     * @return Objeto usuario con la informacion del usuario al que corresponda el login.
     */
    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
        
    }
    
}
