package ecomarket.duoc.ecomarket.duoc.service;

import ecomarket.duoc.ecomarket.duoc.model.Envio;
import ecomarket.duoc.ecomarket.duoc.repository.Enviorepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EnvioService {
    
    @Autowired
    private Enviorepository enviorepository;

    public List<Envio> findAll() {
        return enviorepository.findAll();
    }

    public Envio findById(long id) {
        return enviorepository.findById(id).get();
    }

    public Envio save(Envio envio) {
        return enviorepository.save(envio);
    }

    public void delete(Long id) {
        enviorepository.deleteById(id);
    }
}
