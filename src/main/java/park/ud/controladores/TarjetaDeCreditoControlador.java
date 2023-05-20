package park.ud.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import park.ud.modelos.TarjetaDeCredito;
import park.ud.servicios.TarjetaDeCreditoService;

@RestController
@RequestMapping("/tarjetaDeCredito")
@CrossOrigin("*")
public class TarjetaDeCreditoControlador {
	
	@Autowired
	private TarjetaDeCreditoService tarjetaDeCreditoService;
	
	@PutMapping("/editar/")
	public ResponseEntity<Boolean> editarTarjetaDeCredito(@RequestBody TarjetaDeCredito tarjetaDeCredito){
		boolean tarjetaEditada = tarjetaDeCreditoService.editarTarjetaDeCredito(tarjetaDeCredito);
		return ResponseEntity.ok(tarjetaEditada);
	}
	
	@GetMapping("/obtenerTarjetaDeUsuario/{idUsuario}")
	public ResponseEntity<TarjetaDeCredito> obtenerTarjetaDeCreditoDeUsuario(@PathVariable Long idUsuario){
		TarjetaDeCredito tarjeta = tarjetaDeCreditoService.obtenerTarjetaDeCreditoDeUsuario(idUsuario);
		return ResponseEntity.ok(tarjeta);
	}

}
