package com.dulcemordidaService.proveedor.service;

import com.dulcemordidaService.proveedor.entity.Proveedor;

import java.util.List;

public interface ProveedorService {
    Proveedor createProveedor(Proveedor proveedor);

    List<Proveedor> getAllProveedores();

    Proveedor updateProveedor(Proveedor proveedor);

    void deleteProveedor(int id);

    Proveedor getProveedorById(int id);

    List<Proveedor> getProveedorByNombre(String nombre);
}