package park.ud.servicios;

import park.ud.modelos.TarjetaDeCredito;
import park.ud.modelos.Usuario;

public interface TarjetaDeCreditoService {
	
	public TarjetaDeCredito guardarTarjetaDeCredito(TarjetaDeCredito tarjeta, Usuario usuario);
	
	public boolean editarTarjetaDeCredito(TarjetaDeCredito tarjeta);
	
	public TarjetaDeCredito obtenerTarjetaDeCreditoDeUsuario(Long idUsuario);
	

}
