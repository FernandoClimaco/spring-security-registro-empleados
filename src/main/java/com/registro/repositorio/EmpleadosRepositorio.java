package com.registro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.entity.Empleados;


@Repository
public interface EmpleadosRepositorio extends JpaRepository<Empleados,Integer> {
	
	@Query("select e from Empleados e where e.codigoEmpleado=?1")
	List<Empleados> buscarPorCodigoEmpleados(String codigoEmpleado);
	
	@Query("select e from Empleados e where e.dui=?1 and e.nit=?2")
	List<Empleados> buscarEmpleadosPorDuiYNit(String dui,String nit);

}
