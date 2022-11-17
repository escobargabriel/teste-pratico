package escobar.testepratico.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Classe responsável por definir o modelo de endereço do usuário.
 */
@Entity
public class EnderecoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_usuario", foreignKey = @ForeignKey(name = "fk_endereco_usuario"))
    @JsonBackReference
    private UsuarioModel usuario;

    @Column(nullable = false, length = 50)
    private String logradouro;
    @Column(nullable = false, length = 30)
    private String complemento;
    @Column(nullable = false, length = 50)
    private String bairro;
    @Column(nullable = false, length = 50)
    private String localidade;
    @Column(nullable = false, length = 50)
    private String uf;
    @Column(nullable = false, length = 8)
    private String cep;

    /**
     * Método do construtor da classe com os atributos.
     * @param usuario UsuarioModel - Classe que representa os usuários.
     * @param idEndereco Long - Identificador do endereço.
     * @param logradouro String - Nome da rua referente ao endereço.
     * @param complemento String - Intervalo de número referentes ao endereço para um determinado CEP.
     * @param bairro String - Bairro no qual o endereço está situado.
     * @param localidade String - Cidade na qual o endereço está situado.
     * @param uf String - Estado no qual o endereço está situado.
     * @param cep String - Código de endereçamento postal do endereço.
     */
    public EnderecoModel(UsuarioModel usuario, Long idEndereco, String logradouro, String complemento, String bairro, String localidade, String uf, String cep) {
        this.usuario = usuario;
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
    }

    /**
     * Método construtor de objetos do tipo Endereço sem parâmetros.
     */
    public EnderecoModel() {

    }

    /**
     * Método utilizado para retornar um objeto do tipo UsuarioModel
     * @return usuario UsuarioModel
     */
    public UsuarioModel getUsuario() {
        return usuario;
    }

    /**
     * Método utilizado para alterar um objeto do tipo UsuarioModel.
     * @param usuario UsuarioModelo - Objeto para representar um usuário.
     */
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    /**
     * Método utilizado para retornar o logradouro da rua do endereço.
     * @return logradoura String - Nome do logradouro no qual o endereço está situado.
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Método utilizado para alterar o valor do logradouro.
     * @param logradouro String - Nome do logradouro no qual o endereço está situado.
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * Método para retornar o complemento do endereço.
     * @return complemento String - Complemento do endereço, faixa de números que abrangem o CEP.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Método para alterar o complemento do endereço.
     * @param complemento String - Complemento do endereço, faixa de números que abrangem o CEP.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Método para retornar o Bairro do endereço.
     * @return bairro String - Nome do bairro em que o endereço está situado.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Método para alterar o bairro do endereço.
     * @param bairro String - Bairro no qual o endereço está situado.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Método para retornar a Localidade do endereço.
     * @return bairro String - Nome da cidade em que o endereço está situado.
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Método para alterar a localidade do endereço.
     * @return localidade String - Nome da cidade em que o endereço está situado.
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Método para retornar a unidade da federação do endereço.
     * @return bairro String - Nome da unidade da federação em que o endereço está situado.
     */
    public String getUf() {
        return uf;
    }

    /**
     * Método para alterar unidade da federação do endereço.
     * @return bairro String - Nome da unidade da federação em que o endereço está situado.
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Método para retornar o CEP do endereço.
     * @return CEP String - Código do CEP em que o endereço está situado.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Método para alterar o CEP do endereço.
     * @return CEP String - Código do CEP em que o endereço está situado.
     */
    public void setCep(String cep) {
        this.cep = cep;
    }
}
