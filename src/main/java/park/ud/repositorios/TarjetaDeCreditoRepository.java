package park.ud.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import park.ud.modelos.TarjetaDeCredito;

@Repository
public interface TarjetaDeCreditoRepository extends JpaRepository<TarjetaDeCredito, Long> {

	@Transactional
	@Modifying
	@Query("DELETE FROM TarjetaDeCredito t WHERE t.usuario.id = :id")
	public void eliminarTarjetasDeUsuario(@Param("id") Long id);
	
	@Query("SELECT NEW park.ud.modelos.TarjetaDeCredito("
			+ "t.id, t.numeroTarjeta, t.codigoSeguridad, t.fechaVencimiento) "
			+ "FROM TarjetaDeCredito t WHERE t.usuario.id = :idUsuario")
	public TarjetaDeCredito obtenerTarjetaDeCreditoDeUsuario(@Param("idUsuario") Long idUsuario); 
}
