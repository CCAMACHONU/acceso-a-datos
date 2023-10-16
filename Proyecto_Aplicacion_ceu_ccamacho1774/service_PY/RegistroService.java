package service_PY;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao_Registro.RegistroDao;
import modelo_PY.Registro;

public class RegistroService {

	public List<Registro> consultarRegistroUsuario(Integer id_usuario) throws RegistroException {

		Connection conn = null;
		List<Registro> listaRegistro = new ArrayList<Registro>();

		RegistroDao DaoRegistro = new RegistroDao();

		try {
			conn = new OpenConnection04().abrirConexion();
			listaRegistro = DaoRegistro.consultarRegistro(conn, id_usuario);

		} catch (SQLException e) {
			throw new RegistroException("Error en consultar la base registros ", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listaRegistro;

	}

	public void crearRegistro(Registro registro) throws RegistroException {

		Connection conn = null;
		RegistroDao daoRegistro = new RegistroDao();
		

		try {

			conn = new OpenConnection04().abrirConexion();
			Registro registro2 = new Registro();
			registro2 = daoRegistro.cogerUnRegistro(conn, registro.getId_Registro(), registro.getFecha());
			
			
			if (registro2 != null) {
				
				throw new RegistroException("EL usuario ya existe");
				
			} else {

				daoRegistro.insertarRegistro(conn, registro);
			}

		} catch (SQLException e) {
			throw new RegistroException("Error en consultar la base registros ", e);
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
