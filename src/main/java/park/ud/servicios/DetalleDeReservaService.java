package park.ud.servicios;

import java.util.List;

import park.ud.modelos.DetalleDeReserva;

public interface DetalleDeReservaService {
	
	public List<DetalleDeReserva> listarDetalleDeReservas();
	
	public boolean guardarDetalleDeReserva(DetalleDeReserva detalleDeReserva);
	
	public boolean eliminarDetalleDeReserva(Long idDetalleDeReserva);
	
}
