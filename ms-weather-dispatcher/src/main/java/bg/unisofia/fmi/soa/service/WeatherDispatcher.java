package bg.unisofia.fmi.soa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bg.unisofia.fmi.soa.dto.Location;
import bg.unisofia.fmi.soa.dto.WeatherCommunicationTable;
import bg.unisofia.fmi.soa.repository.WeatherCommunicationRepository;
import bg.unisofia.fmi.soa.tables.pojos.WeatherCommunication;
import bg.unisofia.fmi.soa.wsdl.GetLocationWeatherRequest;
import bg.unisofia.fmi.soa.wsdl.GetLocationWeatherResponse;
import lombok.extern.slf4j.Slf4j;

@RestController("/weather")
@Slf4j
public class WeatherDispatcher {

	private final WeatherCommunicationRepository repo;
	
	@Autowired
	public WeatherDispatcher(WeatherCommunicationRepository repo) {
		this.repo = repo;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/weather/{city}/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getWeatherFor(@PathVariable String city, @PathVariable String country) {
		log.info(">>>>>>>>>>>>>>>> getWeatherFor");
		
		// call SOAP
		bg.unisofia.fmi.soa.wsdl.Location value = new bg.unisofia.fmi.soa.wsdl.Location();
		value.setCity(city);
		value.setCountry(country);
		
		GetLocationWeatherRequest request = new GetLocationWeatherRequest();
		request.setLocation(value);
		
		LocationClient client = new LocationClient();
		GetLocationWeatherResponse response =  client.getLocationWeather(request);
		
		Location location = new Location();
		location.setCity(response.getLocationData().getCity());
		location.setCountry(response.getLocationData().getCountry());
		location.setDescription(response.getLocationData().getDescription());
		location.setHumidity(response.getLocationData().getHumidity());
		location.setTemperature(response.getLocationData().getTemperature());
		
		WeatherCommunication weather = new WeatherCommunication();
		weather.setCity(response.getLocationData().getCity());
		weather.setCountry(response.getLocationData().getCountry());
		weather.setForDate(LocalDate.now());
		weather.setRequestTimestamp(LocalDateTime.now());
		
		repo.create(Optional.ofNullable(weather));
		
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/weather/{city}/{country}/{timeStart}/{timeEnd}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeatherCommunicationTable>> getWeatherDataForTime(@PathVariable String city, @PathVariable String country) {
		List<WeatherCommunication> result = repo.getAllWeatherCommunication();
		List<WeatherCommunicationTable> resultDto = new ArrayList<>();
		for (WeatherCommunication el: result) {
			WeatherCommunicationTable newElement = new WeatherCommunicationTable();
			newElement.setCity(el.getCity());
			newElement.setCountry(el.getCountry());
			newElement.setForDate(el.getForDate());
			newElement.setId(el.getId());
			newElement.setRequestTimestamp(el.getRequestTimestamp());
		}
		
		return new ResponseEntity<List<WeatherCommunicationTable>>(resultDto, HttpStatus.OK);
	}
	
	
}
