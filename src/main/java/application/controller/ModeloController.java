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

import application.dto.ModeloDto;
import application.model.Modelo;
import application.service.ModeloService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/modelo")
public class ModeloController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ModeloService modeloService;
	
	@PostMapping("/created")
    public ResponseEntity<ModeloDto> createMarca(@RequestBody @Valid ModeloDto modeloDto) {
        
		Modelo modeloRequest = modelMapper.map(modeloDto, Modelo.class);
		Modelo modelo = modeloService.saveModelo(modeloRequest);
		ModeloDto modeloResponse = modelMapper.map(modelo, ModeloDto.class);
		
		return new ResponseEntity<ModeloDto>(modeloResponse, HttpStatus.CREATED);
    }
	
	@GetMapping("")
	 public List<ModeloDto> getAllModelos(){
		return modeloService.getModelo()
				.stream()
				.map(post -> modelMapper.map(post, ModeloDto.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModeloDto> getModeloById(@PathVariable Long id) {
		Modelo modelo = modeloService.getModeloById(id);
		ModeloDto modeloResponse = modelMapper.map(modelo, ModeloDto.class);
		
		return ResponseEntity.ok().body(modeloResponse);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ModeloDto> updateModelo(@PathVariable Long id, @RequestBody @Valid ModeloDto modeloDto) {
		
		//Convert DTO to entity
		Modelo modeloRequest = modelMapper.map(modeloDto, Modelo.class);
		Modelo modelo = modeloService.updateModelo(id, modeloRequest);

		//Entity to DTO
		ModeloDto modeloResponse = modelMapper.map(modelo, ModeloDto.class);
		return ResponseEntity.ok().body(modeloResponse);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteModelo(@PathVariable Long id) {
		modeloService.deleteModeloById(id);
		String response = "Deletado com sucesso!";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
