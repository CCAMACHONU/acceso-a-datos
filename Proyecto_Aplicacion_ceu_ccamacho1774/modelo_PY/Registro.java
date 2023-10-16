package modelo_PY;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Registro {

	private Integer id_Registro;
	private Integer id_Usuario;
	private LocalDate fecha;
	private BigDecimal num_Horas;
	private String descripcion;

	public Integer getId_Registro() {
		return id_Registro;
	}

	public void setId_Registro(Integer id_Registro) {
		this.id_Registro = id_Registro;
	}

	public Integer getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getNum_Horas() {
		return num_Horas;
	}

	public void setNum_Horas(BigDecimal num_Horas) {
		this.num_Horas = num_Horas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "registro [id_Registro=" + id_Registro + ", id_Usuario=" + id_Usuario + ", fecha=" + fecha
				+ ", num_Horas=" + num_Horas + ", descripcion=" + descripcion + "]";
	}
	
	

}
