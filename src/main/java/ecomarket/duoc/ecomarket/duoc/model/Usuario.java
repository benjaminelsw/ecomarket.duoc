package ecomarket.duoc.ecomarket.duoc.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    private Integer id;
    private String run;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
    private String tipoUsuario;
}
