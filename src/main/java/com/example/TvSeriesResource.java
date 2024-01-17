package com.example;

import com.example.model.Episode;
import com.example.model.TvSeries;
import com.example.proxy.EpisodeProxy;
import com.example.proxy.TvSeriesProxy;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/tvseries")
public class TvSeriesResource {
    Logger logger = LoggerFactory.getLogger(TvSeriesResource.class);
    @RestClient
    TvSeriesProxy tvSeriesProxy;

    @RestClient
    EpisodeProxy episodeProxy;

    //@Metered
    @Timed(name = "performSeries", unit = MetricUnits.MILLISECONDS)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        long start = System.currentTimeMillis();
        logger.info("START {} ", start);
        TvSeries series = tvSeriesProxy.get("game of thrones");
        List<Episode> episodes = episodeProxy.get(series.getId());
        long end = System.currentTimeMillis();
        logger.info("END: {} ", end);
        logger.info("Elapsed: {}", end - start);
        return Response.ok(episodes).build();
    }
}
