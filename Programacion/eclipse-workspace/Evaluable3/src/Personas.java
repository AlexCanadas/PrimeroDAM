
public abstract class Personas {
	
	private String alias;
	private String contraseña;
	private String email;

public Personas(String alias, String contraseña, String email) {
	this.alias = alias;
	this.contraseña = contraseña;
	this.email = email;
}

public Personas() {
}

public String getAlias() {
	return alias;
}

public void setAlias(String alias) {
	this.alias = alias;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
	



}
