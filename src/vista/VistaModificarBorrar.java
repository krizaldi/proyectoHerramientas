package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminDB.AdminDB;
import modelo.Herramienta;
import modelo.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VistaModificarBorrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nombre;
	private VistaAdministrador vistaAdmon;
	private VistaAltas vistaAltas;
	private JMenuBar menuBar;
	private Logo logo;
	private Radar radar;
	private JTextField Version;
	private JButton Aceptar;
	private JLabel lblNombre;
	private JLabel lblVersion;
	private JButton Regresa;
	private String id;
	private AdminDB base;
	public Herramienta herramienta;
	public VistaModificaciones vistaModificaciones;
	private static Usuario usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaModificarBorrar frame = new VistaModificarBorrar(usuario,"");
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
	public VistaModificarBorrar(Usuario usuario,String id) {
		this.usuario=usuario;
		this.setId(id);
		base=new AdminDB();
		radar =new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Nombre = new JTextField();
		Nombre.setBounds(153, 168, 194, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(157, 34, 53));
		menuBar.setBounds(0, 0, 471, 21);
		contentPane.add(menuBar);
		
		logo = new Logo("logo.jpg");
		logo.setBounds(0, 21, 471, 120);
		contentPane.add(logo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(53, 168, 50, 20);
		contentPane.add(lblNombre);
		
		lblVersion = new JLabel("Version");
		lblVersion.setBounds(53, 218, 46, 14);
		contentPane.add(lblVersion);
		
		Version = new JTextField();
		Version.setBounds(153, 215, 194, 20);
		contentPane.add(Version);
		Version.setColumns(10);
		
		Regresa = new JButton("Regresar");
		Regresa.addActionListener(radar);
		Regresa.setBounds(53, 283, 89, 23);
		contentPane.add(Regresa);
		
		Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(radar);
		Aceptar.setBounds(258, 283, 89, 23);
		contentPane.add(Aceptar);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private class Radar implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("Aceptar")){
				if(getId().equals("Borrar Elementos")){
					int seleccion=JOptionPane.showConfirmDialog(null, "Realmente deseas borrar la Herramienta?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(seleccion==JOptionPane.YES_OPTION){
                    	try{
                    	herramienta=base.buscarHerramienta(Nombre.getText(),Version.getText());
                    	if(!(herramienta.getNombre().equals("Vacio"))){
                    	String msj=base.borrarHerramienta(Nombre.getText(),Version.getText());
                    		JOptionPane.showMessageDialog(null, msj);
                    		Nombre.setText(null);
                    		Version.setText(null);
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
               if(getId().equals("Modificar Elementos")){
            	   herramienta=base.buscarHerramienta(Nombre.getText(),Version.getText());
            	if(!(herramienta.getNombre().equals("Vacio"))){
            		setVisible(false);
   				  vistaModificaciones=new VistaModificaciones(usuario,herramienta);
   				  vistaModificaciones.setVisible(true);
            	}
            	if(Nombre.getText().equals("")&&Version.getText().equals("")){JOptionPane.showMessageDialog(null, "Ingresa datos");}
            	else{
            	   JOptionPane.showMessageDialog(null, "Elemento no encontrado");
            	}
				
				
			}
               }
			if(a.getActionCommand().equals("Regresar")){
				setVisible(false);
				vistaAdmon=new VistaAdministrador(usuario);
				vistaAdmon.setVisible(true);
			}
			
	
	
	}
	
	
}
	}
