package com.registro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.entity.Comentario;  


@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer> {
	
	 

}
