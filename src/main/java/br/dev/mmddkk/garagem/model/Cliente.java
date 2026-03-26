package br.dev.mmddkk.garagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String rg;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String celular;

    @ManyToOne
    private Vaga vaga;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public @NotEmpty String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty String nome) {
        this.nome = nome;
    }

    public @NotEmpty String getCelular() {
        return celular;
    }

    public void setCelular(@NotEmpty String celular) {
        this.celular = celular;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}
