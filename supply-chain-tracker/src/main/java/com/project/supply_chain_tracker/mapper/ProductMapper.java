package com.project.supply_chain_tracker.mapper;

import org.springframework.stereotype.Component;

import com.project.supply_chain_tracker.dto.ProductDTO;
import com.project.supply_chain_tracker.entity.Product;
import com.project.supply_chain_tracker.entity.Supplier;

@Component
public class ProductMapper {

    public ProductDTO toDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getSupplier().getId(),
            product.getCategory(),
            product.getBaseCarbonFootprint()
        );
    }

    public Product toEntity(ProductDTO productDTO, Supplier supplier) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.id());
        product.setName(productDTO.name());
        product.setSupplier(supplier);
        product.setCategory(productDTO.category());
        product.setBaseCarbonFootprint(productDTO.baseCarbonFootprint());
        return product;
    }
}
