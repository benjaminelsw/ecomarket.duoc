package ecomarket.duoc.ecomarket.duoc;

import ecomarket.duoc.ecomarket.duoc.model.*;
import ecomarket.duoc.ecomarket.duoc.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner{


    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();


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

        //Generar envios
        for(int i = 0; i < 5; i++){
            Envio envio = new Envio();
            envio.setId(i + 1);
            envio.setRun(faker.idNumber().valid());
            envio.setCodigoProducto(faker.number().numberBetween(10000, 9999));
            envio.setCodigoEnvio(faker.number().numberBetween(10000, 99999));
            envio.setDireccion(faker.name().fullName());
            envio.setNombreProducto(faker.name().fullName());
            envio.setEstadoPedido(faker.options().option("Entregado", "Noentregado"));
            envio.setFechaLlegada(new Date());
            envioRepository.save(envio);
        }

        for(int i = 0; i < 5; i++){
            Usuario usuario = new Usuario();
            usuario.setId(i + 1);
            usuario.setRun(faker.idNumber().valid());
            usuario.setNombre(faker.name().fullName());
            usuario.setApellido(faker.name().lastName());
            usuario.setFechaNacimiento(new Date());
            usuario.setCorreo(faker.internet().emailAddress());
            usuario.setTipoUsuario(faker.options().option("Administrador", "Usuario"));
            usuarioRepository.save(usuario);
        }
    }
}
