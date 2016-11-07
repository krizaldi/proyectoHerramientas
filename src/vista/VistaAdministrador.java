package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnBusqueda;
	private JMenuBar menuBar;
	private JMenu mnUsuarios;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmEliminar;
	private JMenu mnHerramientas;
	private JMenuItem mntmAgregarElementos;
	private JMenuItem mntmModificarElementos;
	private JMenuItem mntmBorrarElementos;
	private JMenu mnHelp;
	private Logo logo;
	private Radar radar;
	public VistaCambioContrasea vistaU;
	public VistaEliminarUsu vistaE;
	private JMenu mnUsuario;
	private JMenuItem mntmCambiarContrasea;
	private JMenuItem mntmRegresar;
	private JMenuItem mntmSalir;
	private JLabel label;
	private Logo logo2;
	private JMenuItem mntmAcercaDe;
	private JRadioButton Semestre;
	private JComboBox cmbMateria;
	private JComboBox cmbSemestre;
	private JRadioButton Materia;
	public VistaBusquedaSemestre vistaBusquedaSem;
	public VistaBusqueda vistaBusqueda;
	public VistaBusquedaAdm vistaBusquedaAdm;
	public VistaBusqAdmiMat vistaBusqAdmiMat;
	private static Usuario usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdministrador frame = new VistaAdministrador(usuario);
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
	public VistaAdministrador(Usuario usuario) {
		this.usuario=usuario;
		radar=new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 352);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBusqueda = new JButton("Buscar");
		btnBusqueda.setBounds(161, 290, 89, 23);
		contentPane.add(btnBusqueda);
		btnBusqueda.addActionListener(radar);
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(157, 34, 53));
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		mnUsuario = new JMenu("Usuario");
		mnUsuario.setForeground(Color.WHITE);
		menuBar.add(mnUsuario);
		
		mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mnUsuario.add(mntmCambiarContrasea);
		mntmCambiarContrasea.addActionListener(radar);
		
		mntmRegresar = new JMenuItem("Cerrar Sesion");
		mnUsuario.add(mntmRegresar);
		mntmRegresar.addActionListener(radar);
		mntmSalir = new JMenuItem("Salir");
		mnUsuario.add(mntmSalir);
		mntmSalir.addActionListener(radar);
		mnUsuarios = new JMenu("Administradores");
		mnUsuarios.setForeground(Color.WHITE);
		menuBar.add(mnUsuarios);
		
		mntmAgregar = new JMenuItem("Agregar");
		mnUsuarios.add(mntmAgregar);
		mntmAgregar.addActionListener(radar);
		mntmEliminar = new JMenuItem("Eliminar");
		mnUsuarios.add(mntmEliminar);
		mntmEliminar.addActionListener(radar);
	    mnHerramientas = new JMenu("Herramientas");
	    mnHerramientas.setForeground(Color.WHITE);
		menuBar.add(mnHerramientas);
		
		mntmAgregarElementos = new JMenuItem("Agregar Elementos");
		mnHerramientas.add(mntmAgregarElementos);
		mntmAgregarElementos.addActionListener(radar);
		mntmModificarElementos = new JMenuItem("Modificar Elementos");
		mnHerramientas.add(mntmModificarElementos);
		mntmModificarElementos.addActionListener(radar);
		
		mntmBorrarElementos = new JMenuItem("Borrar Elementos");
		mnHerramientas.add(mntmBorrarElementos);
		mntmBorrarElementos.addActionListener(radar);
		
		mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.WHITE);
		menuBar.add(mnHelp);
		
		mntmAcercaDe = new JMenuItem("Acerca de");
		mnHelp.add(mntmAcercaDe);
		
		logo = new Logo("logo.jpg");
		logo.setBounds(0, 62, 434, 116);
		contentPane.add(logo);
		
		label = new JLabel(usuario.getNombre());
		label.setFont(new Font("Arial Black", Font.PLAIN, 13));
		label.setBounds(345, 32, 89, 19);
		contentPane.add(label);
		
		logo2 = new Logo("logo2.jpg");
		logo2.setBounds(270, 21, 55, 45);
		contentPane.add(logo2);
		
		Materia = new JRadioButton("Materia");
		Materia.setBounds(59, 199, 109, 23);
		contentPane.add(Materia);
		Materia.addActionListener(radar);
		
		Semestre = new JRadioButton("Semestre");
		Semestre.setBounds(216, 199, 109, 23);
		contentPane.add(Semestre);
		Semestre.addActionListener(radar);
		cmbMateria = new JComboBox();
		cmbMateria.setEnabled(false);
		cmbMateria.setModel(new DefaultComboBoxModel(new String[] {"Matematicas discretas", "Introduccion a la Programacion", "Introduccion a la Ingenieria de Software", "Programacion Orientada a Objetos", "Estructura de Datos", "Construccion y Evolucion de Software", "Analisis de Algoritmos", "Analisis de Requisitos", "Base de Datos", "Teoria de la computacion", "Sistemas Operativos", "Analisis y Modelamiento de Software", "Programacion Web", "Programacion de Sistemas", "Aseguramiento de la Calidad de Software", "Arquitectura de computadoras", "Lenguajes de programacion", "Tecnicas de pruebas de software", "Dise\u00F1o de software", "Metodologia de la investigacion", "Redes de Computadoras", "Normatividad y legislacion", "Arquitectura de software", "Sistemas distribuidos", "Administracion de proyectos I", "Metricas de software", "Dise\u00F1o de experimentos en ingenieria de software", "Administracion de proyectos II", "Gestion tecnologica"}));
		cmbMateria.setBounds(59, 246, 109, 20);
		contentPane.add(cmbMateria);
		
		cmbSemestre = new JComboBox();
		cmbSemestre.setEnabled(false);
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cmbSemestre.setBounds(216, 246, 109, 20);
		contentPane.add(cmbSemestre);
	}
	public class Radar implements ActionListener{
		

		private VistaAltas vistaA;
		private VistaAltaUsuario vistaAltaAdmon;

		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Agregar"))
			{
				setVisible(false);
				vistaAltaAdmon= new VistaAltaUsuario(usuario);
				vistaAltaAdmon.setVisible(true);
			}
			if(a.getActionCommand().equals("Cambiar contrase\u00F1a"))
			{
				setVisible(false);
				vistaU=new VistaCambioContrasea(usuario);
				vistaU.setVisible(true);
			}
			if(a.getActionCommand().equals("Eliminar"))
			{
				setVisible(false);
				vistaE=new VistaEliminarUsu(usuario);
				vistaE.setVisible(true);
			}
			if(a.getActionCommand().equals("Agregar Elementos"))
			{
				setVisible(false);
				vistaA=new VistaAltas(usuario);
				vistaA.setVisible(true);
				
			}
			
			if(a.getActionCommand().equals("Modificar Elementos"))
			{
				setVisible(false);
				VistaModificarBorrar vistaM = new VistaModificarBorrar(usuario,"Modificar Elementos");
				vistaM.setVisible(true);
				
			}
			
			if(a.getActionCommand().equals("Borrar Elementos"))
			{
				setVisible(false);
				//VistaBorrar vistaB = new VistaBorrar();
				//vistaB.setVisible(true);
				VistaModificarBorrar vistaM = new VistaModificarBorrar(usuario,"Borrar Elementos");
				vistaM.setVisible(true);
			}
			if(a.getActionCommand().equals("Salir"))
			{
		     System.exit(0);
			}
			if(a.getActionCommand().equals("Cerrar Sesion"))
			{
				setVisible(false);
				VistaIngreso vistaI = new VistaIngreso();
				vistaI.setVisible(true);
			}
			if(a.getActionCommand().equals("Materia"))
			{
				Semestre.setSelected(false);
				Semestre.setEnabled(true);
				Materia.setSelected(true);
				cmbSemestre.setEnabled(false);
				cmbMateria.setEnabled(true);
				
			}
			
			if(a.getActionCommand().equals("Semestre"))
			{
				Materia.setSelected(false);
				Materia.setEnabled(true);
				Semestre.setSelected(true);
				cmbSemestre.setEnabled(true);
				cmbMateria.setEnabled(false);
				
			}
			if(a.getActionCommand().equals("Buscar"))
			{
				if(Semestre.isSelected() == true)
				{setVisible(false);
					vistaBusquedaAdm= new VistaBusquedaAdm(Integer.parseInt((String)cmbSemestre.getSelectedItem()),usuario);
					vistaBusquedaAdm.setVisible(true);
				}
				else
				{   setVisible(false);
					vistaBusqAdmiMat= new VistaBusqAdmiMat((String)cmbMateria.getSelectedItem(),usuario);
					vistaBusqAdmiMat.setVisible(true);
				}
				
			}
			
			
			}
		}
}
