package escobar.testepratico.controller;

import escobar.testepratico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Classe utilizada para realizar operação referentes ao usuário.
 */
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    /**
     * Método para buscar usuário pelo endereço de e-mail.
     * @param email String - endereço de e-mail do usuário.
     * @return usuario UsuarioModel - Retorna o objeto referente ao e-mail ou ocorre falha
     * caso o e-mail não esteja cadastrado no banco.
     */
    @GetMapping(path = "/usuario/email/{email}")
    public ResponseEntity<Object> consultarPorEmail(@PathVariable("email") String email){
        return repository.findByEmail(email).
                map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
