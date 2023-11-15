package dao;

import java.io.IOException;
import java.util.List;

import dominio.Cliente;

public interface ClienteDao {

	public boolean insert(Cliente cliente);
	public boolean deleteLogico (String dni);
	public List<Cliente> readAll();
	public boolean update(Cliente cliente_a_modificar, String dni);
	
	public Cliente obtenerClienteXdni(String dni);
	
	public boolean validarAdmin(String user, String pass);
	public boolean loginExitoso(String user, String pass);
	public boolean modificarContasenia(String contrasenia, String dni);
	public Cliente buscarXusuario(String user);
	public List<String> obtenerProvincias();
	public List<String> obtenerLocalidades();
	public List<String> obtenerNacionalidades();
}
