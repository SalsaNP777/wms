package com.enigma.wms_api.service;

import com.enigma.wms_api.dto.request.BranchSearchDTO;
import com.enigma.wms_api.dto.request.branch.BranchCreateRequest;
import com.enigma.wms_api.dto.response.BranchResponse;
import com.enigma.wms_api.dto.response.ControllerResponse;
import com.enigma.wms_api.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BranchService {
    Branch createBranch(Branch branch);
    Page<Branch> getBranchPerPage(Pageable pageable, BranchSearchDTO branchSearchDTO);
    List<Branch> getAllBranch(Branch branch);
    Branch getById(String id);
    Branch update(String id, Branch branch);
    void delete(String id);

    ControllerResponse<?> createBranchWithDto(BranchCreateRequest request);
}
