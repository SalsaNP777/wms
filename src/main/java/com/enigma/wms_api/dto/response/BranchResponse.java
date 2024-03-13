package com.enigma.wms_api.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchResponse {

    private String id;
    private String name;
    private String code;
    private String address;
    private String phoneNumber;
}
