package park.ud.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import park.ud.modelos.EspacioDeParqueadero;

@Repository
public interface EspacioDeParqueaderoRepository extends JpaRepository<EspacioDeParqueadero, Long>{
	
	@Query("DELETE from EspacioDeParqueadero e WHERE e.idEspacioParqueadero = :idEspacioParqueadero")
	@Modifying
	@Transactional
	void deleteByIdEspacioParqueadero(@Param("idEspacioParqueadero") Long idEspacioParqueadero); 

}
