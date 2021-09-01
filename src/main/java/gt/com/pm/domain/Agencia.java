package gt.com.pm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity 
@Table(name = "agencia")
public class Agencia implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agencia;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String direccion;
    private String fechaapertura;
}
