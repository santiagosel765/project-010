package com.ferrisys.service.business.impl;

import com.ferrisys.common.dto.ProviderDTO;
import com.ferrisys.common.entity.business.Provider;
import com.ferrisys.repository.ProviderRepository;
import com.ferrisys.service.business.ProviderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Override
    @Transactional
    public void saveOrUpdate(ProviderDTO dto) {
        Provider provider = dto.getId() != null
                ? providerRepository.findById(dto.getId()).orElse(new Provider())
                : new Provider();
        provider.setName(dto.getName());
        provider.setContact(dto.getContact());
        provider.setStatus(dto.getStatus() != null ? dto.getStatus() : 1);
        providerRepository.save(provider);
    }

    @Override
    @Transactional
    public void disable(Integer id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        provider.setStatus(0);
        providerRepository.save(provider);
    }

    @Override
    public List<ProviderDTO> list() {
        return providerRepository.findAll().stream()
                .map(p -> new ProviderDTO(p.getId(), p.getName(), p.getContact(), p.getStatus()))
                .toList();
    }
}
