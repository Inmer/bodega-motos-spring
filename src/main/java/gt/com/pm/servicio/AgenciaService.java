/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.pm.servicio;

import gt.com.pm.domain.Agencia;
import java.util.List;

/**
 *
 * @author alexc
 */
public interface AgenciaService {
    
    public List<Agencia> listarAgencia();
    
    public void guardarAgencia(Agencia agencia);
    
    public void eliminarAgencia(Agencia agencia);
    
    public Agencia encontrarAgencia(Agencia agencia);
    
}