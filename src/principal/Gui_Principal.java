package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JPopupMenu;

public class Gui_Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnAlmacen;
	private JMenu mnReportes;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JToolBar toolBar;
	private JLabel lblNewLabel;
	private JButton btnClientes;
	private JButton btnProductos;
	private JMenuItem mntmEjecutar;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmGenerar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Principal frame = new Gui_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_Principal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui_Principal.class.getResource("/iconos/Tienda_icon.png")));
		setTitle("Sistema de Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(192, 192, 192));
		toolBar.setBounds(0, 30, 770, 54);
		contentPane.add(toolBar);
		
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(this);
		btnClientes.setBackground(Color.LIGHT_GRAY);
		btnClientes.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/clientes_icon32px.png")));
		toolBar.add(btnClientes);
		
		btnProductos = new JButton("Productos");
		btnProductos.addActionListener(this);
		btnProductos.setBackground(Color.LIGHT_GRAY);
		btnProductos.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/productos_icon32px.png")));
		toolBar.add(btnProductos);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 770, 30);
		contentPane.add(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/mantenimiento_icon.png")));
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/clientes_icon.png")));
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/productos_icon.png")));
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.addActionListener(this);
		mnVentas.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/venta_icon.png")));
		menuBar.add(mnVentas);
		
		mntmEjecutar = new JMenuItem("Efectuar Venta");
		mntmEjecutar.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/Efectuar_icon_24px.png")));
		mntmEjecutar.addActionListener(this);
		mnVentas.add(mntmEjecutar);
		
		mnAlmacen = new JMenu("Almacen");
		mnAlmacen.addActionListener(this);
		mnAlmacen.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/almacen_icon.png")));
		menuBar.add(mnAlmacen);
		
		mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/Agregar_icon_24px.png")));
		mntmAgregar.addActionListener(this);
		mnAlmacen.add(mntmAgregar);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.addActionListener(this);
		mnReportes.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/reportes_icon.png")));
		menuBar.add(mnReportes);
		
		mntmGenerar = new JMenuItem("Generar Reporte");
		mntmGenerar.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/GenerarRep_icon_24px.png")));
		mntmGenerar.addActionListener(this);
		mnReportes.add(mntmGenerar);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/sistema_icon_24px.png")));
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/salir_icon.png")));
		mnSistema.add(mntmSalir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Gui_Principal.class.getResource("/iconos/tienda_fondo.png")));
		lblNewLabel.setBounds(0, 72, 770, 354);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmAgregar) {
			actionPerformedMntmAgregar(e);
		}
		if (e.getSource() == mntmEjecutar) {
			actionPerformedMntmEjecutar(e);
		}
		if (e.getSource() == mntmGenerar) {
			actionPerformedMntmGenerar(e);
		}
		if (e.getSource() == btnClientes) {
			actionPerformedBtnClientes(e);
		}
		if (e.getSource() == btnProductos) {
			actionPerformedBtnProductos(e);
		}
		
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
	}
	
	protected void actionPerformedMntmClientes(ActionEvent e) {
		DlgCliente dc = new DlgCliente();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {
		DlgProducto dp = new DlgProducto();
		dp.setLocationRelativeTo(this);
		dp.setVisible(true);
	}
	protected void actionPerformedBtnProductos(ActionEvent e) {
		DlgProducto bp = new DlgProducto();
		bp.setLocationRelativeTo(this);
		bp.setVisible(true);
	}
	protected void actionPerformedBtnClientes(ActionEvent e) {
		DlgCliente bc = new DlgCliente();
		bc.setLocationRelativeTo(this);
		bc.setVisible(true);
	}

	
	protected void actionPerformedMntmEjecutar(ActionEvent e) {
		DlgVentas dv = new DlgVentas();
		dv.setLocationRelativeTo(this);
		dv.setVisible(true);
	}
	protected void actionPerformedMntmAgregar(ActionEvent e) {
		DlgAlmacen da = new DlgAlmacen();
		da.setLocationRelativeTo(this);
		da.setVisible(true);
	}
	protected void actionPerformedMntmGenerar(ActionEvent e) {
		DlgReportes dr = new DlgReportes();
		dr.setLocationRelativeTo(this);
		dr.setVisible(true);
		
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
}
