package arijitbasu.monitor.application.service;

import arijitbasu.monitor.application.service.response.pojo.Temperature;
import arijitbasu.monitor.bo.MonitorBo;
import arijitbasu.monitor.enums.TemperatureUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("")
public class TemperatureService {

    @Autowired
    private MonitorBo monitorBo;

    private static final Logger logger = LoggerFactory.getLogger(TemperatureRegisterService.class);

    @Path("/min")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMinimumTemperature(@Context ContainerRequestContext requestContext, @QueryParam("startTs") long minTs, @QueryParam("endTs") long maxTs) {
        Double temperature = monitorBo.getMinimumTemperature(minTs, maxTs);
        return Response.status(Response.Status.OK).entity(new Temperature(temperature, TemperatureUnit.K)).build();
    }



    @Path("/max")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMaximumTemperature(@Context ContainerRequestContext requestContext, @QueryParam("startTs") long minTs, @QueryParam("endTs") long maxTs) {
        Double temperature = monitorBo.getMaximumTemperature(minTs, maxTs);
        return Response.status(Response.Status.OK).entity(new Temperature(temperature, TemperatureUnit.K)).build();
    }


    @Path("/avg")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAverageTemperature(@Context ContainerRequestContext requestContext, @QueryParam("startTs") long minTs, @QueryParam("endTs") long maxTs) {
        Double temperature = monitorBo.getAverageTemperature(minTs, maxTs);
        return Response.status(Response.Status.OK).entity(new Temperature(temperature, TemperatureUnit.K)).build();
    }
}
