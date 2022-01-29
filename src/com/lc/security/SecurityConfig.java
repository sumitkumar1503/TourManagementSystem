/*
 * package com.lc.security;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired DataSource ds;
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { System.out.println("in configure"); auth.jdbcAuthentication()
 * .dataSource(ds) //creates database connection
 * .usersByUsernameQuery("select email,password,enabled from user where email=?"
 * ) .authoritiesByUsernameQuery("select email,role from user where email=?") ;
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * System.out.println("in configure2"); http.authorizeRequests()
 * .antMatchers("/homepage").permitAll()
 * .antMatchers("/packages").hasRole("ADMIN") .anyRequest().authenticated()
 * 
 * 
 * .and().formLogin().loginPage("/login").permitAll()
 * 
 * .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
 * 
 * ; }
 * 
 * }
 */