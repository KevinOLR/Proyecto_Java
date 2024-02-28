package clases;

public class Cliente {
	
	/*Atributos Privados de Clase*/
	private int codigo;
	private String nombres, apellidos, direccion, telef, dni;
	
	/*Constructor de clase*/
	public Cliente(int codigo, String nombres, String apellidos, String direccion, String telef, String dni) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telef = telef;
		this.dni = dni;
	}
	
	/*Métodos públicos set/get*/
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelef() {
		return telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
	

}
