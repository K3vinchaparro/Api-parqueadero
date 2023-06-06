package park.ud.implementaciones;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import park.ud.implementaciones.utilidades.UtilFechas;
import park.ud.modelos.DetalleDeReserva;
import park.ud.modelos.Parqueadero;
import park.ud.repositorios.DetalleDeReservaRepository;
import park.ud.repositorios.ParqueaderoRepository;
import park.ud.servicios.EstadisticaService;

@Service
public class EstadisiticaImpl implements EstadisticaService {
	
	@Autowired
	private DetalleDeReservaRepository detalleDeReservaRepository;
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	

	@Override
	public double obtenerTotalDeVentasSegunIdYFecha(long idEspacioParqueadero, Date fecha) throws Exception {
	        double totalVentas = 0.0;

	        
	        double tarifa = obtenerTarifa(idEspacioParqueadero);

	        Date fechaCorregida = UtilFechas.sumarUnDiaAFecha(fecha);
	        
	        List<DetalleDeReserva> reservas = detalleDeReservaRepository.obtenerReservasDeParqueaderoYFecha(idEspacioParqueadero, fechaCorregida);

	        for (DetalleDeReserva reserva : reservas) {
	            double horas = reserva.getHoras(reserva.getHoraEntrada(), reserva.getHoraSalida());
	            totalVentas += tarifa * horas;
	        }

	        return totalVentas;

	}
	
	private double obtenerTarifa(long idEspacioParqueadero) throws Exception {
		Optional<Parqueadero> parqueadero = parqueaderoRepository.findById(idEspacioParqueadero);
		if (parqueadero.isPresent()) {
	        Parqueadero parqueaderoObj = parqueadero.get();
	        int tarifa = parqueaderoObj.getTarifa();
	        return tarifa;
	    } else {
	        throw new Exception("Parqueadero no encontrado");
	    }
    }

}
