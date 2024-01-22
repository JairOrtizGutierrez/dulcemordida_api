package com.dulcemordidaService.producto.service.impl;

import com.dulcemordidaService.pago.entity.Pago;
import com.dulcemordidaService.pago.entity.PagoFormWrapper;
import com.dulcemordidaService.pago.entity.PagoTipo;
import com.dulcemordidaService.producto.entity.*;
import com.dulcemordidaService.producto.repository.ProductoRepository;
import com.dulcemordidaService.producto.service.ProductoService;
import com.dulcemordidaService.utils.Constants;
import com.dulcemordidaService.utils.DataConvert;
import com.dulcemordidaService.utils.Utils;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public String folderName = "/productos";

    @Override
    public Producto createProducto(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return this.productoRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(int id) {
        this.productoRepository.deleteById(id);
    }

    @Override
    public Producto getProductoById(int id) {
        return this.productoRepository.findById(id);
    }

    @Override
    public List<Producto> getProductoByNombre(String nombre) {
        return this.productoRepository.findByNombreContains(nombre);
    }

    @Override
    public Optional<Producto> createProducto(ProductoFormWrapper productoFormWrapper) {
        File newFile = null;
        try {
            Producto createdProducto;
            if (productoFormWrapper.getImagen().getOriginalFilename().isEmpty() || productoFormWrapper.getImagen().getOriginalFilename().isBlank()) {
                createdProducto = this.createProducto(this.fillProductoEntity(productoFormWrapper, null));
            } else {
                newFile = Utils.transferImage(productoFormWrapper.getImagen(), "producto_", new File(Constants.FOLDER_PATH + this.folderName));
                createdProducto = this.createProducto(this.fillProductoEntity(productoFormWrapper, newFile.getName()));
            }
            return Optional.of(createdProducto);
        } catch (Exception exception) {
            System.out.println("createProducto " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<Producto> updateProducto(ProductoFormWrapper productoFormWrapper) {
        File newFile = null;
        try {
            String fileName = this.getProductoById(productoFormWrapper.getId()).getImagen();
            String formFileName = productoFormWrapper.getImagen() != null ? productoFormWrapper.getImagen().getOriginalFilename(): null;
            Producto updatedProducto;

            if (formFileName == null || formFileName.isEmpty() || formFileName.isBlank()) {
                updatedProducto = this.updateProducto(this.fillProductoEntity(productoFormWrapper, null));
            } else {
                if (formFileName.equalsIgnoreCase(fileName)) {
                    updatedProducto = this.updateProducto(this.fillProductoEntity(productoFormWrapper, fileName));
                } else {
                    File fileToDelete = new File(Constants.FOLDER_PATH + this.folderName + "/" + fileName);

                    newFile = Utils.transferImage(productoFormWrapper.getImagen(), "producto_", new File(Constants.FOLDER_PATH + this.folderName));
                    updatedProducto = this.updateProducto(this.fillProductoEntity(productoFormWrapper, newFile.getName()));

                    if (fileToDelete.exists()) fileToDelete.delete();
                }
            }
            return Optional.of(updatedProducto);
        } catch (Exception exception) {
            System.out.println("updateProducto " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    public Producto fillProductoEntity(ProductoFormWrapper productoFormWrapper, String fileName) {
        SubCategoria subCategoria = new SubCategoria();
        subCategoria.setId(productoFormWrapper.getSubCategoriaId());
        Marca marca = new Marca();
        marca.setId(productoFormWrapper.getMarcaId());
        Medida medida = new Medida();
        medida.setId(productoFormWrapper.getMedidaId());
        Estado estado = new Estado();
        estado.setId(productoFormWrapper.getEstadoId());
        Producto producto = new Producto();
        producto.setId(productoFormWrapper.getId());
        producto.setNombre(productoFormWrapper.getNombre());
        producto.setSubCategoria(subCategoria);
        producto.setMarca(marca);
        producto.setMedida(medida);
        producto.setPrecio(productoFormWrapper.getPrecio());
        producto.setImagen(fileName);
        producto.setEstado(estado);
        producto.setDescripcion(productoFormWrapper.getDescripcion());
        return producto;
    }
}