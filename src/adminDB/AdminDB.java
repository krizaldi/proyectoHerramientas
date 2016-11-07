package adminDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Herramienta;
import modelo.Materia;
import modelo.Usuario;
public class AdminDB {
	
	private Connection conexion;
	private ResultSet resultados;
	private String controladorBD;
	private String host;
	private String puerto;
	private String baseDatos;
	private String url;
	private String usuario;
	private String contraseña;
	private Usuario user;

	
	
	public AdminDB() {
		controladorBD = "org.postgresql.Driver";
		host = "127.0.0.1";
		puerto = "5432";
		baseDatos = "proyecto";
		url = "jdbc:postgresql://" + host + ":" + puerto + "/" + baseDatos;
		usuario = "postgres";
		contraseña = "p057gr35";
		resultados = null;
		conexion = null;
		user= null;
	}
	
	public String conectate(){
	       String mensaje="Conectando...";
	       try{
	    	   Class.forName(controladorBD);       
		   }catch(ClassNotFoundException cnfe){
			  mensaje="No se hallo el controlador de PostgreSQL";
		   }
	       try{
	 	       conexion=DriverManager.getConnection(url,usuario,contraseña);
	       }catch(SQLException sqe){
	    	   mensaje ="conexion Fallo"; 
	       }
	       return mensaje;
	    }
	public Usuario buscarUsuario(String usu){
		Statement proposicion=null;
		@SuppressWarnings("unused")
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		if(conexion!=null)
		{
			user=new Usuario();
			try {proposicion=conexion.createStatement();
				ordenSQL="Select * from administradores where nombre='"+usu+"';";
				resultados=proposicion.executeQuery(ordenSQL);
				user.setNombre("Vacio");
				while(resultados.next()){
				user.setNombre(resultados.getString(1));
				user.setContrasena(resultados.getString(2));
				};
				proposicion.close();
				conexion.close();
			} catch (SQLException e) {
				mensaje="No se pudo realizar la operacion";
			}
			
		}
		return user;
	}
	public String cambioContrasena(Usuario usuario,String contra){
		Statement proposicion=null;
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		if(conexion!=null){
			try {proposicion=conexion.createStatement();
			ordenSQL="update administradores set contrasena='"+contra+"' where nombre='"+usuario.getNombre()+"';";	
			proposicion.executeUpdate(ordenSQL);
			mensaje="operacion realizada";
			proposicion.close();
			conexion.close();
			} catch (SQLException e) {
				mensaje="No se pudo realizar la operacion";
			}
			}
		
		return mensaje;
	}
	public ArrayList<Herramienta> buscarMateria(String materia){
		Statement proposicion=null;
		@SuppressWarnings("unused")
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		ArrayList<Herramienta> herramientas=new ArrayList<Herramienta>();
		
		if(conexion!=null){
		try {proposicion=conexion.createStatement();
		ordenSQL="select * from herramientas where contiene='"+materia+"';";
		resultados=proposicion.executeQuery(ordenSQL);
		while(resultados.next()){
			Herramienta software=new Herramienta();
			software.setNombre(resultados.getString(1));
			software.setVersion(resultados.getString(2));
			software.setTipoDlicencia(resultados.getString(3));
			software.setPeriodo(resultados.getString(4));
			software.setCosto(resultados.getString(5));
			software.setDescripcion(resultados.getString(6));
			software.setUrl(resultados.getString(7));
			Materia materi= new Materia();
			materi.setNombre(resultados.getString(8));
			software.setMateria(materi);
			herramientas.add(software);
		};
			proposicion.close();
			conexion.close();
		} catch (SQLException e) {
			mensaje="No se pudo realizar la operacion";
		}
		}return herramientas;
	}
	
