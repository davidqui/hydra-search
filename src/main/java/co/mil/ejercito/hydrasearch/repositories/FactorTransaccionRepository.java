package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.AmenazaTransaccion;
import co.mil.ejercito.hydrasearch.entities.FactoresTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FactorTransaccionRepository extends JpaRepository<FactoresTransaccion, Long>{

}
