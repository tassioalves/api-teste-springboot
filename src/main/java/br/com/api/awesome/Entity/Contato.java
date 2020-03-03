package br.com.api.awesome.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CONTATO")
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CO_ID")
    private Long id;

    @Column(name = "CO_NOME")
    private String nome;

    @Column(name = "CO_TELEFONE")
    private String telefone;

    @Column(name = "CO_EMAIL")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
