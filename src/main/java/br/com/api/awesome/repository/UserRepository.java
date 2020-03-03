package br.com.api.awesome.repository;

import br.com.api.awesome.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByNomeIgnoreCaseContaining(String nome);

    Usuario findByEmailIgnoreCaseContaining(String email);
}
