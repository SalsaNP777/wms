package com.enigma.wms_api.utils.specifications;

import com.enigma.wms_api.dto.request.BranchSearchDTO;
import com.enigma.wms_api.entity.Branch;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BranchSpecification {
    public static Specification<Branch> getSpecification(BranchSearchDTO branchSearchDTO){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (branchSearchDTO.getBranchCode()!=null){
                predicates.add(criteriaBuilder.like(root.get("branch_code"), "%"+branchSearchDTO.getBranchCode()+"%"));
            }
            if (branchSearchDTO.getBranchName()!=null){
                predicates.add(criteriaBuilder.like(root.get("branch_name"), "%"+branchSearchDTO.getBranchName()+"%"));
            }
            if (branchSearchDTO.getAddress()!=null){
                predicates.add(criteriaBuilder.like(root.get("branch_code"), "%"+branchSearchDTO.getAddress()+"%"));
            }
            if (branchSearchDTO.getPhoneNumber()!=null){
                predicates.add(criteriaBuilder.like(root.get("phone_number"), "%"+branchSearchDTO.getPhoneNumber()+"%"));
            }

            jakarta.persistence.criteria.Predicate[] predicates1 = predicates.toArray(new jakarta.persistence.criteria.Predicate[predicates.size()]);
            return criteriaBuilder.and(predicates1);
        });
    }
}
