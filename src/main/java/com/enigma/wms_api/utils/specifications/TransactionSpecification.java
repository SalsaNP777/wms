package com.enigma.wms_api.utils.specifications;

import com.enigma.wms_api.dto.request.TransactionSearchDTO;
import com.enigma.wms_api.entity.Transaction;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TransactionSpecification {
    public static Specification<Transaction> getSpecification(TransactionSearchDTO transactionSearchDTO){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (transactionSearchDTO.getBillId() != null){
                predicates.add(criteriaBuilder.like(root.get("bill_id"), "%"+transactionSearchDTO.getBillId()+"%"));
            }
            if (transactionSearchDTO.getReceiptNumber() != null){
                predicates.add(criteriaBuilder.like(root.get("receipt_number"), "%"+transactionSearchDTO.getReceiptNumber()+"%"));
            }
            if (transactionSearchDTO.getTransDate() != null){
                predicates.add(criteriaBuilder.like(root.get("trans_date"), "%"+transactionSearchDTO.getTransDate()+"%"));
            }
            if (transactionSearchDTO.getBillDetails() != null){
                predicates.add(criteriaBuilder.like(root.get("bill_details"), "%"+transactionSearchDTO.getBillDetails()+"%"));
            }

            Predicate[] predicates1 = predicates.toArray(new Predicate[predicates.size()]);
            return criteriaBuilder.and(predicates1);
        });
    }
}
