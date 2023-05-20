package park.ud.controladores;

import java.util.List;

import javax.transaction.Transactional;

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

import park.ud.modelos.Usuario;
import park.ud.modelosDto.UsuarioTarjetaDto;
import park.ud.servicios.TarjetaDeCreditoService;
import park.ud.servicios.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TarjetaDeCreditoService tarjetaDeCreditoService;
	
	@PostMapping("/guardar/")
	@Transactional
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody UsuarioTarjetaDto usuarioTarjeta) throws Exception {
		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuarioTarjeta.getUsuario());
		tarjetaDeCreditoService.guardarTarjetaDeCredito(usuarioTarjeta.getTarjetaDeCredito().get(0), usuarioGuardado);
	    return ResponseEntity.ok(usuarioGuardado);
	}
	
	@GetMapping("/listarUsuarios/")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}
	
	@DeleteMapping("/eliminarPorId/{id}")
	@Transactional
	public ResponseEntity<Boolean> eliminarUsuarioPorId(@PathVariable("id") Long id){
		boolean usuarioEliminado = usuarioService.eliminarUsuario(id);
		return ResponseEntity.ok(usuarioEliminado);
	}
	
	@PutMapping("/editar/")
	public ResponseEntity<Boolean> editarUsuario(@RequestBody UsuarioTarjetaDto usuario){
		boolean usuarioEditado = usuarioService.editarUsuario(usuario.getUsuario());
		return ResponseEntity.ok(usuarioEditado);
	}
	
	@PutMapping("/desactivar/{id}")
	public ResponseEntity<Boolean> desactivarUsuario(@PathVariable ("id") Long id){
		boolean usuarioDesactivado = usuarioService.desactivarUsuario(id);
		return ResponseEntity.ok(usuarioDesactivado);
	}
	
	@PutMapping("/activar/{id}")
	public ResponseEntity<Boolean> activarUsuario(@PathVariable ("id") Long id){
		boolean usuarioActivado = usuarioService.activarUsuario(id);
		return ResponseEntity.ok(usuarioActivado);
	}
	
}
