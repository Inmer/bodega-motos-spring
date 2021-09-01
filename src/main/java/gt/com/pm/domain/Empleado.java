package gt.com.pm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
@Table(name="empleado")
public class Empleado implements Serializable{
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private long id_empleado;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @OneToMany
    @JoinColumn(name="id_empleado")
    private List<Rol> roles;
    
    
    
}
