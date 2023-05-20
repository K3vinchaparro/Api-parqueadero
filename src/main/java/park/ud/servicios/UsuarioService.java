package park.ud.servicios;

import java.util.List;

import park.ud.modelos.Usuario;

public interface UsuarioService {

	public Usuario guardarUsuario(Usuario usuario) throws Exception;
	
	public List<Usuario> listarUsuarios();
	
	public boolean eliminarUsuario(Long id);
	
	public boolean editarUsuario(Usuario usuario);
	
	public boolean desactivarUsuario(Long id);
	
	public boolean activarUsuario(Long id);
	
}
