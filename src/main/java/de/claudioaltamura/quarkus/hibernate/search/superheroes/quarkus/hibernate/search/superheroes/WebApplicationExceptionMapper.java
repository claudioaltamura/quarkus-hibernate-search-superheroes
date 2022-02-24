package de.claudioaltamura.quarkus.hibernate.search.superheroes.quarkus.hibernate.search.superheroes;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(final WebApplicationException exception) {
		final Response.StatusType responseStatusInfo = exception.getResponse().getStatusInfo();
		final Error error =
				new Error(responseStatusInfo.getStatusCode(), exception.getMessage());
		return Response.status(responseStatusInfo).entity(error).build();
	}
}