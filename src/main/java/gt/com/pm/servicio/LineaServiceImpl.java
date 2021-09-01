package gt.com.pm.servicio;

import gt.com.pm.dao.LineaDao;
import gt.com.pm.domain.Linea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LineaServiceImpl implements LineaService{

    @Autowired
    private LineaDao lineaDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Linea> listarLineas() {
        return (List<Linea>) lineaDao.findAll();
    }
    
    @Override
    @Transactional
    public void guardarLinea(Linea linea) {
        lineaDao.save(linea);
    }

    @Override
    @Transactional
    public void eliminarLinea(Linea linea) {
        lineaDao.delete(linea);
    }

    @Override
    @Transactional(readOnly = true)
    public Linea encontrarLinea(Linea linea) {
        return lineaDao.findById(linea.getId_linea()).orElse(null);
    }
    
}
