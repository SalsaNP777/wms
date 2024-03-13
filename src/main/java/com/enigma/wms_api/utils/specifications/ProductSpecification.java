package com.enigma.wms_api.utils.specifications;

import com.enigma.wms_api.dto.request.ProductSearchDTO;
import com.enigma.wms_api.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    public static Specification<Product> getSpecification(ProductSearchDTO productSearchDTO){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (productSearchDTO.getProductName() != null) {
                predicates.add(criteriaBuilder.like(root.get("product_name"), "%" + productSearchDTO.getProductName() + "%"));
            }
            if (productSearchDTO.getProductCode() != null) {
                predicates.add(criteriaBuilder.like(root.get("product_code"), "%" + productSearchDTO.getProductCode() + "%"));
            }
            if (productSearchDTO.getPrice() != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), productSearchDTO.getPrice()));
            }

            Predicate[] predicates1 = predicates.toArray(new Predicate[predicates.size()]);
            return criteriaBuilder.and(predicates1);
        });
    }
}