package com.enigma.wms_api.service;

import com.enigma.wms_api.dto.request.ProductSearchDTO;
import com.enigma.wms_api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Page<Product> getProductPerPage(Pageable pageable, ProductSearchDTO productSearchDTO);
    List<Product> getAllProductsByBranchId(String branchId);
    Product getById(String id);
    Product update(String id, Product product);
    void delete(String id);
}
