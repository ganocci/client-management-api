package com.joao.apirestjgm.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = Endereco.TABLE_NAME)
public class Endereco {

    public static final String TABLE_NAME = "endereco";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", unique = true)
    private Long id;

    @Column(name = "cep", length = 8, nullable = false)
    @NotBlank
    @Size(max = 8)
    private String cep;

    @Column(name = "logradouro", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String logradouro;

    @Column(name = "complemento", length = 100)
    @Size(max = 100)
    private String complemento;

    @Column(name = "bairro", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String bairro;

    @Column(name = "localidade", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String localidade;

    @Column(name = "uf", length = 2, nullable = false)
    @NotBlank
    @Size(max = 2)
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        return Objects.equals(id, endereco.id) &&
                Objects.equals(cep, endereco.cep) &&
                Objects.equals(logradouro, endereco.logradouro) &&
                Objects.equals(complemento, endereco.complemento) &&
                Objects.equals(bairro, endereco.bairro) &&
                Objects.equals(localidade, endereco.localidade) &&
                Objects.equals(uf, endereco.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, logradouro, complemento, bairro, localidade, uf);
    }
}
