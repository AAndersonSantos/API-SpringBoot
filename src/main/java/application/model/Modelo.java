package application.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name="modelo")
public class Modelo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long modeloId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo" )
	@JsonBackReference
    private List<Carro> carro;
	
	@Size (min = 2, message = "{campo.sizeMin.modelo}")
	@Size(max = 20, message = "{campo.sizeMax.modelo}")
	@NotBlank(message = "{campo.nome.modelo}")
	private String nome;
	
	private Double valor_fipe;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	public Marca marca;
	
}
