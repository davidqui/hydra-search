package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Credibilidad;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CredibilidadRepository extends JpaRepository<Credibilidad, Long>{
    public List<Credibilidad> findAll(Sort sort);
}
