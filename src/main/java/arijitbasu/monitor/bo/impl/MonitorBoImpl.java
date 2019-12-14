package arijitbasu.monitor.bo.impl;

import arijitbasu.monitor.bo.MonitorBo;
import arijitbasu.monitor.dao.MonitorDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MonitorBoImpl implements MonitorBo {

    @Autowired
    private MonitorDao monitorDao;

    public MonitorDao getMonitorDao() {
        return monitorDao;
    }

    public void setMonitorDao(MonitorDao monitorDao) {
        this.monitorDao = monitorDao;
    }

    @Override
    public Double getAverageTemperature(long startTs, long endTs) {
        return monitorDao.getAverageTemperature(startTs, endTs);
    }

    @Override
    public Double getMinimumTemperature(long startTs, long endTs) {
        return monitorDao.getMinimumTemperature(startTs, endTs);
    }

    @Override
    public Double getMaximumTemperature(long startTs, long endTs) {
        return monitorDao.getMaximumTemperature(startTs, endTs);
    }

    @Override
    public void saveTemperature(String sensor, Double temperature, long ts) {
        monitorDao.saveTemperature(sensor, temperature, ts);
    }
}
