package park.ud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import park.ud.modelos.Parqueadero;
import park.ud.modelos.Ubicacion;
import park.ud.modelosDto.EspacioDeParqueaderoDto;
import park.ud.servicios.ParqueaderoService;
import park.ud.servicios.UbicacionService;

@RestController
@RequestMapping("/parqueadero")
@CrossOrigin("*")
public class ParqueaderoController {
	
	private final ObjectMapper objectMapper;
	
	@Autowired
	private ParqueaderoService parqueaderoService;
	
	@Autowired
	private UbicacionService ubicacionService;
	
	public ParqueaderoController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
	
	@GetMapping("/listarParqueaderos/")
	public ResponseEntity<List<Parqueadero>> listarParqueaderos(){
		return ResponseEntity.ok(parqueaderoService.listarParqueaderos());
	}
	
	@GetMapping("/listarEspaciosDeUnParqueadero/{idParqueadero}")
	public ResponseEntity<List<EspacioDeParqueaderoDto>> listarEspaciosDeUnParqueadero(@PathVariable("idParqueadero") Long idParqueadero){
		return ResponseEntity.ok(parqueaderoService.listarEspaciosDeUnParqueadero(idParqueadero));
	}
	
	@PostMapping("/guardar/")
	public ResponseEntity<Parqueadero> guardarParqueadero(@RequestBody Parqueadero parqueadero){
		parqueaderoService.guardarParqueadero(parqueadero);
		return ResponseEntity.ok(parqueadero); 
	}
	
	@PutMapping("/editar/")
	public ResponseEntity<Boolean> editarParqueadero(@RequestBody Parqueadero parqueadero){
		boolean parqueaderoEditado = parqueaderoService.editarParqueadero(parqueadero);
		return ResponseEntity.ok(parqueaderoEditado);
	}
	
	@PutMapping("/editarUbicacion/")
	public ResponseEntity<Boolean> editarUbicacionDelParqueadero(@RequestBody Ubicacion ubicacion){
		boolean ubicacionEditada = ubicacionService.editarUbicacion(ubicacion);
		return ResponseEntity.ok(ubicacionEditada);
	}
	
	@DeleteMapping("/eliminar/{idParqueadero}")
	public ResponseEntity<Boolean> eliminarParqueadero(@PathVariable("idParqueadero") Long idParqueadero){
			boolean parqueaderoEliminado = parqueaderoService.eliminarParqueadero(idParqueadero);
			return ResponseEntity.ok(parqueaderoEliminado);
	}
}
