package com.project.supply_chain_tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.project.supply_chain_tracker.dto.ProductDTO;
import com.project.supply_chain_tracker.entity.Product;
import com.project.supply_chain_tracker.entity.Supplier;
import com.project.supply_chain_tracker.mapper.ProductMapper;
import com.project.supply_chain_tracker.repository.ProductRepository;
import com.project.supply_chain_tracker.repository.SupplierRepository;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
            .map(productMapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
        
    }

    public ProductDTO createProduct(Long supplierId, ProductDTO productDTO) {
        Supplier supplier = supplierRepository.findById(supplierId).orElse(null);
        Product product = productMapper.toEntity(productDTO,supplier);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return productRepository.findById(id)
            .map(existingProduct -> {
                existingProduct.setName(productDTO.name());
                existingProduct.setCategory(productDTO.category());
                existingProduct.setBaseCarbonFootprint(productDTO.baseCarbonFootprint());
                Product updatedProduct = productRepository.save(existingProduct);
                return productMapper.toDto(updatedProduct);
            })
            .orElse(null);
    }

    public ProductDTO deleteProduct(Long id) {
        return productRepository.findById(id)
            .map(existingProduct -> {
                productRepository.deleteById(id);
                return productMapper.toDto(existingProduct);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
    }
}
