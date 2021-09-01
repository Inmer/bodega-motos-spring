package gt.com.pm.servicio;

import gt.com.pm.dao.AgenciaDao;
import gt.com.pm.domain.Agencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgenciaServiceImpl implements AgenciaService{

    @Autowired
    private AgenciaDao agenciaDao;
    
     
    @Override
    @Transactional(readOnly = true)
    public List<Agencia> listarAgencia() {
        return (List<Agencia>) agenciaDao.findAll();
    }
    
    @Override
    @Transactional
    public void guardarAgencia(Agencia agencia) {
        System.out.println(" El campo fecha trae> "+ agencia.getFechaapertura());
        agenciaDao.save(agencia);
    }

    @Override
    @Transactional
    public void eliminarAgencia(Agencia agencia) {
        agenciaDao.delete(agencia);
    }

    @Override
    @Transactional(readOnly = true)
    public Agencia encontrarAgencia(Agencia agencia) {
        return agenciaDao.findById(agencia.getId_agencia()).orElse(null);
    }
    
}
