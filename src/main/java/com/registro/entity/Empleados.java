package com.registro.entity;

import java.io.Serializable;
import java.util.Date; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="empleados") 
public class Empleados  implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) 
	private int idEmpleado;
	 
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaContratacion;
	
	@Column
	private String codigoEmpleado;
	
	@Column
	private String tipoDeContrato;
	
	@Column
	private String dui;
	
	@Column
	private String nit;
	
	@Column
	private String telefonos;
	
	@Column
	private double sueldoMensual;

	public Empleados(int idEmpleado, Date fechaContratacion, String codigoEmpleado, String tipoDeContrato, String dui,
			String nit, String telefonos, double sueldoMensual) {
		super();
		this.idEmpleado = idEmpleado;
		this.fechaContratacion = fechaContratacion;
		this.codigoEmpleado = codigoEmpleado;
		this.tipoDeContrato = tipoDeContrato;
		this.dui = dui;
		this.nit = nit;
		this.telefonos = telefonos;
		this.sueldoMensual = sueldoMensual;
	}

	public Empleados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getTipoDeContrato() {
		return tipoDeContrato;
	}

	public void setTipoDeContrato(String tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public double getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleados [idEmpleado=");
		builder.append(idEmpleado);
		builder.append(", fechaContratacion=");
		builder.append(fechaContratacion);
		builder.append(", codigoEmpleado=");
		builder.append(codigoEmpleado);
		builder.append(", tipoDeContrato=");
		builder.append(tipoDeContrato);
		builder.append(", dui=");
		builder.append(dui);
		builder.append(", nit=");
		builder.append(nit);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append(", sueldoMensual=");
		builder.append(sueldoMensual);
		builder.append("]");
		return builder.toString();
	}
	
	
	 

}
