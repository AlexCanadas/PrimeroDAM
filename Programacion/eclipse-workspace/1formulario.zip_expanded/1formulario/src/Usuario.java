
public class Usuario {
	String dni;
	String nombre;
	String Apellido;
	String email;

protected Usuario(String dni, String nombre, String apellido, String email) {
	this.dni = dni;
	this.nombre = nombre;
	Apellido = apellido;
	this.email = email;
}

protected String getDni() {
	return dni;
}

protected void setDni(String dni) {
	this.dni = dni;
}

protected String getNombre() {
	return nombre;
}

protected void setNombre(String nombre) {
	this.nombre = nombre;
}

protected String getApellido() {
	return Apellido;
}

protected void setApellido(String apellido) {
	Apellido = apellido;
}

protected String getEmail() {
	return email;
}

protected void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Usuario DNI: " + dni + ", Nombre: " + nombre + ", Apellido: " + Apellido + ", email: " + email + "";
}

}
