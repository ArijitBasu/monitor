package arijitbasu.monitor.application.service.response.pojo;

import arijitbasu.monitor.enums.TemperatureUnit;

public class Temperature {

    private Double temperature;

    private TemperatureUnit temperatureUnit;

    public Temperature(Double temperature, TemperatureUnit temperatureUnit) {
        this.temperature = temperature;
        this.temperatureUnit = temperatureUnit;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(TemperatureUnit temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }
}
