package ecomarket.duoc.ecomarket.duoc.controller;

import ecomarket.duoc.ecomarket.duoc.model.Envio;
import ecomarket.duoc.ecomarket.duoc.service.EnvioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envio")
@Tag(name = "Envios", description = "Operaciones relacionados con los envios")
public class EnvioController {
    
    @Autowired
    private EnvioService envioService;

    @GetMapping
    @Operation(summary = "Obtener todos los envios", description = "Obtener lista de todos los envios")
    public List<Envio> getAllEnvios() {
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un envio con una id", description = "Obtener un envio con una id")
    public Envio getEnvioById(@PathVariable Integer id) {
        return envioService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Agregar envio", description = "Crear un envio")
    public Envio createEnvio(@RequestBody Envio envio) {
        return envioService.save(envio);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar por id", description = "Modificar envios por id")
    public Envio updatEnvio(@PathVariable Integer id, @RequestBody Envio envio) {
        envio.setId(id);
        return envioService.save(envio);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar envio", description = "Borrar envios por id")
    public void deleteEnvio(@PathVariable Integer id) {
        envioService.deleteById(id);
    }
}
