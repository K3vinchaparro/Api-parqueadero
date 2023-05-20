package park.ud.servicios;

import java.util.List;

import park.ud.modelos.EspacioDeParqueadero;

public interface EspacioDeParqueaderoService {
	
	public boolean guardarEspaciosDeParqueadero(List<EspacioDeParqueadero> espaciosDeParqueadero);
	
	public boolean eliminarEspacioDeParqueadero(Long idEspacioParqueadero);
	
	public boolean cambiarEstadoDeDisponibilidadDeEspacioDeParqueadero(Long idEspacioParqueadero);
}
