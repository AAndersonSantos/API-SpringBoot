package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Marca;
import application.repository.MarcaRepository;

@Service
public class MarcaService {
	
	 @Autowired
	 private MarcaRepository marcaRepository;
	
	 public Marca saveMarca(Marca marca) {
	        return marcaRepository.save(marca);
	    }
	 
	 public List<Marca> getMarcas(){
		 return marcaRepository.findAll();
	 }
	 
	 public Optional<Marca> getMarcaById(Long id) {
		 return marcaRepository.findById(id); 
	 }
	 
	 public void deleteMarcaById(Long id) {
		 marcaRepository.deleteById(id);
	 }
	 
	public Marca updateMarca(Long id, Marca marcaUpdate) {
		Marca marca = marcaRepository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrado"));
		
		marca.setNome_marca(marcaUpdate.getNome_marca());
		return marcaRepository.save(marca);
	}

}
