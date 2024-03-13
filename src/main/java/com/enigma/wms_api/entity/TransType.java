package com.enigma.wms_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_transaction_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "trans_type")
    private String transType;
}
