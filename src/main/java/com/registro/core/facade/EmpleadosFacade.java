package com.registro.core.facade;

import java.util.List;

import com.registro.entity.Empleados;
import com.registro.response.Response;



public interface EmpleadosFacade {
	
	List<Empleados> listarTodosLosEmpleados();
	List<Empleados> listarEmpleadosPorPaginacion(int pageNo,int numeroRegistros, String sortBy, String sortDir);
	List<Empleados> buscarPorCodigoEmpleados(String codigoEmpleado);
	List<Empleados> buscarEmpleadosPorDuiYNit(String dui,String nit); 
	
	public Response guardarEmpleados(Empleados empleados);
	public Response editarEmpleados(Empleados empleados);
	public Response eliminarEmpleados(String codigoEmpleado);
	

}
