package park.ud.modelosDto;

import park.ud.modelos.EspacioDeParqueadero;

public class EspacioDeParqueaderoDto {
	
	private Long idEspacioParqueadero;
    private String codigoEspacioParqueadero;
    private boolean ocupado;
    private Long idParqueadero;
    
    public EspacioDeParqueaderoDto() {}
    
    //This method is for converting the class EspacioDeParqueadero to this class
    public static EspacioDeParqueaderoDto convertirEspacioDeParqueaderoADto(EspacioDeParqueadero espacio) {
	    EspacioDeParqueaderoDto espacioDto = new EspacioDeParqueaderoDto();
	    espacioDto.setIdEspacioParqueadero(espacio.getIdEspacioParqueadero());
	    espacioDto.setCodigoEspacioParqueadero(espacio.getCodigoEspacioParqueadero());
	    espacioDto.setOcupado(espacio.isOcupado());
	    
	    
	    if (espacio.getParqueadero() != null) {
	        espacioDto.setIdParqueadero(espacio.getParqueadero().getIdParqueadero());
	    }

	    return espacioDto;
	}

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

	public Long getIdParqueadero() {
		return idParqueadero;
	}

	public void setIdParqueadero(Long idParqueadero) {
		this.idParqueadero = idParqueadero;
	}    
}
