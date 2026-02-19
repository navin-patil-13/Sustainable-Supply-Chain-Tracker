package com.project.supply_chain_tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toDto(product);
    }

    public ProductDTO createProduct(Long supplierId, ProductDTO productDTO) {
        Supplier supplier = supplierRepository.findById(supplierId).orElse(null);
        Product product = productMapper.toEntity(productDTO,supplier);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }
}
