package park.ud.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import park.ud.modelos.Usuario;
import park.ud.repositorios.UsuarioRepository;
import park.ud.servicios.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEnconder;

	@Override
	public Usuario guardarUsuario(Usuario usuario) throws Exception {
		 try {
	            if (usuarioRepository.findByUsername(usuario.getUsername()) !=null ) {
	                throw new Exception("El usuario ya existe en la base de datos");
	            }
	            
	            usuario.setPassword(this.passwordEnconder.encode(usuario.getPassword()));
	            return usuarioRepository.save(usuario);
	        } catch (Exception e) {
	            throw new RuntimeException("Error al guardar el usuario en la base de datos", e);
	        }
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public void eliminarUsuarioPorId(Long id) {
		usuarioRepository.deleteById(id);
		
	}
}
