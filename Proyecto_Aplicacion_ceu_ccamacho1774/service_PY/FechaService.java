package service_PY;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao_Fecha.FechaDao;
import dao_Fecha.FechaException;
import modelo_PY.Fecha;

public class FechaService {


	
	public List<Fecha> consultarFecha() throws FechaException{
		
	
		Connection conn = null;
		List<Fecha> listafechas = new ArrayList<Fecha>();

		try {
			conn = new OpenConnection04().abrirConexion();
			FechaDao dao = new FechaDao();
			Integer trimestre = 0;
			if (LocalDate.now().getMonthValue() >= 9 || LocalDate.now().getMonthValue() <=11) {
				
				trimestre = 1;	
			}else if(LocalDate.now().getMonthValue() >= 12 || LocalDate.now().getMonthValue() <=2) {
				
				trimestre =2;
			}else if (LocalDate.now().getMonthValue() >= 3 || LocalDate.now().getMonthValue() <=6) {
				
				trimestre = 3;
			}else {
				trimestre = 4;
			}
			
			listafechas = dao.devolverFechas(conn, LocalDate.now().getYear(), trimestre);
			
			if (listafechas.isEmpty()) {
				
				throw new FechaException("La lista esta vacia");	
			}
			
			
		} catch (SQLException e) {
		
			throw new FechaException("Hubo un problema con las fechas", e);
		}
		
		
		return listafechas;
	}

}
