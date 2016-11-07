package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminDB.AdminDB;
import modelo.Usuario;
import vista.VistaAdministrador.Radar;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;

public class VistaCambioContrasea extends JFrame {
	private AdminDB base;
	private JPanel contentPane;
	private Logo logo;
	private JPasswordField passwordNueva;
	private JPasswordField passwordConfirmar;
	private JMenu menu;
	private JMenuBar menuBar;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lblConfirmarContra;
	private JLabel lblCrearContra;
	private JLabel lblNuevoUsu;
	private JLabel lblNewLabel;
	public VistaAdministrador vista;
	private static Usuario usuario;
	private Radar radar;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCambioContrasea frame = new VistaCambioContrasea(usuario);
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
	public VistaCambioContrasea(Usuario usuario) {
		this.usuario=usuario;
		base=new AdminDB();
		radar=new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		logo = new Logo("logo.jpg");
		logo.setBounds(0, 22, 434, 107);
		contentPane.add(logo);
		
		lblNuevoUsu = new JLabel("Nombre de Usuario");
		lblNuevoUsu.setBounds(27, 138, 150, 25);
		contentPane.add(lblNuevoUsu);
		
		lblCrearContra = new JLabel("Nueva Contrase\u00F1a");
		lblCrearContra.setBounds(27, 167, 106, 25);
		contentPane.add(lblCrearContra);
		
		passwordNueva = new JPasswordField();
		passwordNueva.setBounds(187, 169, 118, 20);
		contentPane.add(passwordNueva);
		
		lblConfirmarContra = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContra.setBounds(27, 191, 106, 29);
		contentPane.add(lblConfirmarContra);
		
		passwordConfirmar = new JPasswordField();
		passwordConfirmar.setBounds(187, 195, 118, 20);
		contentPane.add(passwordConfirmar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(216, 231, 89, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(radar);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(44, 231, 89, 23);
		btnCancelar.addActionListener(radar);
		contentPane.add(btnCancelar);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(157, 34, 53));
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
	     menu = new JMenu("");
		menuBar.add(menu);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(187, 143, 118, 14);
		lblNewLabel.setText(usuario.getNombre());
		contentPane.add(lblNewLabel);
		
	}
	
public class Radar implements ActionListener{
	

		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Confirmar"))
			{    if(passwordNueva.getText().equals(passwordConfirmar.getText())){
				base.cambioContrasena(usuario,passwordNueva.getText());
				JOptionPane.showMessageDialog(null,"Operacion realizada");
				setVisible(false);
				vista=new VistaAdministrador(usuario);
				vista.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"No coincide la contraseña");
				passwordNueva.setText(null);
				passwordConfirmar.setText(null);
			}
			}
			if(a.getActionCommand().equals("Cancelar"))
			{
				setVisible(false);
				vista=new VistaAdministrador(usuario);
				vista.setVisible(true);
			}
		}
		
}
	
}
