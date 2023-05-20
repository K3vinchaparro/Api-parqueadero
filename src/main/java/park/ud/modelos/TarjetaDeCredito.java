package park.ud.modelos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TarjetaDeCredito {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroTarjeta;
	private String codigoSeguridad;
	private String fechaVencimiento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	
	
	public TarjetaDeCredito() {}
	
	public TarjetaDeCredito(Long id, String numeroTarjeta, String codigoSeguridad, String fechaVencimiento) {
	    this.id = id;
	    this.numeroTarjeta = numeroTarjeta;
	    this.codigoSeguridad = codigoSeguridad;
	    this.fechaVencimiento = fechaVencimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
