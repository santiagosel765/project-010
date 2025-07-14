package com.ferrisys.service.business;

import com.ferrisys.common.dto.PurchaseDTO;

import java.util.List;

public interface PurchaseService {
    void saveOrUpdate(PurchaseDTO dto);
    void disable(Integer id);
    List<PurchaseDTO> list();
}
