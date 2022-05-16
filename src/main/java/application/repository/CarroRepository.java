package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

}
