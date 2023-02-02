package anstar.StepTrello.security;

import anstar.StepTrello.filter.CustomAuthenticationFilter;
import anstar.StepTrello.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.cors().and().sessionManagement().sessionCreationPolicy(STATELESS);
        http.cors().and().authorizeHttpRequests().antMatchers("/api/user").permitAll();
        http.cors().and().authorizeHttpRequests().antMatchers("/api/users").permitAll();
        http.cors().and().authorizeHttpRequests().antMatchers( HttpMethod.GET,"/api/user/**","/api/board/**").hasAnyAuthority("USER");
        http.cors().and().authorizeHttpRequests().antMatchers( HttpMethod.POST,"/api/board/**").hasAnyAuthority("USER");
        http.cors().and().authorizeHttpRequests().antMatchers( HttpMethod.PUT,"/user/role/**","/api/role/**","/api/board/**").hasAnyAuthority("USER");
        http.cors().and().authorizeHttpRequests().antMatchers( HttpMethod.DELETE,"/user/role/**","/api/board/**").hasAnyAuthority("USER");
        http.cors().and().authorizeHttpRequests().anyRequest().authenticated();
        http.cors().and().addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.cors().and().addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
