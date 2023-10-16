package dao_Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo_PY.Usuario;

public class UsuariosDao {

	public Usuario consultarUsuarios(Connection conn, String email) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		Usuario usuario = new Usuario();
		String sql = "select * from usuarios where email='" + email + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {

				usuario.setId_Usuario(rs.getInt("id_usuario"));
				usuario.setEmail(rs.getString("email"));
				usuario.setContraseña(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setCiclo(rs.getString("ciclo"));
				usuario.setActivo(rs.getBoolean("activo"));

			} else {
				return null;
			}

		} finally {
			if (stmt != null) {

				stmt.close();
			}
		}

		return usuario;

	}

	public Long insertarUsuarios(Connection conn, Usuario user) throws SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement(

					"INSERT INTO USUARIOS(email,password,nombre,apellidos,ciclo,activo) VALUES (?,?,?,?,?,?)",

					Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getContraseña());
			stmt.setString(3, user.getNombre());
			stmt.setString(4, user.getApellidos());
			stmt.setString(5, user.getCiclo());
			stmt.setBoolean(6, user.getActivo());
			stmt.execute();

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

}
