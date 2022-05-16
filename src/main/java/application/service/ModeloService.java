package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Modelo;
import application.repository.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;
	
	public Modelo saveModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }
	
	public List<Modelo> getModelo(){
		 return modeloRepository.findAll();
	 }
	
	public Optional<Modelo> getModeloById(Long id) {
		 return modeloRepository.findById(id); 
	 }
	
	public void deleteModeloById(Long id) {
		modeloRepository.deleteById(id);
	 }
	
	public Modelo update(Long id, Modelo modelo) {
		return modeloRepository.findById(id)
			.map((updateModelo) -> {
				updateModelo.setNome(modelo.getNome());
				updateModelo.setMarca(modelo.getMarca());
				updateModelo.setValor_fipe(modelo.getValor_fipe());
				return modeloRepository.save(updateModelo);
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrada"));
	}
	
}
