package br.dev.mmddkk.garagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

@Entity
public class Vaga implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long codigo;

    @NotEmpty
    private String placa;

    @NotEmpty
    private String veiculo;

    @NotEmpty
    private String data;

    @NotEmpty
    private String hentrada;

    @NotEmpty
    private String hsaida;

    @NotEmpty
    private String valor;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE)
    private List<Cliente> cliente;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public @NotEmpty String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotEmpty String placa) {
        this.placa = placa;
    }

    public @NotEmpty String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(@NotEmpty String veiculo) {
        this.veiculo = veiculo;
    }

    public @NotEmpty String getData() {
        return data;
    }

    public void setData(@NotEmpty String data) {
        this.data = data;
    }

    public @NotEmpty String getHentrada() {
        return hentrada;
    }

    public void setHentrada(@NotEmpty String hentrada) {
        this.hentrada = hentrada;
    }

    public @NotEmpty String getHsaida() {
        return hsaida;
    }

    public void setHsaida(@NotEmpty String hsaida) {
        this.hsaida = hsaida;
    }

    public @NotEmpty String getValor() {
        return valor;
    }

    public void setValor(@NotEmpty String valor) {
        this.valor = valor;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }
}
