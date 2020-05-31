/*
 * This file is generated by jOOQ.
 */
package bg.unisofia.fmi.soa;


import bg.unisofia.fmi.soa.tables.FlywaySchemaHistory;
import bg.unisofia.fmi.soa.tables.WeatherCommunication;
import bg.unisofia.fmi.soa.tables.records.FlywaySchemaHistoryRecord;
import bg.unisofia.fmi.soa.tables.records.WeatherCommunicationRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>weather-dispatcher</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<WeatherCommunicationRecord, Integer> IDENTITY_WEATHER_COMMUNICATION = Identities0.IDENTITY_WEATHER_COMMUNICATION;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<WeatherCommunicationRecord> WEATHER_COMMUNICATION_PK = UniqueKeys0.WEATHER_COMMUNICATION_PK;
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<WeatherCommunicationRecord, Integer> IDENTITY_WEATHER_COMMUNICATION = Internal.createIdentity(WeatherCommunication.WEATHER_COMMUNICATION, WeatherCommunication.WEATHER_COMMUNICATION.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<WeatherCommunicationRecord> WEATHER_COMMUNICATION_PK = Internal.createUniqueKey(WeatherCommunication.WEATHER_COMMUNICATION, "WEATHER_COMMUNICATION_PK", WeatherCommunication.WEATHER_COMMUNICATION.ID);
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK);
    }
}