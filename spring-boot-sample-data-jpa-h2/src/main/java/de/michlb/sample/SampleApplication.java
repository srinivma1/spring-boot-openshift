package de.michlb.sample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;





@SpringBootApplication

public class SampleApplication{
	//private static final Logger logger = LoggerFactory.getLogger(SampleApplication.class);
	
	@Value("${service_bus.queue}")
	private String consumerQueue;
	
	

  public static void main(String[] args) {
     SpringApplication.run(SampleApplication.class, args);

   
  }
  
  
  
  /*@Component
	class MessageRoute extends RouteBuilder {

		@Override
		public void configure() throws Exception {
			from("direct:message").routeId("producerStrtUp").autoStartup(true).log("${body}")
			
			.inOnly("netty:tcp://localhost:9998?transferExchange=true&sync=false&synchronous=false");
		}
	}*/

}
