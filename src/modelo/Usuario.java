package modelo;//
//
//
//
//  @ Project : Herramientas de software
//  @ File Name : Busqueda.java
//  @ Date : 02/10/2016
//  @ Author : Equipo 1
//
//




public class Usuario {
	private String nombre;
	private String contrasena;
	private Profesor profesor;
	private Estudiante estudiante;
	private Busqueda busqueda;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Busqueda getBusqueda() {
		return busqueda;
	}
	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}
	
}
