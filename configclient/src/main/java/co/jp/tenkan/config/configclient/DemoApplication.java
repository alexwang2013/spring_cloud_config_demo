package co.jp.tenkan.config.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class DemoApplication {

	@Autowired
	private AlexBean alexbean;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping(
		value = "/whoami/{username}",  
		produces = MediaType.TEXT_PLAIN_VALUE)
		public String whoami(@PathVariable("username") String username) {
			String role = alexbean.getRole();
			String password = alexbean.getPassword();
			return String.format("Hello! You're %s and you'll become a(n) %s, " +
			  "but only if your password is '%s'!\n", 
			  username, role, password);
		}

}
