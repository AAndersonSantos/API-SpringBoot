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
	ModeloRepository modeloRepository;

	public Modelo saveModelo(Modelo modelo) {
		return modeloRepository.save(modelo);
	}

	public List<Modelo> getModelo() {
		return modeloRepository.findAll();
	}

	public Modelo getModeloById(Long id) {
		Optional<Modelo> modelo = modeloRepository.findById(id);
		if (modelo.isPresent()) {
			return modelo.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado");
		}
	}

	public Modelo updateModelo(Long id, Modelo modeloRequest) {
		Modelo modelo = modeloRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado"));

		modelo.setNome(modeloRequest.getNome());
		modelo.setMarca(modeloRequest.getMarca());
		modelo.setValor_fipe(modeloRequest.getValor_fipe());
		return modeloRepository.save(modelo);
	}

	public void deleteModeloById(Long id) {
		Modelo modelo = modeloRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado"));
		modeloRepository.delete(modelo);
	}
}
