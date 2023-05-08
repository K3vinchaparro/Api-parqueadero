package park.ud.servicios;

import java.util.List;

import park.ud.modelos.Usuario;

public interface UsuarioService {

	public Usuario guardarUsuario(Usuario usuario) throws Exception;
	
	public List<Usuario> listarUsuarios();
	
	public void eliminarUsuarioPorId(Long id);
	
}
