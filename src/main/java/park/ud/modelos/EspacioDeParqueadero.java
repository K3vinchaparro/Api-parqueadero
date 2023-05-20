package park.ud.modelos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class EspacioDeParqueadero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEspacioParqueadero;
	private String codigoEspacioParqueadero;
	private boolean ocupado = false; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Parqueadero parqueadero;
	

	
	public EspacioDeParqueadero() {}

	public Long getIdEspacioParqueadero() {
		return idEspacioParqueadero;
	}

	public void setIdEspacioParqueadero(Long idEspacioParqueadero) {
		this.idEspacioParqueadero = idEspacioParqueadero;
	}

	public String getCodigoEspacioParqueadero() {
		return codigoEspacioParqueadero;
	}

	public void setCodigoEspacioParqueadero(String codigoEspacioParqueadero) {
		this.codigoEspacioParqueadero = codigoEspacioParqueadero;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}	
}
