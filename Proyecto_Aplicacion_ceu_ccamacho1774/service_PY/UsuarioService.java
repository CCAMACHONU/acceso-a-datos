package service_PY;

import java.sql.Connection;
import java.sql.SQLException;

import dao_Usuarios.UsuariosDao;
import dao_Usuarios.UsuariosException;
import modelo_PY.Usuario;

public class UsuarioService {

	public Usuario iniciarSesion(String email, String password)
			throws EmailException, ContraseñaException, UsuariosException {

		Connection conn = null;
		Usuario usuario = new Usuario();
		UsuariosDao usuariosdao = new UsuariosDao();
		Usuario usuario1;
		try {

			conn = new OpenConnection04().abrirConexion();
			usuario1 = usuariosdao.consultarUsuarios(conn, usuario.getEmail());

			if (usuario1 == null) {

				throw new EmailException("El gmail no existe");

			}
			if (!usuario1.getContraseña().equals(password)) {

				throw new ContraseñaException("La contraseña es incorrecta");
			}
			return usuario1;

		} catch (SQLException e) {
			throw new UsuariosException("Error en consultar la base usuarios ", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void registrarUsuario(Usuario user) throws UsuariosException, RegistroException {

		Connection conn = null;
		UsuariosDao usuariosdao = new UsuariosDao();

		try {
			conn = new OpenConnection04().abrirConexion();

			if (usuariosdao.consultarUsuarios(conn, user.getEmail()) == null) {

				usuariosdao.insertarUsuarios(conn, user);

			} else {
				throw new RegistroException("EL usuario ya existe");
			}

		} catch (SQLException e) {
			throw new UsuariosException("Error en consultar la base usuarios ", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
