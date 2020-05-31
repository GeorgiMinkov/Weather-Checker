package bg.unisofia.fmi.soa.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bg.unisofia.fmi.soa.dto.Location;
import lombok.extern.slf4j.Slf4j;

@RestController("/weather")
@Slf4j
public class WeatherDispatcher {


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/weather/{city}/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getWeatherFor(@PathVariable String city, @PathVariable String country) {
		log.info(">>>>>>>>>>>>>>>>START THE FCKING REST");
		Location location = new Location();
		location.setCity("asd");
		location.setCountry("asd");
		
		// call SOAP
		
		
		return new ResponseEntity<Location>(location, HttpStatus.OK);
//		return ResponseEntity.ok(location);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/weather/{city}/{country}/{timeStart}/{timeEnd}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getWeatherDataForTime(@PathVariable String city, @PathVariable String country) {
		log.info(">>>>>>>>>>>>>>>>START THE FCKING REST");
		Location location = new Location();
		location.setCity("asd");
		location.setCountry("asd");
		
		// call SOAP
		
		
		return new ResponseEntity<Location>(location, HttpStatus.OK);
//		return ResponseEntity.ok(location);
	}
	
	
}
