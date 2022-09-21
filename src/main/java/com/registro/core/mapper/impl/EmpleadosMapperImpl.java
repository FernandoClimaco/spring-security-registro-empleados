package com.registro.core.mapper.impl;

import java.util.List;
import java.util.UUID; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.registro.core.mapper.EmpleadosMapper;
import com.registro.core.service.EmpleadosServices;
import com.registro.entity.Empleados;
import com.registro.response.Response; 

@Component
public class EmpleadosMapperImpl implements  EmpleadosMapper {
	
	@Autowired
	private EmpleadosServices empleadosServices;
 

	@Override
	public List<Empleados> listarTodosLosEmpleados() {
		List<Empleados> listaEmpleados = null;
		Response response = new Response();
		
		try {
			
			listaEmpleados = empleadosServices.listarTodosLosEmpleados();
			
			if(listaEmpleados !=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Registros encontrados");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Registros no encontrados");
			}
			
		}catch(HttpStatusCodeException e) {
			
			if(e.getRawStatusCode()==400) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("bad request");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("not found");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);
			} 
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
 		return listaEmpleados;
	}
	
	
	

	@Override
	public List<Empleados> listarEmpleadosPorPaginacion(int pageNo, int numeroRegistros, String sortBy, String sortDir) {
		List<Empleados> listaEmpleados = null;
		Response response = new Response();

		try {
			listaEmpleados = empleadosServices.listarEmpleadosPorPaginacion(pageNo, numeroRegistros, sortBy, sortDir);

		} catch (HttpStatusCodeException e) {

			if (e.getRawStatusCode() == 400) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("bad request");
				System.out.println(response);
			}
			if (e.getRawStatusCode() == 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("not found");
				System.out.println(response);
			}
			if (e.getRawStatusCode() == 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return listaEmpleados;
	}
	
	
	 

	@Override
	public List<Empleados> buscarPorCodigoEmpleados(String codigoEmpleado) {
		List<Empleados> listaEmpleados = null;
		Response response = new Response();
		
		try {
			
			listaEmpleados = empleadosServices.buscarPorCodigoEmpleados(codigoEmpleado);
			
			if(listaEmpleados.isEmpty()) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos encontrados");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos encontrados");
				System.out.println(response); 
			}
			
		}catch(HttpStatusCodeException e) {
			
			if(e.getRawStatusCode()==400) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("bad request");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("not found");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);
			} 
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
 		return listaEmpleados;
	}

	
	
	
	@Override
	public List<Empleados> buscarEmpleadosPorDuiYNit(String dui, String nit) {
		List<Empleados> listaEmpleados = null;
		Response response = new Response();
		
		try {
			
			listaEmpleados = empleadosServices.buscarEmpleadosPorDuiYNit(dui, nit);
			
			if(listaEmpleados.isEmpty()) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos encontrados");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos encontrados");
				System.out.println(response); 
			}
			
		}catch(HttpStatusCodeException e) {
			
			if(e.getRawStatusCode()==400) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("bad request");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("not found");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);
			} 
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
 		return listaEmpleados;
	}

	
	
	@Override
	public Response guardarEmpleados(Empleados empleados) {
		 
		Response response = new Response();
		
		try {
			
			response = empleadosServices.guardarEmpleados(empleados);
			
			if(response!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos de empleados guardados");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos no guardados de empleados");
				System.out.println(response); 
			}
			
		}catch(HttpStatusCodeException e) {
			
			if(e.getRawStatusCode()==400) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("bad request");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("not found");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);
			} 
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
 		return response;
	}

	
	
	
	
	@Override
	public Response editarEmpleados(Empleados empleados) {
		  
		Response response = new Response();
		
		try {
			
			response = empleadosServices.editarEmpleados(empleados);
			
			if(response!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos de empleados editados");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos no guardados de editados");
				System.out.println(response); 
			}
			
		}catch(HttpStatusCodeException e) {
			
			if(e.getRawStatusCode()==400) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("bad request");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("not found");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);
			} 
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
 		return response; 
	}

	
	
	
	@Override
	public Response eliminarEmpleados(String codigoEmpleado) { 
		Response response = new Response();
		
		try {
			
			response = empleadosServices.eliminarEmpleados(codigoEmpleado);
			
			if(response!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos de empleados eliminados");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Datos no eliminados de empleados");
				System.out.println(response); 
			}
			
		}catch(HttpStatusCodeException e) {
			
			if(e.getRawStatusCode()==400) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("bad request");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("not found");
				System.out.println(response);
			}
			if(e.getRawStatusCode()==500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);
			} 
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
 		return response;  
	}
	
	

}
