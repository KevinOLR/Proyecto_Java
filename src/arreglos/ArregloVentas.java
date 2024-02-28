package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Venta;

public class ArregloVentas {
	//DECLARAMOS EL ARRAYLIST
	private ArrayList<Venta> ven;
	
	//CONSTRUCTOR DEL ARREGLO
	public ArregloVentas() {
		ven = new ArrayList<Venta>();
		cargarVentas();
	}
	
	//METODO ADICIONAR
	public void adicionar(Venta x) {ven.add(x);
		grabarVentas();
	}
	
	//METODO TAMA�O
	public int tamanio() {return ven.size();}
	
	//METODO OBTENER
	public Venta obtener(int i) {return ven.get(i);}
	
	//METODO BUSCAR
	public Venta buscar (int codigo)
	{for(int i=0; i<tamanio(); i++)
	{if (codigo ==obtener(i).getCodProducto())
		{return obtener(i);
	}}
	return null;
	}
	
	//METODO ELIMINAR
	public void eliminar(Venta x) {ven.remove(x);
	grabarVentas();
	}
	
	//METODO GENERAR CORRELATIVO DE ITEM
	public int numeroCorrelativo() {
		if(tamanio() ==0)
			return 3001;
		else
			return obtener(tamanio()-1).getCodVenta()+1;
	}
	//Metodo Cantidades Acumuladas
	public int acumulacion(Venta x) {
		int total=0;
		for (int i = 0; i <tamanio(); i++) {
			total = total + x.getCantVenta();
		}
		return total;
	}
	
	
	//DATOS A GRABAR
	
	private void grabarVentas() {
		try {
			PrintWriter pw;
			String linea;
			Venta x;
			pw = new PrintWriter (new FileWriter("ventas.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodVenta()+";"+
						x.getCodCliente()+";"+
						x.getCodProducto()+";"+
						x.getCantVenta()+";"+
						x.getPrecioVenta()+";"+
						x.getFechaVenta();
				pw.println(linea);
			}
			pw.close();
				
		}
		catch (Exception e) {
			
		}	
	}
	//DATOS CARGAR
	private void cargarVentas() {
		try {
			BufferedReader br;
			String linea, fechaVenta;
			String[] s;
			int codVenta, codCliente, codProducto, cantVenta;
			double precioVenta;
			br = new BufferedReader(new FileReader("ventas.txt"));
			while((linea = br.readLine()) !=null) {
				s= linea.split(";");
				codVenta = Integer.parseInt(s[0].trim());
				codCliente = Integer.parseInt(s[1].trim());
				codProducto = Integer.parseInt(s[2].trim());
				cantVenta = Integer.parseInt(s[3].trim());
				precioVenta = Double.parseDouble(s[4].trim());
				fechaVenta = (s[5].trim());

				
				adicionar(new Venta(codVenta,codProducto,codCliente,cantVenta, fechaVenta,precioVenta));
			}
			br.close();
			}
		catch (Exception e) {
			
		}
	}
	
}