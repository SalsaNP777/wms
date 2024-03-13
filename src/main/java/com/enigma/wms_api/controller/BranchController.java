package com.enigma.wms_api.controller;

import com.enigma.wms_api.dto.request.BranchSearchDTO;
import com.enigma.wms_api.dto.request.branch.BranchCreateRequest;
import com.enigma.wms_api.dto.request.branch.BranchUpdateRequest;
import com.enigma.wms_api.dto.response.ControllerResponse;
import com.enigma.wms_api.dto.response.PageResponseWrapper;
import com.enigma.wms_api.entity.Branch;
import com.enigma.wms_api.service.BranchService;
import com.enigma.wms_api.utils.constant.ApiUrlConstant;
import com.enigma.wms_api.utils.constant.ConstantMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiUrlConstant.BRANCH)
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<?> createBranchWithDto(BranchCreateRequest request){
        ControllerResponse<?> response = branchService.createBranchWithDto(request);

        ResponseEntity result = ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

        return  result;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable String id){
        Optional<Branch> branch = Optional.ofNullable(branchService.getById(id));
        return ResponseEntity.status(HttpStatus.OK).body(branch);
    }

    @PutMapping("/dto/update")
    public ResponseEntity<?> updateBranchWithDto(@PathVariable String id, BranchUpdateRequest request){
        ControllerResponse<?> response = branchService.updateBranchWithDto(id, request);

        ResponseEntity result = ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

        return  result;
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable String id){
        branchService.delete(id);
    }

    @GetMapping
    public List<Branch> getAllBranches(Branch branch) {
        return branchService.getAllBranch(branch);
    }
}
