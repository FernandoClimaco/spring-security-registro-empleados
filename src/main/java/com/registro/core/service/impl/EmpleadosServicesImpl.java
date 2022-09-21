package com.registro.core.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.registro.core.service.EmpleadosServices;
import com.registro.entity.Empleados;
import com.registro.repositorio.EmpleadosRepositorio;
import com.registro.response.Response;



@Service
public class EmpleadosServicesImpl implements EmpleadosServices {

	@Autowired
	private EmpleadosRepositorio empleadosRepositorio;
	
	
	
	@Override
	public List<Empleados> listarTodosLosEmpleados() {
		List<Empleados> listaEmpleados = null;
		Response response = new Response();
		
		try {
			
			listaEmpleados = empleadosRepositorio.findAll();
			
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
			Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
					                                                        : Sort.by(sortBy).descending();
			Pageable pageable = PageRequest.of(pageNo, numeroRegistros, sort);
			Page<Empleados> page = empleadosRepositorio.findAll(pageable);
			listaEmpleados = page.getContent();

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
			
			listaEmpleados = empleadosRepositorio.buscarPorCodigoEmpleados(codigoEmpleado);
			
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
			
			listaEmpleados = empleadosRepositorio.buscarEmpleadosPorDuiYNit(dui, nit);
			
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
		Empleados empleado = new Empleados();
		Response response = new Response();
		
		try {
			
			empleado = empleadosRepositorio.save(empleados);
			
			if(empleado!=null) {
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
		Empleados empleado = new Empleados();
		Response response = new Response();
		
		try {
			
			
			 //busqueda por codigo
			 List<Empleados> listaEmpleados = this.buscarPorCodigoEmpleados(empleados.getCodigoEmpleado());
			 
			 if(listaEmpleados!=null) {
				 
				 if(empleados.getFechaContratacion()!=null && !empleados.getFechaContratacion().equals(" ")) {
					 listaEmpleados.get(0).setFechaContratacion(empleados.getFechaContratacion());
				 }
				 if(empleados.getCodigoEmpleado()!=null && !empleados.getCodigoEmpleado().equals(" ") && !empleados.getCodigoEmpleado().isEmpty()) {
					 listaEmpleados.get(0).setCodigoEmpleado(empleados.getCodigoEmpleado());
				 }
				 if(empleados.getTipoDeContrato()!=null && !empleados.getTipoDeContrato().equals(" ") && !empleados.getTipoDeContrato().isEmpty()) {
					 listaEmpleados.get(0).setTipoDeContrato(empleados.getTipoDeContrato());
				 }
				 
				 if(empleados.getDui()!=null && !empleados.getDui().equalsIgnoreCase(" ") && !empleados.getDui().isEmpty()) {
					 listaEmpleados.get(0).setDui(empleados.getDui());
				 }
				 
				 if(empleados.getNit()!=null && !empleados.getNit().equalsIgnoreCase(" ") && !empleados.getNit().isEmpty()) {
					 listaEmpleados.get(0).setNit(empleados.getNit());
				 }
				 
				 if(empleados.getTelefonos()!=null && !empleados.getTelefonos().equalsIgnoreCase(" ") && !empleados.getTelefonos().isEmpty()) {
					 listaEmpleados.get(0).setTelefonos(empleados.getTelefonos());
				 }
				 
				 if(empleados.getSueldoMensual()>0) {
					 listaEmpleados.get(0).setSueldoMensual(empleados.getSueldoMensual());
				 }
				 
				 
				  //Editando registros
				 empleado = empleadosRepositorio.save(listaEmpleados.get(0));
				 
				 if(empleado!=null) {
						response.setIdTransaccion(UUID.randomUUID().toString());
						response.setMensaje("Datos de empleados guardados");
						System.out.println(response);
					}else {
						response.setIdTransaccion(UUID.randomUUID().toString());
						response.setMensaje("Datos no guardados de empleados");
						System.out.println(response); 
					}
					 
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
		List<Empleados> listaEmpleados = null;
		Response response = new Response();
		
		try {
			
			listaEmpleados = this.buscarPorCodigoEmpleados(codigoEmpleado);
			
			if(listaEmpleados !=null) {
				empleadosRepositorio.delete(listaEmpleados.get(0));
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Registros eliminados");
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Registros no eliminadoss");
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
