package ecomarket.duoc.ecomarket.duoc.repository;

import ecomarket.duoc.ecomarket.duoc.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Enviorepository extends JpaRepository <Envio, Long>{

    
}
