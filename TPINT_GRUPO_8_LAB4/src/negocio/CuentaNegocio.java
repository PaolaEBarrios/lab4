package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDaoImpl;
import dao.CuentaDao;
import dao.CuentaDaoImpl;
import dominio.Cliente;
import dominio.Cuenta;
public class CuentaNegocio {
	
	private CuentaDao cuentaD;
	
	public CuentaNegocio() {
       
		this.cuentaD = new CuentaDaoImpl();
	}
	
	
	public boolean darBajaCuenta(String cbu)
	{
		CuentaDaoImpl cuentaDaoImpl= new CuentaDaoImpl();
		
		return cuentaDaoImpl.deleteLogico(cbu);
	}
	
	public List<Cuenta> listaCuentaXdni(String dni) 
	{
		CuentaDaoImpl cuentasDaoImpl= new CuentaDaoImpl();
		List<Cuenta> cuentas= new ArrayList<Cuenta> ();
		
		cuentas=cuentasDaoImpl.listaCuentaXdni(dni);
		
		return cuentas;
	}
	
	public boolean crearCuenta(Cuenta cuenta)
	{
		CuentaDaoImpl cuentaDaoImpl= new CuentaDaoImpl();
		
		return cuentaDaoImpl.insert(cuenta);
	}
		
	
	public Cuenta obtenerCuentaXNroCbu(String cbu)
	{
		CuentaDaoImpl cuentaDaoImpl= new CuentaDaoImpl();
		Cuenta cuenta=  cuentaDaoImpl.obtenerCuentaXCbu(cbu);

	
		return cuenta;
	}
	
	
	
	
}