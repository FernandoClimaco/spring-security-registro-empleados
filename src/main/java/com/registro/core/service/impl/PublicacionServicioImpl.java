package com.registro.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.registro.core.service.PublicacionServicio;
import com.registro.dto.PublicacionDTO;
import com.registro.dto.PublicacionRespuesta;
import com.registro.entity.Comentario;
import com.registro.entity.Publicacion;
import com.registro.repositorio.PublicacionRepositorio;
import com.registro.util.excepciones.ResourceNotFoundException;  

@Service
public class PublicacionServicioImpl implements PublicacionServicio {
	
	 
	
	
	@Autowired
	private PublicacionRepositorio publicacionRepositorio;

	@Override
	public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) { 
		
		 Publicacion publicacion = mapearEntidad(publicacionDTO);
		 
		 Publicacion  nuevaPublicacion = publicacionRepositorio.save(publicacion);
		 
		 PublicacionDTO publicacionRespuesta  = mapearDTO(nuevaPublicacion);
		 
		 return publicacionRespuesta;
	}

	
	
	@Override
	public List<PublicacionDTO> obtenerTodasLasPublicaciones() {
		 List<Publicacion> publicaciones =  publicacionRepositorio.findAll();
		 return publicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());
	 
	}
	
	
	
	@Override
	public  PublicacionRespuesta  obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina, String ordenarPor,String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending() : Sort.by(ordenarPor).descending();
		
		Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);
		
		Page<Publicacion> publicaciones = publicacionRepositorio.findAll(pageable);
		
		 List<Publicacion> listaDePublicaciones =  publicaciones.getContent(); 
		 List<PublicacionDTO> contenido = listaDePublicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());
	
		 
		 PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();
		 publicacionRespuesta.setContenido(contenido);
		 publicacionRespuesta.setNumeroPagina(publicaciones.getNumber());
		 publicacionRespuesta.setMedidaPagina(publicaciones.getSize());
		 publicacionRespuesta.setTotalElementos(publicaciones.getTotalElements());
		 publicacionRespuesta.setTotalPaginas(publicaciones.getTotalPages());
		 publicacionRespuesta.setUltima(publicaciones.isLast());
		 
		 return publicacionRespuesta;
	}
	
	
	
	
	@Override
	public List<PublicacionDTO> obtenerTodasLasPublicacion(int  numeroDePagina, int medidaDePagina) {
		
		Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
		
		Page<Publicacion> publicaciones = publicacionRepositorio.findAll(pageable);
		
		 List<Publicacion> listaDePublicaciones =  publicaciones.getContent(); 
		 return listaDePublicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());
	 
	}
	
	
	
	
	//Conversion de Entidad a DTO
	private PublicacionDTO mapearDTO(Publicacion publicacion) {
		
		// para estar perdiendo el tiempo en estar seteando ocupo ModelMapper:
		//PublicacionDTO publicacionDTO= modelMapper.map(publicacion, PublicacionDTO.class);
		 
		//Convertimos Entidad a DTO: 
		PublicacionDTO publicacionDTO = new PublicacionDTO();
		publicacionDTO.setId(publicacion.getId());
		publicacionDTO.setTitulo(publicacion.getTitulo());
		publicacionDTO.setDescripcion(publicacion.getDescripcion());
		publicacionDTO.setContenido(publicacion.getContenido());
		
		return publicacionDTO;
	}
	
	
	//Conversion de DTO a Entidad
	private Publicacion mapearEntidad(PublicacionDTO publicacionDTO) {
		
		Publicacion publicacion = new Publicacion();
		Comentario comentario = new Comentario();
		
		try {
			
			//Convertimos DTO a Entidad: 
			
			publicacion.setId(publicacionDTO.getId());
			publicacion.setTitulo(publicacionDTO.getTitulo());
			publicacion.setDescripcion(publicacionDTO.getDescripcion());
			publicacion.setContenido(publicacionDTO.getContenido());
			
			
			comentario.setId(publicacionDTO.getComentarios());
			comentario.setCuerpo("java es java");
			comentario.setEmail("no tengo email");
			comentario.setNombre("programador estrella");
			publicacion.setComentarios( comentario );
			
		}catch(Exception e) {
			System.out.println("capa service transformando mapeo" +e);
		} 
		
		return publicacion;
	}



	@Override
	public PublicacionDTO obtenerPublicacionPorId(Integer id) {
		Publicacion publicacion = publicacionRepositorio.findById(id)
				.orElseThrow(( ) -> new ResourceNotFoundException("Publicacion", "id", id));
				
				return mapearDTO(publicacion);
	}



	@Override
	public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, Integer id) {
		Publicacion publicacion = publicacionRepositorio.findById(id)
				                  .orElseThrow(() -> new ResourceNotFoundException("publicacion","id",id));
				                  
		publicacion.setTitulo(publicacionDTO.getTitulo());      
		publicacion.setDescripcion(publicacionDTO.getDescripcion());
		publicacion.setContenido(publicacionDTO.getContenido());
		
		Publicacion publicacionActualizada = publicacionRepositorio.save(publicacion);
		
		return this.mapearDTO(publicacionActualizada);
	}



	@Override
	public void eliminarPublicacion(Integer id) {
		 Publicacion publicacion = publicacionRepositorio.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("publicacion", "id", id));
				 
		 publicacionRepositorio.delete(publicacion);
		
	}



	
	
	
	

}
