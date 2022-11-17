package escobar.testepratico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe para verificar o status da aplicação.
 */
@RestController
public class StatusController {

    /**
     * Método para verificar se a aplicação está disponível.
     * @return String status;
     */
    @GetMapping(path = "/status")
    public String check(){
        return "online";
    }
}
