package de.claudioaltamura.quarkus.hibernate.search.superheroes.quarkus.hibernate.search.superheroes;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

public class Superhero {

	private Long id;

	@NotEmpty
	private String name;

	private String realName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Superhero superhero = (Superhero) o;
		return id.equals(superhero.id) && name.equals(superhero.name) && Objects.equals(realName, superhero.realName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, realName);
	}

	@Override
	public String toString() {
		return "Superhero{" +
				"id=" + id +
				", name='" + name + '\'' +
				", realName='" + realName + '\'' +
				'}';
	}
}
