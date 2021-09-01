/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.pm.servicio;

import gt.com.pm.domain.Cliente;
import java.util.List;

/**
 *
 * @author alexc
 */
public interface ClienteService {
    
    public List<Cliente> listarClientes();
    
    public void guardar(Cliente cliente);
    
    public void eliminar(Cliente cliente);
    
    public Cliente encontrarCliente(Cliente cliente);
    
}
