//package com.enigma.wms_api.controller;
//
//import com.enigma.wms_api.dto.request.ProductSearchDTO;
//import com.enigma.wms_api.dto.request.TransactionSearchDTO;
//import com.enigma.wms_api.dto.response.PageResponseWrapper;
//import com.enigma.wms_api.entity.Product;
//import com.enigma.wms_api.entity.Transaction;
//import com.enigma.wms_api.service.TransactionService;
//import com.enigma.wms_api.utils.constant.ApiUrlConstant;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Date;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(ApiUrlConstant.TRANSACTION)
//@RequiredArgsConstructor
//public class TransactionController {
//    private final TransactionService transactionService;
//
//    @PostMapping
//    public Transaction createTransaction(@RequestBody TransactionSearchDTO transactionDTO){
//        return transactionService.createTransaction(transactionDTO);
//    }
//
//    @GetMapping
//    public List<Transaction> getAllTransactions(Transaction transaction) {
//        return transactionService.getAllTransaction(transaction);
//    }
//
////    get transaction with filter
//    @GetMapping("/pageable")
//    public ResponseEntity<?> getTransactionByPage(
//            @RequestParam(name = "page", defaultValue = "0") Integer page,
//            @RequestParam(name = "size", defaultValue = "5") Integer size,
//            @RequestParam(name = "sort-by", defaultValue = "trans_date") String sortBy,
//            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
//            @RequestParam(name = "bill_id", required = false) String billId,
//            @RequestParam(name = "receipt_number", required = false) String receiptNumber,
//            @RequestParam(name = "trans_date", required = false) Date transDate,
//            @RequestParam(name = "trans_type", required = false) String transType,
//            @RequestParam(name = "bill_details", required = false) String billDetails
//    ) {
//        TransactionSearchDTO transactionSearchDTO = new TransactionSearchDTO(billId, receiptNumber, transDate, transType, billDetails);
//        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
//        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<Transaction> resultPage = transactionService.getTransactionPerPage(pageable, transactionSearchDTO);
//        PageResponseWrapper<Transaction> productPageResponseWrapper = new PageResponseWrapper<>(resultPage);
//
//        return ResponseEntity.status(HttpStatus.OK).body(productPageResponseWrapper);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
//        Optional<Transaction> transaction = Optional.ofNullable(transactionService.getById(id));
//        return ResponseEntity.status(HttpStatus.OK).body(transaction);
//    }
//}
