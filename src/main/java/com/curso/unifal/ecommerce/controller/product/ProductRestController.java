package com.curso.unifal.ecommerce.controller.product;

import com.curso.unifal.ecommerce.domain.product.dto.ProductDTO;
import com.curso.unifal.ecommerce.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    @PostMapping(path = "/v1/product")
    public void createProduct(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
    }

    @GetMapping(path = "v1/product")
    public ResponseEntity<ProductDTO> getProductBySku(@RequestParam String sku){
        return ResponseEntity.ok(productService.getProductBySku(sku));
    }

    @PutMapping(path = "v1/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping(path = "v1/product")
    public void deleteProductBySku(@RequestParam String sku){
        productService.deleteProductBySku(sku);
    }
}
