package application.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.model.Modelo;
import application.service.ModeloService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/modelo")
public class ModeloController {
	
	@Autowired
	ModeloService modeloService;
	
	@PostMapping("/created")
	@ResponseStatus(HttpStatus.CREATED)
    	public Modelo createMarca(@RequestBody @Valid Modelo modelo) {
        return modeloService.saveModelo(modelo);
    }
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	 public List<Modelo> getAllModelos(){
		return modeloService.getModelo();
	}
	
	@GetMapping("/{id}")
	public Optional<Modelo> getModeloById(@PathVariable Long id) {
		return modeloService.getModeloById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Modelo> updateModelo(@PathVariable Long id, @RequestBody @Valid Modelo modelo) {
		Modelo modeloObj = modeloService.update(id, modelo);
		return ResponseEntity.ok().body(modeloObj);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteModelo(@PathVariable Long id) {
		modeloService.deleteModeloById(id);
		String response = "Deletado com sucesso!";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
