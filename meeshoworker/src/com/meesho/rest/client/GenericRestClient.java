package com.meesho.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

public class GenericRestClient {
	public Response callRestApi(String URL, String[] headers, RestRequestType type, String urlParams,String jsonPayload) {
		//TODO add rest api calling code

		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
        WebTarget webTarget = client.target(URL);
        Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_JSON);
        //here we are passing generic message object as a payload to the rest api
    	Response response = invocationBuilder.post(Entity.entity(jsonPayload, MediaType.APPLICATION_JSON));
		
		//return response object
		return response;
	}
}
