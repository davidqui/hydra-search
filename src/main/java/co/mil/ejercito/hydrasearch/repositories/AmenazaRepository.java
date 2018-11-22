package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Amenaza;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AmenazaRepository extends JpaRepository<Amenaza, Long>{
    public List<Amenaza> findAll(Sort sort);
}
