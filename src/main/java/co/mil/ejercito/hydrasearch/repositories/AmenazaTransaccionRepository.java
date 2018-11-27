package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Amenaza;
import co.mil.ejercito.hydrasearch.entities.AmenazaTransaccion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AmenazaTransaccionRepository extends JpaRepository<AmenazaTransaccion, Long>{

}
