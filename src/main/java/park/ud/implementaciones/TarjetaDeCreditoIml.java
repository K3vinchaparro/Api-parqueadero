package park.ud.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import park.ud.modelos.TarjetaDeCredito;
import park.ud.modelos.Usuario;
import park.ud.repositorios.TarjetaDeCreditoRepository;
import park.ud.servicios.TarjetaDeCreditoService;

@Service
public class TarjetaDeCreditoIml implements TarjetaDeCreditoService{
	
	@Autowired
	private TarjetaDeCreditoRepository tarjetaDeCreditoRepository;

	@Override
	public TarjetaDeCredito guardarTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito, Usuario usuario) {
		tarjetaDeCredito.setUsuario(usuario);
		return tarjetaDeCreditoRepository.save(tarjetaDeCredito);
	}

	@Override
	public boolean editarTarjetaDeCredito(TarjetaDeCredito tarjeta) {
		if(tarjetaDeCreditoRepository.existsById(tarjeta.getId())) {
			tarjetaDeCreditoRepository.save(tarjeta);
			return true;
		}
		return false;
	}

	@Override
	public TarjetaDeCredito obtenerTarjetaDeCreditoDeUsuario(Long idUsuario) {
		return tarjetaDeCreditoRepository.obtenerTarjetaDeCreditoDeUsuario(idUsuario);
	}

	

}
