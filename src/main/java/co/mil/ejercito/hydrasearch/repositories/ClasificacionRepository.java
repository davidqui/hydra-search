package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Clasificacion;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long>{
    public List<Clasificacion> findAll(Sort sort);
}
