package arijitbasu.monitor.dao.impl;

import arijitbasu.monitor.dao.MonitorDao;
import arijitbasu.monitor.pojo.Temperature;
import org.hibernate.criterion.*;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class MonitorDaoImpl extends HibernateDaoSupport implements MonitorDao {


    private Double getAggregateTemperature(long minTs, long maxTs, AggregateProjection projection) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Temperature.class)
                .add(Restrictions.lt("ts", maxTs)).add(Restrictions.ge("ts", minTs));
        detachedCriteria.setProjection(projection);
        List list = getHibernateTemplate().findByCriteria(detachedCriteria);
        return  (Double) list.get(0);
    }


    public Double getAverageTemperature(long minTs, long maxTs) {
        return getAggregateTemperature(minTs, maxTs, Projections.avg("temperature"));
    }


    public Double getMinimumTemperature(long minTs, long maxTs) {
        return getAggregateTemperature(minTs, maxTs, Projections.min("temperature"));
    }

    public Double getMaximumTemperature(long minTs, long maxTs) {
        return getAggregateTemperature(minTs, maxTs, Projections.max("temperature"));
    }

    @Override
    public void saveTemperature(String sensor, Double temp, long ts) {
        Temperature temperature = new Temperature(sensor, temp, ts);
        getSessionFactory().getCurrentSession().save(temperature);
    }
}
