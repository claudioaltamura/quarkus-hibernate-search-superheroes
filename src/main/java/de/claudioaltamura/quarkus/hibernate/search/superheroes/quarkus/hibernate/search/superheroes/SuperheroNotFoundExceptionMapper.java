package de.claudioaltamura.quarkus.hibernate.search.superheroes.quarkus.hibernate.search.superheroes;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

@Provider
public class SuperheroNotFoundExceptionMapper implements ExceptionMapper<Exception> {

	private static final Logger LOGGER = Logger.getLogger(SuperheroNotFoundExceptionMapper.class);

	@Context
	private UriInfo uriInfo;

	@Override
	public Response toResponse(final Exception exception) {
		LOGGER.errorf("Handling uncaught exception on request path: %s", uriInfo.getAbsolutePath(), exception);
		final Error error = new Error(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), exception.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}

}