/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.pm.servicio;

import gt.com.pm.dao.GeneroDao;
import gt.com.pm.domain.Genero;
import gt.com.pm.domain.Linea;
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
public class LineaServiceImplTest {
    
    public LineaServiceImplTest() {
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
     * Test of listarLineas method, of class LineaServiceImpl.
     */
    
     @Autowired
    private GeneroDao generoDao;
     
    @Test
    public void testListarLineas() {
        System.out.println("listarLineas");
        LineaServiceImpl instance = new LineaServiceImpl();
        List<Genero> expResult = (List<Genero>) generoDao.findAll();
        List<Linea> result = instance.listarLineas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
        fail("The test case is a prototype.");
        }
    }


    /**
     * Test of encontrarLinea method, of class LineaServiceImpl.
     */
    @Test
    public void testEncontrarLinea() {
        System.out.println("encontrarLinea");
        Linea linea = null;
        LineaServiceImpl instance = new LineaServiceImpl();
        Linea expResult = null;
        Linea result = instance.encontrarLinea(linea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
