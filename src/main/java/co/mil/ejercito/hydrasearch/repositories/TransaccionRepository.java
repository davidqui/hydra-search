package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Transaccion;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    public List<Transaccion> findAll(Sort sort);
    public Transaccion findByidTransaccion(Long idTransaccion);
}
