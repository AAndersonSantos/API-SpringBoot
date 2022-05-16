package application.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Data;

//@Table(name="carro")
@Entity
@Data
public class Carro{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "modeloId")
    public Modelo modelo;
	
	private Integer ano;
	
	private String combustivel;
	
	private Integer num_portas;
	
	private String cor;
	
	private LocalDateTime timestampCadastro;
	
	@PrePersist
	public void prePersist() {
		setTimestampCadastro(LocalDateTime.now());
	};

}
