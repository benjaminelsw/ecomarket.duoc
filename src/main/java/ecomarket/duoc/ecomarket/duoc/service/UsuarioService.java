package ecomarket.duoc.ecomarket.duoc.service;

import ecomarket.duoc.ecomarket.duoc.model.Usuario;
import ecomarket.duoc.ecomarket.duoc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Integer id){
        usuarioRepository.deleteById(id);
    }

}
