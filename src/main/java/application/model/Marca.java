package application.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

//@Table(name="marca")
@Entity
@Data
public class Marca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long marcaId;
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
	@JsonBackReference
	private List<Modelo> modelo;
	
	@NotBlank(message = "{campo.nome.marca}")
	private String nome_marca;

}