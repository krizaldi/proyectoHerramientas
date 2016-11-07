package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminDB.AdminDB;
import modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaEliminarUsu extends JFrame {

	private JPanel contentPane;
	private Logo logo;
	private JTextField textIdUsu;
	private JTextField textConfimarId;
	private static Usuario usuario;
	private AdminDB base;
	private Radar radar;
	private JLabel lblIngresaElUsuario;
	private JLabel lblConfirmarId;
	private JButton btnConfimar;
	private JButton btnCancelar;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEliminarUsu frame = new VistaEliminarUsu(usuario);
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
	public VistaEliminarUsu(Usuario usuario) {
		this.usuario=usuario;
		base=new AdminDB();
		radar =new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logo = new Logo("logo.jpg");
		logo.setBounds(0, 22, 434, 107);
		contentPane.add(logo);
		
		lblIngresaElUsuario = new JLabel("Ingresa el Usuario a eliminar");
		lblIngresaElUsuario.setBounds(20, 145, 144, 20);
		contentPane.add(lblIngresaElUsuario);
		
		lblConfirmarId = new JLabel("Confirmar el ID de Usuario");
		lblConfirmarId.setBounds(20, 176, 144, 20);
		contentPane.add(lblConfirmarId);
		
		textIdUsu = new JTextField();
		textIdUsu.setBounds(195, 145, 144, 20);
		contentPane.add(textIdUsu);
		textIdUsu.setColumns(10);
		
		textConfimarId = new JTextField();
		textConfimarId.setBounds(195, 176, 144, 20);
		contentPane.add(textConfimarId);
		textConfimarId.setColumns(10);
		
		btnConfimar = new JButton("Confirmar");
		btnConfimar.setBounds(250, 217, 89, 23);
		contentPane.add(btnConfimar);
		btnConfimar.addActionListener(radar);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(75, 217, 89, 23);
		btnCancelar.addActionListener(radar);
		contentPane.add(btnCancelar);
		
	}
	private class Radar implements ActionListener{
		private Usuario usuari;
		private VistaAdministrador vista;

		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Confirmar")){
				if(!(usuario.getNombre().equals(textIdUsu.getText()))){
				int seleccion=JOptionPane.showConfirmDialog(null, "Realmente deseas borrar este Usuario?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(seleccion==JOptionPane.YES_OPTION){
                    	try{
                    	usuari=base.buscarUsuario(textIdUsu.getText());
                    	if(!(usuari.getNombre().equals("Vacio"))){
                    	String msj=base.borrarUsuario(textIdUsu.getText());
                    		JOptionPane.showMessageDialog(null, msj);
                    		setVisible(false);
        					vista=new VistaAdministrador(usuario);
        					vista.setVisible(true);
                    	}
                    	else{
                     	   JOptionPane.showMessageDialog(null, "Elemento no encontrado");
                     	}
                    	}catch(NullPointerException c){
                    		JOptionPane.showMessageDialog(null, "elemento no encontrado");
                    	}
                    	
                    }
                    if(seleccion==JOptionPane.NO_OPTION){
                    	JOptionPane.showMessageDialog(null, "Operacion cancelada");
                    }
				}
				else{
					JOptionPane.showMessageDialog(null, "No puedes borrar tu Usuario");
					textIdUsu.setText(null);
					textConfimarId.setText(null);
				}
				}
			if(a.getActionCommand().equals("Cancelar")){
				setVisible(false);
				vista=new VistaAdministrador(usuario);
				vista.setVisible(true);
			}
			}
	}
	}
