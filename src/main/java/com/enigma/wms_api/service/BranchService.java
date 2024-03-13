package com.enigma.wms_api.service;

import com.enigma.wms_api.dto.request.BranchSearchDTO;
import com.enigma.wms_api.dto.request.branch.BranchCreateRequest;
import com.enigma.wms_api.dto.request.branch.BranchUpdateRequest;
import com.enigma.wms_api.dto.response.BranchResponse;
import com.enigma.wms_api.dto.response.ControllerResponse;
import com.enigma.wms_api.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BranchService {
    ControllerResponse<?> createBranchWithDto(BranchCreateRequest request); //addBranch with valid data
    Branch getById(String id); //get branchById
    ControllerResponse<?> updateBranchWithDto(String id, BranchUpdateRequest request); //updateBranch with valid data
    void delete(String id); //delete branch with valid id
    List<Branch> getAllBranch(Branch branch); //getAllBranch
}
