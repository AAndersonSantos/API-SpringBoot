package application.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeloDto {
	
	private Long modeloId;
	
	@Size(min = 2, message = "{campo.min.modelo}")
	@Size(max = 20, message = "{campo.max.modelo}")
	@NotBlank(message = "{campo.nome.modelo}")
	private String nome;
	
	private BigDecimal valor_fipe;
	
	private Integer marcaId;

}