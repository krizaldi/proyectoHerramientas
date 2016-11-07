package vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminDB.AdminDB;
import modelo.Usuario;
import vista.VistaModificaciones.Radar;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class VistaAltaUsuario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Logo logo;
	private JMenuBar menuBar;
	private Radar radar;
	public VistaAdministrador vista;
	private JLabel lblSeleccionaElTipo;
	private static Usuario usuario;
	public VistaBusqueda vistaBusqueda;
	public VistaBusquedaSemestre vistaBusquedaSem;
	private JTextField txtUsuario;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton Acepto;
	private JRadioButton NoAcepto;
	private JButton Continuar;
	private JButton Cancelar;
	private AdminDB base;
	private JLabel lblNombreDeUsuario;
	private JLabel lblNombre;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaUsuario frame = new VistaAltaUsuario(usuario);
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
	public VistaAltaUsuario(Usuario usuario) {
		this.usuario=usuario;
		radar=new Radar();
		base=new AdminDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 658);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(157, 34, 53));
		menuBar.setBounds(0, 0, 538, 21);
		contentPane.add(menuBar);
		
		logo = new Logo("logo.jpg");
		logo.setBounds(0, 22, 538, 107);
		contentPane.add(logo);
		
		lblSeleccionaElTipo = new JLabel("Nuevo Administrador");
		lblSeleccionaElTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccionaElTipo.setBounds(182, 129, 186, 14);
		contentPane.add(lblSeleccionaElTipo);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setBounds(71, 178, 94, 14);
		contentPane.add(lblNombreDeUsuario);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(71, 213, 94, 14);
		contentPane.add(lblNombre);
		
		lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setBounds(71, 248, 94, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(71, 278, 111, 14);
		contentPane.add(lblApellidoMaterno);
		
		lblTelefono = new JLabel("telefono");
		lblTelefono.setBounds(71, 314, 46, 14);
		contentPane.add(lblTelefono);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(71, 350, 46, 14);
		contentPane.add(lblEmail);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(227, 175, 247, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 210, 247, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(227, 245, 247, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 275, 247, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(227, 314, 247, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(227, 347, 247, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 9));
		textArea.setSelectionStart(2);
		textArea.setEditable(false);
		textArea.setText("\t\t Pol\u00EDtica de privacidad y manejo de datos personales\r\n\r\nEn cumplimiento con lo establecido por la Ley Federal de Transparencia y Acceso a la\r\nInformaci\u00F3n P\u00FAblica Gubernamental, su reglamento, as\u00ED como lo se\u00F1alado en los\r\nLineamientos de Protecci\u00F3n de Datos Personales, se establece el siguiente compromiso:\r\n\r\nLos datos personales que se ingresen en el formulario de contacto, no ser\u00E1n difundidos,\r\ndistribuidos o comercializados. \u00DAnicamente podr\u00E1n ser proporcionados a terceros de\r\nacuerdo con lo estrictamente se\u00F1alado en el Art. 22 de la Ley Federal de Transparencia y \r\nAcceso a la Informaci\u00F3n P\u00FAblica Gubernamental, para lo cual, la UACM se compromete a\r\ntratar dicha informaci\u00F3n, de conformidad con los principios de licitud, calidad, acceso y \r\ncorrecci\u00F3n de informaci\u00F3n, seguridad, custodia, y consentimiento para su transmisi\u00F3n\r\ndebiendo obedecer exclusivamente.\r\n\r\nLa informaci\u00F3n que nos proporcione mediante el llenado de formularios publicados en\r\n esta p\u00E1gina, puede ser incluida dentro de los informes que se elaboran para el seguimiento\r\n de avances institucionales de la UACM, los cuales ser\u00E1n meramente estad\u00EDsticos y no incluir\u00E1n\r\n informaci\u00F3n que permita identificarle en lo individual. Los datos personales que\r\n proporcione en los formularios del sitio web de la UACM, ser\u00E1n protegidos en t\u00E9rminos de los\r\n art\u00EDculos 3, fracci\u00F3n II, 18, fracci\u00F3n II, 19, 20, fracci\u00F3n VI, 21, 22 y dem\u00E1s correlativos de la\r\n Ley Federal de Transparencia y Acceso a la Informaci\u00F3n P\u00FAblica Gubernamental, as\u00ED como\r\n los art\u00EDculos 37, 38, 39, 40, 41, 47 y 48 de su Reglamento, y los Lineamientos de Protecci\u00F3n\r\n de Datos Personales.\r\n\r\nEl Instituto compromete a su personal que tiene acceso a datos personales en el ejercicio \r\nde sus funciones o intervenci\u00F3n en cualquier fase del tratamiento, a mantener\r\nconfidencialidad respecto de dicha informaci\u00F3n. El Instituto informar\u00E1 por este medio \r\nsobre cualquier cambio a la Pol\u00EDtica de Privacidad y Manejo de Datos Personales. Se sugiere\r\nvisitar con frecuencia esta \u00E1rea del sitio, a fin de mantenerse oportunamente informado.\r\n\r\n\r\nSi hubiera alg\u00FAn cambio de material en el tipo de informaci\u00F3n que recogemos o en la \r\nmanera que utilizamos tal informaci\u00F3n, obtendremos su permiso antes de realizar \r\ncualquier alteraci\u00F3n.");
		textArea.setBounds(60, 383, 430, 130);
		contentPane.add(textArea);
		
		Acepto = new JRadioButton("Acepto");
		Acepto.setBounds(76, 526, 89, 23);
		contentPane.add(Acepto);
		Acepto.addActionListener(radar);
		
		
		
		NoAcepto = new JRadioButton("No Acepto");
		NoAcepto.setBounds(227, 526, 89, 23);
		contentPane.add(NoAcepto);
		NoAcepto.addActionListener(radar);
		
		Continuar = new JButton("Continuar");
		Continuar.setEnabled(false);
		Continuar.setBounds(385, 585, 89, 23);
		contentPane.add(Continuar);
		Continuar.addActionListener(radar);
		
		Cancelar = new JButton("Cancelar");
		Cancelar.setBounds(138, 585, 89, 23);
		contentPane.add(Cancelar);
		Cancelar.addActionListener(radar);
	}
	
	
	
	public class Radar implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Acepto"))
			{
				NoAcepto.setSelected(false);
				NoAcepto.setEnabled(true);
				Acepto.setSelected(true);
				Continuar.setEnabled(true);
				
			}
			if(a.getActionCommand().equals("No Acepto"))
			{
				Acepto.setSelected(false);
				Acepto.setEnabled(true);
				NoAcepto.setSelected(true);
				Continuar.setEnabled(false);
				
			}
			
			if(a.getActionCommand().equals("Cancelar")){
				setVisible(false);
				vista=new VistaAdministrador(usuario);
				vista.setVisible(true);
			}
			if(a.getActionCommand().equals("Continuar")){
				String msj=base.agregarUsuario(txtUsuario.getText());
				JOptionPane.showMessageDialog(null,msj);
				setVisible(false);
				vista=new VistaAdministrador(usuario);
				vista.setVisible(true);
			}
			
			
			}
		}
}


