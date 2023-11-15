package negocio;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.ClienteDao;
import dao.ClienteDaoImpl;
import dominio.Cliente;
public class ClienteNegocio {
	
	private ClienteDao clienteDao;
	
	public ClienteNegocio() {
       
        this.clienteDao = new ClienteDaoImpl();
    }

	
	public boolean darBajaCliente(String dni)
	{
		
		ClienteDaoImpl clienteDaoImpl= new ClienteDaoImpl();
		
		boolean resultado= clienteDaoImpl.deleteLogico(dni);
		return resultado;
	}
	
	public List<String> obtenerProvincias(){
		 
		 List<String> provincias = clienteDao.obtenerProvincias();
		 System.out.println("Provincias obtenidas: " + provincias);
		 return clienteDao.obtenerProvincias();
	};
	public List<String> obtenerLocalidades(){
		  return clienteDao.obtenerLocalidades();
	};
	public List<String> obtenerNacionalidades() {
		 return clienteDao.obtenerNacionalidades();
	}
	
	
	public List<Cliente> obtenerClientes()
	{
		ClienteDaoImpl daoCliente = new ClienteDaoImpl();
		ArrayList<Cliente> listaCliente=(ArrayList<Cliente>) daoCliente.readAll();
		
		
		return listaCliente;
	}
	
	
	public boolean modificarPass(String dni, String nuevoPass)
	{

		ClienteDaoImpl daoCliente = new ClienteDaoImpl();
		boolean resultado = daoCliente.modificarContasenia(nuevoPass,dni);

		return resultado;
	}
	
	public Cliente obtenerCliente(String dni)
	{
		ClienteDaoImpl clienteDaoImpl= new ClienteDaoImpl();
		Cliente cliente= new Cliente();
		
		cliente=clienteDaoImpl.obtenerClienteXdni(dni);
		
		return cliente;
	}
	
	public void actualizar(Cliente cliente, String dniCuenta)
	{
		ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
		clienteDaoImpl.update(cliente, dniCuenta);
	}
	
}
