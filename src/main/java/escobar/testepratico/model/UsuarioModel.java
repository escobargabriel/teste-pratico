package escobar.testepratico.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável para representar o usuário e seus atributos.
 */
@Entity(name = "usuario")
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @Column(nullable = false, length = 50)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_usuario", foreignKey = @ForeignKey(name = "fk_endereco_usuario"))
    @JsonBackReference
    private List<EnderecoModel> enderecoModelList = new ArrayList<>();

    /**
     * Método construtor do Modelo de usuário sem parâmetros.
     */
    public UsuarioModel() {

    }

    /**
     * Método para retornar a lista de endereços cadastrados.
     * @return endereçoModelList List - Lista de endereços.
     */
    public List<EnderecoModel> getEnderecoModelList() {
        return enderecoModelList;
    }

    /**
     * Método construtor do modelo de usuário.
     * @param email String -  Endereço de e-mail do usuário.
     * @param enderecoModelList List - Lista de endereços.
     */
    public UsuarioModel(String email, List<EnderecoModel> enderecoModelList) {
        this.email = email;
        this.enderecoModelList = enderecoModelList;
    }

    /**
     * Método para retornar o endereço de e-mail do usuário.
     * @return email String.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Método para alterar o endereço de e-mail do usuário.
     * @return email String - Endereço de e-mail do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
