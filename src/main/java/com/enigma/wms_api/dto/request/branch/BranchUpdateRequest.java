package com.enigma.wms_api.dto.request.branch;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BranchUpdateRequest {
    private String name;
    private String code;
    private String address;
    private String phoneNumber;
}
