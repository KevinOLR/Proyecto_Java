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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class DlgAlmacen extends JDialog implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodProducto;
	private JTextField txtNombreProducto;
	private JTextField txtCantidadIngreso;
	private JTextField txtStockMaximo;
	private JLabel lblCheckCodP;
	private JLabel lblErrorIconP;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAlmacen dialog = new DlgAlmacen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlmacen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlmacen.class.getResource("/iconos/almacen_icon.png")));
		setTitle("Almacen");
		setBounds(100, 100, 643, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Codigo del Producto:");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel.setBounds(10, 30, 147, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cantidad a Ingresar:");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel_1.setBounds(10, 138, 138, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nombre del Producto:");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel_2.setBounds(10, 78, 147, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblMaxStock = new JLabel("Stock Máximo:");
			lblMaxStock.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblMaxStock.setForeground(Color.WHITE);
			lblMaxStock.setBackground(Color.WHITE);
			lblMaxStock.setBounds(344, 78, 99, 14);
			contentPanel.add(lblMaxStock);
		}
		{
			txtCodProducto = new JTextField();
			txtCodProducto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			txtCodProducto.setBounds(170, 27, 86, 20);
			contentPanel.add(txtCodProducto);
			txtCodProducto.setColumns(10);
		}
		{
			txtNombreProducto = new JTextField();
			txtNombreProducto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			txtNombreProducto.setBounds(170, 75, 86, 20);
			contentPanel.add(txtNombreProducto);
			txtNombreProducto.setColumns(10);
		}
		{
			txtCantidadIngreso = new JTextField();
			txtCantidadIngreso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			txtCantidadIngreso.setBounds(170, 135, 87, 20);
			contentPanel.add(txtCantidadIngreso);
			txtCantidadIngreso.setColumns(10);
		}
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtStockMaximo.setForeground(new Color(0, 0, 0));
		txtStockMaximo.setEditable(false);
		txtStockMaximo.setBounds(456, 75, 99, 20);
		contentPanel.add(txtStockMaximo);
		txtStockMaximo.setColumns(10);
		
		lblCheckCodP = new JLabel("");
		lblCheckCodP.addMouseListener(this);
		lblCheckCodP.setIcon(new ImageIcon(DlgAlmacen.class.getResource("/iconos/check_icon_24.png")));
		lblCheckCodP.setBounds(266, 28, 25, 24);
		contentPanel.add(lblCheckCodP);
		
		lblErrorIconP = new JLabel("");
		lblErrorIconP.addMouseListener(this);
		lblErrorIconP.setIcon(new ImageIcon(DlgAlmacen.class.getResource("/iconos/error_24.png")));
		lblErrorIconP.setBounds(301, 28, 33, 24);
		contentPanel.add(lblErrorIconP);
		
		btnNuevoIngreso = new JButton("Nuevo Ingreso");
		btnNuevoIngreso.addActionListener(this);
		btnNuevoIngreso.setBackground(new Color(135, 206, 235));
		btnNuevoIngreso.setBounds(344, 187, 125, 23);
		contentPanel.add(btnNuevoIngreso);
		
		txtStockActual = new JTextField();
		txtStockActual.setEditable(false);
		txtStockActual.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtStockActual.setBounds(456, 30, 99, 20);
		contentPanel.add(txtStockActual);
		txtStockActual.setColumns(10);
		
		lblStockActual = new JLabel("Stock Actual:");
		lblStockActual.setForeground(Color.WHITE);
		lblStockActual.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblStockActual.setBounds(347, 30, 99, 14);
		contentPanel.add(lblStockActual);
		{
			btnIngresar = new JButton("Ingresar Stock");
			btnIngresar.setBounds(161, 187, 131, 23);
			contentPanel.add(btnIngresar);
			btnIngresar.addActionListener(this);
			btnIngresar.setForeground(new Color(0, 0, 0));
			btnIngresar.setBackground(new Color(50, 205, 50));
		}
		
		txtStockMin = new JTextField();
		txtStockMin.setEditable(false);
		txtStockMin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtStockMin.setBounds(456, 136, 99, 20);
		contentPanel.add(txtStockMin);
		txtStockMin.setColumns(10);
		
		lblStockMin = new JLabel("Stock Mínimo:");
		lblStockMin.setForeground(Color.WHITE);
		lblStockMin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStockMin.setBounds(344, 138, 99, 14);
		contentPanel.add(lblStockMin);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevoIngreso) {
			actionPerformedBtnNuevoIngreso(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblCheckCodP) {
			mouseClickedLblCheckCodP(e);
		}
		if (e.getSource() == lblErrorIconP) {
			mouseClickedLblErrorIconP(e);
		}
	}
	
	//DECLARAR GLOBALES
			ArregloVentas av = new ArregloVentas();
			ArregloCliente ac = new ArregloCliente();
			ArregloProductos ap = new ArregloProductos();
			private JButton btnNuevoIngreso;
			private JTextField txtStockActual;
			private JLabel lblStockActual;
			private JTextField txtStockMin;
			private JLabel lblStockMin;
	
	
	//Boton ingresar stock
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		cambio();
	}
	protected void actionPerformedBtnNuevoIngreso(ActionEvent e) {
		limpieza();
	}
	
	//Metodos mouse
	public void mouseEntered(MouseEvent e) {
		lblCheckCodP.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblErrorIconP.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblErrorIconP(MouseEvent e) {
		
	}
	protected void mouseClickedLblCheckCodP(MouseEvent e) {
		int codigo = Integer.parseInt(txtCodProducto.getText()); 
		Producto p = ap.buscar(codigo);
			if (p != null) {
				txtNombreProducto.setText(p.getNombre());
				txtStockMaximo.setText(""+p.getStockMax());
				txtStockActual.setText(""+p.getStockActual());
				txtStockMin.setText(""+p.getStockMin());
				
			}
			else {
				mensaje("EL CÓDIGO NO EXISTE");
				limpieza();
			}
	}
		
	void cambio() {
		
		int codigo = Integer.parseInt(txtCodProducto.getText());
		int  Stock =Integer.parseInt(txtCantidadIngreso.getText());
		Producto p = ap.buscar(codigo);
		
		if(p.getStockActual()< p.getStockMax()) {
			
			p.setStockActual(Stock + p.getStockActual());
			
			mensaje("¡El Stock Actual se Actualizó!");
		}
		else {
			mensaje("El Stock Actual No puede Sobre pasar el Stock Máximo");}
		ap.actualizarArchivo();
	}
	
	
	void mensaje(String s) 
	{JOptionPane.showMessageDialog(this, s);}
	
	void limpieza() {
		txtCodProducto.setText("");
		txtNombreProducto.setText("");
		txtCantidadIngreso.setText("");
		txtStockActual.setText("");
		txtStockMaximo.setText("");
		txtStockMin.setText("");
	}
	
}
