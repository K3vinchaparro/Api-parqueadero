package park.ud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import park.ud.modelos.DetalleDeReserva;
import park.ud.servicios.DetalleDeReservaService;

@RestController
@RequestMapping("/detalleDeReserva")
@CrossOrigin("*")
public class DetalleDeReservaController {
	
	@Autowired
	private DetalleDeReservaService detalleReservaService;
	
	@PostMapping("/guardar/")
	public ResponseEntity<Boolean> guardarDetalleReservaService(@RequestBody DetalleDeReserva detalleDeReserva){
		boolean detalleGuardado = detalleReservaService.guardarDetalleDeReserva(detalleDeReserva);
		return ResponseEntity.ok(detalleGuardado);
	}
	
	@GetMapping("/listarSegunIdUsuario/{id}")
	public ResponseEntity<List<DetalleDeReserva>> listarDetalleDeReservasSegunIdUsuario(@PathVariable("id") Long id){
		return ResponseEntity.ok(detalleReservaService.listarDetalleDeReservasSegunIdUsuario(id));
	}
	
	@GetMapping("/listarTodos/")
	public ResponseEntity<List<DetalleDeReserva>> listarDetalleDeReservas(){
		return ResponseEntity.ok(detalleReservaService.listarDetalleDeReservas());
	}
	
	@DeleteMapping("/eliminarPorId/{id}")
	public ResponseEntity<Boolean> eliminarDetalleDeReservaPorId(@PathVariable("id") Long idDetalleDeReserva){
		boolean detalleBorrado = detalleReservaService.eliminarDetalleDeReserva(idDetalleDeReserva);
		return ResponseEntity.ok(detalleBorrado);
	}
}
