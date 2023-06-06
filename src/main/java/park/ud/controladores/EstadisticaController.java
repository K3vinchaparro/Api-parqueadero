package park.ud.controladores;



import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import park.ud.servicios.EstadisticaService;

@RestController
@RequestMapping("/estadistica")
@CrossOrigin("*")
public class EstadisticaController {
	
	@Autowired
	private EstadisticaService estadisticaService;
	
	@GetMapping("/obtenerTotalDeVentasSegunIdParqueaderoYFecha/{id}/{fecha}")
	public ResponseEntity<Double> obtenerTotalDeVentasSegunIdYFecha(@PathVariable("id") Long id, @PathVariable("fecha") Date fecha) throws Exception{
		double totalDeVentas = estadisticaService.obtenerTotalDeVentasSegunIdYFecha(id, fecha);
		return ResponseEntity.ok(totalDeVentas);
	}
}