	public String agregarHerramienta(Herramienta herramienta){
		Statement proposicion=null;
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		if(conexion!=null){
			try {proposicion=conexion.createStatement();
			ordenSQL="INSERT INTO herramientas VALUES('"+herramienta.getNombre()+"','"+herramienta.getVersion()+"','"
			+herramienta.getTipoDlicencia()+"','"+herramienta.getPeriodo()+"','"+herramienta.getCosto()+"','"
			+herramienta.getDescripcion()+"','"+herramienta.getUrl()+"','"+herramienta.getMateria().getNombre()+"'); ";	
			proposicion.executeUpdate(ordenSQL);
			mensaje="operacion realizada";
			proposicion.close();
			conexion.close();
			} catch (SQLException e) {
				mensaje="No se pudo realizar la operacion";
			}
			}
		return mensaje;
		
	}
	public String agregarUsuario(String nombre){
		Statement proposicion=null;
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		if(conexion!=null){
			try {proposicion=conexion.createStatement();
			ordenSQL="INSERT INTO administradores VALUES('"+nombre+"','equipo1'); ";	
			proposicion.executeUpdate(ordenSQL);
			mensaje="Usuario agregado";
			proposicion.close();
			conexion.close();
			} catch (SQLException e) {
				mensaje="No se pudo realizar la operacion";
			}
			}
		return mensaje;
		
	}
	
	public Herramienta buscarHerramienta(String nombre, String version)
	{
		
		Statement proposicion=null;
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		Herramienta herramienta=new Herramienta();
		Materia materia=new Materia();
		if(conexion!=null)
		{
			try {proposicion=conexion.createStatement();
				ordenSQL="Select * from herramientas where nombre='"+nombre+"' AND version='"+version+"';";
				resultados=proposicion.executeQuery(ordenSQL);
				herramienta.setNombre("Vacio");
				while(resultados.next()){
				herramienta.setNombre(resultados.getString(1));
				herramienta.setVersion(resultados.getString(2));
				herramienta.setTipoDlicencia(resultados.getString(3));
				herramienta.setPeriodo(resultados.getString(4));
				herramienta.setCosto(resultados.getString(5));
				herramienta.setDescripcion(resultados.getString(6));
				herramienta.setUrl(resultados.getString(7));
			    materia.setNombre(resultados.getString(8));
				herramienta.setMateria(materia);};	
				
				
				
		 
				proposicion.close();
				conexion.close();
			} catch (SQLException e) {
				mensaje="No se pudo realizar la operacion";
			}
			
		}
		return herramienta;
	}
	public String borrarHerramienta(String nombre, String version){
		Statement proposicion=null;
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		if(conexion!=null){
			try {proposicion=conexion.createStatement();
			ordenSQL="delete from herramientas where nombre='"+nombre+"' and version='"+version+"'; ";	
			proposicion.executeUpdate(ordenSQL);
			mensaje="operacion realizada";
			proposicion.close();
			conexion.close();
			} catch (SQLException e) {
				mensaje="No se pudo realizar la operacion";
			}
			}
		
		
		return mensaje;
	}
	
	public String borrarUsuario(String nombre){
		Statement proposicion=null;
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		if(conexion!=null){
			try {proposicion=conexion.createStatement();
			ordenSQL="delete from administradores where nombre='"+nombre+"'; ";	
			proposicion.executeUpdate(ordenSQL);
			mensaje="operacion realizada";
			proposicion.close();
			conexion.close();
			} catch (SQLException e) {
				mensaje="No se pudo realizar la operacion";
			}
			}
		
		
		return mensaje;
	}
	
	public ArrayList<Herramienta> buscarSemestre(int semestre){
		Statement proposicion=null;
		@SuppressWarnings("unused")
		String mensaje=null, ordenSQL=null;
		mensaje=conectate();
		
		ArrayList<Herramienta> herramientas=new ArrayList<Herramienta>();
		
		if(conexion!=null){
		try {proposicion=conexion.createStatement();
		ordenSQL="select * from herramientas where contiene IN (select nombre from materias where semestre="+semestre+");";
		resultados=proposicion.executeQuery(ordenSQL);
		while(resultados.next()){
			Herramienta software=new Herramienta();
			software.setNombre(resultados.getString(1));
			software.setVersion(resultados.getString(2));
			software.setTipoDlicencia(resultados.getString(3));
			software.setPeriodo(resultados.getString(4));
			software.setCosto(resultados.getString(5));
			software.setDescripcion(resultados.getString(6));
			software.setUrl(resultados.getString(7));
			Materia materia= new Materia();
			materia.setNombre(resultados.getString(8));
			software.setMateria(materia);
			herramientas.add(software);
		};
			proposicion.close();
			conexion.close();
		} catch (SQLException e) {
			mensaje="No se pudo realizar la operacion";
		}
		}return herramientas;
	}
	
}