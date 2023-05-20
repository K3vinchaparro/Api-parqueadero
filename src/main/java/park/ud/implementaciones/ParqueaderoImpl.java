package park.ud.implementaciones;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import park.ud.modelos.EspacioDeParqueadero;
import park.ud.modelos.Parqueadero;
import park.ud.modelosDto.EspacioDeParqueaderoDto;
import park.ud.repositorios.ParqueaderoRepository;
import park.ud.servicios.ParqueaderoService;

@Service
public class ParqueaderoImpl implements ParqueaderoService{
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;

	@Override
	public Parqueadero guardarParqueadero(Parqueadero parqueadero) {
		try {
			return parqueaderoRepository.save(parqueadero);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el parqueadero en la base de datos", e);
        }
	}

	@Override
	public boolean eliminarParqueadero(Long idParqueadero) {
		try {
			parqueaderoRepository.deleteById(idParqueadero);;
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Error al eliminar el parqueadero", e);
		}
	}

	@Override
	public boolean editarParqueadero(Parqueadero parqueadero) {
		try {
			if(parqueaderoRepository.existsById(parqueadero.getIdParqueadero())) {
				parqueaderoRepository.save(parqueadero);
				return true;
			}else {return false;}
			
		} catch (Exception e) {
			throw new RuntimeException("Error al editar parqueadero", e);
		}
	}

	@Override
	public List<Parqueadero> listarParqueaderos() {
		return parqueaderoRepository.findAll();
	}

	@Override
	public List<EspacioDeParqueaderoDto> listarEspaciosDeUnParqueadero(Long idParqueadero) {
		List<EspacioDeParqueadero> espaciosDeParqueadero = parqueaderoRepository.listarEspaciosDeUnParqueadero(idParqueadero);

		return espaciosDeParqueadero.stream()
			    .map(EspacioDeParqueaderoDto::convertirEspacioDeParqueaderoADto)
			    .collect(Collectors.toList());
	}
}
