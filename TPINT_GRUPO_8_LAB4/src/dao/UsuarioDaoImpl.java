package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Cliente;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	public int obtenerUltimoIdUsuario() {
		int ultimoId = 0;
		Connection con = Conexion.getConexion().getSQLConexion();
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			String consulta = "SELECT Id FROM Usuarios ORDER BY Id DESC LIMIT 1";
			statement = con.prepareStatement(consulta);
			rs = statement.executeQuery();

			if (rs.next()) {
				ultimoId = rs.getInt("Id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ultimoId;
	}

	@Override
	public boolean insert(Usuario usuario) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion
					.prepareStatement("INSERT INTO Usuarios(Usuario, Contraseña, DNI,activo) VALUES (?, ?, ?,?)");
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getContrasenia());
			statement.setString(3, usuario.getDNI());
			statement.setBoolean(4, true);

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
	public String obtenerIniciales(String nombre, String apellido) {
		String nomInicial = nombre.substring(0, 1);
		String apeInicial = apellido.substring(0, 1);
		return nomInicial + apeInicial;
	}

	public Usuario obtenerUsuarioXdni(String dni) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();

		try {
			String consulta = "SELECT * FROM Usuarios WHERE Dni = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, dni);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String Dni = resultSet.getString("Dni");
				String Us = resultSet.getString("Usuario");
				String Contrasenia = resultSet.getString("Contraseña");
				boolean activo = resultSet.getBoolean("activo");
				return new Usuario(Dni, Us, Contrasenia, activo);
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

	public ArrayList<Usuario> obtenerUsuarios() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			String consulta = "SELECT * FROM Usuarios";
			statement = conexion.prepareStatement(consulta);
			rs = statement.executeQuery();

			while (rs.next()) {
				String id = rs.getString("Id");
				String us = rs.getString("Usuario");
				String contrasenia = rs.getString("Contraseña");
				String dni = rs.getString("DNI");
				boolean state = rs.getBoolean("activo");

				Usuario usuario = new Usuario(id, us, contrasenia, dni, state);
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaUsuarios;
	}

	@Override
	public String generarUsuario(String iniciales, int ultimoId) {
		int nuevoId = ultimoId + 1;
		return iniciales + nuevoId;
	}

	public boolean modficarUsuario(String contrasenia, String dni) {

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modificarContrasenia = false;
		try {
			statement = conexion.prepareStatement("UPDATE Usuarios set Contraseña=? where Dni = ?");
			statement.setString(1, contrasenia);
			statement.setString(2, dni);

			if (statement.executeUpdate() > 0) {
				conexion.commit();
				modificarContrasenia = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return modificarContrasenia;
	}

	@Override
	public boolean deleteLogico(String dni) {

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement("UPDATE Usuarios SET administrador = ? WHERE dni = ?");
			statement.setBoolean(1, false); // Set the 'state' to false for logical delete
			statement.setString(2, dni);

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

		return isDeleteExitoso;
	}
}
