package application.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="carro")
public class Carro{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "modelo_id")
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
