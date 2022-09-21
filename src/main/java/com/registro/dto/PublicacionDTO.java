package com.registro.dto;

 

public class PublicacionDTO {
	
	private Integer id;
	private String titulo;
	private String descripcion;
	private String contenido;
	private Integer comentarios;
	public PublicacionDTO(Integer id, String titulo, String descripcion, String contenido, Integer comentarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.comentarios = comentarios;
	}
	public PublicacionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Integer getComentarios() {
		return comentarios;
	}
	public void setComentarios(Integer comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublicacionDTO [id=");
		builder.append(id);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", contenido=");
		builder.append(contenido);
		builder.append(", comentarios=");
		builder.append(comentarios);
		builder.append("]");
		return builder.toString();
	}
	
	
	 
	
	 
	

}
