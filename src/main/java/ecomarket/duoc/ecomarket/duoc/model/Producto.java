package ecomarket.duoc.ecomarket.duoc.model;


import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private Integer id;
    private Integer codigoProducto;
    private String nombre;
    private String marca;
    private Integer cantidadProducto;
    private Date fechaElavoracion;
    private Date fechaVencimiento;
}
