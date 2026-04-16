package br.dev.mmddkk.garagem.respository;

import br.dev.mmddkk.garagem.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByPlaca(String placa);
}
