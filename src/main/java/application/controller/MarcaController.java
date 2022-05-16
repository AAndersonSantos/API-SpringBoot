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

import application.model.Marca;
import application.service.MarcaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/marca")
public class MarcaController {
	
	@Autowired
	MarcaService marcaService;
	
	@PostMapping("/created")
	@ResponseStatus(HttpStatus.CREATED)
    public Marca createMarca(@RequestBody @Valid Marca marca) {
        return marcaService.saveMarca(marca);
    }
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	 public List<Marca> getAllMarcas(){
		return marcaService.getMarcas();
	}
	
	@GetMapping("/{id}")
	public Optional<Marca> getAMarcasById(@PathVariable Long id) {
		return marcaService.getMarcaById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Marca> marcaUpdate(@PathVariable Long id, @RequestBody @Valid Marca marca) {
		Marca marcaObj = marcaService.updateMarca(id, marca);
		return ResponseEntity.ok().body(marcaObj);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMarca(@PathVariable Long id) {
		marcaService.deleteMarcaById(id);
		String response = "Deletado com sucesso!";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
