package ecomarket.duoc.ecomarket.duoc;

import ecomarket.duoc.ecomarket.duoc.model.*;
import ecomarket.duoc.ecomarket.duoc.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner{ 
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        //Generar producto
        for(int i = 0; i < 5; i++){
            Producto producto = new Producto();
            producto.setId(i + 1);
            producto.setCodigoProducto(faker.number().numberBetween(10000, 99999));
            producto.setNombre(faker.name().fullName());
            producto.setMarca(faker.name().fullName());
            producto.setCantidadProducto(faker.number().numberBetween(1, 100));
            producto.setFechaElavoracion(new Date());
            producto.setFechaVencimiento(new Date());
            productoRepository.save(producto);
        }
    }
}
