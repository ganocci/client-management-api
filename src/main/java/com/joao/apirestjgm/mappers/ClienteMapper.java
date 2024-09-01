package com.joao.apirestjgm.mappers;

import com.joao.apirestjgm.models.*;
import com.joao.apirestjgm.models.dtos.ClienteDTO;
import com.joao.apirestjgm.models.dtos.EnderecoDTO;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setSobrenome(cliente.getSobrenome());
        dto.setIdade(cliente.getIdade());
        dto.setCpf(cliente.getCpf());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        if (cliente.getEndereco() != null) {
            EnderecoDTO enderecoDTO = new EnderecoDTO();
            enderecoDTO.setId(cliente.getEndereco().getId());
            enderecoDTO.setCep(cliente.getEndereco().getCep());
            enderecoDTO.setLogradouro(cliente.getEndereco().getLogradouro());
            enderecoDTO.setComplemento(cliente.getEndereco().getComplemento());
            enderecoDTO.setBairro(cliente.getEndereco().getBairro());
            enderecoDTO.setLocalidade(cliente.getEndereco().getLocalidade());
            enderecoDTO.setUf(cliente.getEndereco().getUf());
            dto.setEndereco(enderecoDTO);
        }

        return dto;
    }

    public Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setSobrenome(dto.getSobrenome());
        cliente.setIdade(dto.getIdade());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        if (dto.getEndereco() != null) {
            Endereco endereco = new Endereco();
            endereco.setId(dto.getEndereco().getId());
            endereco.setCep(dto.getEndereco().getCep());
            endereco.setLogradouro(dto.getEndereco().getLogradouro());
            endereco.setComplemento(dto.getEndereco().getComplemento());
            endereco.setBairro(dto.getEndereco().getBairro());
            endereco.setLocalidade(dto.getEndereco().getLocalidade());
            endereco.setUf(dto.getEndereco().getUf());
            cliente.setEndereco(endereco);
        }

        return cliente;
    }
}

