package dominio;
import java.util.Random;
public class Cuenta {
	
	String NroCuenta;
	String DniCliente;
	String CBU ;
	String TipoCuenta;
	String FechaCreacion;
	double Saldo;
	boolean Activa;
	
	public Cuenta()
	{
		
	}
	
	public boolean getActiva() {
		return Activa;
	}

	public void setActiva(boolean activa) {
		Activa = activa;
	}

	 private String generarCBU() {
	        int longitudCBU = 22; 
	        StringBuilder cbuBuilder = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < longitudCBU; i++) {
	            int digito = random.nextInt(10); 
	            cbuBuilder.append(digito);
	        }

	        return cbuBuilder.toString();
	    }

	 private String generarNroCuenta() {
	        int longitudCBU = 20; 
	        StringBuilder cbuBuilder = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < longitudCBU; i++) {
	            int digito = random.nextInt(10); 
	            cbuBuilder.append(digito);
	        }

	        return cbuBuilder.toString();
	    }

	
	public Cuenta(String DniCliente,String Tipo,String FechaCreacion,boolean Activa){
		this.NroCuenta = generarNroCuenta();
		this.DniCliente=DniCliente;
		this.CBU = generarCBU();
		this.TipoCuenta = Tipo;
		this.FechaCreacion = FechaCreacion;
		this.Saldo = 10000.00;
		this.Activa = Activa;
	}
	
	

	public String getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}

	public Cuenta(String nroCuenta, String dniCliente, String cBU, String tipoCuenta, String fechaCreacion,
			double saldo, boolean activa) {
		super();
		NroCuenta = nroCuenta;
		DniCliente = dniCliente;
		CBU = cBU;
		TipoCuenta = tipoCuenta;
		FechaCreacion = fechaCreacion;
		Saldo = saldo;
		Activa = activa;
	}

	public String getNroCuenta() {
		return NroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		NroCuenta = nroCuenta;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public String getTipo() {
		return TipoCuenta;
	}

	public void setTipo(String Tipo) {
		TipoCuenta = Tipo;
	}

	public String getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta: NroCuenta:" + NroCuenta + ", Dni Cliente:" + DniCliente + ", CBU:" + CBU + ", Tipo:" + TipoCuenta + ", FechaCreacion:"
				+ FechaCreacion + ", Saldo:" + Saldo ;
	}

	
	
	public String getDniCliente() {
		return DniCliente;
	}
	
	public void setDniCliente(String dniCliente) {
		DniCliente = dniCliente;
	}
}
