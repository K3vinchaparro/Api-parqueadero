package park.ud.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import park.ud.modelos.EspacioDeParqueadero;
import park.ud.modelos.Parqueadero;

@Repository
public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Long>{
	
	@Query("DELETE from Parqueadero p WHERE p.idParqueadero = :idParqueadero")
	@Modifying
	@Transactional
	void deleteByIdParqueadero(@Param("idParqueadero") Long idParqueadero); 
	
	@Query("SELECT e FROM EspacioDeParqueadero e WHERE e.parqueadero.idParqueadero = :idParqueadero")
	List<EspacioDeParqueadero> listarEspaciosDeUnParqueadero(@Param("idParqueadero") Long idParqueadero);

}
