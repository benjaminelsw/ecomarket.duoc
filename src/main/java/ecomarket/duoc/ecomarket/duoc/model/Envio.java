package ecomarket.duoc.ecomarket.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "envio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 13, nullable = false)
    private String run;

    @Column(nullable = false)
    private String codigoProducto;

    @Column(nullable = false)
    private String codigoEnvio;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private String estadoPedido;

    @Column(nullable = true)
    private Date fechaLlegada;
}
