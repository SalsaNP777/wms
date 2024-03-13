package com.enigma.wms_api.service.impl;

import com.enigma.wms_api.dto.request.branch.BranchCreateRequest;
import com.enigma.wms_api.dto.request.branch.BranchUpdateRequest;
import com.enigma.wms_api.dto.response.BranchResponse;
import com.enigma.wms_api.dto.response.ControllerResponse;
import com.enigma.wms_api.entity.Branch;
import com.enigma.wms_api.repository.BranchRepository;
import com.enigma.wms_api.service.BranchService;
import lombok.RequiredArgsConstructor;
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
    public ControllerResponse<?> createBranchWithDto(BranchCreateRequest request) {
        //mapping isi dari CreateRequest ke branchnya biar di build
        Branch branch = Branch.builder()
                //cara bacanya : set BranchName = Request.GetName
                .branchName(request.getName())
                //cara bacanya : set BranchCode = Request.GetCode
                .branchCode(request.getCode())
                //silahkan lanjut lgi buat mapping fieldnya
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())

                //klo udah build
                .build();
        branchRepository.save(branch);

        //bungkus hasil Branch ke dalem BranchResponse
        BranchResponse branchResponse = BranchResponse.builder()
                //.id itu liat dari field BranchResponse, sesuaikan
                .id(branch.getId())
                .name(branch.getBranchName())
                .code(branch.getBranchCode())
                .address(branch.getAddress())
                .phoneNumber(branch.getPhoneNumber())
                //tambah field lain
                //.namaField(isiValue)
                //klo udah build
                .build();

        //bungkus BranchResponsenya kedalem Controller Response
        //ControllerResponse<?> artinya ControllerResponse bisa menampung berbagai macam Object bisa Class, Bisa List, Bisa Page
        //kalo ditulis ControllerResponse<BranchResponse> berarti dia hanya mau nampung BranchResponse
        ControllerResponse<BranchResponse> response = ControllerResponse.<BranchResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Branch Created")
                .data(branchResponse)
                .build();

        return  response;
    }

    @Override
    public Branch getById(String id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if (optionalBranch.isPresent()) return optionalBranch.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "branch not found");
    }

    @Override
    public ControllerResponse<?> updateBranchWithDto(String id, BranchUpdateRequest request) {
        Branch existingBranch = branchRepository.findById(id).orElse(null);

        existingBranch = Branch.builder()
                .branchName(request.getName())
                .branchCode(request.getCode())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
        branchRepository.save(existingBranch);


        BranchResponse branchResponse = BranchResponse.builder()
                .id(existingBranch.getId())
                .name(existingBranch.getBranchName())
                .code(existingBranch.getBranchCode())
                .address(existingBranch.getAddress())
                .phoneNumber(existingBranch.getPhoneNumber())
                .build();

        ControllerResponse<BranchResponse> response = ControllerResponse.<BranchResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Branch Updated")
                .data(branchResponse)
                .build();

        return response;
    }

    @Override
    public void delete(String id) {
        branchRepository.deleteById(id);
    }

    @Override
    public List<Branch> getAllBranch(Branch branch) {
        return branchRepository.findAll();
    }
}
