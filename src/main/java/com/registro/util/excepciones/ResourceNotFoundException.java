package com.registro.util.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
 
	private static final long serialVersionUID = 1L;
	
	private String nombreDelRecurso;
	private String nombreDelCampo;
	private Integer valorDelCampo;
	
	public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, Integer valorDelCampo) {
		super(String.format("%s  No encontrado con : %s : '%s'" , nombreDelRecurso,nombreDelCampo,valorDelCampo));
		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
		this.valorDelCampo = valorDelCampo;
	}

	
	public String getNombreDelRecurso() {
		return nombreDelRecurso;
	}

	public void setNombreDelRecurso(String nombreDelRecurso) {
		this.nombreDelRecurso = nombreDelRecurso;
	}

	public String getNombreDelCampo() {
		return nombreDelCampo;
	}

	public void setNombreDelCampo(String nombreDelCampo) {
		this.nombreDelCampo = nombreDelCampo;
	}

	public Integer getValorDelCampo() {
		return valorDelCampo;
	}

	public void setValorDelCampo(Integer valorDelCampo) {
		this.valorDelCampo = valorDelCampo;
	}
	
	
	
	
	

}
