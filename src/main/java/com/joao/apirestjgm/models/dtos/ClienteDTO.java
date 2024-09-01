package com.joao.apirestjgm.models.dtos;


import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteDTO {

    private Long id;

    @Valid

    @NotBlank(message = ("Nome é Obrigatório"))
    @Size(max = 100)
    private String nome;

    @NotBlank(message = ("Sobrenome é Obrigatório"))
    @Size(max = 100)
    private String sobrenome;

    @NotNull(message = ("Idade é Obrigatória"))
    private Integer idade;

    @NotBlank(message = ("CPF é Obrigatório"))
    @Size(min = 11,max = 11)
    @CPF(message = ("CPF inválido"))
    private String cpf;

    @NotBlank(message = ("Telefone é Obrigatório"))
    @Size(min =11,max = 11, message = "Telefone Inválido")
    private String telefone;

    @NotBlank(message = ("E-mail é Obrigatório"))
    @Email(message = ("E-mail inválido"))
    private String email;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoDTO endereco;


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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
