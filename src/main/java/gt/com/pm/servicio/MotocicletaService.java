/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.pm.servicio;

import gt.com.pm.domain.Motocicleta;
import java.util.List;

/**
 *
 * @author alexc
 */
public interface MotocicletaService {
    
    public List<Motocicleta> listarMotocicletas();
    
    public void guardarMotocicleta(Motocicleta motocicleta);
    
    public void eliminarMotocicleta(Motocicleta motocicleta);
    
    public Motocicleta encontrarMotocicleta(Motocicleta motocicleta);
    
}
