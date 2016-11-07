package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminDB.AdminDB;
import modelo.Herramienta;
import modelo.Materia;
import modelo.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class VistaModificaciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logo logo;
	private Radar radar;
	private AdminDB base;
	private JPanel txtVersion;
	private JPanel panel;
	private JTextField txtNombre;
	private JTextField textVersion;
	private JTextField textCosto;
	private JTextField textDescripcion;
	private JTextField textURL;
	private JLabel lblNombre;
	private JLabel lblVersion;
	private JLabel lblDescripcion;
	private JLabel lblCosto;
	private JLabel lblTipoDeLicencia;
	private JLabel lblPeriodoDeLicencia;
	private JLabel lblUrl;
	private JButton btnAceptar;
	private JLabel lblMateria;
	private JButton btnRegresar;
	private JComboBox cmbMateria;
	private JComboBox cmbMesAno;
	private JComboBox cmbNum;
	private JComboBox cmbTipo;
	private static Usuario usuario;
	private static Herramienta herramienta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaModificaciones frame = new VistaModificaciones(usuario, herramienta);
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
	public VistaModificaciones(Usuario usuario,Herramienta herra) {
		this.usuario=usuario;
		herramienta=herra;
		base=new AdminDB();
		radar=new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 560);
		txtVersion = new JPanel();
		txtVersion.setBackground(Color.WHITE);
		txtVersion.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txtVersion);
		txtVersion.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(157, 34, 53));
		panel.setBounds(0, 0, 434, 45);
		txtVersion.add(panel);
		
		logo = new Logo("logo.jpg");
		logo.setBounds(0, 42, 434, 93);
		txtVersion.add(logo);
		
		txtNombre = new JTextField();
		txtNombre.setText(herramienta.getNombre());
		txtNombre.setBounds(149, 146, 209, 20);
		txtVersion.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		textVersion = new JTextField();
		textVersion.setText(herramienta.getVersion());
		textVersion.setColumns(10);
		textVersion.setBounds(149, 188, 209, 20);
		txtVersion.add(textVersion);
	
		
		textCosto = new JTextField();
		textCosto.setText(herramienta.getCosto());
		textCosto.setColumns(10);
		textCosto.setBounds(149, 305, 209, 20);
		txtVersion.add(textCosto);
		
		textDescripcion = new JTextField();
		textDescripcion.setText(herramienta.getDescripcion());
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(149, 233, 209, 20);
		txtVersion.add(textDescripcion);
		
		textURL = new JTextField();
		textURL.setText(herramienta.getUrl());
		textURL.setColumns(10);
		textURL.setBounds(149, 272, 209, 20);
		txtVersion.add(textURL);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(58, 149, 46, 14);
		txtVersion.add(lblNombre);
		
		lblVersion = new JLabel("Version");
		lblVersion.setBounds(58, 191, 46, 14);
		txtVersion.add(lblVersion);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(58, 236, 68, 14);
		txtVersion.add(lblDescripcion);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setBounds(60, 311, 46, 14);
		txtVersion.add(lblCosto);
		
		lblTipoDeLicencia = new JLabel("Tipo de Licencia");
		lblTipoDeLicencia.setBounds(58, 395, 125, 14);
		txtVersion.add(lblTipoDeLicencia);
		
		lblPeriodoDeLicencia = new JLabel("Periodo de Licencia");
		lblPeriodoDeLicencia.setBounds(58, 357, 91, 14);
		txtVersion.add(lblPeriodoDeLicencia);
		
		lblUrl = new JLabel("URL");
		lblUrl.setBounds(60, 278, 46, 14);
		txtVersion.add(lblUrl);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(172, 466, 89, 23);
		btnAceptar.addActionListener(radar);
		txtVersion.add(btnAceptar);
		
		lblMateria = new JLabel("Materia");
		lblMateria.setBounds(60, 425, 46, 14);
		txtVersion.add(lblMateria);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(20, 466, 89, 23);
		txtVersion.add(btnRegresar);
		
		cmbMateria = new JComboBox();
		cmbMateria.setModel(new DefaultComboBoxModel(new String[] {"Introduccion a la Programacion", "Introduccion a la Ingenieria de Software", "Programacion Orientada a Objetos", "Estructura de Datos", "Construccion y Evolucion de Software", "Analisis de Algoritmos", "Analisis de Requisitos", "Base de Datos", "Sistemas Operativos", "Analis y Modelamiento de Software", "Programacion Web", "Programacion de Sistemas", "Aseguramiento de la Calidad de Software"}));
		cmbMateria.setBounds(149, 423, 209, 20);
		txtVersion.add(cmbMateria);
		
		cmbMesAno = new JComboBox();
		cmbMesAno.setModel(new DefaultComboBoxModel(new String[] {"", "Meses", "A\u00F1os"}));
		cmbMesAno.setBounds(184, 354, 61, 20);
		txtVersion.add(cmbMesAno);
		
		cmbNum = new JComboBox();
		cmbNum.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbNum.setBounds(299, 354, 37, 20);
		txtVersion.add(cmbNum);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "abierta"}));
		cmbTipo.setBounds(149, 389, 207, 20);
		txtVersion.add(cmbTipo);
		btnRegresar.addActionListener(radar);
		
	}	
		public class Radar implements ActionListener{
			private VistaAdministrador vista;
			private Materia materia;
			private Herramienta herramienta;

			public void actionPerformed(ActionEvent a) {
				if(a.getActionCommand().equals("Regresar")){
					setVisible(false);
					vista=new VistaAdministrador(usuario);
					vista.setVisible(true);
				}
				if(a.getActionCommand().equals("Aceptar"))
				{ 
				 try{String mensaje=null;
				    materia=new Materia();
					herramienta=new Herramienta();
					herramienta.setNombre(txtNombre.getText());
					herramienta.setVersion(textVersion.getText());
					herramienta.setTipoDlicencia(cmbTipo.getName());
					String periodo=cmbNum.getName()+" "+cmbMesAno.getName();
					herramienta.setPeriodo(periodo);
					herramienta.setCosto(textCosto.getText());
					herramienta.setDescripcion(textDescripcion.getText());
					herramienta.setUrl(textURL.getText());
				    materia.setNombre(cmbMateria.getName());
					herramienta.setMateria(materia);
					mensaje=base.agregarHerramienta(herramienta);
					JOptionPane.showMessageDialog(null,mensaje);
					txtNombre.setText(null);
					textVersion.setText(null);
					textCosto.setText(null);
					textDescripcion.setText(null);
					textURL.setText(null);
					}catch(NullPointerException |NumberFormatException c){
						JOptionPane.showMessageDialog(null,"Datos Invalidos");
					}	
				}
				}
				}
		}