package escobar.testepratico.repository;

import escobar.testepratico.model.EnderecoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Definição de uma interface que extende a clase CRUDRepository para realizar operações básicas de banco de dados.
 */
@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoModel, Long> {
}
