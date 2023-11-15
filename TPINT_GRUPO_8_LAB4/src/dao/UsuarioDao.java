package dao;


import dominio.Usuario;

public interface UsuarioDao {
	int obtenerUltimoIdUsuario();
	public boolean insert(Usuario usuario);
	String obtenerIniciales(String nombre, String apellido);
	String generarUsuario(String iniciales, int ultimoId);
	public boolean modficarUsuario(String contrasenia,String dni);
	public boolean deleteLogico(String dni);
	public Usuario obtenerUsuarioXdni(String dni);
}