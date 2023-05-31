package park.ud.modelos;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleDeReserva {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleDeReserva;
	private Date fecha;
	private String horaEntrada; 
	private String horaSalida;
	
	@ManyToOne(fetch = FetchType.EAGER)   
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_espacio_parqueadero")
	private EspacioDeParqueadero espacioDeParqueadero;
	
	public DetalleDeReserva() {}

	public Long getIdDetalleDeReserva() {
		return idDetalleDeReserva;
	}

	public void setIdDetalleDeReserva(Long idDetalleDeReserva) {
		this.idDetalleDeReserva = idDetalleDeReserva;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EspacioDeParqueadero getEspacioDeParqueadero() {
		return espacioDeParqueadero;
	}

	public void setEspacioDeParqueadero(EspacioDeParqueadero espacioDeParqueadero) {
		this.espacioDeParqueadero = espacioDeParqueadero;
	}
}
