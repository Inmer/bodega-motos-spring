package gt.com.pm.servicio;

import gt.com.pm.dao.GeneroDao;
import gt.com.pm.domain.Genero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroDao generoDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Genero> listarGenero() {
        return (List<Genero>) generoDao.findAll();
    }
       
}

