package com.enigma.wms_api.dto.request.branch;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BranchCreateRequest {

    //COCOKIN SAMA DOKUMENTASI FIELD BUTUHNYA APA AJA, MANJA NTAR
    private String name;
    private String code;
}
