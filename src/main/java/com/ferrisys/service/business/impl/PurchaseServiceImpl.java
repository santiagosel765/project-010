package com.ferrisys.service.business.impl;

import com.ferrisys.common.dto.PurchaseDTO;
import com.ferrisys.common.entity.business.Provider;
import com.ferrisys.common.entity.business.Purchase;
import com.ferrisys.repository.ProviderRepository;
import com.ferrisys.repository.PurchaseRepository;
import com.ferrisys.service.business.PurchaseService;
import java.util.UUID;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProviderRepository providerRepository;

    @Override
    @Transactional
    public void saveOrUpdate(PurchaseDTO dto) {
        Purchase purchase = dto.getId() != null
                ? purchaseRepository.findById(dto.getId()).orElse(new Purchase())
                : new Purchase();
        Provider provider = providerRepository.findById(dto.getProviderId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        purchase.setProvider(provider);
        purchase.setDescription(dto.getDescription());
        purchase.setTotal(dto.getTotal());
        purchase.setStatus(dto.getStatus() != null ? dto.getStatus() : 1);
        purchaseRepository.save(purchase);
    }

    @Override
    @Transactional
    public void disable(UUID id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        purchase.setStatus(0);
        purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseDTO> list() {
        return purchaseRepository.findAll().stream()
                .map(p -> PurchaseDTO.builder()
                        .id(p.getId())
                        .providerId(p.getProvider().getId())
                        .description(p.getDescription())
                        .total(p.getTotal())
                        .status(p.getStatus())
                        .build())
                .toList();
    }
}
