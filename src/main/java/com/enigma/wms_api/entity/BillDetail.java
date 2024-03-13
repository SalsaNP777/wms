package com.enigma.wms_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bill_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String billDetailId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private Integer quantity;
    private Integer totalSales;
}
