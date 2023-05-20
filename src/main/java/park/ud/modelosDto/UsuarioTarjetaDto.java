package park.ud.modelosDto;

import java.util.List;

import park.ud.modelos.TarjetaDeCredito;
import park.ud.modelos.Usuario;

public class UsuarioTarjetaDto {

	private Usuario usuario;
    private List<TarjetaDeCredito> tarjetaDeCredito;
    
    public UsuarioTarjetaDto() {}
    
	public UsuarioTarjetaDto(Usuario usuario, List<TarjetaDeCredito> tarjetaDeCredito) {
		super();
		this.usuario = usuario;
		this.tarjetaDeCredito = tarjetaDeCredito;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<TarjetaDeCredito> getTarjetaDeCredito() {
		return tarjetaDeCredito;
	}

	public void setTarjetaDeCredito(List<TarjetaDeCredito> tarjetaDeCredito) {
		this.tarjetaDeCredito = tarjetaDeCredito;
	}

	
}
