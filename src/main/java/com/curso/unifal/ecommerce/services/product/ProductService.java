package com.curso.unifal.ecommerce.services.product;

import com.curso.unifal.ecommerce.domain.product.Product;
import com.curso.unifal.ecommerce.domain.product.dto.ProductDTO;
import com.curso.unifal.ecommerce.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;

    public void save(final ProductDTO productDTO){
        productRepository.save(productDTO.toEntity());
    }

    public ProductDTO getProductBySku(String sku){
        Optional<Product> productOptional = productRepository.findBySku(sku);

        if(productOptional.isPresent()){
            return ProductDTO.fromEntity(productOptional.get());
        }

        throw new RuntimeException("PRODUCT NOT FOUND");
    }

    public Product findProductBySku(String sku){
        Optional<Product> productOptional = productRepository.findBySku(sku);

        if(productOptional.isPresent()){
            return productOptional.get();
        }

        throw new RuntimeException("PRODUCT NOT FOUND");
    }


    public ProductDTO updateProduct(ProductDTO productDTO){
        Optional<Product> productOptional = productRepository.findBySku(productDTO.getSku());

        if(productOptional.isEmpty()){
            throw new RuntimeException("PRODUCT NOT FOUND");
        }

        Product productToUpdate = productOptional.get();

        if(productToUpdate.getName() != null){
            productToUpdate.setName(productDTO.getName());
        }
        if(productToUpdate.getPrice() != null){
           productToUpdate.setPrice(productDTO.getPrice());
        }
        if(productToUpdate.getSku() != null){
            productToUpdate.setSku(productDTO.getSku());
        }

        return ProductDTO.fromEntity(productRepository.save(productToUpdate));
    }

    public void deleteProductBySku(String sku){
        Optional<Product> productOptional = productRepository.findBySku(sku);

        if(productOptional.isEmpty()){
            throw new RuntimeException("PRODUCT NOT FOUND");
        }

        productRepository.delete(productOptional.get());
    }
}
