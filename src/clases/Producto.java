package clases;

public class Producto {
	//atributos privados
	private int codProducto,stockActual,stockMin,stockMax;
	private String nombre;
	private double precio;
	
	
	//constructor
	public Producto(int codProducto, String nombre,int stockActual, int stockMin, int stockMax, double precio) {
		this.codProducto = codProducto;
		this.stockActual = stockActual;
		this.stockMin = stockMin;
		this.stockMax = stockMax;
		this.nombre = nombre;
		this.precio = precio;
		
		
	}
	//metodos get y set
	public int getCodProducto() {return codProducto;}

	public void setCodProducto(int codProducto) {		this.codProducto = codProducto;}

	public int getStockActual() {return stockActual;}

	public void setStockActual(int stockActual) {this.stockActual = stockActual;}

	public int getStockMin() {	return stockMin;}

	public void setStockMin(int stockMin) {this.stockMin = stockMin;}
	
	public int getStockMax() {return stockMax;	}
	
	public void setStockMax(int stockMax) {this.stockMax = stockMax;}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public double getPrecio() {return precio;}

	public void setPrecio(double precio) {this.precio = precio;}
	

	
	 
}
