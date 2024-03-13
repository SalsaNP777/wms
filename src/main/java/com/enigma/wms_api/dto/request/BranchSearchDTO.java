package com.enigma.wms_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BranchSearchDTO {
    private String branchCode;
    private String branchName;
    private String address;
    private String phoneNumber;
}
