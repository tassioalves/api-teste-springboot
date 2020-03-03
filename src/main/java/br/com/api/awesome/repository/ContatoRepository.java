package br.com.api.awesome.repository;

import br.com.api.awesome.Entity.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
}
