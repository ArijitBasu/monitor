package arijitbasu.monitor.dao;

public interface MonitorDao {

    Double getAverageTemperature(long minTs, long MaxTs);

    Double getMinimumTemperature(long minTs, long maxTs);

    Double getMaximumTemperature(long minTs, long maxTs);

    void saveTemperature(String sensor, Double temperature, long ts);
}
