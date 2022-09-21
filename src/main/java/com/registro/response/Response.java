package com.registro.response;

public class Response {
	
	
	private String idTransaccion; 
	private String mensaje;
	public Response(String idTransaccion, String mensaje) {
		super();
		this.idTransaccion = idTransaccion;
		this.mensaje = mensaje;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [idTransaccion=");
		builder.append(idTransaccion);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
