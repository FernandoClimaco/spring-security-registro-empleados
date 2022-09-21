package com.registro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

 
import com.registro.core.facade.EmpleadosFacade;
import com.registro.entity.Empleados;
import com.registro.response.Response;
import com.registro.util.RestResponse;
import com.registro.util.excepciones.ResourceNotFoundException;  

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadosController {
	
	@Autowired
	private EmpleadosFacade empleadosFacade;
	
	@Autowired
	private RestResponse restResponse;
	
	
	@GetMapping("/listarTodosLosEmpleados/")
	public ResponseEntity<List<Empleados>> listarTodosLosProductos(){
		ResponseEntity<List<Empleados>> response = null;
		
		try {
			response = new ResponseEntity<>( empleadosFacade.listarTodosLosEmpleados(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	@GetMapping("/listarTodoConPaginacion")
	public ResponseEntity<List<Empleados>> listarTodoConPaginacion(@RequestParam(value="pageNo",defaultValue="0",required=false) int pageNo,
			                                  @RequestParam(value="cantidadRegistro", defaultValue="10", required=false) int cantidadRegistro,
			                                  @RequestParam(value="idEmpleado",defaultValue ="idEmpleado",required=false) String idEmpleado	,
			                                  @RequestParam(value="sortDir", defaultValue="asc", required=false) String sortDir ){
		ResponseEntity<List<Empleados>> response = null;
		
		try {
			response = new ResponseEntity<>( empleadosFacade.listarEmpleadosPorPaginacion(pageNo, cantidadRegistro, idEmpleado, sortDir), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	
	
	@GetMapping("/buscarPorCodigoEmpleados/")
	public ResponseEntity<List<Empleados>> buscarPorCodigoEmpleados(@RequestParam(value="codigoEmpleado") String codigoEmpleado ) throws Exception{
		
		ResponseEntity<List<Empleados>> response = null;
		 
		
		try {
			//response = new ResponseEntity<>( productoFacade.listarPorCodigoProductos(codigoProducto), HttpStatus.OK);
			List<Empleados> listaProductos = empleadosFacade.buscarPorCodigoEmpleados(codigoEmpleado);
			
			if(listaProductos.isEmpty()) { 
				 //response = restResponse.createCustomizedResponse(null, 404,"404", "DATOS no ENCONTRADOS" );   
				//throw new CustomException("404","Datos no encontrados");
				response = new ResponseEntity<>( HttpStatus.NOT_FOUND);

			}else {
				response = restResponse.createCustomizedResponse(listaProductos, 200,"200", "DATOS  ENCONTRADOS" ); 
			}
			 
		}
		catch(HttpStatusCodeException e) {
			e.getMessage().toString();
			response = restResponse.createCustomizedResponse(null,e.getRawStatusCode() ,"500", "DATOS no ENCONTRADOS" );
		} catch (ResourceNotFoundException c) {
			throw c;
		}
		return response; 
	}
	
	
	
	
	
	@GetMapping("/buscarEmpleadosPorDuiYNit/")
	public   ResponseEntity<List<Empleados>>  buscarEmpleadosPorDuiYNit(@RequestParam(value="dui") String dui,
			                                                      @RequestParam(value="nit") String nit){
		ResponseEntity<List<Empleados>>  response = null;
		
		try {
			response = new ResponseEntity<>( empleadosFacade.buscarEmpleadosPorDuiYNit(dui,nit), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/guardarEmpleados")
	public ResponseEntity<Response> guardarEmpleados(@RequestBody Empleados empleados){
		ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( empleadosFacade.guardarEmpleados(empleados), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editarEmpleados")
	public ResponseEntity<Response> editarEmpleados(@RequestBody Empleados empleados){
		ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( empleadosFacade.editarEmpleados(empleados), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminar/{codigoEmpleado}")
	public ResponseEntity<Response> eliminarEmpleados(@PathVariable String codigoEmpleado){
         ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( empleadosFacade.eliminarEmpleados(codigoEmpleado), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
		
	}
	
	

}
