package com.communityratesgames.logging.rest;

import com.communityratesgames.logging.dao.DataAccessLocal;
import com.communityratesgames.logging.domain.Logging;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@NoArgsConstructor
@Stateless
@Path("/logs")
public class LoggingController {

    @Inject
    private DataAccessLocal dal;

    @POST
    @Consumes("application/JSON")
    public Response addLog(String log) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Logging logs = mapper.readValue(log, Logging.class);
            Logging l = dal.addNewLog(logs);
            String temp = mapper.writeValueAsString(l);
            return Response.ok(temp).build();
        }catch (Exception e){
            return Response.status(413).entity(e.getMessage()).build();
        }
    }
}
