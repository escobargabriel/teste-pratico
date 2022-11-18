package escobar.testepratico.controller;

import com.google.gson.Gson;
import escobar.testepratico.model.EnderecoModel;
import escobar.testepratico.model.UsuarioModel;
import escobar.testepratico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    /**
     * Método para realizar a busca do endereço utilizando o CEP.
     * @param cep String - Código de endereçamento postal do endereço.
     * @return jsonCEP StringBuilder - objeto para manipular Strings dinamicamente.
     * @throws Exception - Lançamento de exceção em caso de falha.
     */
    @GetMapping(path = "/endereco/cep/{cep}")
    public StringBuilder buscarCep(@PathVariable("cep") String cep) throws Exception{
        EnderecoModel usuario = new EnderecoModel();
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

    /**
     * Método para salvar um endereço no banco de dados.
     * @param endereco EnderecoModel - endereco que será armazenado no banco de dados e retornado para o front-end.
     * @param email String - endereço de e-mail do usuário que será armanzenado no banco de dados.
     * @return enderecoRepository.save(endereco) - Resultado da inserção do endereço no banco de dados.
     * @throws Exception - Lançamento de exceção em caso de falha.
     */
    @PostMapping(path = "/endereco/salvar/{email}")
    public EnderecoModel salvar(@RequestBody EnderecoModel endereco, @PathVariable("email") String email) throws Exception {
        UsuarioModel user = new UsuarioModel();
        user.setEmail(email);
        endereco.setUsuario(user);
        endereco.setEmail(email);


        URL url = new URL("https://viacep.com.br/ws/"+ endereco.getCep() +"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        String cepAux = "";
        StringBuilder jsonCep = new StringBuilder();

        while((cepAux = bufferedReader.readLine()) != null){
            jsonCep.append(cepAux);
        }

        EnderecoModel enderecoModel = new Gson().fromJson(jsonCep.toString(), EnderecoModel.class);
        System.out.println(enderecoModel.toString());
        endereco.setLogradouro(enderecoModel.getLogradouro());
        endereco.setComplemento(enderecoModel.getComplemento());
        endereco.setBairro(enderecoModel.getBairro());
        endereco.setLocalidade(enderecoModel.getLocalidade());
        endereco.setUf(enderecoModel.getUf());
        return enderecoRepository.save(endereco);
    }
    /**
     * Método para buscar endereço pelo endereço de e-mail.
     * @param email String - endereço de e-mail do usuário.
     * @return usuario UsuarioModel - Retorna o objeto referente ao e-mail ou ocorre falha
     * caso o e-mail não esteja cadastrado no banco.
     */
    @GetMapping(path = "/endereco/email/{email}")
    public ResponseEntity<Object> buscarPorEmail(@PathVariable("email") String email) {
        return enderecoRepository.findByEmail(email).
                map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
