package park.ud.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import park.ud.modelos.Ubicacion;
import park.ud.repositorios.UbicacionRepository;
import park.ud.servicios.UbicacionService;

@Service
public class UbicacionImpl implements UbicacionService{
	
	@Autowired
	private UbicacionRepository ubicacionRepository;
}
