package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;
import dominio.Cuenta;

public class CuentaDaoImpl implements CuentaDao {

	private static final String insert = "INSERT INTO cuentas(NroCuenta,DniCliente,CBU,Tipo,FechaCreacion,Saldo,Activa) VALUES(?,?,?,?,?,?,?)";
	private static final String readall = "SELECT * FROM Cuentas";
	private static final String delete = "UPDATE cuentas SET activa = ? WHERE CBU = ?";

	public boolean insert(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cuenta.getNroCuenta());
			statement.setString(2, cuenta.getDniCliente());
			statement.setString(3, cuenta.getCBU());
			statement.setString(4, cuenta.getTipo());
			statement.setString(5, cuenta.getFechaCreacion());
			statement.setDouble(6, cuenta.getSaldo());
			statement.setBoolean(7, cuenta.getActiva());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isInsertExitoso;
	}

	@Override
	public boolean deleteLogico(String CBU) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		
		System.out.println("cbu: "+CBU);
		
		try {
			statement = conexion.prepareStatement(delete);
			statement.setBoolean(1, false);
			statement.setString(2, CBU);
			
			
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isDeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.println("ES DELETE : EXITO O FALSE: "+isDeleteExitoso);
		return isDeleteExitoso;
	}

	@Override
	public List<Cuenta> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Cuenta> cuenta = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cuenta.add(getCuenta(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuenta;
	}

	private Cuenta getCuenta(ResultSet resultSet) throws SQLException {
		String Nrocuenta = resultSet.getString("NroCuenta");
		String DniCliente = resultSet.getString("DniCliente");
		String CBU = resultSet.getString("CBU");
		String IdTipo = resultSet.getString("IdTipo");
		String FechaCreacion = resultSet.getString("FechaCreacion");
		String Saldo = resultSet.getString("Saldo");
		Boolean activa = resultSet.getBoolean("activa");
		return new Cuenta(DniCliente,IdTipo, FechaCreacion, activa);
	}

	@Override
	public boolean update(Cuenta cuenta_a_modificar, int CBU) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cuenta obtenerCuentaXCbu(String Cbu) {
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    Connection conexion = Conexion.getConexion().getSQLConexion();

	    try {
	        String consulta = "SELECT * FROM cuentas WHERE CBU = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setString(1, Cbu);

	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            System.out.println("Entró: ");
	            String DniCliente = resultSet.getString("DniCliente");
	            String CBU = resultSet.getString("CBU"); 
	            String IdTipo = resultSet.getString("Tipo");
	            String NroCuenta = resultSet.getString("NroCuenta");
	            String FechaCreacion = resultSet.getString("FechaCreacion");
	            double Saldo = resultSet.getDouble("Saldo"); 
	            boolean activa = resultSet.getBoolean("Activa"); 
	            Cuenta cuenta = new Cuenta(NroCuenta, DniCliente, CBU, IdTipo, FechaCreacion, Saldo, activa);

	            return cuenta;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null)
	                resultSet.close();
	            if (statement != null)
	                statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return null;
	}



	public int cantidadCuentasXdni(String dni) {
		int cant = 0;

		return cant;
	}

	public List<Cuenta> listaCuentaXdni(String dni) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Cuenta> cuenta = new ArrayList<Cuenta>();
		Connection conexion = Conexion.getConexion().getSQLConexion();

		try {
			String consulta = "SELECT c.NroCuenta FROM db_banco.cuentas c INNER JOIN clientes cli ON C.CBU = cli.CBU WHERE cli.Dni = ?";
			
			
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, dni);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String NroCuenta = resultSet.getString("NroCuenta");
				

				cuenta.add(getCuenta(resultSet));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cuenta;

	}
	
	


}