package Ejercicio1;

public class DatosFormulario {

	String usuario, contraseña, dni;

	// Constructores 
	
	public DatosFormulario(String usuario, String contraseña, String dni) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.dni = dni;
	}

	public DatosFormulario() {

	}


	//Getters & Setters
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

	

	 //Creamos un toString para mostrar todos los datos
    public String toString() {
        return "Datos del formulario:\n" +
                "Usuario: " + usuario + "\n" +
                "Apellidos: " + contraseña + "\n" +
                "DNI: " + dni + "\n";
    }

	
}
