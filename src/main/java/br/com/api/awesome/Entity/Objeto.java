package br.com.api.awesome.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_OBJECT")
public class Objeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "OB_ID")
    private Long id;

    @Column (name = "OB_DESCRICAO")
    private String descricao;

    @Column (name = "OB_QTDE")
    private int qtde;

    @Column (name = "OB_SITUACAO")
    private String situacao;

    public Objeto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return descricao;
    }

    public void setDescription(String description) {
        this.descricao = description;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getSituation() {
        return situacao;
    }

    public void setSituation(String situation) {
        this.situacao = situation;
    }
}

