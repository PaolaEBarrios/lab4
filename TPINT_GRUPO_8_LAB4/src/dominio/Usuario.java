package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
	String Id;
	String Usuario;
	String Contrasenia;
	String DNI;
	boolean state;
	
	public Usuario(String usuario, String contrasenia, String dNI,boolean activo) {
		
		
		Usuario = usuario;
		Contrasenia = contrasenia;
		DNI = dNI;
		this.state=activo; 
		
	}
	
	public Usuario(String id, String usuario, String contrasenia, String dNI, boolean state) {
		super();
		Id = id;
		Usuario = usuario;
		Contrasenia = contrasenia;
		DNI = dNI;
		this.state = state;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getContrasenia() {
		return Contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	private Usuario getUsuario(ResultSet resultSet) throws SQLException {
		String Dni = resultSet.getString("Dni");
		String Usuario= resultSet.getString("Usuario");
		String Contrasenia = resultSet.getString("Contraseña");
	   	boolean activo = resultSet.getBoolean("activo");
		return new Usuario(Dni,Usuario, Contrasenia,activo);
	}
	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", Usuario=" + Usuario + ", Contrasenia=" + Contrasenia + ", DNI=" + DNI
				+ ", state=" + state + "]";
	}

	public Usuario() {


	}
	
	
	
}
