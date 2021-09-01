package gt.com.pm.web;

import gt.com.pm.domain.Cliente;
import gt.com.pm.servicio.ClienteService;
import gt.com.pm.domain.Agencia;
import gt.com.pm.domain.Linea;
import gt.com.pm.domain.Marca;
import gt.com.pm.domain.Motocicleta;
import gt.com.pm.servicio.AgenciaService;
import gt.com.pm.servicio.GeneroService;
import gt.com.pm.servicio.LineaService;
import gt.com.pm.servicio.MarcaService;
import gt.com.pm.servicio.MotocicletaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private GeneroService generoService;
    
    @Autowired
    private MarcaService marcaService;
    
    @Autowired
    private MotocicletaService motocicletaService;
    
    @Autowired
    private LineaService lineaService;
    
    @Autowired
    private AgenciaService agenciaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var clientes = clienteService.listarClientes();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("clientes", clientes);
        return "index";
    }
    /*INICIA CONTROLADOR CLIENTE*/
    @PostMapping("/guardar")
    public String guardar(@Valid Cliente cliente, Errors errores,Model model){
        
        if(errores.hasErrors()){
            return "modificarclientes";
        }
        clienteService.guardar(cliente);
        return "redirect:/mclientes";
    }
    
    @GetMapping("/editar/{id_cliente}")
    public String editar(Cliente cliente, Model model){
        cliente = clienteService.encontrarCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarclientes";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Cliente cliente){
        clienteService.eliminar(cliente);
        return "redirect:/mclientes";
    }
    
    @GetMapping("/mclientes")
    public String mclientes (Model model){
        var generos = generoService.listarGenero();
        model.addAttribute("generos",generos);
        var clientes = clienteService.listarClientes();
        System.out.println("controlador"+generos);
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("clientes", clientes); 
        return "mclientes";
    }
    /*FIN CLIENTE*/
    
    /*INICIA CONTROLADOR AGENCIA*/
    @PostMapping("/guardarAgencia")
    
    
    public String guardarAgencia(@Valid Agencia agencia, Errors errores){
        if(errores.hasErrors()){
            return "modificaragencias";
        }
        agenciaService.guardarAgencia(agencia);
        return "redirect:/magencias";
    }
    
    @GetMapping("/editarAgencia/{id_agencia}")
    public String editar(Agencia agencia, Model model){
        agencia = agenciaService.encontrarAgencia(agencia);
        model.addAttribute("agencia", agencia);
        return "modificaragencias";
    }
    
    @GetMapping("/eliminarAgencia")
    public String eliminar(Agencia agencia){
        agenciaService.eliminarAgencia(agencia);
        return "redirect:/magencias";
    }
    
    @GetMapping("/magencias")
    public String magencias (Model model){
        var agencias = agenciaService.listarAgencia();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("agencias", agencias);
        return "magencias";
    }
    /*FIN AGENCIA*/
    
    /*INICIA CONTROLADOR MARCA*/
    @PostMapping("/guardarMarca")
    
    
    public String guardarMarca(@Valid Marca marca, Errors errores){
        if(errores.hasErrors()){
            return "modificarmarcas";
        }
        marcaService.guardarMarca(marca);
        return "redirect:/mmarcas";
    }
    
    @GetMapping("/editarMarca/{id_marca}")
    public String editar(Marca marca, Model model){
        marca = marcaService.encontrarMarca(marca);
        model.addAttribute("marca", marca);
        return "modificarmarca";
    }
    
    @GetMapping("/eliminarMarca")
    public String eliminar(Marca marca){
        marcaService.eliminarMarca(marca);
        return "redirect:/mmarcas";
    }
    
    @GetMapping("/mmarcas")
    public String mmarcas (Model model){
        var marcas = marcaService.listarMarca();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("marcas", marcas);
        return "mmarcas";
    }
    /*FIN MARCA*/
    
     /*INICIA CONTROLADOR Linea*/
    @PostMapping("/guardarLinea")
    public String guardarLinea(@Valid Linea linea, Errors errores,Model model){
        var marcas = marcaService.listarMarca(); 
        model.addAttribute("marcas",marcas);
        if(errores.hasErrors()){
            return "modificarlineas";
        }
        lineaService.guardarLinea(linea);
        return "redirect:/mlineas";
    }
    
    @GetMapping("/editarLinea/{id_linea}")
    public String editar(Linea linea, Model model){
        linea = lineaService.encontrarLinea(linea);
        model.addAttribute("linea", linea);
        return "modificarlineas";
    }
    
    @GetMapping("/eliminarLinea")
    public String eliminarLinea(Linea linea){
        lineaService.eliminarLinea(linea);
        return "redirect:/mlineas";
    }
    
    @GetMapping("/mlineas")
    public String mlineas (Model model){
        
        var marcas = marcaService.listarMarca(); 
        model.addAttribute("marcas",marcas);
        
        var lineas = lineaService.listarLineas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("lineas", lineas); 
        return "mlineas";
    }
    /*FIN Linea*/
    
    /*INICIA CONTROLADOR Motocicleta*/
    @PostMapping("/guardarMotocicleta")
    public String guardarMotocicleta(@Valid Motocicleta motocicleta, Errors errores,Model model){
        var marcas = marcaService.listarMarca(); 
        model.addAttribute("marcas",marcas);
        if(errores.hasErrors()){
            return "modificarmotocicleta";
        }
        motocicletaService.guardarMotocicleta(motocicleta);
        return "redirect:/mmotocicletas";
    }
    
    @GetMapping("/editarMotocicleta/{id_motocicleta}")
    public String editar(Motocicleta motocicleta, Model model){
        var lineas = lineaService.listarLineas(); 
        model.addAttribute("lineas",lineas);
        var agencias = agenciaService.listarAgencia(); 
        model.addAttribute("agencias",agencias);
        var clientes = clienteService.listarClientes(); 
        model.addAttribute("clientes",clientes);
        motocicleta = motocicletaService.encontrarMotocicleta(motocicleta);
        model.addAttribute("motocicleta", motocicleta);
        return "modificarmotocicletas";
    }
    
    @GetMapping("/eliminarMotocicleta")
    public String eliminarMotocicleta(Motocicleta motocicleta){
        motocicletaService.eliminarMotocicleta(motocicleta);
        return "redirect:/mmotocicletas";
    }
    
    @GetMapping("/mmotocicletas")
    public String mmotocicletas (Model model){
        
        var lineas = lineaService.listarLineas(); 
        model.addAttribute("lineas",lineas);
        var agencias = agenciaService.listarAgencia(); 
        model.addAttribute("agencias",agencias);
        var clientes = clienteService.listarClientes(); 
        model.addAttribute("clientes",clientes);
        
        
        var motocicletas = motocicletaService.listarMotocicletas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("motocicletas", motocicletas); 
        return "mmotocicletas";
    }
    /*FIN Motocicleta*/
    
    @GetMapping("/mreportes")
    public String mreportes (Model model){
        log.info("ejecutando el controlador Spring MVC");
        return "mreportes";
    }
    
}
