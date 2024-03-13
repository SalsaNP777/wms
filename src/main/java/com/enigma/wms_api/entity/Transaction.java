//package com.enigma.wms_api.entity;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "t_transaction")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//public class Transaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
//    @Column(name = "bill_id")
//    private String billId;
//    @Column(name = "receipt_number")
//    private String receiptNumber;
//    @Column(name = "trans_date")
//    @DateTimeFormat(pattern = "yyy-MM-dd")
//    @JsonFormat(pattern = "yyy-MM-dd")
//    private Date transDate;
//    @ManyToOne
//    @JoinColumn(name = "trans_type", referencedColumnName = "id")
//    private TransType transTypeId;
//    @OneToMany(mappedBy = "transaction")
//    private List<BillDetail> billDetails;
//}
