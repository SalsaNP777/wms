package com.enigma.wms_api.service.impl;

import com.enigma.wms_api.dto.request.ProductSearchDTO;
import com.enigma.wms_api.entity.Product;
import com.enigma.wms_api.repository.ProductRepository;
import com.enigma.wms_api.service.ProductService;
import com.enigma.wms_api.utils.specifications.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getProductPerPage(Pageable pageable, ProductSearchDTO productSearchDTO) {
        Specification<Product> specification = ProductSpecification.getSpecification(productSearchDTO);
        return productRepository.findAll(specification, pageable);
    }

    @Override
    public List<Product> getAllProductsByBranchId(String branchId) {
        return productRepository.findByBranchId_Id(branchId);
    }

    @Override
    public Product getById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) return optionalProduct.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    }

    @Override
    public Product update(String id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        existingProduct.setProductCode(product.getProductCode());
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());

        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
