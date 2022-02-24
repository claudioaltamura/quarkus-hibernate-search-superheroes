package de.claudioaltamura.quarkus.hibernate.search.superheroes.quarkus.hibernate.search.superheroes;

public class Error {

	private int errorCode;

	private String message;

	public Error(){}

	public Error(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Error{" +
				"errorCode='" + errorCode + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
