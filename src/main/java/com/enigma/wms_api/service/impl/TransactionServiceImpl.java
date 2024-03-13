//package com.enigma.wms_api.service.impl;
//import com.enigma.wms_api.dto.request.TransactionSearchDTO;
//import com.enigma.wms_api.entity.BillDetail;
//import com.enigma.wms_api.entity.Product;
//import com.enigma.wms_api.entity.TransType;
//import com.enigma.wms_api.entity.Transaction;
//import com.enigma.wms_api.repository.TransactionRepository;
//import com.enigma.wms_api.service.BillDetailService;
//import com.enigma.wms_api.service.ProductService;
//import com.enigma.wms_api.service.TransTypeService;
//import com.enigma.wms_api.service.TransactionService;
//import com.enigma.wms_api.utils.specifications.TransactionSpecification;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class TransactionServiceImpl implements TransactionService {
//    private final TransactionRepository transactionRepository;
//    private final TransTypeService transTypeService;
//    private final BillDetailService billDetailService;
//    private final ProductService productService;
//
//    @Override
//    @Transactional
//    public Transaction createTransaction(TransactionSearchDTO transactionReq) {
////        TransType transType = transTypeService.getById(String.valueOf(transactionReq.getTransTypes()));
////        Transaction newTransaction = Transaction.builder()
////                .billId(transactionReq.getBillId())
////                .receiptNumber(transactionReq.getReceiptNumber())
////                .transDate(transactionReq.getTransDate())
////                .transTypeId(transType)
////                .build();
////        List<BillDetail> billDetails = new ArrayList<>();
////        for (BillDetail billDetail : transactionReq.getBillDetails()){
////            Product product = productService.getById(String.valueOf(billDetail.getProduct()));
////            BillDetail newBillDetail = BillDetail.builder()
////                    .billDetailId(billDetail.getBillDetailId())
////                    .product(product)
////                    .quantity(billDetail.getQuantity())
////                    .totalSales(billDetail.getTotalSales())
////                    .build();
////            billDetails.add(newBillDetail);
////            billDetailService.saveBillDetail(newBillDetail);
////        }
////        newTransaction.setBillDetails(billDetails);
////        return transactionRepository.save(newTransaction);
//        return null;
//    }
//
//    @Override
//    public List<Transaction> getAllTransaction(Transaction transaction) {
//        return transactionRepository.findAll();
//    }
//
//    @Override
//    public Page<Transaction> getTransactionPerPage(Pageable pageable, TransactionSearchDTO transactionSearchDTO) {
//        Specification<Transaction> specification = TransactionSpecification.getSpecification(transactionSearchDTO);
//        return transactionRepository.findAll(specification, pageable);
//    }
//
//    @Override
//    public Transaction getById(String id) {
//        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
//        if (optionalTransaction.isPresent()) return optionalTransaction.get();
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
//    }
//}
