package gt.com.pm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
@Table(name="genero")
public class Genero implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;
    @NotEmpty
    private String nombre;
}