package com.ferrisys.service;

import com.ferrisys.common.dto.CategoryDTO;
import com.ferrisys.common.dto.ProductDTO;

import java.util.List;

public interface InventoryService {
    void saveOrUpdateCategory(CategoryDTO dto);
    void saveOrUpdateProduct(ProductDTO dto);
    void disableCategory(Integer id);
    void disableProduct(Integer id);
    List<CategoryDTO> listCategories();
    List<ProductDTO> listProducts();
}
