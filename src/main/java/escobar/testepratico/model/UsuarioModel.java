package escobar.testepratico.model;

import javax.persistence.*;

@Entity(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer codigo;
   // @Column(nullable = false, length = 50)
   // public String email;
    @Column(nullable = false, length = 50)
    public String logradouro;
    @Column(nullable = false, length = 5)
    public Integer numero;
    @Column(nullable = false, length = 50)
    public String bairro;
    @Column(nullable = false, length = 50)
    public String cidade;
    @Column(nullable = false, length = 50)
    public String uf;
    @Column(nullable = false, length = 8)
    public String cep;

//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String estado) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
