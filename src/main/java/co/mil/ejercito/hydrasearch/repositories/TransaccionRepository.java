package co.mil.ejercito.hydrasearch.repositories;


import co.mil.ejercito.hydrasearch.entities.Transaccion;
import co.mil.ejercito.hydrasearch.entities.Transicion;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    public List<Transaccion> findAll(Sort sort);
    public Transaccion findByidTransaccion(Long idTransaccion);
//    public List<Transaccion> findAllAndTransicionActivoTrue();
    
    @Query(nativeQuery = true, value = ""
            + "SELECT * FROM "
            + "\"TRANSICION\"\n" 
            +"LEFT JOIN \"TRANSACCION\" "
            + "ON \"TRANSICION\".id_transaccion=\"TRANSACCION\".id_transaccion\n" 
            +"LEFT JOIN \"DOCUMENTO\" "
            + "ON \"TRANSACCION\".id_documento=\"DOCUMENTO\".id_documento\n" 
            + "WHERE \"TRANSICION\".activo=TRUE AND \"TRANSICION\".login_usuario='?';"
            )
    public List<Object> ListTrasicionesActivas(String login);
    
//    public Transaccion findByIdTransaccion(Long idTransaccion);
}
