package com.dulcemordidaService.proveedor.service.impl;

import com.dulcemordidaService.proveedor.entity.Proveedor;
import com.dulcemordidaService.proveedor.repository.ProveedorRepository;
import com.dulcemordidaService.proveedor.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public Proveedor createProveedor(Proveedor proveedor) {
        return this.proveedorRepository.save(proveedor);
    }

    @Override
    public List<Proveedor> getAllProveedores() {
        return this.proveedorRepository.findAll();
    }

    @Override
    public Proveedor updateProveedor(Proveedor proveedor) {
        return this.proveedorRepository.save(proveedor);
    }

    @Override
    public void deleteProveedor(int id) {
        this.proveedorRepository.deleteById(id);
    }

    @Override
    public Proveedor getProveedorById(int id) {
        return this.proveedorRepository.findById(id);
    }

    @Override
    public List<Proveedor> getProveedorByNombre(String nombre) {
        return this.proveedorRepository.findByNombreContains(nombre);
    }
}