package ecomarket.duoc.ecomarket.duoc.service;

import ecomarket.duoc.ecomarket.duoc.model.Envio;
import ecomarket.duoc.ecomarket.duoc.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
    
    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> findAll() {
        return envioRepository.findAll();
    }

    public Envio findById(Integer id){
        return envioRepository.findById(id).orElse(null);
    }

    public Envio save(Envio envio){
        return envioRepository.save(envio);
    }

    public void deleteById(Integer id) {
        envioRepository.deleteById(id);
    }
}
