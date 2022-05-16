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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

//@Table(name="tb_modelo")
@Entity
@Data
public class Modelo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long modeloId;
	
	@ManyToOne
	@JoinColumn(name = "marcaId")
	public Marca marca;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo")
	@JsonBackReference
    public List<Carro> carro;
	
	//@Size(min = 2, message = "{campo.min.modelo}")
	//@Size(max = 20, message = "{campo.max.modelo}")
	@NotBlank(message = "{campo.nome.modelo}")
	private String nome;
	
	private Double valor_fipe;
	
}
