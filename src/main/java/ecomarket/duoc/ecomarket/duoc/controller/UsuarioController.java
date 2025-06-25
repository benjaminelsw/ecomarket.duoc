package ecomarket.duoc.ecomarket.duoc.controller;

import ecomarket.duoc.ecomarket.duoc.model.Usuario;
import ecomarket.duoc.ecomarket.duoc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ususario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioyId(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteById(id);
    }

}
