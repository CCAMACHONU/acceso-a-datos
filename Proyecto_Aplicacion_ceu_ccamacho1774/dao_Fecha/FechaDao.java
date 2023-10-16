package dao_Fecha;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo_PY.Fecha;

public class FechaDao {

	
	public List<Fecha> devolverFechas(Connection conn, Integer año, Integer eva) throws FechaException, SQLException{
		
		Statement stmt = null;
		ResultSet rs = null;

		List<Fecha> lista_fecha= new ArrayList<Fecha>();
		String sql = "select * from fechas where año = ? and evaluacion = ?";  

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Fecha fecha = new Fecha();

			
				fecha.setFecha(rs.getDate("fecha").toLocalDate());
				fecha.setAño(rs.getInt("año"));
				fecha.setEvaluacion(rs.getInt("evaluacion"));
				fecha.setDisponibilidad(rs.getInt("disponibilidad"));

				lista_fecha.add(fecha);

			}

		}catch (SQLException e) {
			throw new FechaException("Da fallo en la base de datos de fechas", e);
			
		} 
		finally {
			if (stmt != null) {
				stmt.close();

			}
		}

		return lista_fecha;

		
	}
	

}
