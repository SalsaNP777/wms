package com.enigma.wms_api.service.impl;

import com.enigma.wms_api.dto.request.BranchSearchDTO;
import com.enigma.wms_api.entity.Branch;
import com.enigma.wms_api.repository.BranchRepository;
import com.enigma.wms_api.service.BranchService;
import com.enigma.wms_api.utils.specifications.BranchSpecification;
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
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    @Override
    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Page<Branch> getBranchPerPage(Pageable pageable, BranchSearchDTO branchSearchDTO) {
        Specification<Branch> specification = BranchSpecification.getSpecification(branchSearchDTO);
        return branchRepository.findAll(specification, pageable);
    }

    @Override
    public List<Branch> getAllBranch(Branch branch) {
        return branchRepository.findAll();
    }

    @Override
    public Branch getById(String id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if (optionalBranch.isPresent()) return optionalBranch.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "branch not found");
    }

    @Override
    public Branch update(String id, Branch branch) {
        Branch existingBranch = branchRepository.findById(id).orElse(null);

        existingBranch.setBranchCode(branch.getBranchCode());
        existingBranch.setBranchName(branch.getBranchName());
        existingBranch.setAddress(branch.getAddress());
        existingBranch.setPhoneNumber(branch.getPhoneNumber());

        branchRepository.save(existingBranch);
        return existingBranch;
    }

    @Override
    public void delete(String id) {
        branchRepository.deleteById(id);
    }
}
