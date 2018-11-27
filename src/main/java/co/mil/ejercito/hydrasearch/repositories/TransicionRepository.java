package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Transaccion;
import co.mil.ejercito.hydrasearch.entities.Transicion;
import co.mil.ejercito.hydrasearch.entities.Usuario;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TransicionRepository extends JpaRepository<Transicion, Long> {
    public List<Transicion> findAll(Sort sort);

    public Transicion findFirstByIdTransaccionAndActivoTrue(Long idTransaccion);

    public Transicion findByIdTransaccionAndActivoTrue(Transaccion idTransaccion);

}