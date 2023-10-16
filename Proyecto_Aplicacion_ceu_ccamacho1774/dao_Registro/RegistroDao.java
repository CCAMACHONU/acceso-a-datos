package dao_Registro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo_PY.Registro;
import service_PY.RegistroException;

public class RegistroDao {

	public List<Registro> consultarRegistro(Connection conn, Integer id_usuario) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		List<Registro> lista_Registros = new ArrayList<Registro>();
		String sql = "select * from registros where id_usuario=" + id_usuario;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Registro registro = new Registro();

				registro.setId_Registro(rs.getInt("id_registro"));
				registro.setId_Usuario(rs.getInt("id_usuario"));
				LocalDate date = rs.getDate("fecha").toLocalDate();
				registro.setFecha(date);
				registro.setNum_Horas(rs.getBigDecimal("num_horas"));
				registro.setDescripcion(rs.getString("descripcion"));

				lista_Registros.add(registro);

			}

		} finally {
			if (stmt != null) {
				stmt.close();

			}
		}

		return lista_Registros;

	}

	public Long insertarRegistro(Connection conn, Registro registro) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement(

					"INSERT INTO REGISTROS(id_usuario,fecha,num_horas,descripcion) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, registro.getId_Usuario());
			stmt.setDate(2, Date.valueOf(registro.getFecha()));
			stmt.setBigDecimal(3, registro.getNum_Horas());
			stmt.setString(4, registro.getDescripcion());

			rs = stmt.getGeneratedKeys();
			rs.next();

			Long id = rs.getLong(1);

			return id;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}

	}

	public Registro cogerUnRegistro(Connection conn, Integer id, LocalDate fecha) throws RegistroException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Registro registro2 = new Registro();

		try {

			String sql = "Select * from registro where id_usuario = ? and fecha = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.setDate(2, Date.valueOf(fecha));

			rs = stmt.executeQuery();
			rs.next();

			if (rs.next()) {

				registro2.setId_Registro(rs.getInt("id_registro"));
				registro2.setId_Usuario(rs.getInt("id_usuario"));
				LocalDate date = rs.getDate("fecha").toLocalDate();
				registro2.setFecha(date);
				registro2.setNum_Horas(rs.getBigDecimal("num_horas"));
				registro2.setDescripcion(rs.getString("descripcion"));
				
				return registro2;
			}

		} catch (SQLException e) {
			throw new RegistroException("Ha fallado los registros de la base de datos",e);
		}
		
		return null;

	}

}
