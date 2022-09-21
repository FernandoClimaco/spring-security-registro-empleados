package com.registro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.entity.Publicacion; 


@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion,Integer> {

}
