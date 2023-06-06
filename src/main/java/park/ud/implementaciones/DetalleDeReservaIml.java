package park.ud.implementaciones;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import park.ud.modelos.DetalleDeReserva;
import park.ud.repositorios.DetalleDeReservaRepository;
import park.ud.servicios.DetalleDeReservaService;

@Service
public class DetalleDeReservaIml implements DetalleDeReservaService{
	
	@Autowired
	private DetalleDeReservaRepository detalleReservaRepository;

	@Override
	public boolean guardarDetalleDeReserva(DetalleDeReserva detalleDeReserva) {
		
		Date fecha = sumarUnDiaFecha(detalleDeReserva.getFecha());
		detalleDeReserva.setFecha(fecha);
		
		try {
			detalleReservaRepository.save(detalleDeReserva);
			return true;
		} catch (Exception e) {
            throw new RuntimeException("Error al guardar el detalle en la base de datos", e);
        }
	}

	@Override
	public List<DetalleDeReserva> listarDetalleDeReservas() {
		return detalleReservaRepository.findAll();
	}

	@Override
	public boolean eliminarDetalleDeReserva(Long idDetalleDeReserva) {
		try {
			detalleReservaRepository.deleteByIdDetalleDeReserva(idDetalleDeReserva);
			return true;
		} catch (Exception e) {
            throw new RuntimeException("Error al eliminar el detalle en la base de datos", e);
        }
	}
	
	public Date sumarUnDiaFecha(java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date nuevaFecha = (Date) calendar.getTime();
		return nuevaFecha;
	}
}