package application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetAllCarroDto {
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime timestampCadastro;
	
	private String combustivel;
	
	private Integer ano;
	
	private Integer num_portas;
	
	private String cor;
	
	private Long modeloId;
	
	private String nome;
	
	private BigDecimal valor_fipe;
	
	private Long marcaId;
	
	private String nome_marca;
	
}
