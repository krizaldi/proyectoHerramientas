package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adminDB.AdminDB;
import modelo.Herramienta;
import modelo.Usuario;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuItem;

public class VistaBusquedaAdm extends JFrame {

	private JPanel contentPane;
	private AdminDB base;
	private ArrayList<Herramienta> herramientas;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private Logo logo;
	private GroupLayout gl_contentPane;
	private static int semestre;
	private JTable table;
	private JScrollPane scrollPane;
	private JMenuItem mntmGuardar;
	private JMenuItem mntmRegresar;
	private JMenuItem mntmSalir;
	private Radar radar;
	public VistaPrincipal vistaPrincipal;
	public VistaAdministrador vistaAdministrador;
	private static Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaBusquedaAdm frame = new VistaBusquedaAdm(semestre,usuario);
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
	public VistaBusquedaAdm(int sem,Usuario user) {
		base=new AdminDB();
		radar=new Radar();
		semestre=sem;
		usuario=user;
		herramientas=base.buscarSemestre(sem);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 453);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(157, 34, 53));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setForeground(Color.WHITE);
		menuBar.add(mnArchivo);
		
		mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		mntmRegresar = new JMenuItem("Regresar");
		mnArchivo.add(mntmRegresar);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		logo=new Logo("logo.jpg");
		scrollPane = new JScrollPane();
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(logo, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(logo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Version", "Tipo de Licencia", "Periodo", "Costo", "Descripcion", "Url", "Materia"
			}
		));
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		Object[] fila = new Object[modelo.getColumnCount()];
		for(int i=0; i<herramientas.size(); i++){
			fila[0]= herramientas.get(i).getNombre();
			fila[1]= herramientas.get(i).getVersion();
			fila[2]= herramientas.get(i).getTipoDlicencia();
			fila[3]= herramientas.get(i).getPeriodo();
			fila[4]= herramientas.get(i).getCosto();
			fila[5]= herramientas.get(i).getDescripcion();
			fila[6]= herramientas.get(i).getUrl();
			fila[7]= herramientas.get(i).getMateria().getNombre();
			modelo.addRow(fila);
		}
		table.setModel(modelo);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(220);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
	}
	public class Radar implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Regresar"))
			{   setVisible(false);
				vistaAdministrador=new VistaAdministrador(usuario);
				vistaAdministrador.setVisible(true);
			}
			if(a.getActionCommand().equals("Salir"))
			{
				System.exit(0);
			}	
			if(a.getActionCommand().equals("Guardar"))
			{}
		
		}}
	
}
