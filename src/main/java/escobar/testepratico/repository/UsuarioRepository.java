package escobar.testepratico.repository;

import escobar.testepratico.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Definição de uma interface que extende a clase CRUDRepository para realizar operações básicas de banco de dados.
 */
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    Optional<Object> findByEmail(String email);
}
