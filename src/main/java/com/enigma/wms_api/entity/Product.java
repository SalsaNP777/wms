package com.enigma.wms_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "product_name")
    private String productName;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branchId;
}
