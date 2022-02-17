package de.claudioaltamura.quarkus.hibernate.search.superheroes.quarkus.hibernate.search.superheroes;

import javax.enterprise.context.Dependent;

@Dependent
public class SuperheroMapper {

	public Superhero toDto(SuperheroEntity superheroEntity) {
		final Superhero superhero = new Superhero();
		superhero.setId(superheroEntity.getId());
		superhero.setName(superheroEntity.getName());
		superhero.setRealName(superheroEntity.getRealName());

		return superhero;
	}

	public SuperheroEntity toEntity(Superhero superhero) {
		final SuperheroEntity superheroEntity = new SuperheroEntity();
		superheroEntity.setName(superhero.getName());
		superheroEntity.setRealName(superhero.getRealName());
		return superheroEntity;
	}
}
