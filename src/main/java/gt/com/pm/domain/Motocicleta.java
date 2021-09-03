package gt.com.pm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity 
@Table(name = "motocicleta")
public class Motocicleta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_motocicleta;
    @NotNull
    private Long id_cliente;
    @NotEmpty
    private String fecha_recepcion;
    private String fecha_retiro;
    @NotNull
    private Long id_agencia;
    @NotEmpty
    private String placa;
    @NotEmpty
    private String numero_motor;
    @NotEmpty
    private String numero_chasis;
    @NotNull
    private Long id_linea;
    @NotEmpty
    private String modelo;
    private String comentario;
}
