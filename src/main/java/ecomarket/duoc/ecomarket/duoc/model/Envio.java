package ecomarket.duoc.ecomarket.duoc.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "envio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envio {
    @Id
    private Integer id;
    private String run;
    private Integer codigoProducto;
    private Integer codigoEnvio;
    private String direccion;
    private String nombreProducto;
    private String estadoPedido;
    private Date fechaLlegada;
}
