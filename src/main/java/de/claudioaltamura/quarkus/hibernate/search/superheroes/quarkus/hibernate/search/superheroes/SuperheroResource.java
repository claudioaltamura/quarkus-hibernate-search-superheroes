package de.claudioaltamura.quarkus.hibernate.search.superheroes.quarkus.hibernate.search.superheroes;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/api/v1/superheroes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SuperheroResource {

	private final SuperheroService superheroService;

	public SuperheroResource(SuperheroService superheroService) {
		this.superheroService = superheroService;
	}

	@GET
	public Response get() {
		return Response.ok(superheroService.findAll()).build();
	}

	@GET
	@Path("/{superheroId}")
	public Response getById(@PathParam("superheroId") @NotNull Long superheroId) {
		return Response.ok(superheroService.findById(superheroId)).build();
	}

	@POST
	public Response post(@Valid Superhero superhero, @Context UriInfo uriInfo) {
		final Superhero saved = superheroService.save(superhero);

		final UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(Long.toString(saved.getId()));
		return Response.created(uriBuilder.build()).entity(saved).build();
	}

	@PUT
	public Response put(@Valid Superhero superhero) {
		final Superhero updated = superheroService.update(superhero);
		return Response.ok(updated).build();
	}

	@DELETE
	@Path("/{superheroId}")
	public Response delete(@PathParam("id") @NotNull Long superheroId) {
		superheroService.deleteById(superheroId);
		return Response.noContent().build();
	}

	@GET
	@Path("/search/{name}")
	public Response search(@PathParam("name") @NotEmpty String name) {
		return Response.ok(superheroService.search(name)).build();
	}
}