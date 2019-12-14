package arijitbasu.monitor.application.service.requests.pojo;

import arijitbasu.monitor.enums.TemperatureUnit;

public class SensorTemperature {

    private String sensor;

    private Double Temperature;

    private long ts;

    private TemperatureUnit temperatureUnit = TemperatureUnit.K;

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public Double getTemperature() {
        return Temperature;
    }

    public void setTemperature(Double temperature) {
        Temperature = temperature;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }
}
