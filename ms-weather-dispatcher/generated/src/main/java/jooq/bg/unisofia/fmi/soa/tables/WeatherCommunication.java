/*
 * This file is generated by jOOQ.
 */
package bg.unisofia.fmi.soa.tables;


import bg.unisofia.fmi.soa.Indexes;
import bg.unisofia.fmi.soa.Keys;
import bg.unisofia.fmi.soa.WeatherDispatcher;
import bg.unisofia.fmi.soa.tables.records.WeatherCommunicationRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WeatherCommunication extends TableImpl<WeatherCommunicationRecord> {

    private static final long serialVersionUID = -81815209;

    /**
     * The reference instance of <code>weather-dispatcher.WEATHER_COMMUNICATION</code>
     */
    public static final WeatherCommunication WEATHER_COMMUNICATION = new WeatherCommunication();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WeatherCommunicationRecord> getRecordType() {
        return WeatherCommunicationRecord.class;
    }

    /**
     * The column <code>weather-dispatcher.WEATHER_COMMUNICATION.ID</code>.
     */
    public final TableField<WeatherCommunicationRecord, Integer> ID = createField(DSL.name("ID"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>weather-dispatcher.WEATHER_COMMUNICATION.CITY</code>.
     */
    public final TableField<WeatherCommunicationRecord, String> CITY = createField(DSL.name("CITY"), org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>weather-dispatcher.WEATHER_COMMUNICATION.COUNTRY</code>.
     */
    public final TableField<WeatherCommunicationRecord, String> COUNTRY = createField(DSL.name("COUNTRY"), org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>weather-dispatcher.WEATHER_COMMUNICATION.FOR_DATE</code>.
     */
    public final TableField<WeatherCommunicationRecord, LocalDate> FOR_DATE = createField(DSL.name("FOR_DATE"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>weather-dispatcher.WEATHER_COMMUNICATION.REQUEST_TIMESTAMP</code>.
     */
    public final TableField<WeatherCommunicationRecord, LocalDateTime> REQUEST_TIMESTAMP = createField(DSL.name("REQUEST_TIMESTAMP"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * Create a <code>weather-dispatcher.WEATHER_COMMUNICATION</code> table reference
     */
    public WeatherCommunication() {
        this(DSL.name("WEATHER_COMMUNICATION"), null);
    }

    /**
     * Create an aliased <code>weather-dispatcher.WEATHER_COMMUNICATION</code> table reference
     */
    public WeatherCommunication(String alias) {
        this(DSL.name(alias), WEATHER_COMMUNICATION);
    }

    /**
     * Create an aliased <code>weather-dispatcher.WEATHER_COMMUNICATION</code> table reference
     */
    public WeatherCommunication(Name alias) {
        this(alias, WEATHER_COMMUNICATION);
    }

    private WeatherCommunication(Name alias, Table<WeatherCommunicationRecord> aliased) {
        this(alias, aliased, null);
    }

    private WeatherCommunication(Name alias, Table<WeatherCommunicationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> WeatherCommunication(Table<O> child, ForeignKey<O, WeatherCommunicationRecord> key) {
        super(child, key, WEATHER_COMMUNICATION);
    }

    @Override
    public Schema getSchema() {
        return WeatherDispatcher.WEATHER_DISPATCHER;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_7);
    }

    @Override
    public Identity<WeatherCommunicationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_WEATHER_COMMUNICATION;
    }

    @Override
    public UniqueKey<WeatherCommunicationRecord> getPrimaryKey() {
        return Keys.WEATHER_COMMUNICATION_PK;
    }

    @Override
    public List<UniqueKey<WeatherCommunicationRecord>> getKeys() {
        return Arrays.<UniqueKey<WeatherCommunicationRecord>>asList(Keys.WEATHER_COMMUNICATION_PK);
    }

    @Override
    public WeatherCommunication as(String alias) {
        return new WeatherCommunication(DSL.name(alias), this);
    }

    @Override
    public WeatherCommunication as(Name alias) {
        return new WeatherCommunication(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WeatherCommunication rename(String name) {
        return new WeatherCommunication(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WeatherCommunication rename(Name name) {
        return new WeatherCommunication(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, LocalDate, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
