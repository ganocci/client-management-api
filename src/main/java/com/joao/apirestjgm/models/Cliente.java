package com.joao.apirestjgm.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {

    public static final String TABLE_NAME = "cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String sobrenome;

    @Column(name = "idade", nullable = false)
    @NotNull
    private Integer idade;

    @Column(name = "cpf", length = 11, nullable = false)
    @NotBlank
    @Size(min = 11,max = 11)
    private String cpf;

    @Column(name = "telefone", length = 11, nullable = false)
    @NotBlank
    @Size(min = 11,max = 11)
    private String telefone;

    @Column(name = "email", nullable = false)
    @NotBlank
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String sobrenome, Integer idade, String cpf, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        // Comparar IDs se ambos não forem nulos
        if (id != null && cliente.id != null && !id.equals(cliente.id)) {
            return false;
        }

        // Comparar os demais campos
        return Objects.equals(id, cliente.id) &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(sobrenome, cliente.sobrenome) &&
                Objects.equals(idade, cliente.idade) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(telefone, cliente.telefone) &&
                Objects.equals(email, cliente.email)&&
                Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, idade, cpf, telefone, email, endereco);
    }
}

