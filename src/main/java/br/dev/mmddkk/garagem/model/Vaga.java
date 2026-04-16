package br.dev.mmddkk.garagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Vaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_vaga")
    private Long idVaga;

    @NotEmpty
    @Column(name = "placa", length = 10, nullable = false)
    private String placa;

    @NotEmpty
    @Column(name = "veiculo", length = 60)
    private String veiculo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data")
    private LocalDate data;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "hora_entrada")
    private LocalTime hentrada;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "hora_saida")
    private LocalTime hsaida;

    @NumberFormat(pattern = "#,##0.00")
    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    public Long getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Long idVaga) {
        this.idVaga = idVaga;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHentrada() {
        return hentrada;
    }

    public void setHentrada(LocalTime hentrada) {
        this.hentrada = hentrada;
    }

    public LocalTime getHsaida() {
        return hsaida;
    }

    public void setHsaida(LocalTime hsaida) {
        this.hsaida = hsaida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
