package com.registro.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.entity.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
	
	public Optional<Rol> findByNombre(String nombre);

}
