package dominio;
import java.time.LocalDate;

public class Prestamo {

	private int Id;
	private int NroCuenta;
	private String DniCliente;
	private String FechaPedido;
	private double ImporteTotal;
	private double ImporteCuota;
	private int CantidadCuotas;
	private int CuotaApagar;	
	private boolean Activo;
	
	
	
	public Prestamo(int id, int nroCuenta, String dniCliente, String fechaPedido, double importeTotal,
			double importeCuota, int cantidadCuotas, int cuotaApagar, boolean activo) {
		super();
		Id = id;
		NroCuenta = nroCuenta;
		DniCliente = dniCliente;
		FechaPedido = fechaPedido;
		ImporteTotal = importeTotal;
		ImporteCuota = importeCuota;
		CantidadCuotas = cantidadCuotas;
		CuotaApagar = cuotaApagar;
		Activo = activo;
	}
	
	
	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getNroCuenta() {
		return NroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		NroCuenta = nroCuenta;
	}
	public String getDniCliente() {
		return DniCliente;
	}
	public void setDniCliente(String dniCliente) {
		DniCliente = dniCliente;
	}
	public String getFechaPedido() {
		return FechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		FechaPedido = fechaPedido;
	}
	public double getImporteTotal() {
		return ImporteTotal;
	}
	public void setImporteTotal(double importeTotal) {
		ImporteTotal = importeTotal;
	}
	public double getImporteCuota() {
		return ImporteCuota;
	}
	public void setImporteCuota(double importeCuota) {
		ImporteCuota = importeCuota;
	}
	public int getCantidadCuotas() {
		return CantidadCuotas;
	}
	public void setCantidadCuotas(int cantidadCuotas) {
		CantidadCuotas = cantidadCuotas;
	}
	public int getCuotaApagar() {
		return CuotaApagar;
	}
	public void setCuotaApagar(int cuotaApagar) {
		CuotaApagar = cuotaApagar;
	}
	public boolean isActivo() {
		return Activo;
	}
	public void setActivo(boolean activo) {
		Activo = activo;
	}
	
	@Override
	public String toString() {
		return "Prestamo [Id=" + Id + ", NroCuenta=" + NroCuenta + ", DniCliente=" + DniCliente + ", FechaPedido="
				+ FechaPedido + ", ImporteTotal=" + ImporteTotal + ", ImporteCuota=" + ImporteCuota
				+ ", CantidadCuotas=" + CantidadCuotas + ", CuotaApagar=" + CuotaApagar + ", Activo=" + Activo + "]";
	}
}




 
