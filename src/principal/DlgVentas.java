package principal;

import clases.*;
import arreglos.*;
import libreria.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class DlgVentas extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigoCli;
	private JLabel lblNombreCli;
	private JTextField txtNombreCli;
	private JLabel lblCodigoPro;
	private JLabel lblNombrePro;
	private JLabel lblCantidad;
	private JLabel lblPrecioPro;
	private JTextField txtNombreProd;
	private JTextField txtCantUnid;
	private JTextField txtPrecioUni;
	private JLabel lblNewLabel_7;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVentas dialog = new DlgVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVentas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgVentas.class.getResource("/iconos/venta_icon.png")));
		setForeground(new Color(0, 51, 102));
		setTitle("Ventas");
		setBounds(100, 100, 780, 718);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 102));
		contentPanel.setForeground(new Color(0, 51, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCodigoCli = new JLabel("Cliente  :");
		lblCodigoCli.setForeground(Color.WHITE);
		lblCodigoCli.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoCli.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigoCli.setBounds(20, 79, 121, 14);
		contentPanel.add(lblCodigoCli);
		
		lblNombreCli = new JLabel("Nombre   :");
		lblNombreCli.setForeground(Color.WHITE);
		lblNombreCli.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCli.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreCli.setBounds(20, 121, 128, 14);
		contentPanel.add(lblNombreCli);
		
		txtNombreCli = new JTextField();
		txtNombreCli.setEditable(false);
		txtNombreCli.setBounds(145, 121, 103, 20);
		contentPanel.add(txtNombreCli);
		txtNombreCli.setColumns(10);
		
		lblCodigoPro = new JLabel("Producto  :");
		lblCodigoPro.setForeground(Color.WHITE);
		lblCodigoPro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigoPro.setBounds(391, 79, 103, 14);
		contentPanel.add(lblCodigoPro);
		
		lblNombrePro = new JLabel("Nombre Producto  :");
		lblNombrePro.setForeground(Color.WHITE);
		lblNombrePro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombrePro.setBounds(360, 121, 134, 14);
		contentPanel.add(lblNombrePro);
		
		lblCantidad = new JLabel("Cantidad  :");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(598, 139, 153, 14);
		contentPanel.add(lblCantidad);
		
		lblPrecioPro = new JLabel("Precio S/  :");
		lblPrecioPro.setForeground(Color.WHITE);
		lblPrecioPro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecioPro.setBounds(370, 166, 107, 14);
		contentPanel.add(lblPrecioPro);
		
		txtNombreProd = new JTextField();
		txtNombreProd.setEditable(false);
		txtNombreProd.setBounds(499, 119, 103, 20);
		contentPanel.add(txtNombreProd);
		txtNombreProd.setColumns(10);
		
		txtCantUnid = new JTextField();
		txtCantUnid.setBounds(631, 164, 86, 20);
		contentPanel.add(txtCantUnid);
		txtCantUnid.setColumns(10);
		
		txtPrecioUni = new JTextField();
		txtPrecioUni.setEditable(false);
		txtPrecioUni.setBounds(499, 164, 103, 20);
		contentPanel.add(txtPrecioUni);
		txtPrecioUni.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Boletas Electronica  :");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(20, 200, 153, 14);
		contentPanel.add(lblNewLabel_7);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 243, 741, 425);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setForeground(new Color(0, 51, 102));
		scrollPane.setViewportView(txtS);
		
		btnVenta = new JButton("EFECTUAR VENTA");
		btnVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVenta.setForeground(new Color(0, 51, 102));
		scrollPane.setColumnHeaderView(btnVenta);
		btnVenta.addActionListener(this);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DlgVentas.class.getResource("/iconos/clientes_icon32px.png")));
		lblNewLabel_2.setBounds(20, 51, 55, 73);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(DlgVentas.class.getResource("/iconos/productos_icon32px.png")));
		lblNewLabel_8.setBounds(342, 51, 55, 73);
		contentPanel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("DATOS DEL CLIENTE");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setForeground(Color.GREEN);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(20, 39, 228, 14);
		contentPanel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("DATOS DEL PRODUCTO");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setForeground(Color.YELLOW);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(332, 40, 270, 14);
		contentPanel.add(lblNewLabel_10);
		
		lblApellidoCli = new JLabel("Apellidos  :");
		lblApellidoCli.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoCli.setForeground(Color.WHITE);
		lblApellidoCli.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidoCli.setBounds(20, 160, 128, 14);
		contentPanel.add(lblApellidoCli);
		
		txtApellidoCli = new JTextField();
		txtApellidoCli.setEditable(false);
		txtApellidoCli.setColumns(10);
		txtApellidoCli.setBounds(145, 160, 103, 20);
		contentPanel.add(txtApellidoCli);
		
		txtCodVenta = new JTextField();
		txtCodVenta.setEditable(false);
		txtCodVenta.setBounds(100, 11, 73, 20);
		contentPanel.add(txtCodVenta);
		txtCodVenta.setColumns(10);
		
		lblCodVenta = new JLabel("Nro\u00B0 Venta  :");
		lblCodVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodVenta.setForeground(Color.WHITE);
		lblCodVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodVenta.setBounds(0, 14, 90, 14);
		contentPanel.add(lblCodVenta);
		
		lblFecha = new JLabel("");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(619, 12, 145, 17);
		contentPanel.add(lblFecha);
		
		txtCodigoCli = new JTextField();
		txtCodigoCli.setBounds(145, 77, 103, 20);
		contentPanel.add(txtCodigoCli);
		txtCodigoCli.setColumns(10);
		
		txtCodigoPro = new JTextField();
		txtCodigoPro.setColumns(10);
		txtCodigoPro.setBounds(499, 77, 103, 20);
		contentPanel.add(txtCodigoPro);
		setLocationRelativeTo(null);
		setVisible(true);
		
		lblFecha.setText(""+fechaActual());
		txtCodVenta.setText(""+av.numeroCorrelativo());
		
		separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.WHITE);
		separator.setBounds(625, 121, 103, 90);
		contentPanel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(621, 121, 31, 85);
		contentPanel.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(727, 121, 22, 85);
		contentPanel.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(624, 205, 103, 25);
		contentPanel.add(separator_3);
		
		lblCheckCliente = new JLabel("");
		lblCheckCliente.addMouseListener(this);
		lblCheckCliente.setIcon(new ImageIcon(DlgVentas.class.getResource("/iconos/check_icon_24.png")));
		lblCheckCliente.setBounds(258, 72, 31, 25);
		contentPanel.add(lblCheckCliente);
		
		lblCheckProducto = new JLabel("");
		lblCheckProducto.addMouseListener(this);
		lblCheckProducto.setIcon(new ImageIcon(DlgVentas.class.getResource("/iconos/check_icon_24.png")));
		lblCheckProducto.setBounds(607, 72, 31, 25);
		contentPanel.add(lblCheckProducto);
		
		lblBorrarProducto = new JLabel("");
		lblBorrarProducto.addMouseListener(this);
		lblBorrarProducto.setIcon(new ImageIcon(DlgVentas.class.getResource("/iconos/error_24.png")));
		lblBorrarProducto.setBounds(636, 72, 31, 25);
		contentPanel.add(lblBorrarProducto);
		
		lblBorrarCliente = new JLabel("");
		lblBorrarCliente.addMouseListener(this);
		lblBorrarCliente.setIcon(new ImageIcon(DlgVentas.class.getResource("/iconos/error_24.png")));
		lblBorrarCliente.setForeground(Color.WHITE);
		lblBorrarCliente.setBounds(287, 73, 31, 24);
		contentPanel.add(lblBorrarCliente);
		
		btnNuevo = new JButton("NUEVA VENTA");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevo.setBackground(new Color(0, 204, 0));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(619, 217, 132, 23);
		contentPanel.add(btnNuevo);

	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
		if (e.getSource() == btnVenta) {
			do_btnVenta_actionPerformed(e);
		}
	}
	private JLabel lblApellidoCli;
	private JTextField txtApellidoCli;
	private JTextField txtCodVenta;
	private JLabel lblCodVenta;
	
	//DECLARAR GLOBALES
		ArregloVentas av = new ArregloVentas();
		ArregloCliente ac = new ArregloCliente();
		ArregloProductos ap = new ArregloProductos();
		
		
		private JLabel lblFecha;
		private JTextField txtCodigoCli;
		private JTextField txtCodigoPro;
		private JSeparator separator;
		private JSeparator separator_1;
		private JSeparator separator_2;
		private JSeparator separator_3;
		private JLabel lblCheckCliente;
		private JLabel lblCheckProducto;
		private JLabel lblBorrarProducto;
		private JLabel lblBorrarCliente;
		private JButton btnVenta;
		private JButton btnNuevo;
		

		protected void do_btnVenta_actionPerformed(ActionEvent e) {	
			Venta v1= new Venta(leerCodigoVenta(),leerProducto(), leerCliente(), leerCantidad(),fechaActual(),leerPrecio());

			av.adicionar(v1);
			listar(v1);
			limpieza();	
		}	
		void listar(Venta x) 
		{    
			imprimir("\t\t\t**************BOLETA DE PAGO**************");
			imprimir("");
			imprimir("\t\t\tCODIGO DEL CLIENTE\t: "+leerCliente());
			imprimir("");
			imprimir("\t\t\tNOMBRE DEL CLIENTE\t: "+leerNombreCliente());
			imprimir("");
			imprimir("\t\t\tAPELLIDO DEL CLIENTE\t: "+leerApellidoCliente());
			imprimir("");
			imprimir("\t\t\tCODIGO DEL PRODUCTO\t: "+leerProducto());
			imprimir("");
			imprimir("\t\t\tNOMBRE DEL PRODUCTO\t: "+leerNombreProducto());
			imprimir("");
			imprimir("\t\t\tCANTIDADES ADQUIRIDAS\t: "+leerCantidad()+" UNIDADES");
			imprimir("");
			imprimir("\t\t\tPRECIO UNITARIO\t: "+leerPrecio());
			imprimir("");
			imprimir("\t\t\tIMPORTE SUBTOTAL\t: "+x.subTotal());
			imprimir("");
			imprimir("\t\t\tIMPORTE IGV ( 18% )\t: "+x.desctIgv());
			imprimir("");
			imprimir("\t\t\tIMPORTE TOTAL A PAGAR\t: "+x.pagoTotal());
			imprimir("\n");
			
		}
	/*	int total=0;
		
		public int sumaCantidades() {
			for (int i = 0; i < av.tamanio(); i++) {
				  Venta v = av.buscar(i);
					total= total + v.getCantVenta();
			}
			return total;
		}*/
		
		/*private void actualizarStock() {
			int cantidad = leerCantidad();
			int codigo = Integer.parseInt(txtCodigoPro.getText());
			Producto p = ap.buscar(codigo);
			if (cantidad <= p.getStockActual()) {
					p.setStockActual(p.getStockActual()-cantidad);
					
					ap.actualizarArchivo();}
			else {
				mensaje("No se pudo Actualizar el Stock");
			}
						
		}*/
	
		
	//Métodos tipo void
			
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
		txtCodVenta.setText(""+ av.numeroCorrelativo());
		txtNombreCli.setText("");
		txtApellidoCli.setText("");
		txtCodigoCli.setText("");
		txtCodigoPro.setText("");
		txtNombreProd.setText("");
		txtPrecioUni.setText("");
		txtCodigoCli.requestFocus();
	}
	
	//METODOS QUE RETORNAN VALOR (SIN PARAMETROS)
	int leerCodigoVenta() {return Integer.parseInt(txtCodVenta.getText().trim());}
	int leerCliente() {return Integer.parseInt(txtCodigoCli.getText().trim());}
	String leerNombreCliente() {return txtNombreCli.getText();}
	String leerApellidoCliente() {return txtApellidoCli.getText();}
	int leerProducto() {return Integer.parseInt(txtCodigoPro.getText().trim());}
	String leerNombreProducto() {return txtNombreProd.getText();}
	double leerPrecio() {return Double.parseDouble(txtPrecioUni.getText().trim());}
	int leerCantidad() { return Integer.parseInt(txtCantUnid.getText().trim());}
	
	String fechaActual() {
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		return Fecha.ajustar(dd) + "/" + Fecha.ajustar(mm) + "/" + aa;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblCheckCliente) {
			do_lblCheckCliente_mouseClicked(e);
		}
		if (e.getSource() == lblCheckProducto) {
			do_lblCheckProducto_mouseClicked(e);
		}
		if (e.getSource() == lblBorrarCliente) {
			do_lblBorrarCliente_mouseClicked(e);
		}
		if (e.getSource() == lblBorrarProducto) {
			do_lblBorrarProducto_mouseClicked(e);
		}
	}
	
	
	
	
	//EVENTO MOUSE CLICKED
	public void mouseEntered(MouseEvent e) {
		lblCheckCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblCheckProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblBorrarProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblBorrarCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_lblBorrarProducto_mouseClicked(MouseEvent e) {
		txtCodigoPro.setText("");
		txtNombreProd.setText("");
		txtPrecioUni.setText("");
		txtCodigoPro.requestFocus();
		
	}
	protected void do_lblBorrarCliente_mouseClicked(MouseEvent e) {
		txtCodigoCli.setText("");
		txtNombreCli.setText("");
		txtApellidoCli.setText("");
		txtCodigoCli.requestFocus();
		
	}
	protected void do_lblCheckProducto_mouseClicked(MouseEvent e) {
		
		
		int codigo = Integer.parseInt(txtCodigoPro.getText()); 
		Producto p = ap.buscar(codigo);
			if (p != null) {
				txtNombreProd.setText(p.getNombre());
				txtPrecioUni.setText(""+p.getPrecio());
				
			}
			else {
				mensaje("EL CODIGO NO EXISTE");
				limpieza();
			}
		}
	

	protected void do_lblCheckCliente_mouseClicked(MouseEvent e) {
		

		int codigo = Integer.parseInt(txtCodigoCli.getText()); 
		Cliente c = ac.buscar(codigo);
			if (c != null) {
				txtNombreCli.setText(c.getNombres());
				txtApellidoCli.setText(c.getApellidos());
				
			}
			else {
				mensaje("EL CODIGO NO EXISTE");
				limpieza();
			}
	}
	

	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		limpieza();
		txtS.setText("");
		txtCantUnid.setText("");
		
		
	}
}
