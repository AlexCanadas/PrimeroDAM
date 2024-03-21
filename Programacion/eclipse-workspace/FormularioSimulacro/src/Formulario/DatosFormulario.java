package Formulario;

public class DatosFormulario {
String nombre, apellidos, dni, email;

//Getters & Setters
public String getNombre() {
	return nombre;
}

public void setNombre(String _nombre) {
	this.nombre = _nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String _apellidos) {
	this.apellidos = _apellidos;
}

public String getDni() {
	return dni;
}

public void setDni(String _dni) {
	this.dni = _dni;
}

public String getEmail() {
	return email;
}

public void setEmail(String _email) {
	this.email = _email;
}

// Constructor vacío
public DatosFormulario() {
	
}

//Constructor con parámetros
public DatosFormulario(String _nombre, String _apellidos, String _dni, String _email) {
	this.nombre = _nombre;
	this.apellidos = _apellidos;
	this.dni = _dni;
	this.email = _email;
}


}
