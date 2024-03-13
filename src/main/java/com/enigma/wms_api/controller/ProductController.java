package com.enigma.wms_api.controller;

import com.enigma.wms_api.dto.request.ProductSearchDTO;
import com.enigma.wms_api.dto.response.ControllerResponse;
import com.enigma.wms_api.dto.response.PageResponseWrapper;
import com.enigma.wms_api.entity.Product;
import com.enigma.wms_api.service.ProductService;
import com.enigma.wms_api.utils.constant.ApiUrlConstant;
import com.enigma.wms_api.utils.constant.ConstantMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiUrlConstant.PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {//<?>->all data type, alternate for <Product>
        String message = ConstantMessage.getMessage("Product");

        Product product1 = productService.create(product);
        ControllerResponse<Product> response = ControllerResponse.<Product>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())//beda dengan status yang dibawah
                .message(message)
                .data(product1)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

//    get all product and get product with filter using DTO
    @GetMapping
    public ResponseEntity<?> getProductByPage(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "5") Integer size,
            @RequestParam(name = "sort-by", defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(name = "product_code", required = false) String productCode,
            @RequestParam(name = "product_name", required = false) String productName,
            @RequestParam(name = "price", required = false) Integer price
    ) {
        ProductSearchDTO productSearchDTO = new ProductSearchDTO(productCode, productName, price);
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> resultPage = productService.getProductPerPage(pageable, productSearchDTO);
        PageResponseWrapper<Product> productPageResponseWrapper = new PageResponseWrapper<>(resultPage);

        return ResponseEntity.status(HttpStatus.OK).body(productPageResponseWrapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        Optional<Product> product = Optional.ofNullable(productService.getById(id));
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/branch/{branchId}")
    public List<Product> getAllProductsByBranchId(@PathVariable String branchId) {
        return productService.getAllProductsByBranchId(branchId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Product product) {
        Product update = productService.update(id, product);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.delete(id);
    }
}
