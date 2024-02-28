package principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloCliente;
import arreglos.ArregloProductos;
import arreglos.ArregloVentas;
import clases.Cliente;
import clases.Producto;
import clases.Venta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgReportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cboReporte;
	private final JButton btnReportar = new JButton("Generar Reporte");
	private final JTextArea txtS = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReportes dialog = new DlgReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReportes() {
		setTitle("Reportes");
		setBounds(100, 100, 769, 456);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Seleccione Reporte:");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel.setBounds(10, 29, 125, 14);
			contentPanel.add(lblNewLabel);
		}
		
		cboReporte = new JComboBox();
		cboReporte.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione una opción-", "Listado general de ventas", "Listado de productos con stock  por debajo del stock mínimo", "Listado de productos por unidades vendidas acumuladas", "Listado de productos por importe total acumulado"}));
		cboReporte.setBounds(146, 26, 419, 22);
		contentPanel.add(cboReporte);
		btnReportar.addActionListener(this);
		btnReportar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnReportar.setForeground(Color.BLACK);
		btnReportar.setBounds(575, 26, 156, 23);
		
		contentPanel.add(btnReportar);
		scrollPane.setBounds(10, 70, 733, 336);
		
		contentPanel.add(scrollPane);
		scrollPane.setViewportView(txtS);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
		int eleccion= cboReporte.getSelectedIndex();
		
		switch(eleccion) {
		
		case 1:{listadoGeneralVentas();}break;
		case 2:{listadodeProductos();}break;
		case 3:{ listadoUnidadesProductos();}break;
		
		default: {
			mensaje("Haga otra elección");
		}
		
		}
	}

	
	//DECLARAR GLOBALES
	ArregloVentas av = new ArregloVentas();
	ArregloCliente ac = new ArregloCliente();
	ArregloProductos ap = new ArregloProductos();
	
	
	
	
	private void listadoGeneralVentas() {
		limpieza();
		for (int i=0; i<av.tamanio(); i++) {
			Venta v= av.obtener(i);
			imprimir("Venta: "+(i+1));
			if (v != null) {
				imprimir("Numero de Venta\t:  " + v.getCodVenta());
				imprimir("Código de Cliente\t:  " + v.getCodCliente());
				imprimir("Código de Producto\t: "+v.getCodProducto());
				imprimir("Fecha de Venta\t\t:  " + v.getFechaVenta());
				imprimir("Importe SubTotal\t:  " + v.subTotal());
				imprimir("Importe IGV\t\t: " + v.desctIgv());
				imprimir("Pago Total\t\t:" + v.pagoTotal());
				imprimir("");
			}
			}
		}

	private void listadodeProductos() {
		limpieza();
		for (int i = 0; i < ap.tamanio(); i++) {
			Producto p = ap.obtener(i);
			if(p.getStockActual()<p.getStockMin()) {
				imprimir("Producto: "+(i+1));
				imprimir("");
				imprimir("Codigo del Producto: "+p.getCodProducto());
				imprimir("Nombre del Producto: "+p.getNombre());
				imprimir("Stock Actual del Producto: "+p.getStockActual());
				imprimir("Stock Mínimo del Producto: "+p.getStockMin());
			}
		}
	}
	
	private void listadoUnidadesProductos() {
		limpieza();
		for (int i = 0; i < ap.tamanio(); i++) {
			Venta v = av.obtener(i);
			Producto p = ap.obtener(i);
			if(p!=null) {
				imprimir("Producto: "+(i+1));
				imprimir("");
				imprimir("Código del Producto: "+p.getCodProducto());
				imprimir("Nombre del Producto: "+p.getNombre());
				imprimir("Cantidades Acumuladas: " +av.acumulacion(v));
			}
		}}
	
	
	
	
	
	
	
	
	
	//MÃ©todos tipo void
	
	void imprimir(String s) 
			{txtS.append(s + "\n");}
	
	void mensaje(String s) 
			{JOptionPane.showMessageDialog(this, s);}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void limpieza() {
		txtS.setText("");
	}
	
	

}
