package ecomarket.duoc.ecomarket.duoc.controller;

import ecomarket.duoc.ecomarket.duoc.model.Usuario;
import ecomarket.duoc.ecomarket.duoc.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Operaciones relacionadas con el tipo usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Obtener lista de todos los usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por id", description = "Obtener usuario con una id")
    public Usuario getUsuarioyId(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Agregar usuario", description = "Crear usuario")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar usuario", description = "Modificar usuario por id")
    public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar usuario", description = "Borrar usuarios por id")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteById(id);
    }

}
