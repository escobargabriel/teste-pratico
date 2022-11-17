package escobar.testepratico.controller;

import com.google.gson.Gson;
import escobar.testepratico.model.UsuarioModel;
import escobar.testepratico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioController() {
    }


    @GetMapping(path = "/usuario/codigo/{codigo}")
    public ResponseEntity consultarPorId(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping(path = "/usuario/email/{email}")
    public ResponseEntity<Object> consultarPorEmail(@PathVariable("email") String email) {
        return repository.findByEmail(email).
                map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path = "/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }


}
