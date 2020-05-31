package bg.unisofia.fmi.soa.repository.impl;

import java.util.List;
import java.util.Optional;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.unisofia.fmi.soa.Tables;
import bg.unisofia.fmi.soa.repository.WeatherCommunicationRepository;
import bg.unisofia.fmi.soa.tables.pojos.WeatherCommunication;
import bg.unisofia.fmi.soa.tables.records.WeatherCommunicationRecord;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class WeatherCommunicationRepositoryImpl implements WeatherCommunicationRepository {

	private final DSLContext create;
	
	@Autowired
	public WeatherCommunicationRepositoryImpl(DSLContext create) {
		this.create = create;
	}
	
	@Override
	public void create(Optional<WeatherCommunication> weather) {
		if (!weather.isPresent()) {
			return;
		}
		
		WeatherCommunicationRecord record = create.newRecord(Tables.WEATHER_COMMUNICATION, weather.get());
		record.store();		
	}

	@Override
	public List<WeatherCommunication> getAllWeatherCommunication() {
		return create.select().from(Tables.WEATHER_COMMUNICATION).fetchInto(WeatherCommunication.class);
	}

	@Override
	public void update(Optional<WeatherCommunication> weather) {
		
	}

}
