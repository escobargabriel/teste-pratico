package escobar.testepratico.repository;

import escobar.testepratico.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {

    Optional<Object> findByEmail(String email);
}
