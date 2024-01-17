package com.example.filter;

import java.io.IOException;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
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
public class APIRequestFilter implements ContainerRequestFilter {
    @Context
    UriInfo uriInfo;

    Logger LOG = LoggerFactory.getLogger(APIRequestFilter.class);


    @Override
    public void filter(ContainerRequestContext requestContext) {
        long startTime = System.currentTimeMillis();
        LOG.info("Filter StartTime: {}", startTime);

        String requestUrl = uriInfo.getRequestUri().toString();
        LOG.info("Request URL: {}", requestUrl);

        requestContext.setProperty("startTime", startTime);

    }
}