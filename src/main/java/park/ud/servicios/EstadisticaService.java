package park.ud.servicios;

import java.sql.Date;

public interface EstadisticaService {

	public double obtenerTotalDeVentasSegunIdYFecha(long idEspacioParqueadero, Date fecha) throws Exception;
	
}
