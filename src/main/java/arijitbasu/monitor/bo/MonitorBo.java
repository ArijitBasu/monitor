package arijitbasu.monitor.bo;

public interface MonitorBo {

    Double getAverageTemperature(long startTs, long endTs);

    Double getMinimumTemperature(long startTs, long endTs);

    Double getMaximumTemperature(long startTs, long endTs);

    void saveTemperature(String sensor, Double temperature, long ts);

}
