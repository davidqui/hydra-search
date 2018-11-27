package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Usuario;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public List<Usuario> findAll(Sort sort);
    public List<Usuario> findAllGroupByIdUnidadIsNotNull(Sort sort);
    public Usuario findByLogin(String login);
}
