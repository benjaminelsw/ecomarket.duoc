package ecomarket.duoc.ecomarket.duoc.controller;

import ecomarket.duoc.ecomarket.duoc.model.Producto;
import ecomarket.duoc.ecomarket.duoc.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Obtener todos los productos")
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto con una id", description = "Obtener un producto con una id")
    public Producto getProductoById(@PathVariable Integer id) {
        return productoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Agregar producto", description = "Crear producto")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar por id", description = "Modificar producto por id")
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar producto", description = "Borrar productos por id")
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteById(id);
    }
}
