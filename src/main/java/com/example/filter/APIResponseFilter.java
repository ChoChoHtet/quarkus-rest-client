package com.example.filter;

import java.io.IOException;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@PreMatching
@Priority(1)
@ApplicationScoped
public class APIResponseFilter implements ContainerResponseFilter {
    @Context
    UriInfo uriInfo;

    Logger LOG = LoggerFactory.getLogger(APIResponseFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        long startTime = (long) requestContext.getProperty("startTime");

        // Calculate the time taken for the request and response
        long endTime = System.currentTimeMillis();
        LOG.info("Filter EndTime: {}", endTime);
        long elapsedTime = endTime - startTime;
        int responseStatus = responseContext.getStatus();

        LOG.info("Response Elapsed: {}, Status: {}", elapsedTime, responseStatus);


    }
}
