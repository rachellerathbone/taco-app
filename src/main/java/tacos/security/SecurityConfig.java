//tag::securityConfigOuterClass[]
package tacos.security;

import org.springframework.context.annotation.Bean;
//end::securityConfigOuterClass[]
//tag::baseBonesImports[]
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web
                        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
                        .configuration.WebSecurityConfigurerAdapter;
//end::baseBonesImports[]

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Overide
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception {
		
	}
	
	@Bean
	  public PasswordEncoder encoder() {
	    return new StandardPasswordEncoder("53cr3t");
	  }
	
	@Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
		
		// make a call to the userDetailsService() method, passing in the 
		// userDetailsService instance that has been autowired into SecurityConfig
	    auth
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(encoder());

	  }
}