package escobar.testepratico.controller;

import com.google.gson.Gson;
import escobar.testepratico.model.UsuarioModel;
import escobar.testepratico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/usuario/codigo/{codigo}")
    public ResponseEntity consultarPorId(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/usuario/email/{email}")
    public ResponseEntity<Object> consultarPorEmail(@PathVariable("email") String email){
        return repository.findByEmail(email).
                map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/usuario/salvar/{email}")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario, @PathVariable("email") String email) throws Exception {

        URL url = new URL("https://viacep.com.br/ws/"+ usuario.getCep() +"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        String cepAux = "";
        StringBuilder jsonCep = new StringBuilder();

        while((cepAux = bufferedReader.readLine()) != null){
            jsonCep.append(cepAux);
        }

        UsuarioModel userAux = new Gson().fromJson(jsonCep.toString(), UsuarioModel.class);
        System.out.println(userAux.toString());
        usuario.setEmail(email);
        usuario.setLogradouro(userAux.getLogradouro());
        usuario.setComplemento(userAux.getComplemento());
        usuario.setBairro(userAux.getBairro());
        usuario.setLocalidade(userAux.getLocalidade());
        usuario.setUf(userAux.getUf());
        return repository.save(usuario);
    }

    @GetMapping(path = "/usuario/cep/{cep}")
    public StringBuilder buscarCep(@PathVariable("cep") String cep) throws Exception{
        UsuarioModel usuario = new UsuarioModel();
        usuario.setCep(cep);
        URL url = new URL("https://viacep.com.br/ws/"+ usuario.getCep() +"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String ccep = "";
        StringBuilder jsonCep = new StringBuilder();

        while((ccep = bufferedReader.readLine()) != null){
            jsonCep.append(ccep);
        }
        return jsonCep;
    }
}
