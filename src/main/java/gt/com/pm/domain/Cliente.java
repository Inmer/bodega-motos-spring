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
@Table(name = "cliente")
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    private String dpi;
    @NotEmpty
    private String nit;
    private String direccion;
    private String telefono;
    private String celular;
    @Email
    private String email;
    @NotNull
    private Long id_genero;
    @NotEmpty
    private String fechadenacimiento;
}
