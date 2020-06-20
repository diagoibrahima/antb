package com.atnb.africathenextbrain;

import com.atnb.africathenextbrain.dao.ContributionRepository;
import com.atnb.africathenextbrain.entities.Contribution;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@SpringBootApplication
public class AfricathenextbrainApplication implements CommandLineRunner {
	@Autowired
	private ContributionRepository contributionRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(AfricathenextbrainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Contribution.class);
      contributionRepository.save(new Contribution(null,"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt mollit anim id est laborum","El ibrahima DIAGO","Agriculture", "el-hadji-ibrahima-diago-11729466", new Date(),"", 1));
       contributionRepository.save(new Contribution(null,"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt mollit anim id est laborum","Demba FALL","Science", "el-hadji-ibrahima-diago-11729466", new Date(),"",1));
       contributionRepository.save(new Contribution(null,"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt mollit anim id est laborum","Jean Noel SARR","Technologie", "el-hadji-ibrahima-diago-11729466", new Date(),"",1));
        contributionRepository.save(new Contribution(null,"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt mollit anim id est laborum","Abdou S DIOP","Transport", "el-hadji-ibrahima-diago-11729466", new Date(),"",1));
       contributionRepository.save(new Contribution(null,"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt mollit anim id est laborum","Mamadou Moustapha","Economie", "el-hadji-ibrahima-diago-11729466", new Date(),"",1));
       contributionRepository.save(new Contribution(null,"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt mollit anim id est laborum","Dr Ndeye A DIAGO","Peche", "el-hadji-ibrahima-diago-11729466", new Date(),"",1));

        contributionRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});


		System.out.println("salut africa");

	}
}

@Configuration
class keycloakConfig{
	@Bean
	KeycloakSpringBootConfigResolver configResolver(){
		return new KeycloakSpringBootConfigResolver();
	}
}

@KeycloakConfiguration
class KeycloakSpringSecurity extends KeycloakWebSecurityConfigurerAdapter {

	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(keycloakAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);

		//http.authorizeRequests().antMatchers("/contributions/**").hasAnyAuthority("app-manager");
		//http.authorizeRequests().antMatchers("/contributions/**").authenticated();



		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/contributions/**").authenticated()
				.antMatchers(HttpMethod.PUT, "/contributions/**").authenticated()
				.antMatchers(HttpMethod.DELETE, "/contributions/**").authenticated()
				.antMatchers(HttpMethod.GET, "/contributions/**").authenticated();

	}
}

/*
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}
*/




