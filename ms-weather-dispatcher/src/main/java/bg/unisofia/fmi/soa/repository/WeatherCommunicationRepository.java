package bg.unisofia.fmi.soa.repository;

import java.util.List;
import java.util.Optional;

import bg.unisofia.fmi.soa.tables.pojos.WeatherCommunication;

public interface WeatherCommunicationRepository {

	public void create(Optional<WeatherCommunication> weather);
	
	public List<WeatherCommunication> getAllWeatherCommunication();
	
	public void update(Optional<WeatherCommunication> weather);
}
