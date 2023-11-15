package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	private static final String insert = "INSERT INTO clientes(Dni,Cuil,CBU,Apellido,Nombre,FechaNacimiento,Sexo,Nacionalidad,Email,Telefono,Direccion,Provincia,Localidad,Activo,Administrador,Contrasenia) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String readall = "SELECT * FROM Clientes";

	public boolean insert(Cliente cliente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getCbu());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getNombre());
			statement.setString(6, cliente.getFechaNacimiento());
			statement.setString(7, cliente.getSexo());
			statement.setString(8, cliente.getNacionalidad());
			statement.setString(9, cliente.getEmail());
			statement.setString(10, cliente.getTelefono());
			statement.setString(11, cliente.getDireccion());
			statement.setString(12, cliente.getProvincia());
			statement.setString(13, cliente.getLocalidad());
			statement.setBoolean(14, cliente.getactivo());
			statement.setBoolean(15, cliente.getAdministrador());
			statement.setString(16, cliente.getContrasenia());
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

	public boolean deleteLogico(String dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement("UPDATE Clientes SET activo = ? WHERE dni = ?");
			statement.setBoolean(1, false); // Set the 'state' to false for logical delete
			statement.setString(2, dni);

			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	public List<Cliente> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 boolean activo = resultSet.getBoolean("Activo");
		            
		            if (activo) {
		                clientes.add(getCliente(resultSet));
		            }
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	private Cliente getCliente(ResultSet resultSet) throws SQLException {
		String Dni = resultSet.getString("Dni");
		String Cuil = resultSet.getString("Cuil");
		String Cbu = resultSet.getString("CBU");
		String Nombre = resultSet.getString("Nombre");
		String Apellido = resultSet.getString("Apellido");
		String fechaNacimiento = resultSet.getString("FechaNacimiento");
		String Sexo = resultSet.getString("Sexo");
		String Nacionalidad = resultSet.getString("Nacionalidad");
		String Email = resultSet.getString("Email");
		String Telefono = resultSet.getString("Telefono");
		String Direccion = resultSet.getString("Direccion");
		String Localidad = resultSet.getString("Localidad");
		String Provincia = resultSet.getString("Provincia");
		boolean Activo = resultSet.getBoolean("Activo");
		boolean Administrador = resultSet.getBoolean("Administrador");
		String Contrasenia = resultSet.getString("Contrasenia");
		return new Cliente(Dni, Cuil, Cbu, Nombre, Apellido, fechaNacimiento, Sexo, Nacionalidad, Email, Telefono,
				Direccion, Provincia, Localidad, Activo, Administrador, Contrasenia);
	}

	public boolean update(Cliente cliente_a_modificar, String dniCuenta) {
		PreparedStatement statement = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;

		try {
			String consulta = "UPDATE clientes SET Dni = ?, Cuil = ?, Cbu = ?, Nombre = ?, Apellido = ?, fechaNacimiento = ?, Sexo = ?, Nacionalidad = ?, Email = ?, Telefono = ?, Direccion = ?, Localidad = ?, Provincia = ?, activo = ?, Administrador = ?, Contrasenia = ? WHERE Dni = ?";
			statement = conexion.prepareStatement(consulta);

			// Establecer los valores de los parámetros en la sentencia SQL
			statement.setString(1, cliente_a_modificar.getDni());
			statement.setString(2, cliente_a_modificar.getCuil());
			statement.setString(3, cliente_a_modificar.getCbu());
			statement.setString(4, cliente_a_modificar.getNombre());
			statement.setString(5, cliente_a_modificar.getApellido());
			statement.setString(6, cliente_a_modificar.getFechaNacimiento());
			statement.setString(7, cliente_a_modificar.getSexo());
			statement.setString(8, cliente_a_modificar.getNacionalidad());
			statement.setString(9, cliente_a_modificar.getEmail());
			statement.setString(10, cliente_a_modificar.getTelefono());
			statement.setString(11, cliente_a_modificar.getDireccion());
			statement.setString(12, cliente_a_modificar.getLocalidad());
			statement.setString(13, cliente_a_modificar.getProvincia());
			statement.setBoolean(14, cliente_a_modificar.getactivo());
			statement.setBoolean(15, cliente_a_modificar.getAdministrador());
			statement.setString(16, cliente_a_modificar.getContrasenia());
			statement.setString(17, dniCuenta);

			int filasActualizadas = statement.executeUpdate();

			if (filasActualizadas > 0) {
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isUpdateExitoso;
	}

	@Override
	public Cliente obtenerClienteXdni(String dni) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();

		try {
			String consulta = "SELECT * FROM clientes WHERE Dni = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, dni);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String Dni = resultSet.getString("Dni");
				String Cuil = resultSet.getString("Cuil");
				String Cbu = resultSet.getString("CBU");
				String Nombre = resultSet.getString("Nombre");
				String Apellido = resultSet.getString("Apellido");
				String fechaNacimiento = resultSet.getString("FechaNacimiento");
				String Sexo = resultSet.getString("Sexo");
				String Nacionalidad = resultSet.getString("Nacionalidad");
				String Email = resultSet.getString("Email");
				String Telefono = resultSet.getString("Telefono");
				String Direccion = resultSet.getString("Direccion");
				String Localidad = resultSet.getString("Localidad");
				String Provincia = resultSet.getString("Provincia");
				boolean activo = resultSet.getBoolean("activo");
				boolean Administrador = resultSet.getBoolean("Administrador");
				String Contrasenia = resultSet.getString("Contrasenia");
				Cliente cliente = new Cliente(Dni, Cuil, Cbu, Nombre, Apellido, fechaNacimiento, Sexo, Nacionalidad,
						Email, Telefono, Direccion, Localidad, Provincia, activo, Administrador, Contrasenia);
				return cliente;

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

	@Override
	public boolean validarAdmin(String user, String pass) {
		PreparedStatement preparedStatement = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet = null;

		try {
			String consulta = "SELECT * FROM Clientes WHERE Email = ? AND Contrasenia = ? AND Administrador = 1";
			preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);

			resultSet = preparedStatement.executeQuery();

			// Verificar si hay al menos una fila en el resultado y si el cliente es un
			// administrador
			boolean esAdmin = resultSet.next() && resultSet.getBoolean("Administrador");

			// Mensaje de log aquí, dentro del bloque try
			if (esAdmin) {
				System.out.println("Usuario Admin");
			} else {
				System.out.println("Usuario no admin");
			}

			return esAdmin;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean loginExitoso(String user, String pass) {
		PreparedStatement preparedStatement = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet = null;

		try {
			String consulta = "SELECT * FROM Clientes WHERE Email = ? AND Contrasenia = ?";
			preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);

			resultSet = preparedStatement.executeQuery();

			// Verificar si hay al menos una fila en el resultado
			return resultSet.next();
		} catch (SQLException e) {
			// Manejar la excepción de manera más controlada, por ejemplo, registrándola en
			// un sistema de log
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean modificarContasenia(String contrasenia, String dni) {

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modificarContrasenia = false;
		try {
			statement = conexion.prepareStatement("UPDATE Clientes set Contrasenia=? where Dni = ?");
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
	
	public Cliente buscarXusuario(String user) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();

		try {
			String consulta = "SELECT * FROM clientes WHERE Email = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, user);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String Dni = resultSet.getString("Dni");
				String Cuil = resultSet.getString("Cuil");
				String Cbu = resultSet.getString("CBU");
				String Nombre = resultSet.getString("Nombre");
				String Apellido = resultSet.getString("Apellido");
				String fechaNacimiento = resultSet.getString("FechaNacimiento");
				String Sexo = resultSet.getString("Sexo");
				String Nacionalidad = resultSet.getString("Nacionalidad");
				String Email = resultSet.getString("Email");
				String Telefono = resultSet.getString("Telefono");
				String Direccion = resultSet.getString("Direccion");
				String Localidad = resultSet.getString("Localidad");
				String Provincia = resultSet.getString("Provincia");
				boolean activo = resultSet.getBoolean("activo");
				boolean Administrador = resultSet.getBoolean("Administrador");
				String Contrasenia = resultSet.getString("Contrasenia");
				Cliente cliente = new Cliente(Dni, Cuil, Cbu, Nombre, Apellido, fechaNacimiento, Sexo, Nacionalidad,
						Email, Telefono, Direccion, Localidad, Provincia, activo, Administrador, Contrasenia);
				return cliente;

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
	public List<String> obtenerProvincias() {
	    List<String> provincias = new ArrayList<>();
	    Connection conexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        conexion = Conexion.getConexion().getSQLConexion();

	        if (conexion != null && !conexion.isClosed()) {
	            statement = conexion.prepareStatement("SELECT nombre FROM provincias");
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                provincias.add(resultSet.getString("nombre"));
	            }
	        } else {
	           
	            throw new IllegalStateException("La conexión está cerrada.");
	        }
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	    } finally {
	        // Cierre de recursos
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return provincias;
	}




	public List<String> obtenerLocalidades() {
	    List<String> localidades = new ArrayList<>();
	    Connection conexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        conexion = Conexion.getConexion().getSQLConexion();

	        if (conexion != null && !conexion.isClosed()) {
	            statement = conexion.prepareStatement("SELECT nombre FROM localidades");
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                localidades.add(resultSet.getString("nombre"));
	            }
	        } else {
	           
	            throw new IllegalStateException("La conexión está cerrada.");
	        }
	    } catch (SQLException e) {
	       
	        e.printStackTrace();
	    } finally {
	      
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return localidades;
	}


	 public List<String> obtenerNacionalidades() {
		    List<String> nacionalidades = new ArrayList<>();
		    Connection conexion = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		        conexion = Conexion.getConexion().getSQLConexion();

		        if (conexion != null && !conexion.isClosed()) {
		            statement = conexion.prepareStatement("SELECT nombre FROM nacionalidades");
		            resultSet = statement.executeQuery();

		            while (resultSet.next()) {
		                nacionalidades.add(resultSet.getString("nombre"));
		            }
		        } else {
		            
		            throw new IllegalStateException("La conexión está cerrada.");
		        }
		    } catch (SQLException e) {
		      
		        e.printStackTrace();
		    } finally {
		       
		        try {
		            if (resultSet != null) {
		                resultSet.close();
		            }
		            if (statement != null) {
		                statement.close();
		            }
		           
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    return nacionalidades;
		}


}
