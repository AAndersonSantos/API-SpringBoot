package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long>{

}
