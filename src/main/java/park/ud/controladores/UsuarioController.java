package park.ud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import park.ud.modelos.Usuario;
import park.ud.servicios.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/guardar/")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
	    return ResponseEntity.ok(usuarioGuardado);
	}
	
	@GetMapping("/listarUsuarios/")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}
	

}
