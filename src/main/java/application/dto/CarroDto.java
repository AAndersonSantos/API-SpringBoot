package application.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import application.model.Modelo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarroDto{

	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime timestampCadastro;
	
	@Min(value=1965, message = "{campo.min.carro}")
	@Max(value=2050, message = "{campo.max.carro}")
	@NotNull(message = "{campo.ano.carro}")
	private Integer ano;
	
	public Modelo modelo;
	
	@NotBlank(message = "{campo.combustivel.carro}")
	private String combustivel;
	
	@NotNull(message = "{campo.numeroDePortas.carro}")
	private Integer num_portas;
	
	@NotBlank(message = "{campo.cor.carro}")
	private String cor;
	
	public CarroDto(LocalDateTime timestampCadastro, Integer ano, Modelo modelo, String combustivel, Integer num_portas,
			String cor) {
		super();
		this.timestampCadastro = timestampCadastro;
		this.ano = ano;
		this.modelo = modelo;
		this.combustivel = combustivel;
		this.num_portas = num_portas;
		this.cor = cor;
	}
	
	public CarroDto() {}
	
}
