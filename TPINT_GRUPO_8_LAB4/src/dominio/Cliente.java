package dominio;
import java.time.LocalDate;
public class Cliente {
  
	private String Dni;
	private String Cuil;
	private String Cbu;
	private String Apellido;
	private String Nombre;
	private String FechaNacimiento;
	private String Sexo;
	private String Nacionalidad;
	private String Email;
	private String Telefono;
	private String Direccion;
	private String Provincia;
	private String Localidad;
	private boolean activo;
	private boolean Administrador;
	private String Contrasenia;
	
	
	
	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean getAdministrador() {
		return Administrador;
	}

	public void setAdministrador(boolean administrador) {
		Administrador = administrador;
	}

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}

	public Cliente (String Dni,String Cuil,String Cbu,String Nombre,String Apellido,String FecNac, String Sexo,String Nacionalidad,String Email,String Telefono,String Direccion,
			        String Provincia, String Localidad, boolean Activo,boolean Administrador,String Contrasenia)
	{
		this.Dni = Dni;
		this.Cuil = Cuil;
		this.Cbu = Cbu;
		this.Apellido = Apellido;
		this.Nombre = Nombre;
		this.FechaNacimiento = FecNac;
		this.Sexo = Sexo;
		this.Nacionalidad = Nacionalidad;
		this.Email = Email;
		this.Telefono =Telefono;
		this.Direccion = Direccion;
		this.Provincia = Provincia;
		this.Localidad =Localidad;
		this.activo=Activo;
		this.Administrador = Administrador;
		this.Contrasenia = Contrasenia;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getCuil() {
		return Cuil;
	}

	public void setCuil(String cuil) {
		Cuil = cuil;
	}

	public String getCbu() {
		return Cbu;
	}

	public void setCbu(String cbu) {
		Cbu = cbu;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.FechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	
	public boolean getactivo() {
		return activo;
	}

	public void setactivo(boolean Activo) {
		activo = Activo;
	}

	@Override
	public String toString() {
		return "Cliente : Dni:" + Dni + ", Cuil:" + Cuil + ", Cbu:" + Cbu + ", Apellido:" + Apellido + ", Nombre:"
				+ Nombre + ", fechaNacimiento:" + FechaNacimiento + ", Sexo:" + Sexo + ", Nacionalidad:" + Nacionalidad
				+ ", Email:" + Email + ", Telefono:" + Telefono + ", Direccion:" + Direccion + ", Provincia:"
				+ Provincia + ", Localidad:" + Localidad + ", Activo:" + activo + "Administrador:" + Administrador + "Contrasenia:"+ Contrasenia ;
	}
	
	
}
