package com.enigma.wms_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_branch")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "branch_code")
    private String branchCode;
    @Column(name = "branch_name")
    private String branchName;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
