package dao;

import java.util.List;

import dominio.Cuenta;


public interface CuentaDao {

	public boolean insert(Cuenta cuenta);
	public boolean deleteLogico (String CBU);
	public List<Cuenta> readAll();
	public boolean update(Cuenta cuenta_a_modificar, int CBU);
	public int cantidadCuentasXdni (String dni);
	public List<Cuenta> listaCuentaXdni (String dni);
	public Cuenta obtenerCuentaXCbu(String CBU);	
}
