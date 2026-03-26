package br.dev.mmddkk.garagem.respository;

import br.dev.mmddkk.garagem.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
