package arijitbasu.monitor.application.service;

import arijitbasu.monitor.application.service.requests.pojo.SensorTemperature;
import arijitbasu.monitor.application.service.response.pojo.Temperature;
import arijitbasu.monitor.bo.MonitorBo;
import arijitbasu.monitor.enums.TemperatureUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Component
@Path("")
public class TemperatureRegisterService {


    @Autowired
    private MonitorBo monitorBo;

    private static final Logger logger = LoggerFactory.getLogger(TemperatureRegisterService.class);

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Context ContainerRequestContext requestContext, SensorTemperature sensorTemperature) {
        monitorBo.saveTemperature(sensorTemperature.getSensor(), sensorTemperature.getTemperature(), sensorTemperature.getTs());
        return Response.status(Response.Status.OK).build();
    }

}
