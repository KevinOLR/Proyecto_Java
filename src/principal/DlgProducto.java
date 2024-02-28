package principal;

import clases.*;
import arreglos.*;
import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgProducto extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMin;
	private JTextField txtStockMax;
	private JTable tblTabla;
	private JButton btnConsultar;
	private JButton btnIngresar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnListar;
	private DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgProducto.class.getResource("/iconos/productos_icon.png")));
		setResizable(false);
		setTitle("Sistema de Ventas | Producto");
		setBounds(100, 100, 737, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Codigo :");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(46, 14, 70, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNombre.setBounds(46, 37, 70, 14);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblPrecio = new JLabel("Precio : ");
			lblPrecio.setForeground(Color.WHITE);
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblPrecio.setBounds(46, 60, 70, 14);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblStockActual = new JLabel("Stock Actual :");
			lblStockActual.setForeground(Color.WHITE);
			lblStockActual.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblStockActual.setBounds(46, 85, 70, 14);
			contentPanel.add(lblStockActual);
		}
		{
			JLabel lblStockMinimo = new JLabel("Stock Minimo :");
			lblStockMinimo.setForeground(Color.WHITE);
			lblStockMinimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblStockMinimo.setBounds(46, 109, 70, 14);
			contentPanel.add(lblStockMinimo);
		}
		{
			JLabel lblStockMaximo = new JLabel("Stock Maximo :");
			lblStockMaximo.setForeground(Color.WHITE);
			lblStockMaximo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblStockMaximo.setBounds(46, 134, 82, 14);
			contentPanel.add(lblStockMaximo);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(129, 11, 103, 20);
			contentPanel.add(txtCodigo);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(129, 34, 103, 20);
			contentPanel.add(txtNombre);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(129, 57, 103, 20);
			contentPanel.add(txtPrecio);
		}
		{
			txtStockActual = new JTextField();
			txtStockActual.setEditable(false);
			txtStockActual.setColumns(10);
			txtStockActual.setBounds(129, 82, 103, 20);
			contentPanel.add(txtStockActual);
		}
		{
			txtStockMin = new JTextField();
			txtStockMin.setEditable(false);
			txtStockMin.setColumns(10);
			txtStockMin.setBounds(129, 106, 103, 20);
			contentPanel.add(txtStockMin);
		}
		{
			txtStockMax = new JTextField();
			txtStockMax.setEditable(false);
			txtStockMax.setColumns(10);
			txtStockMax.setBounds(129, 130, 103, 20);
			contentPanel.add(txtStockMax);
		}
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setEnabled(false);
			btnListar.setBounds(246, 125, 89, 23);
			contentPanel.add(btnListar);
		}
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(this);
			btnIngresar.setBounds(615, 25, 89, 23);
			contentPanel.add(btnIngresar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(615, 50, 89, 23);
			contentPanel.add(btnModificar);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(this);
			btnConsultar.setBounds(615, 75, 89, 23);
			contentPanel.add(btnConsultar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(615, 100, 89, 23);
			contentPanel.add(btnEliminar);
		}
		{
			JScrollPane scpTabla = new JScrollPane();
			scpTabla.setBounds(10, 159, 699, 219);
			contentPanel.add(scpTabla);
			{
				tblTabla = new JTable();
				tblTabla.setSurrendersFocusOnKeystroke(true);
				tblTabla.setFillsViewportHeight(true);
				tblTabla.addMouseListener(this);
				scpTabla.setViewportView(tblTabla);
			}
		}
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PRECIO");
		modelo.addColumn("STOCK ACTUAL");
		modelo.addColumn("STOCK MIN");
		modelo.addColumn("STOCK MAX");
		
		tblTabla.setModel(modelo);
		
		txtCodigo.setEditable(false);
		
		lblcheck = new JLabel("");
		lblcheck.addMouseListener(this);
		lblcheck.setIcon(new ImageIcon(DlgProducto.class.getResource("/iconos/check_icon_24.png")));
		lblcheck.setBounds(255, -3, 48, 57);
		contentPanel.add(lblcheck);
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(DlgProducto.class.getResource("/iconos/tienda_fondo.png")));
			lblNewLabel_1.setBounds(0, 0, 721, 393);
			contentPanel.add(lblNewLabel_1);
		}
		habilitarEntradas(false);
		listar();
		habilitarEntradas(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
		if (e.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(e);
		}
	}
	
	//DECLARAR ARREGLO PRODUCTOS
	ArregloProductos ap = new ArregloProductos();
	private JLabel lblcheck;
	private JLabel lblNewLabel_1;
	
	protected void do_btnConsultar_actionPerformed(ActionEvent e) 
	{
	
		btnConsultar.setEnabled(false);
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(false);
		btnListar.setEnabled(false);
		btnEliminar.setEnabled(false);
		habilitarEntradas(false);
		txtCodigo.setEditable(true);
		txtCodigo.requestFocus();

		limpiarcampos();
	}
	
	protected void do_btnIngresar_actionPerformed(ActionEvent e) 
	{
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnListar.setEnabled(true);
		btnEliminar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		txtNombre.requestFocus();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) 
	{
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnListar.setEnabled(false);
		if(ap.tamanio()==0)
			mensaje("NO EXISTEN PRODUCTOS");
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar ("¿DESEAS ELIMINAR ESTE REGISTRO?");
			if (ok ==0) {
				ap.eliminar(ap.buscar(leerCodigo()));
				listar();
				editarFila();
			}
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) 
	{

		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if(ap.tamanio() == 0) {
			btnListar.setEnabled(false);
			habilitarEntradas(false);

			mensaje("NO EXISTEN PRODUCTOS");
		}
		else {
			editarFila();
			btnListar.setEnabled(true);
			habilitarEntradas(true);
			txtNombre.requestFocus();
		}
		
	}
	protected void do_btnListar_actionPerformed(ActionEvent arg0)
	{
		
		int codigo = leerCodigo();
		String nombre = leerNombre();
		if(nombre.length()>0) {
		try {
			double precio = leerPrecio();
			try {
				int StockActual = leerStockActual();
				try {
					int StockMin = leerStockMin();
					try {
						int StockMax = leerStockMax();
							if(btnIngresar.isEnabled()==false) {
								Producto nuevo = new Producto(codigo,  nombre, StockActual, StockMin, StockMax,  precio);
								ap.adicionar(nuevo);
								btnIngresar.setEnabled(true);
							}
							if(btnModificar.isEnabled()==false) {
								Producto p = ap.buscar(codigo);
								p.setNombre(nombre);
								p.setPrecio(precio);
								p.setStockActual(StockActual);
								p.setStockMin(StockMin);
								p.setStockMax(StockMax);
								ap.actualizarArchivo();
								btnModificar.setEnabled(true);
							}
							listar();
							habilitarEntradas(false);
						}
						catch (Exception e) {
							error("INGRESE STOCK MÁXIMO", txtStockMax);
					}
				}
				catch (Exception e) {
						error("INGRESE STOCK MÍNIMO", txtStockMin);
				}
			}
			catch (Exception e) {
					error("INGRESE STOCK ACTUAL", txtStockActual);
			}
		}
		catch (Exception e) {
				error("INGRESE PRECIO", txtPrecio);
		}
	}
		else
			error("INGRESE NOMBRE ", txtNombre);
	}
	
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTabla.getSelectedRow();
		if (modelo.getRowCount() == ap.tamanio() - 1)
			posFila = ap.tamanio() - 1;
		if (posFila == ap.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Producto p;
		for (int i=0; i<ap.tamanio(); i++) {
			p = ap.obtener(i);
			Object[] fila = { p.getCodProducto(),
					          p.getNombre(),
					          p.getPrecio(),
					          p.getStockActual(),
					          p.getStockMin(),
							  p.getStockMax() };
			modelo.addRow(fila);
		}
		if (ap.tamanio() > 0)
			tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (ap.tamanio() == 0)
			limpieza();
		else {
			Producto p = ap.obtener(tblTabla.getSelectedRow());
			txtCodigo.setText("" + p.getCodProducto());
			txtNombre.setText(p.getNombre());
			txtPrecio.setText(""+p.getPrecio());
			txtStockActual.setText(""+p.getStockActual());
			txtStockMin.setText(""+p.getStockMin());
			txtStockMax.setText(""+p.getStockMax());
		}
	}
	
	void limpiarcampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMin.setText("");
		txtStockMax.setText("");
	}
	void limpieza() {
		txtCodigo.setText("" + ap.numCorrelativo());
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMin.setText("");
		txtStockMax.setText("");
	}
	
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	//MÉTODO PARA CONFIRMAR UNA ELIMNACIÓN
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	/*void habilitarCodigo(boolean sino) {
		txtCodigo.setEditable(sino);
	}*/
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		txtPrecio.setEditable(sino);
		txtStockActual.setEditable(sino);
		txtStockMin.setEditable(sino);
		txtStockMax.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		
	}
//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerStockActual() {
		return Integer.parseInt(txtStockActual.getText().trim());
	}
	int leerStockMin() {
		return Integer.parseInt(txtStockMin.getText().trim());
	}
	int leerStockMax() {
		return Integer.parseInt(txtStockMax.getText().trim());
	}
	
	//BOTON CHECK
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblTabla) {
			do_tblTabla_mouseClicked(e);
		}
		if (e.getSource() == lblcheck) {
			do_lblcheck_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		lblcheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void do_tblTabla_mouseClicked(MouseEvent e) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	protected void do_lblcheck_mouseClicked(MouseEvent e) {
		int codigo = leerCodigo();
		if(btnConsultar.isEnabled() == false) {
			btnConsultar.setEnabled(true);
			btnIngresar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
			Producto p = ap.buscar(codigo);
			if (p != null) {
				txtNombre.setText(p.getNombre());
				txtPrecio.setText(""+p.getPrecio());
				txtStockActual.setText(""+p.getStockActual());
				txtStockMin.setText(""+p.getStockMin());
				txtStockMax.setText(""+p.getStockMax());
				
			}
			else {
				mensaje("EL CÓDIGO NO EXISTE");
				limpieza();
			}
		}
	}

}
