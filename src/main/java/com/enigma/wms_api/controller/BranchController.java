package com.enigma.wms_api.controller;

import com.enigma.wms_api.dto.request.BranchSearchDTO;
import com.enigma.wms_api.dto.request.branch.BranchCreateRequest;
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

import java.util.Optional;

@RestController
@RequestMapping(ApiUrlConstant.BRANCH)
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<?> createBranch(Branch branch){
        String message = ConstantMessage.getMessage("Branch");

        Branch branch1 = branchService.createBranch(branch);
        ControllerResponse<Branch> response =ControllerResponse.<Branch>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message(message)
                .data(branch1)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

//    get all branch and get branch with filter using DTO
    @GetMapping
    public ResponseEntity<?> getBranchPerPage(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "5") Integer size,
            @RequestParam(name = "sort-by", defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(name = "branch_code", required = false) String branchCode,
            @RequestParam(name = "branch_name", required = false) String branchName,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "phone_number", required = false) String phoneNumber
    ){
        BranchSearchDTO branchSearchDTO = new BranchSearchDTO(branchCode, branchName, address, phoneNumber);
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Branch> resultPage = branchService.getBranchPerPage(pageable, branchSearchDTO);
        PageResponseWrapper<Branch> branchPageResponseWrapper =new PageResponseWrapper<>(resultPage);

        return ResponseEntity.status(HttpStatus.OK).body(branchPageResponseWrapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable String id){
        Optional<Branch> branch = Optional.ofNullable(branchService.getById(id));
        return ResponseEntity.status(HttpStatus.OK).body(branch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBranch(@PathVariable String id, Branch branch){
        Branch update = branchService.update(id, branch);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable String id){
        branchService.delete(id);
    }

    @PostMapping("/dto")
    public ResponseEntity<?> createBranchWithDto(BranchCreateRequest request){
        ControllerResponse<?> response = branchService.createBranchWithDto(request);

        ResponseEntity result = ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

        return  result;
    }
}
