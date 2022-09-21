package com.registro.entity;

import java.io.Serializable;   
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint; 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Entity
@Table(name = "publicacion" , uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})  } )
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name="titulo" , nullable = false )
	private String titulo;
	
	@Column(name="descripcion" , nullable = false)
	private String descripcion;
	
	@Column(name="contenido" , nullable = false)
	private String contenido;
	
	
	@ManyToOne
	@JoinColumn(name="comentario") 
	private Comentario comentarios;


	public Publicacion(Integer id, String titulo, String descripcion, String contenido, Comentario comentarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.comentarios = comentarios;
	}


	public Publicacion() {
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


	public Comentario getComentarios() {
		return comentarios;
	}


	public void setComentarios(Comentario comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Publicacion [id=");
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
