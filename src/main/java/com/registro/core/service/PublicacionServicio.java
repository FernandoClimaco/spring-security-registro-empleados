package com.registro.core.service;

import java.util.List;

import com.registro.dto.PublicacionDTO;
import com.registro.dto.PublicacionRespuesta;

 

public interface PublicacionServicio {
	
	public PublicacionDTO crearPublicacion(PublicacionDTO  publicacionDTO);
	public  PublicacionRespuesta  obtenerTodasLasPublicaciones(int  numeroDePagina, int medidaDePagina,String ordenarPor,String sortDir);
	public List<PublicacionDTO> obtenerTodasLasPublicaciones();
	public List<PublicacionDTO> obtenerTodasLasPublicacion(int  numeroDePagina, int medidaDePagina);
	public PublicacionDTO obtenerPublicacionPorId(Integer id);
	public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, Integer id);
	public void eliminarPublicacion(Integer id);

}
