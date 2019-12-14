package arijitbasu.monitor.pojo;

import javax.persistence.*;

@Entity
@Table(name = "temperature")
public class Temperature {

    private static final long serialVersionUID = -7415410969017941320L;

    private Long id;

    private Double temperature;

    private long ts;

    private String sensor;

    public Temperature(String sensor, Double temperature, long ts) {
        this.temperature = temperature;
        this.ts = ts;
        this.sensor = sensor;
    }

    @Column(name = "temperature", nullable = false)
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Column(name = "ts")
    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    @Column(name = "sensor")
    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
