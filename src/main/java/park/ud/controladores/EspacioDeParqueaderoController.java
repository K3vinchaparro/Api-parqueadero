package park.ud.controladores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import park.ud.modelos.EspacioDeParqueadero;
import park.ud.servicios.EspacioDeParqueaderoService;

@RestController
@RequestMapping("/espacioDeParqueadero")
@CrossOrigin("*")
public class EspacioDeParqueaderoController {
	
	@Autowired
	private EspacioDeParqueaderoService espacioDeParqueaderoService;

	@PostMapping("/guardar/")
	public ResponseEntity<Boolean> guardarEspacioDeParqueadero(@RequestBody List<EspacioDeParqueadero> espaciosDeParqueadero){
		boolean espacioGuardado = espacioDeParqueaderoService.guardarEspaciosDeParqueadero(espaciosDeParqueadero);
		   return ResponseEntity.ok(espacioGuardado);
	}
	
	@DeleteMapping("/eliminar/{idEspacio}")
	@Transactional
	public ResponseEntity<Boolean> eliminarEspacioDeParqueadero(@PathVariable("idEspacio") Long idEspacioParqueadero){
		boolean espacioEliminado = espacioDeParqueaderoService.eliminarEspacioDeParqueadero(idEspacioParqueadero);
		return ResponseEntity.ok(espacioEliminado);
	}
	
	@PutMapping("/cambiarEstadoDeDisponibilidad/{idEspacioParqueadero}")
	public ResponseEntity<Boolean> cambiarEstadoDeDisponibilidad(@PathVariable("idEspacioParqueadero") Long idEspacioParqueadero){
		boolean disponibilidadCambiada = espacioDeParqueaderoService.cambiarEstadoDeDisponibilidadDeEspacioDeParqueadero(idEspacioParqueadero);
		return ResponseEntity.ok(disponibilidadCambiada);
	};
}
