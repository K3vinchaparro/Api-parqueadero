package park.ud.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parqueadero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idParqueadero")
	private Long idParqueadero;
	private String nombreParqueadero;
	private String tipoParqueadero;
	private String horarioServicio;
	private int tarifa;
	@Transient
	private int cantidadDeCupos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parqueadero")
	@JsonIgnore
	private List<EspacioDeParqueadero> espaciosDeParqueadero;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUbicacion")
	private Ubicacion ubicacion;

	public Long getIdParqueadero() {
		return idParqueadero;
	}

	public void setIdParqueadero(Long idParqueadero) {
		this.idParqueadero = idParqueadero;
	}

	public String getNombreParqueadero() {
		return nombreParqueadero;
	}

	public void setNombreParqueadero(String nombreParqueadero) {
		this.nombreParqueadero = nombreParqueadero;
	}

	public String getTipoParqueadero() {
		return tipoParqueadero;
	}

	public void setTipoParqueadero(String tipoParqueadero) {
		this.tipoParqueadero = tipoParqueadero;
	}

	public String getHorarioServicio() {
		return horarioServicio;
	}

	public void setHorarioServicio(String horarioServicio) {
		this.horarioServicio = horarioServicio;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public int getCantidadDeCupos() {
	    if (espaciosDeParqueadero != null) {
	        return espaciosDeParqueadero.size();  
	    }
	    return 0;
	}

	public void setCantidadDeCupos() {
		cantidadDeCupos = getCantidadDeCupos();
	}

	public List<EspacioDeParqueadero> getEspaciosDeParqueadero() {
		return espaciosDeParqueadero;
	}

	public void setEspaciosDeParqueadero(List<EspacioDeParqueadero> espaciosDeParqueadero) {
		this.espaciosDeParqueadero = espaciosDeParqueadero;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
}
