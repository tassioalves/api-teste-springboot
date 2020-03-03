package br.com.api.awesome.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "US_ID")
    private Long id;
    @Column(name = "US_NOME")
    private String nome;
    @Column(name = "US_EMAIL")
    private String email;
    @Column(name = "US_SENHA")
    private String senha;


    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return senha;
    }

    public void setPassword(String password) {
        this.senha = password;
    }

    public String getNome() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }
}
