package gt.com.pm.dao;

import gt.com.pm.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente ,Long>{
    
}
