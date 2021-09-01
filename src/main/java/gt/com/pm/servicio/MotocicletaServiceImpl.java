package gt.com.pm.servicio;

import gt.com.pm.dao.MotocicletaDao;
import gt.com.pm.domain.Motocicleta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotocicletaServiceImpl implements MotocicletaService{

    @Autowired
    private MotocicletaDao motocicletaDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Motocicleta> listarMotocicletas() {
        return (List<Motocicleta>) motocicletaDao.findAll();
    }
    
    @Override
    @Transactional
    public void guardarMotocicleta(Motocicleta motocicleta) {
        motocicletaDao.save(motocicleta);
    }

    @Override
    @Transactional
    public void eliminarMotocicleta(Motocicleta motocicleta) {
        motocicletaDao.delete(motocicleta);
    }

    @Override
    @Transactional(readOnly = true)
    public Motocicleta encontrarMotocicleta(Motocicleta motocicleta) {
        return motocicletaDao.findById(motocicleta.getId_motocicleta()).orElse(null);
    }
    
}
