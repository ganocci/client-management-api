package com.joao.apirestjgm.services.impl;

import com.joao.apirestjgm.mappers.ClienteMapper;
import com.joao.apirestjgm.models.Cliente;
import com.joao.apirestjgm.models.Endereco;
import com.joao.apirestjgm.models.dtos.ClienteDTO;
import com.joao.apirestjgm.repositories.ClienteRepository;
import com.joao.apirestjgm.repositories.EnderecoRepository;
import com.joao.apirestjgm.services.ClienteService;
import com.joao.apirestjgm.validators.CPFValidator;
import com.joao.apirestjgm.validators.EmailValidator;
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
    private final CPFValidator cpfValidator;
    private final EmailValidator emailValidator;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              EnderecoRepository enderecoRepository,
                              ClienteMapper clienteMapper,
                              CPFValidator cpfValidator,
                              EmailValidator emailValidator) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.clienteMapper = clienteMapper;
        this.cpfValidator = cpfValidator;
        this.emailValidator = emailValidator;
    }


    @Override
    @Transactional
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {

        if (!cpfValidator.isValid(clienteDTO.getCpf())) {
            throw new IllegalArgumentException("CPF inválido");
        }


        if (!emailValidator.isValid(clienteDTO.getEmail())) {
            throw new IllegalArgumentException("Email inválido");
        }

        /*
        // Verifica se o CPF já existe
        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            throw new IllegalArgumentException("CPF já está em uso");
        }*/


        Cliente cliente = clienteMapper.toEntity(clienteDTO);
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

