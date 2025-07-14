package com.ferrisys.service.business.impl;

import com.ferrisys.common.dto.ClientDTO;
import com.ferrisys.common.entity.business.Client;
import com.ferrisys.repository.ClientRepository;
import com.ferrisys.service.business.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public void saveOrUpdate(ClientDTO dto) {
        Client client = dto.getId() != null
                ? clientRepository.findById(dto.getId()).orElse(new Client())
                : new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setStatus(dto.getStatus() != null ? dto.getStatus() : 1);
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void disable(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        client.setStatus(0);
        clientRepository.save(client);
    }

    @Override
    public List<ClientDTO> list() {
        return clientRepository.findAll().stream()
                .map(c -> new ClientDTO(c.getId(), c.getName(), c.getEmail(), c.getStatus()))
                .toList();
    }
}
