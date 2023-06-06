package park.ud.implementaciones.utilidades;

import java.util.Calendar;

public class UtilFechas {
	
	public static java.sql.Date sumarUnDiaAFecha(java.util.Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, 1);
	    java.util.Date nuevaFecha = calendar.getTime();
	    return new java.sql.Date(nuevaFecha.getTime());
	}

}
