package com.curso.unifal.ecommerce.domain.product.dto;

import com.curso.unifal.ecommerce.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String name;
    private String sku;
    private BigDecimal price;

    public Product toEntity(){
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .sku(generateSKU())
                .build();
    }

    public static ProductDTO fromEntity(Product product){
        return ProductDTO.builder()
                .name(product.getName())
                .price(product.getPrice())
                .sku(product.getSku())
                .build();
    }

    public static String generateSKU(){
        final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String NUMBERS = "0123456789";
        final int SKU_LENGTH = 8;

        StringBuilder skuBuilder = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < SKU_LENGTH; i++){
            if(i < SKU_LENGTH/2){
                int randomIndex = random.nextInt(LETTERS.length());
                char randomLetter = LETTERS.charAt(randomIndex);
                skuBuilder.append(randomLetter);
            } else {
                int randomIndex = random.nextInt(NUMBERS.length());
                char randomNumber = NUMBERS.charAt(randomIndex);
                skuBuilder.append(randomNumber);
            }
        }

        return skuBuilder.toString().toUpperCase();
    }
}
