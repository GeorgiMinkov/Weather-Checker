package bg.unisofia.fmi.soa.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class WeatherCommunicationTable {
    private Integer       id;
    private String        city;
    private String        country;
    private LocalDate     forDate;
    private LocalDateTime requestTimestamp;
}
