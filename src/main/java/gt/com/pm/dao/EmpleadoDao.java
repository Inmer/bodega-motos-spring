package gt.com.pm.dao;

import gt.com.pm.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDao extends JpaRepository <Empleado,Long>{
    Empleado findByUsername(String username);
}
