package park.ud.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import park.ud.modelos.DetalleDeReserva;

@Repository
public interface DetalleDeReservaRepository extends JpaRepository<DetalleDeReserva, Long>{
	
	@Query("DELETE from DetalleDeReserva d WHERE d.idDetalleDeReserva = :id")
	@Modifying
	@Transactional
	void deleteByIdDetalleDeReserva(@Param("id") Long id); 

}
