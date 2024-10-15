package Ejercicio1;

public class Usuario {
	String usuario, contraseña, dni;

	public Usuario(String usuario, String contraseña, String dni) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.dni = dni;
	}

	public Usuario() {

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "\n Usuario \n {usuario: " + usuario + " \n contraseña: " + contraseña + " \n dni: " + dni + "}";
	}

}
