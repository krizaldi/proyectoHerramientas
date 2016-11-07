package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import adminDB.AdminDB;
import modelo.Usuario;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class VistaIngreso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	
    private Logo logo;
    private GroupLayout gl_contentPane;
	private Radar radar;
	private JButton btnIngresar;
	private VistaAdministrador vista;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private AdminDB base;
	private JPasswordField txtContrasena;
	private JButton btnRegresar;
	public VistaPrincipal vistaPrincipal;
	/**
	 * Launch the application.
	 * private JTextField txtContrasena;
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaIngreso frame = new VistaIngreso();
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
	public VistaIngreso() {
		base= new AdminDB();
		radar=new Radar();
		logo=new Logo("logo.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		lblUsuario = new JLabel("Usuario");
		lblContrasena = new JLabel("Contrase\u00F1a");
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtContrasena = new JPasswordField();
		txtContrasena.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(radar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(157, 34, 53));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(radar);
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnRegresar)
					.addGap(87)
					.addComponent(btnIngresar)
					.addContainerGap(175, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(114)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(lblContrasena))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(136, Short.MAX_VALUE))
				.addComponent(logo, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(logo, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasena))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIngresar)
						.addComponent(btnRegresar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public class Radar implements ActionListener{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Ingresar"))
			{
				String nombre,contrasena;
				nombre=txtUsuario.getText();
				contrasena=txtContrasena.getText();
				Usuario user=null;	
				user = base.buscarUsuario(nombre);
				try{
				if(user.getNombre().equals(nombre)&&user.getContrasena().equals(contrasena)){
					setVisible(false);
					vista=new VistaAdministrador(user);
					vista.setVisible(true);
				}
				if(user.getNombre().equals(nombre)&&!(user.getContrasena().equals(contrasena))){
					JOptionPane.showMessageDialog(null,"Contraseña invalida");
				}
				
				}catch(NullPointerException c){
					JOptionPane.showMessageDialog(null,"Datos Invalidos");
				}
				}
			if(a.getActionCommand().equals("Regresar"))
			{
				setVisible(false);
				vistaPrincipal=new VistaPrincipal();
				vistaPrincipal.setVisible(true);
			}	
		}
			}
			
			
		}
