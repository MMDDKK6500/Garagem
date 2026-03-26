package br.dev.mmddkk.garagem.respository;

import br.dev.mmddkk.garagem.model.Vaga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VagaRepository extends CrudRepository<Vaga, String> {
    Vaga findByCodigo(long codigo);
    List<Vaga> findByPlaca(String placa);
}
