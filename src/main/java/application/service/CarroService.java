package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Carro;
import application.repository.CarroRepository;

@Service
public class CarroService{

	@Autowired
	CarroRepository carroRepository;
	
	public Carro saveCarro(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public List<Carro> getAllCarros() {
		return carroRepository.findAll();
	}
	
	public Carro getCarroById(long id) {
		 Optional<Carro> carro = carroRepository.findById(id);
		 if(carro.isPresent()) {
			 return carro.get();
		 }else {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado");
		 }
			
	}
	
	public Carro updateCarro(long id, Carro carroRequest) {
		Carro carro = carroRepository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));
		
		//carro.setModelo(carroRequest.getModelo());
		carro.setAno(carroRequest.getAno());
		carro.setCombustivel(carroRequest.getCombustivel());
		carro.setNum_portas(carroRequest.getNum_portas());
		carro.setCor(carroRequest.getCor());
		return carroRepository.save(carro);
	}
	
	public void deleteCarroById(Long id) {
		 Carro carro = carroRepository
				 .findById(id)
				 .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));
		 carroRepository.delete(carro);
	}
		
}
