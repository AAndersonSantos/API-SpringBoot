package application.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroDto{

	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime timestampCadastro;
	
	private Integer modeloId;
	
	@Min(value=1965, message = "{campo.min.carro}")
	@Max(value=2050, message = "{campo.max.carro}")
	@NotNull(message = "{campo.ano.carro}")
	private Integer ano;
	
	@NotBlank(message = "{campo.combustivel.carro}")
	private String combustivel;
	
	@NotNull(message = "{campo.numeroDePortas.carro}")
	private Integer num_portas;
	
	@NotBlank(message = "{campo.cor.carro}")
	private String cor;
	
}
