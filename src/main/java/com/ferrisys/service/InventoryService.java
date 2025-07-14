package com.ferrisys.service;

import com.ferrisys.common.dto.CategoryDTO;
import com.ferrisys.common.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface InventoryService {
    void saveOrUpdateCategory(CategoryDTO dto);
    void saveOrUpdateProduct(ProductDTO dto);
    void disableCategory(UUID id);
    void disableProduct(UUID id);
    List<CategoryDTO> listCategories();
    List<ProductDTO> listProducts();
}
