package com.joao.apirestjgm.services.impl;

import com.joao.apirestjgm.mappers.ClienteMapper;
import com.joao.apirestjgm.models.Cliente;
import com.joao.apirestjgm.models.Endereco;
import com.joao.apirestjgm.models.dtos.ClienteDTO;
import com.joao.apirestjgm.repositories.ClienteRepository;
import com.joao.apirestjgm.repositories.EnderecoRepository;
import com.joao.apirestjgm.services.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              EnderecoRepository enderecoRepository,
                              ClienteMapper clienteMapper){
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.clienteMapper = clienteMapper;
    }


    @Override
    @Transactional
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {

        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado.");
        }

        Endereco endereco = new Endereco();
        endereco.setCep(clienteDTO.getEndereco().getCep());
        endereco.setLogradouro(clienteDTO.getEndereco().getLogradouro());
        endereco.setComplemento(clienteDTO.getEndereco().getComplemento());
        endereco.setBairro(clienteDTO.getEndereco().getBairro());
        endereco.setLocalidade(clienteDTO.getEndereco().getLocalidade());
        endereco.setUf(clienteDTO.getEndereco().getUf());

        endereco = enderecoRepository.save(endereco);

        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.setEndereco(endereco);
        cliente = clienteRepository.save(cliente);

        return clienteMapper.toDTO(cliente);
    }

    @Override
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"));

        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setSobrenome(clienteDTO.getSobrenome());
        clienteExistente.setIdade(clienteDTO.getIdade());
        clienteExistente.setCpf(clienteDTO.getCpf());
        clienteExistente.setTelefone(clienteDTO.getTelefone());
        clienteExistente.setEmail(clienteDTO.getEmail());

        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);

        return clienteMapper.toDTO(clienteAtualizado);
    }

    @Override
    public ClienteDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"));
        return clienteMapper.toDTO(cliente);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }
}

