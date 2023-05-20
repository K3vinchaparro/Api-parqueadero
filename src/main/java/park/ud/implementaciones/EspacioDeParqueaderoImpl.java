package park.ud.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import park.ud.modelos.EspacioDeParqueadero;
import park.ud.repositorios.EspacioDeParqueaderoRepository;
import park.ud.servicios.EspacioDeParqueaderoService;

@Service
public class EspacioDeParqueaderoImpl implements EspacioDeParqueaderoService {
	
	@Autowired
	private EspacioDeParqueaderoRepository espacioDeParqueaderoRepository;

	@Override
	public boolean guardarEspaciosDeParqueadero(List<EspacioDeParqueadero> espaciosDeParqueadero) {
		try {
            for (int i = 0; i<espaciosDeParqueadero.size(); i++) {
            	EspacioDeParqueadero espacioDeParqueaderoAGuardar = espaciosDeParqueadero.get(i);
            	espacioDeParqueaderoRepository.save(espacioDeParqueaderoAGuardar);
            }
            return true;
            
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el espacio en la base de datos", e);
        }
	}

	@Override
	public boolean eliminarEspacioDeParqueadero(Long idEspacioParqueadero) {
		try {
			espacioDeParqueaderoRepository.deleteByIdEspacioParqueadero(idEspacioParqueadero);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Error al eliminar el espacio en la base de datos", e);
		}
		
	}
	
	@Override
	public boolean cambiarEstadoDeDisponibilidadDeEspacioDeParqueadero(Long idEspacioParqueadero) {
		try {
			Optional<EspacioDeParqueadero> espacioParqueaderoOptional = espacioDeParqueaderoRepository.findById(idEspacioParqueadero);
			if(espacioParqueaderoOptional.isPresent()) {
				EspacioDeParqueadero espacioDeParqueadero = espacioParqueaderoOptional.get();
				espacioDeParqueadero.setOcupado(!espacioDeParqueadero.isOcupado());
				espacioDeParqueaderoRepository.save(espacioDeParqueadero);
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Error al cambiar el estado de disponibilidad", e);
		}
	}

}
