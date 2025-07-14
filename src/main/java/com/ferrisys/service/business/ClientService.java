package com.ferrisys.service.business;

import com.ferrisys.common.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    void saveOrUpdate(ClientDTO dto);
    void disable(Integer id);
    List<ClientDTO> list();
}
