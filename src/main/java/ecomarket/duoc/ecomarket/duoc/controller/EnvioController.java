package ecomarket.duoc.ecomarket.duoc.controller;

import ecomarket.duoc.ecomarket.duoc.model.Envio;
import ecomarket.duoc.ecomarket.duoc.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envio")
public class EnvioController {
    
    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> getAllEnvios() {
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    public Envio getEnvioById(@PathVariable Integer id) {
        return envioService.findById(id);
    }

    @PostMapping
    public Envio createEnvio(@RequestBody Envio envio) {
        return envioService.save(envio);
    }

    @PutMapping("/{id}")
    public Envio updatEnvio(@PathVariable Integer id, @RequestBody Envio envio) {
        envio.setId(id);
        return envioService.save(envio);
    }

    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Integer id) {
        envioService.deleteById(id);
    }
}
