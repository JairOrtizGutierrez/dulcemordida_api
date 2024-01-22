package com.dulcemordidaService.producto.service;

import com.dulcemordidaService.pago.entity.Pago;
import com.dulcemordidaService.pago.entity.PagoFormWrapper;
import com.dulcemordidaService.producto.entity.Producto;
import com.dulcemordidaService.producto.entity.ProductoFormWrapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto createProducto(Producto producto);

    List<Producto> getAllProductos();

    Producto updateProducto(Producto producto);

    void deleteProducto(int id);

    Producto getProductoById(int id);

    List<Producto> getProductoByNombre(String nombre);

    Optional<Producto> createProducto(ProductoFormWrapper productoFormWrapper);

    Optional<Producto> updateProducto(ProductoFormWrapper productoFormWrapper);
}