
package gt.com.pm.servicio;

import java.util.List;
import gt.com.pm.dao.ClienteDao;
import gt.com.pm.domain.Cliente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jpopm
 */
public class ClienteServiceImplTest {
    
    public ClienteServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listarClientes method, of class ClienteServiceImpl.
     * 
     */
    
       @Autowired
    private ClienteDao clienteDao;
       
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        ClienteServiceImpl instance = new ClienteServiceImpl();
        List<Cliente> expResult = (List<Cliente>) clienteDao.findAll();
        List<Cliente> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
        fail("The test case is a prototype.");
        }
    }


    /**
     * Test of encontrarCliente method, of class ClienteServiceImpl.
     */
    @Test
    public void testEncontrarCliente() {
        System.out.println("encontrarCliente");
        Cliente cliente = (Cliente) (List<Cliente>) clienteDao.findAll();
        ClienteServiceImpl instance = new ClienteServiceImpl();
        Cliente expResult = (Cliente) (List<Cliente>) clienteDao.findAll();
        Cliente result = instance.encontrarCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
