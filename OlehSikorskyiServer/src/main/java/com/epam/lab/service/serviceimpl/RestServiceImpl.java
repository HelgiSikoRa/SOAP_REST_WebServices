package com.epam.lab.service.serviceimpl;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("path")
public class RestServiceImpl {
    private final static Logger LOG = LogManager.getLogger(SoapServiceImpl.class);
    SoapServiceImpl soapService;
    private Gson gson;

    public RestServiceImpl() {
        soapService = new SoapServiceImpl();
        gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/checkBalance")
    public Response checkBalance() {
        return Response.ok(gson.toJson(soapService.checkBalance())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/refillAccount")
    public Response refillAccount(@FormParam("money") Double transferAmountPut) {
        return Response.ok(gson.toJson(soapService.refillAccount(transferAmountPut))).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @PathParam("/withdrawMoney")
    public Response withdrawMoney(@FormParam("money") Double transferAmountGet) {
        return Response.ok(gson.toJson(soapService.withdrawMoney(transferAmountGet))).build();
    }
}