package park.ud.repositorios;

import java.sql.Date;
import java.util.List;

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

	@Query("SELECT d FROM DetalleDeReserva d WHERE d.espacioDeParqueadero.parqueadero.idParqueadero = :idParqueadero AND d.fecha = :fecha")
	List<DetalleDeReserva> obtenerReservasDeParqueaderoYFecha(@Param("idParqueadero") Long idParqueadero, @Param("fecha") Date fecha);
	
	@Query("SELECT d FROM DetalleDeReserva d WHERE d.usuario.id = :idUsuario")
	List<DetalleDeReserva> obtenerReservasSegunIdUsuario(@Param("idUsuario") Long idUsuario);
	
	@Query("UPDATE Usuario SET puntosAcumulados = puntosAcumulados + :puntos WHERE id = :idUsuario")
	@Modifying
	@Transactional
	void sumarPuntosUsuario(@Param("idUsuario") Long idUsuario, @Param("puntos") int puntos);
}
 