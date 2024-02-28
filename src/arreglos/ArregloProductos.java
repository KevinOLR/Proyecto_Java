package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Producto;

public class ArregloProductos {
	//DECLARAMOS EL ARRAYLIST
	private ArrayList<Producto> pro;
	

	//CONSTRUCTOR DEL ARREGLO
	public ArregloProductos() {
		pro = new ArrayList<Producto>();
		cargarProductos();}

	//METODO ADICIONAR
	public void adicionar(Producto x) {	pro.add(x) ;
	grabarProductos();} 
	
	//METODO TAMA�O
	public int tamanio() {	return pro.size() ;}
	
	//METODO OBTENER
	public Producto obtener(int i) {	return pro.get(i) ; }
	
	//METODO BUSCAR
	public Producto buscar (int codigo) {
		for(int i = 0; i<tamanio() ;  i++) { 
			if (codigo == obtener(i).getCodProducto()) { return obtener(i) ;}	
		}
		return null;
	}
	
	//METODO ELIMINAR
	public void eliminar(Producto x) { pro.remove(x) ; 
	grabarProductos();}
	
	//ACTUALIZAR ARCHIVO
	public void actualizarArchivo() {
		grabarProductos();
	}
	
	//METODO GENERAR NUMERO CORRELATIVO
	public int numCorrelativo() { if(tamanio() == 0)
		return 2001;
	else
		return obtener(tamanio()-1).getCodProducto()+1 ; }
	
	//DATOS A GRABAR
	
		private void grabarProductos() {
			try {
				PrintWriter pw;
				String linea;
				Producto x;
				pw = new PrintWriter (new FileWriter("Productos.txt"));
				for (int i=0; i<tamanio(); i++) {
					x = obtener(i);
					linea = x.getCodProducto()+";"+
							x.getNombre()+";"+
							x.getPrecio()+";"+
							x.getStockActual()+";"+
							x.getStockMax()+";"+
							x.getStockMin();
					pw.println(linea);
				}
				pw.close();
					
			}
			catch (Exception e) {
				
			}	
		}
		//DATOS CARGAR
		private void cargarProductos() {
			try {
				BufferedReader br;
				String linea;
				String[] s;
				double precio;
				String nombre;
				int codigo,StockActual,StockMax,StockMin;
				br = new BufferedReader(new FileReader("Productos.txt"));
				while((linea = br.readLine()) !=null) {
					s= linea.split(";");
					codigo = Integer.parseInt(s[0].trim());
					nombre= (s[1].trim());
					precio = Double.parseDouble(s[2].trim());
					StockActual = Integer.parseInt(s[3].trim());
					StockMin = Integer.parseInt(s[4].trim());
					StockMax = Integer.parseInt(s[5].trim());
					

					
					adicionar(new Producto(codigo,nombre, StockActual, StockMin, StockMax, precio ));
				}
				br.close();
				}
			catch (Exception e) {
				
			}
		}
}