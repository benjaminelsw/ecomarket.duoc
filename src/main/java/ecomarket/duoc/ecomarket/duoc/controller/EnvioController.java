package ecomarket.duoc.ecomarket.duoc.controller;

import ecomarket.duoc.ecomarket.duoc.model.Envio;
import ecomarket.duoc.ecomarket.duoc.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public ResponseEntity<List<Envio>> listar() {
        List<Envio> envios = envioService.findAll();
        if (envios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(envios);
    }

    @PostMapping
    public ResponseEntity<Envio> guardar(@RequestBody Envio envio) {
        Envio envioNuevo = envioService.save(envio);
        return ResponseEntity.status(HttpStatus.CREATED).body(envioNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> buscar(@PathVariable Integer id) {
        try{
            Envio envio = envioService.findById(id);
            return ResponseEntity.ok(envio);
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envio> actualizar(@PathVariable Integer id, @RequestBody Envio envio) {
        try{
            Envio env = envioService.findById(id);
            env.setId(id);
            env.setRun(envio.getRun());
            env.setCodigoProducto(envio.getCodigoProducto());
            env.setCodigoEnvio(envio.getCodigoEnvio());
            env.setDireccion(envio.getDireccion());
            env.setNombreProducto(envio.getNombreProducto());
            env.setEstadoPedido(envio.getEstadoPedido());
            env.setFechaLlegada(envio.getFechaLlegada());

            envioService.save(env);
            return ResponseEntity.ok(envio);
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try{
            envioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }
}
