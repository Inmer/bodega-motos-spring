package gt.com.pm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
      
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/editarcliente/**", "/agregarcliente/**", "/eliminarcliente/**",
                        "/editaragencia/**", "/agregaragencia/**", "/eliminaragencia/**", 
                        "/editarmarca/**", "/agregarmarca/**", "/eliminarmarca/**",
                        "/editarlinea/**", "/agregarlinea/**", "/eliminarlinea/**",
                        "/editarmotocicleta/**", "/agregarmotocicleta/**", "/eliminarmotocicleta/**","/editar/**")
                    .hasRole("ADMIN")
                .antMatchers("/", "/mclientes**", "/magencias**", "/mmarcas**", "/mlinea**", "/mmotocicletas**")
                    .hasAnyRole("USER","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403")
                ;
    }
}