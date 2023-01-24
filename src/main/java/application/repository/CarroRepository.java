package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import application.dto.GetAllCarroDto;
import application.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	@Query("SELECT new application.dto.GetAllCarroDto(c.timestampCadastro, c.combustivel, c.ano, c.num_portas,"
			+ " c.cor, p.modeloId, p.nome, p.valor_fipe, a.marcaId, a.nome_marca) FROM Carro c JOIN c.modelo p JOIN p.marca a")
    public List<GetAllCarroDto> getJoinInformation();
	
}
