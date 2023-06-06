package park.ud.modelos;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class DetalleDeReserva {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleDeReserva;
	private Date fecha;
	private String horaEntrada; 
	private String horaSalida;
	
	@Transient
	private int horas;
	
	
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
	
	public int getHoras(String horaEntrada, String horaSalida) {
	    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	    Date fechaEntrada;
	    Date fechaSalida;
	    int horas = 0;

	    try {
	        fechaEntrada = (Date) format.parse(horaEntrada);
	        fechaSalida = (Date) format.parse(horaSalida);

	        long tiempoEntrada = fechaEntrada.getTime();
	        long tiempoSalida = fechaSalida.getTime();

	        long diferencia = tiempoSalida - tiempoEntrada;
	        horas = (int) (diferencia / (1000 * 60 * 60)); 
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    return horas;
	}

}
