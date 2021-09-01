package gt.com.pm.servicio;

import gt.com.pm.domain.Marca;
import java.util.List;

public interface MarcaService {
    
    public List<Marca> listarMarca();
    
    public void guardarMarca(Marca marca);
    
    public void eliminarMarca(Marca marca);
    
    public Marca encontrarMarca(Marca marca);
}
