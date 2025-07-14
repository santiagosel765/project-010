package com.ferrisys.service.business;

import com.ferrisys.common.dto.PurchaseDTO;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {
    void saveOrUpdate(PurchaseDTO dto);
    void disable(UUID id);
    List<PurchaseDTO> list();
}
