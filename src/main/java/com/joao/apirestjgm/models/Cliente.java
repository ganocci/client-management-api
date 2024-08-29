package com.joao.apirestjgm.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {

    public interface CreateCliente {}
    public interface UpdateCliente {}

    public static final String TABLE_NAME = "cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotBlank(groups = {CreateCliente.class, UpdateCliente.class})
    private String nome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    @NotBlank(groups = {CreateCliente.class, UpdateCliente.class})
    private String sobrenome;

    @Column(name = "idade", length = 2, nullable = false)
    @NotBlank(groups = {CreateCliente.class, UpdateCliente.class})
    private String idade;

    @Column(name = "cpf", length = 11, nullable = false)
    @NotBlank(groups = {CreateCliente.class, UpdateCliente.class})
    private String cpf;

    @Column(name = "telefone", length = 11, nullable = false)
    @NotBlank(groups = {CreateCliente.class, UpdateCliente.class})
    private String telefone;

    @Column(name = "email", length = 100, nullable = false)
    @NotBlank(groups = {CreateCliente.class, UpdateCliente.class})
    private String email;

    //private list<Task> tasks = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(Long id, String nome, String sobrenome, String idade, String cpf, String telefone, String email) {
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Cliente cliente)) return false;
        Cliente other = (Cliente) o;
        if (this.id != null)
            if (other.id != null) return false;
            else if (!this.id.equals(other.id)) return false;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(sobrenome, cliente.sobrenome)
                && Objects.equals(idade, cliente.idade) && Objects.equals(cpf, cliente.cpf) && Objects.equals(telefone, cliente.telefone)
                && Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, idade, cpf, telefone, email);
    }
}

