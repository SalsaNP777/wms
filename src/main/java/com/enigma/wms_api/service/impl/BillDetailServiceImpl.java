package com.enigma.wms_api.service.impl;

import com.enigma.wms_api.entity.BillDetail;
import com.enigma.wms_api.entity.Product;
import com.enigma.wms_api.entity.Transaction;
import com.enigma.wms_api.repository.BillDetailRepository;
import com.enigma.wms_api.repository.TransactionRepository;
import com.enigma.wms_api.service.BillDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillDetailServiceImpl implements BillDetailService {
    private BillDetailRepository billDetailRepository;
    private TransactionRepository transactionRepository;

    @Override
    public BillDetail saveBillDetail(BillDetail billDetail) {
        return billDetailRepository.save(billDetail);
    }

    @Override
    public BillDetail getById(String id) {
        Optional<BillDetail> optionalBillDetail = billDetailRepository.findById(id);
        if (optionalBillDetail.isPresent()) return optionalBillDetail.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill not found");
    }

    @Override
    public Integer getTotalSales(String id) {
        List<BillDetail> billDetails = billDetailRepository.findByBillDetailId(id);
        Integer totalSales = 0;

        for (BillDetail detail : billDetails) {
            Integer quantity = detail.getQuantity();
            Product product = detail.getProduct();
            Integer price = product.getPrice(); // Assuming Product has a getPrice() method

            totalSales += quantity * price;
        }

        return totalSales;
    }

    @Override
    public Integer calculateTotalSalesForDateRange(Date startDate, Date endDate) {
        List<Transaction> transactions = transactionRepository.findByTransDateBetween((java.sql.Date) startDate, (java.sql.Date) endDate);

        int totalSales = 0;

        for (Transaction transaction : transactions) {
            for (BillDetail detail : transaction.getBillDetails()) {
                Integer quantity = detail.getQuantity();
                Product product = detail.getProduct();
                Integer price = product.getPrice(); // Assuming Product has a getPrice() method

                if (quantity != null && price != null) {
                    totalSales += quantity * price;
                }
            }
        }
        return totalSales;
    }
}
