package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminDB.AdminDB;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBoxMat;
	private JButton btnBuscar;
	private Logo logo;
	private JMenuItem mntmInformacin;
	private JMenu mnAyuda;
	private JMenuBar menuBar;
	private Radar radar;
	public VistaIngreso vista;
	private JMenuItem mntmLogin;
	private JRadioButton Semestre;
	private JComboBox comboBoxSem;
	private JRadioButton Materia;
	private JLabel lblSeleccionaElTipo;
	private AdminDB base;
	public VistaBusqueda vistaBusqueda;
	public VistaBusquedaSemestre vistaBusquedaSem;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
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
	public VistaPrincipal() {
		radar=new Radar();
		base=new AdminDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(157, 34, 53));
		menuBar.setBounds(0, 0, 538, 21);
		contentPane.add(menuBar);
		
		mntmLogin = new JMenuItem("Login");
		mntmLogin.setForeground(Color.WHITE);
		mntmLogin.setBackground(new Color(157, 34, 53));
		menuBar.add(mntmLogin);
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		mnAyuda.setForeground(Color.WHITE);
		mntmInformacin = new JMenuItem("Informaci\u00F3n");
		mntmInformacin.setBackground(new Color(157, 34, 53));
		mntmInformacin.setForeground(Color.WHITE);
		mnAyuda.add(mntmInformacin);
		mntmLogin.addActionListener(radar);
		
		logo = new Logo("logo.jpg");
		logo.setBounds(0, 22, 538, 107);
		contentPane.add(logo);
		
	    btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(213, 290, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(radar);
		
		comboBoxMat = new JComboBox();
		comboBoxMat.setEnabled(false);
		comboBoxMat.setModel(new DefaultComboBoxModel(new String[] {"Matematicas discretas","Introduccion a la Programacion", "Introduccion a la Ingenieria de Software", "Programacion Orientada a Objetos", "Estructura de Datos", "Construccion y Evolucion de Software", "Analisis de Algoritmos", "Analisis de Requisitos", "Base de Datos","Teoria de la computacion", "Sistemas Operativos", "Analisis y Modelamiento de Software", "Programacion Web", "Programacion de Sistemas", "Aseguramiento de la Calidad de Software","Arquitectura de computadoras","Lenguajes de programacion","Tecnicas de pruebas de software","Diseño de software","Metodologia de la investigacion","Redes de Computadoras","Normatividad y legislacion","Arquitectura de software","Sistemas distribuidos","Administracion de proyectos I","Metricas de software","Diseño de experimentos en ingenieria de software","Administracion de proyectos II","Gestion tecnologica"}));
		comboBoxMat.setBounds(73, 220, 179, 20);
		contentPane.add(comboBoxMat);
		
		Materia = new JRadioButton("Materia");
		Materia.setBounds(73, 167, 123, 23);
		contentPane.add(Materia);
		Materia.addActionListener(radar);
		
		Semestre = new JRadioButton("Semestre");
		Semestre.setBounds(302, 167, 109, 23);
		contentPane.add(Semestre);
		Semestre.addActionListener(radar);
		
		comboBoxSem = new JComboBox();
		comboBoxSem.setEnabled(false);
		comboBoxSem.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxSem.setBounds(302, 220, 109, 20);
		contentPane.add(comboBoxSem);
		
		lblSeleccionaElTipo = new JLabel("Selecciona el tipo de Busqueda");
		lblSeleccionaElTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccionaElTipo.setBounds(92, 134, 186, 14);
		contentPane.add(lblSeleccionaElTipo);
	}
	public class Radar implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Login"))
			{
				setVisible(false);
				vista=new VistaIngreso();
				vista.setVisible(true);
			}
			
			
			if(a.getActionCommand().equals("Materia"))
			{
				Semestre.setSelected(false);
				Semestre.setEnabled(true);
				Materia.setSelected(true);
				comboBoxSem.setEnabled(false);
				comboBoxMat.setEnabled(true);
				
			}
			
			if(a.getActionCommand().equals("Semestre"))
			{
				Materia.setSelected(false);
				Materia.setEnabled(true);
				Semestre.setSelected(true);
				comboBoxSem.setEnabled(true);
				comboBoxMat.setEnabled(false);
				
			}


			
			if(a.getActionCommand().equals("Buscar"))
			{
				if(Semestre.isSelected() == true)
				{setVisible(false);
					vistaBusquedaSem= new VistaBusquedaSemestre(Integer.parseInt((String)comboBoxSem.getSelectedItem()));
					vistaBusquedaSem.setVisible(true);
				}
				else
				{   setVisible(false);
					vistaBusqueda= new VistaBusqueda((String)comboBoxMat.getSelectedItem());
					vistaBusqueda.setVisible(true);
				}
				
			}
			
			}
		}
}
