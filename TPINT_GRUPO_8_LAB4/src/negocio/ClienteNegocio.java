package negocio;

import java.util.ArrayList;
import java.util.List;
import dao.ClienteDao;
import dao.ClienteDaoImpl;
import dominio.Cliente;
public class ClienteNegocio {
	
	private ClienteDao clienteDao;
	
	public ClienteNegocio() {
       
        this.clienteDao = new ClienteDaoImpl();
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
	
}
