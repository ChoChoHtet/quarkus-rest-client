package com.example;

import com.example.model.Episode;
import com.example.model.TvSeries;
import com.example.proxy.EpisodeProxy;
import com.example.proxy.TvSeriesProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/tvseries")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy tvSeriesProxy;

    @RestClient
    EpisodeProxy episodeProxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
      TvSeries series =  tvSeriesProxy.get("game of thrones");
      List<Episode> episodes = episodeProxy.get(series.getId());
        return Response.ok(episodes).build();
    }
}
