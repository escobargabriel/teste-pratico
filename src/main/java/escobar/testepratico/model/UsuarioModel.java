package escobar.testepratico.model;

import javax.persistence.*;

@Entity(name = "usuario")
public class UsuarioModel {

    @Id
    @Column(nullable = false, length = 50)
    public String email;
    @Column(nullable = false, length = 50)
    public String logradouro;
    @Column(nullable = false, length = 30)
    public String complemento;
    @Column(nullable = false, length = 50)
    public String bairro;
    @Column(nullable = false, length = 50)
    public String localidade;
    @Column(nullable = false, length = 50)
    public String uf;
    @Column(nullable = false, length = 8)
    public String cep;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "{" +
                "Logradouro='" + logradouro + '\'' +
                ", Numero=" + complemento +
                ", Bairro='" + bairro + '\'' +
                ", Cidade='" + localidade + '\''+
                ", Estado='" + uf + '\'' +
                ", Cep='" + cep + '\'' +
                '}';
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
