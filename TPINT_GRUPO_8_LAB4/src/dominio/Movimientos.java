package dominio;


public class Movimientos {
  
	private int Id;
	private String NroCuenta;
	private String Detalle;
	private String Fecha;
	private double Importe;	
	private String TipoMovimiento;
	private boolean Activa;
	
	
	
	public Movimientos(int id, String nroCuenta, String detalle, String fecha, double importe, String tipoMovimiento,
			boolean activa) {
		super();
		Id = id;
		NroCuenta = nroCuenta;
		Detalle = detalle;
		Fecha = fecha;
		Importe = importe;
		TipoMovimiento = tipoMovimiento;
		Activa = activa;
	}
	
	
	public Movimientos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNroCuenta() {
		return NroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		NroCuenta = nroCuenta;
	}
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public double getImporte() {
		return Importe;
	}
	public void setImporte(double importe) {
		Importe = importe;
	}
	public String getTipoMovimiento() {
		return TipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}
	public boolean isActiva() {
		return Activa;
	}
	public void setActiva(boolean activa) {
		Activa = activa;
	}
	
	@Override
	public String toString() {
		return "Movimientos [Id=" + Id + ", NroCuenta=" + NroCuenta + ", Detalle=" + Detalle + ", Fecha=" + Fecha
				+ ", Importe=" + Importe + ", TipoMovimiento=" + TipoMovimiento + ", Activa=" + Activa + "]";
	}
}