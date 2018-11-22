package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.TipoDoc;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TipoDocRepository extends JpaRepository<TipoDoc, Long>{
    public List<TipoDoc> findAll(Sort sort);
}
