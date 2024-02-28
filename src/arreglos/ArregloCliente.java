package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;

public class ArregloCliente {
	
	/*Declaramos la lista de Arreglo*/
	private ArrayList<Cliente> cl;
	
	/*Creamos el constructor del arreglo*/
	public ArregloCliente() {
		/*Creamos la lista de Arreglo*/
		cl = new ArrayList<Cliente>();
		cargarClientes();
	}
	
	/*Método para adicionar objetos al arreglo*/
	public void adicionar (Cliente x) {
		cl.add(x);
		grabarClientes();
	}
	
	/*Método para calcular el tamaño del arreglo*/
	public int tamanio() {
		return cl.size();
	}
	
	/*Método para obtener el índice del objeto en el arreglo*/
	public Cliente obtener(int i) {
		return cl.get(i);
	}
	
	/*Método para buscar un objeto en el arreglo*/
	public Cliente buscar(String dni) {
		for(int i = 0; i<tamanio(); i++) {
			if(dni == obtener(i).getDni()){
				return obtener(i);
			}
		}
		return null;
	}
	
	public Cliente buscar(int codigo) {
		for(int i = 0; i<tamanio(); i++) {
			if(codigo == obtener(i).getCodigo()){
				return obtener(i);
			}
		}
		return null;
	}
	
	/*Método para eliminar un objeto del arreglo*/
	public void eliminar(Cliente x) {
		cl.remove(x);
		grabarClientes();
	}
	
	/*Método para generar el número correlativo*/
	public int num_corre() {
		if(tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigo()+1;
			
	}
	
	public void actualizarLista() {
		grabarClientes();
	}
	
	private void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for(int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDireccion() + ";" +
						x.getTelef() + ";" +
						x.getDni();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarClientes() {
		try {
			BufferedReader br;
			String linea, nombres, apellido, direccion, telef, dni;
			String[] s;
			int codigo; 
			br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombres = s[1];
				apellido = s[2];
				direccion = s[3];
				telef = s[4];
				dni = s[5];
				adicionar(new Cliente(codigo, nombres, apellido, direccion, telef, dni));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	
	

}
