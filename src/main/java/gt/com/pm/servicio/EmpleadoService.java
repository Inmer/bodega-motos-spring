package gt.com.pm.servicio;

import gt.com.pm.dao.EmpleadoDao;
import gt.com.pm.domain.Empleado;
import gt.com.pm.domain.Rol;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service ("userDetailService")
@Slf4j
public class EmpleadoService implements UserDetailsService{

    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Override
    @Transactional(readOnly=true)
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Empleado empleado = empleadoDao.findByUsername(username);
        
        if(empleado == null){
            throw new UsernameNotFoundException(username);
        }
        
        var roles =new ArrayList <GrantedAuthority >();
        
        for (Rol rol: empleado.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User (empleado.getUsername(), empleado.getPassword() , roles );
    }
    
}
