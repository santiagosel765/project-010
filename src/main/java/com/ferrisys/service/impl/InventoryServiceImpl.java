package com.ferrisys.service.impl;

import com.ferrisys.common.dto.CategoryDTO;
import com.ferrisys.common.dto.ProductDTO;
import com.ferrisys.common.entity.inventory.Category;
import com.ferrisys.common.entity.inventory.Product;
import com.ferrisys.repository.CategoryRepository;
import com.ferrisys.repository.ProductRepository;
import com.ferrisys.service.InventoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void saveOrUpdateCategory(CategoryDTO dto) {
        Category category = dto.getId() != null
                ? categoryRepository.findById(dto.getId()).orElse(new Category())
                : new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setStatus(dto.getStatus() != null ? dto.getStatus() : 1);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void saveOrUpdateProduct(ProductDTO dto) {
        Product product = dto.getId() != null
                ? productRepository.findById(dto.getId()).orElse(new Product())
                : new Product();
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(category);
        product.setStatus(dto.getStatus() != null ? dto.getStatus() : 1);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void disableCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        category.setStatus(0);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void disableProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        product.setStatus(0);
        productRepository.save(product);
    }

    @Override
    public List<CategoryDTO> listCategories() {
        return categoryRepository.findAll().stream()
                .map(c -> new CategoryDTO(c.getId(), c.getName(), c.getDescription(), c.getStatus()))
                .toList();
    }

    @Override
    public List<ProductDTO> listProducts() {
        return productRepository.findAll().stream()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getDescription(),
                        p.getCategory().getId(), p.getStatus()))
                .toList();
    }
}
