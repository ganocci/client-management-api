package com.joao.apirestjgm.services;

import com.joao.apirestjgm.models.dtos.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO criarCliente(ClienteDTO clienteDTO);
    ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO);
    ClienteDTO buscarClientePorId(Long id);
    List<ClienteDTO> listarClientes();
    void deletarCliente(Long id);
}


