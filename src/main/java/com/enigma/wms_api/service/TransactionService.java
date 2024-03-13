//package com.enigma.wms_api.service;
//
//import com.enigma.wms_api.dto.request.TransactionSearchDTO;
//import com.enigma.wms_api.entity.Transaction;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
//public interface TransactionService {
//    Transaction createTransaction(TransactionSearchDTO transactionDTO);
//    List<Transaction> getAllTransaction(Transaction transaction);
//    Page<Transaction> getTransactionPerPage(Pageable pageable, TransactionSearchDTO transactionSearchDTO);
//    Transaction getById(String id);
//}
