package application.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dto.CarroDto;
import application.dto.GetAllCarroDto;
import application.model.Carro;
import application.repository.CarroRepository;
import application.service.CarroService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/carro")
public class CarroController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	CarroRepository carroRepository;
	
	@PostMapping("/created")
	public ResponseEntity<CarroDto> saveCarro(@RequestBody @Valid CarroDto carroDto){
		
		Carro carroRequest = modelMapper.map(carroDto, Carro.class);
		Carro carro = carroService.saveCarro(carroRequest);
		CarroDto carroResponse = modelMapper.map(carro, CarroDto.class);
		
		return new ResponseEntity<CarroDto>(carroResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public List<GetAllCarroDto> getAllCarros(){
		return carroService.getAllCarros()
				.stream()
				.map(post -> modelMapper.map(post, GetAllCarroDto.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarroDto> getCarroById(@PathVariable Long id){
		Carro carro = carroService.getCarroById(id);
		CarroDto carroDto = modelMapper.map(carro, CarroDto.class);
		
		return ResponseEntity.ok().body(carroDto);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CarroDto> updateCarro(@PathVariable long id, @RequestBody @Valid CarroDto carroDto){

		//Convert DTO to entity
		Carro carroRequest = modelMapper.map(carroDto, Carro.class);
		Carro carro = carroService.updateCarro(id, carroRequest);

		//Entity to DTO
		CarroDto carroResponse = modelMapper.map(carro, CarroDto.class);
		return ResponseEntity.ok().body(carroResponse);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMarca(@PathVariable Long id) {
		carroService.deleteCarroById(id);
		String response = "Deletado com sucesso!";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
