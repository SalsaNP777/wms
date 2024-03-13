package com.enigma.wms_api.controller;

import com.enigma.wms_api.service.BillDetailService;
import com.enigma.wms_api.utils.constant.ApiUrlConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(ApiUrlConstant.BILLS)
@RequiredArgsConstructor
public class BillDetailController {
    private final BillDetailService billDetailService;

    @GetMapping("/total-sales/{billId}")
    public Integer getTotalSalesForBill(@PathVariable String billId) {
        return billDetailService.getTotalSales(billId);
    }

    @GetMapping("/total-sales")
    public Integer getTotalSalesForDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return billDetailService.calculateTotalSalesForDateRange(startDate, endDate);
    }
}
