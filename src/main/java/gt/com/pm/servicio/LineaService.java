/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.pm.servicio;

import gt.com.pm.domain.Linea;
import java.util.List;

/**
 *
 * @author alexc
 */
public interface LineaService {
    
    public List<Linea> listarLineas();
    
    public void guardarLinea(Linea linea);
    
    public void eliminarLinea(Linea linea);
    
    public Linea encontrarLinea(Linea linea);
    
}
