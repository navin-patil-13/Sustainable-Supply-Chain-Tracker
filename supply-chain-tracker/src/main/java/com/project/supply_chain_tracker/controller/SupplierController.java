package com.project.supply_chain_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.supply_chain_tracker.dto.SupplierDTO;
import com.project.supply_chain_tracker.service.SupplierService;

import jakarta.validation.Valid;

/*

*/
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;
    /*

     */
    @GetMapping()
    public List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDTO getSupplierById(@PathVariable Long id){
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierDTO createSupplier(@Valid @RequestBody SupplierDTO supplierDTO){
        return supplierService.createSupplier(supplierDTO);
    }

    @PutMapping("/{id}")
    public SupplierDTO updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDTO supplierDTO){
        return supplierService.updateSupplier(id, supplierDTO);
    }

    @DeleteMapping("/{id}")
    public SupplierDTO deleteSupplier(@PathVariable Long id){
        return supplierService.deleteSupplier(id);
    }
}
