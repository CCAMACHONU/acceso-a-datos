package modelo_PY;

public class Usuario {

	private Integer id_Usuario;
	private String email;
	private String contraseña;
	private String nombre;
	private String apellidos;
	private String ciclo;
	private Boolean activo;
	
	public Integer getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "usuario [id_Usuario=" + id_Usuario + ", email=" + email + ", contraseña=" + contraseña + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo + ", activo=" + activo + "]";
	}
	
	
	
	
}
