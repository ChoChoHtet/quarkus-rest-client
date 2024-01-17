package com.example;

import io.quarkiverse.freemarker.TemplatePath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/counter")
public class CountResource {

   /* @Inject
    @TemplatePath()*/

    @Inject
    CounterBean counterBean;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String count(){
        return "count: " + counterBean.get();
    }
}
