package clases;

public class Venta {
	//ATRIBUTOS PRIVADOS
	private int codVenta,codProducto, codCliente, cantVenta;
	private String fechaVenta;
	private double precioVenta;

	//CONSTRUCTOR
	public Venta(int codVenta, int codProducto, int codCliente, int cantVenta, String fechaVenta,
			double precioVenta) {
		this.codVenta = codVenta;
		this.codProducto = codProducto;
		this.codCliente = codCliente;
		this.cantVenta = cantVenta;
		this.fechaVenta = fechaVenta;
		this.precioVenta = precioVenta;
	}

	//GET Y SET
	public int getCodVenta() {return codVenta;}
	public void setCodVenta(int codVenta) {this.codVenta = codVenta;}
	public int getCodProducto() {return codProducto;}
	public void setCodProducto(int codProducto) {this.codProducto = codProducto;}
	public int getCodCliente() {return codCliente;}
	public void setCodCliente(int codCliente) {this.codCliente = codCliente;}
	public int getCantVenta() {return cantVenta;}
	public void setCantVenta(int cantVenta) {this.cantVenta = cantVenta;}
	public String getFechaVenta() {return fechaVenta;}
	public void setFechaVenta(String fechaVenta) {this.fechaVenta = fechaVenta;}
	public double getPrecioVenta() {return precioVenta;}
	public void setPrecioVenta(double precioVenta) {this.precioVenta = precioVenta;}


	//• IMPORTE SUBTOTAL.
	public double subTotal() {return cantVenta * precioVenta;}
	
	//• IMPORTE DEL IGV
	public double desctIgv() {return subTotal()*0.18;}
	
	//• IMPORTE TOTAL A PAGAR
	public double pagoTotal() {return subTotal()+desctIgv();}
	


}
