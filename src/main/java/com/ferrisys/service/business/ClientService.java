package com.ferrisys.service.business;

import com.ferrisys.common.dto.ClientDTO;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    void saveOrUpdate(ClientDTO dto);
    void disable(UUID id);
    List<ClientDTO> list();
}
