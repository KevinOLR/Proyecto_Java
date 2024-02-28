package principal;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloCliente;
import clases.Cliente;

import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.Toolkit;

public class DlgCliente extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCodigo;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JScrollPane scpTabla;
	private DefaultTableModel modelo;
	private JTable tblTabla;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//  Variable Global 
	private int tipoOperacion;
	
	//  Constantes para los tipos de operaciones
	public final static int INGRESAR = 0;
	public final static int MODIFICAR = 1;
	public final static int CONSULTAR = 2;
	public final static int ELIMINAR  = 3;

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCliente.class.getResource("/iconos/clientes_icon.png")));
		setResizable(false);
		setTitle("Sistema de Ventas | Cliente");
		setBounds(100, 100, 743, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCodigo = new JLabel("Código :");
		lblCodigo.setBounds(21, 13, 70, 14);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigo.setForeground(Color.WHITE);
		contentPanel.add(lblCodigo);
		
		lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(21, 63, 70, 14);
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombres.setForeground(Color.WHITE);
		contentPanel.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(21, 88, 70, 14);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellidos.setForeground(Color.WHITE);
		contentPanel.add(lblApellidos);
		
		lblDireccion = new JLabel("Dirección :");
		lblDireccion.setBounds(21, 138, 70, 14);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDireccion.setForeground(Color.WHITE);
		contentPanel.add(lblDireccion);
		
		lblTelefono = new JLabel("Teléfono :");
		lblTelefono.setBounds(21, 113, 70, 14);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefono.setForeground(Color.WHITE);
		contentPanel.add(lblTelefono);
		
		lblDni = new JLabel("Nro DNI :");
		lblDni.setBounds(21, 38, 70, 14);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDni.setForeground(Color.WHITE);
		contentPanel.add(lblDni);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(101, 11, 103, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(101, 34, 103, 20);
		txtDNI.setColumns(10);
		contentPanel.add(txtDNI);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(101, 57, 103, 20);
		txtNombres.setColumns(10);
		contentPanel.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(101, 82, 103, 20);
		txtApellidos.setColumns(10);
		contentPanel.add(txtApellidos);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(101, 106, 103, 20);
		txtTelefono.setColumns(10);
		contentPanel.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(101, 131, 103, 20);
		txtDireccion.setColumns(10);
		contentPanel.add(txtDireccion);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(613, 38, 89, 23);
		btnIngresar.addActionListener(this);
		contentPanel.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(613, 63, 89, 23);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(613, 88, 89, 23);
		btnConsultar.addActionListener(this);
		contentPanel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(613, 113, 89, 23);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(613, 13, 89, 23);
		btnListar.addActionListener(this);
		contentPanel.add(btnListar);
		
		scpTabla = new JScrollPane();
		scpTabla.setBounds(10, 167, 707, 219);
		contentPanel.add(scpTabla);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scpTabla.setViewportView(tblTabla);
		 
		 btnAceptar = new JButton("Aceptar");
		 btnAceptar.addActionListener(this);
		 btnAceptar.setBounds(225, 9, 89, 23);
		 contentPanel.add(btnAceptar);
		
		 modelo = new DefaultTableModel();
		 modelo.addColumn("Código");
		 modelo.addColumn("Nombre");
		 modelo.addColumn("Apellidos");
		 modelo.addColumn("Dirección");
		 modelo.addColumn("Teléfono");
		 modelo.addColumn("DNI");
		 tblTabla.setModel(modelo);
		 
		 modelo.setRowCount(0);
		 
		 txtCodigo.setEnabled(false);
		 btnAceptar.setEnabled(false);		 
		 
		 lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon(DlgCliente.class.getResource("/iconos/tienda_fondo.png")));
		 lblNewLabel.setBounds(-10, -41, 737, 486);
		 contentPanel.add(lblNewLabel);
		 //limpieza();
		 listar(cli.tamanio()-1);
		 //editarFila();
		 habilitarCampos(false);
		 /*habilitarBotones(false);*/

		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	
	/*Llamar al Arreglo Principal*/
	ArregloCliente cli = new ArregloCliente();
	private JButton btnAceptar;
	private JLabel lblNewLabel;
	
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		// Boton CONSULTAR
		int codigo = leerCodigo();
		if(btnConsultar.isEnabled() == false) {
			Cliente x = cli.buscar(codigo);
			if(x != null) {
				txtNombres.setText(x.getNombres());
				txtApellidos.setText(x.getApellidos());
				txtDireccion.setText(x.getDireccion());
				txtTelefono.setText(x.getTelef());
				txtDNI.setText(x.getDni());
				btnConsultar.setEnabled(true);
				btnAceptar.setEnabled(false);
				habilitarCampos(false);									
			}else {
				error("El código " + codigo + " no existe", txtCodigo);
			}
		}
			
		String dni = leerDni();
		if(dni.length()> 0) {
			String nombre = leerNombre();
			if(nombre.length()>0) {
				String apellido = leerApellidos();
				if(apellido.length()>0){
					String telefono = leerTelefono();
					if(telefono.length()>0) {
						String direccion = leerDireccion();
						if(direccion.length()>0) {
								
							// Boton INGRESAR
							if(btnIngresar.isEnabled() == false) {
								if(cli.buscar(dni) == null) {
									Cliente cl = new Cliente(codigo, nombre, apellido, direccion, telefono, dni);
									cli.adicionar(cl);
									btnIngresar.setEnabled(true);
									listar(tblTabla.getRowCount());
									limpieza();
									habilitarCampos(false);
									btnAceptar.setEnabled(false);
								} else {
									error("El DNI " + dni + " ya existe", txtDNI);
								}
							}
								
							// Boton MODIFICAR
							if(btnModificar.isEnabled() == false) {
								Cliente x = cli.buscar(codigo);
								x.setNombres(nombre);
								x.setApellidos(apellido);
								x.setDireccion(direccion);
								x.setTelef(telefono);
								x.setDni(dni);
								cli.actualizarLista();
								btnModificar.setEnabled(true);
								btnAceptar.setEnabled(false);
								listar(tblTabla.getSelectedRow());
								habilitarCampos(false);
								limpiezaGeneral();
							}
								
						} else {
							error("La dirección ingresada es incorrecta", txtDireccion);
						}
							
					} else {
						error("El Teléfono ingresado es incorrecto", txtTelefono);
					}
						
				} else {
					error("El apellido ingresado es incorrecto", txtApellidos);
				}
					
			} else {
				error("El nombre ingresado es incorrecto", txtNombres);
			}
		} else {
			error("El número del DNI es incorrecto", txtDNI);
		}
	}
	
	/*Método para listar toda la información de los clientes*/
	protected void actionPerformedBtnListar(ActionEvent e){
		if(tblTabla.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this,"No hay lista de clientes para mostrar. Ingrese un nuevo Cliente.", "Información", 1);
		}else {
			JOptionPane.showMessageDialog(this,"No hay nuevos clientes para mostrar.", "Información", 1);
		}	
	}
	
	protected void actionPerformedBtnIngresar(ActionEvent e){
		habilitarCampos(true);
		btnIngresar.setEnabled(false);
		btnAceptar.setEnabled(true);
		limpieza();
		txtDNI.requestFocus();		
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e){
		//String xx = Integer.toString(leerCodigo());
		if(leerDni().length() > 0) {
			habilitarCampos(true);
			btnModificar.setEnabled(false);
			btnAceptar.setEnabled(true);
			txtDNI.requestFocus();
		} else {
			error("Seleccione en la tabla al cliente a modificar", txtCodigo);			
		}
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e){
		habilitarCampos(false);
		limpiezaGeneral();
		btnAceptar.setEnabled(true);
		btnConsultar.setEnabled(false);
		mensaje("Ingresa el codigo que deseas consultar");
		txtCodigo.setEnabled(true);
		txtCodigo.requestFocus();		
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e){
		if(cli.tamanio() == 0) {
			btnEliminar.setEnabled(false);
			mensaje("No existen clientes para eliminar");
		} else {
			editarFila();
			int ok = confirmar("¿ Desea eliminar al cliente ?");
			if(ok == 0) {
				Cliente x = cli.buscar(leerCodigo());
				int posFila = tblTabla.getSelectedRow();
				if(posFila == cli.tamanio()-1)
					posFila --;
				cli.eliminar(x);
				listar(posFila);
				editarFila();
			}
			btnAceptar.setEnabled(false);
			limpiezaGeneral();
		}
	}
	
	void limpieza() {
		txtCodigo.setText("" + cli.num_corre());
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDNI.setText("");		
	}
	
	void limpiezaGeneral() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDNI.setText("");		
	}
	
	void editarFila() {
		if(cli.tamanio() == 0)
			limpieza();
		else {
			Cliente x = cli.obtener(tblTabla.getSelectedRow());
			txtCodigo.setText("" + x.getCodigo());
			txtDNI.setText("" + x.getDni());
			txtNombres.setText(x.getNombres());
			txtApellidos.setText(x.getApellidos());
			txtTelefono.setText(x.getTelef());
			txtDireccion.setText(x.getDireccion());
		}		
	}
	
	void listar(int posFila) {
		modelo.setRowCount(0);
		Cliente x;
		for(int i=0; i<cli.tamanio(); i++) {
			x = cli.obtener(i);
			Object[] fila = {
								x.getCodigo(),
								x.getNombres(),
								x.getApellidos(),
								x.getDireccion(),
								x.getTelef(),
								x.getDni()								
			};
			modelo.addRow(fila);			
		}
		tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);	
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Mensaje", 1);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void habilitarCampos(boolean estado) {
		txtNombres.setEnabled(estado);
		txtApellidos.setEnabled(estado);
		txtDireccion.setEnabled(estado);
		txtTelefono.setEnabled(estado);
		txtDNI.setEnabled(estado);		
	}
	
	void habilitarBotones(boolean estado) {
		btnIngresar.setEnabled(estado);
		btnModificar.setEnabled(estado);
		btnConsultar.setEnabled(estado);
		btnEliminar.setEnabled(estado);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblTabla) {
			mouseClickedTblTabla(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblTabla(MouseEvent e) {
		habilitarCampos(false);
		habilitarBotones(true);
		editarFila();
	}
	
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String leerDni() {
		return txtDNI.getText().trim();
	}
	
	String leerNombre() {
		return txtNombres.getText().trim();
	}
	
	String leerApellidos() {
		return txtApellidos.getText().trim();
	}
	
	String leerTelefono() {
		return txtTelefono.getText().trim(); 
	}
	
	String leerDireccion() {
		return txtDireccion.getText().trim();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	

}

