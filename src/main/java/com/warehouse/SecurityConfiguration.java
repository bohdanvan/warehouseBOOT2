package com.warehouse;
import com.warehouse.security.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
@EnableGlobalMethodSecurity(prePostEnabled = true) // FIXME: 15.11.2016  почитать об этой анотаци
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    // FIXME: 15.11.2016  two @Authowired - TEST
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
    }



    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()/*.loginPage("/log")*/
                .usernameParameter("userName").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")  /* что означает ?logout*/
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");


    }
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser("root").password("admin").roles("ADMIN").and()
//                .withUser("admin").password("admin").roles("USER", "ADMIN");
//    }



}




// WORK VERSION

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/documents").access("hasRole('ROLE_ADMIN')")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin().loginPage("/log")
//                .usernameParameter("login").passwordParameter("password")
//                .and()
//                .logout().logoutSuccessUrl("/login?logout")
//                .and()
//                .exceptionHandling().accessDeniedPage("/403")
//                .and()
//                .csrf();









//        http
//                .authorizeRequests().anyRequest().authenticated();
//
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/", "/admin/**", "/newuser").access("hasRole('ADMIN')")
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                .and().formLogin().loginPage("/login")
//                .usernameParameter("login").passwordParameter("password")
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied");

//        http
//                .formLogin().failureUrl("/login?error")
//                .defaultSuccessUrl("/")
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
//                .permitAll();


