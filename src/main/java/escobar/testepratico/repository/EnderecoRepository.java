package escobar.testepratico.repository;

import escobar.testepratico.model.EnderecoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Definição de uma interface que extende a clase CRUDRepository para realizar operações básicas de banco de dados.
 */
@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoModel, Long> {
    Optional<Object> findByEmail(String email);
}
