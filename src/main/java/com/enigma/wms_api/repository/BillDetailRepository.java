package com.enigma.wms_api.repository;

import com.enigma.wms_api.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillDetailRepository extends JpaRepository<BillDetail, String> {
    List<BillDetail> findByBillDetailId(String Id);
}
