package park.ud.servicios;

import java.util.List;

import park.ud.modelos.Parqueadero;
import park.ud.modelosDto.EspacioDeParqueaderoDto;

public interface ParqueaderoService {
	
	public List<Parqueadero> listarParqueaderos();
	
	public List<EspacioDeParqueaderoDto> listarEspaciosDeUnParqueadero(Long idParqueadero);
	
	public Parqueadero guardarParqueadero(Parqueadero parqueadero);
	
	public boolean eliminarParqueadero(Long idParqueadero);
	
	public boolean editarParqueadero(Parqueadero parqueadero);

}
