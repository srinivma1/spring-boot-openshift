/**
 * 
 */
package de.michlb.sample;


import org.apache.camel.component.amqp.AMQPComponent;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;

/**
 * @author mahes
 *
 */
@Configuration
@Profile("!tests")
@EnableJms
public class IntegrationConfig{
	
	@Value("${jms.username}")
	  private String username;
	
	@Value("${jms.password}")
	  private String password;
	
	@Value("${jms.remoteUri}")
	  private String remoteUri;
	
	

	@Bean
	public JmsConnectionFactory jmsConnectionFactory() {
		JmsConnectionFactory jmsConnectionFactory = new JmsConnectionFactory(
				username,password,remoteUri);
		jmsConnectionFactory.setReceiveLocalOnly(true);
		
		return jmsConnectionFactory;
	}
	
	@Bean
	@Primary
	public CachingConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory cachingConnectionFactory= new CachingConnectionFactory();
		cachingConnectionFactory.setTargetConnectionFactory(jmsConnectionFactory());
		return cachingConnectionFactory;
	}
	
	@Bean
	public JmsConfiguration jmsConfiguration() {
		JmsConfiguration config = new JmsConfiguration();
		config.setConnectionFactory(cachingConnectionFactory());
		config.setCacheLevelName("CACHE_AUTO");
		return config;
	}
	
	@Bean
	public AMQPComponent amqp() {
		AMQPComponent comp = new AMQPComponent();
		comp.setConfiguration(jmsConfiguration());
		
		return comp;
	}
	
	
	/*@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory jmsConnectionFactory = new ActiveMQConnectionFactory(
				username,password,remoteUri);
	
		
		return jmsConnectionFactory;
	}
	
	@Bean
	@Primary
	public PooledConnectionFactory pooledConnectionFactory() {
		PooledConnectionFactory cachingConnectionFactory= new PooledConnectionFactory();
		cachingConnectionFactory.setConnectionFactory(activeMQConnectionFactory());
		cachingConnectionFactory.setMaxConnections(5);
		return cachingConnectionFactory;
	}
	
	@Bean
	public ActiveMQConfiguration jmsConfiguration() {
		ActiveMQConfiguration config = new ActiveMQConfiguration();
		config.setConnectionFactory(pooledConnectionFactory());
		config.setCacheLevelName("CACHE_AUTO");
		return config;
	}
	
	@Bean
	public ActiveMQComponent amq() {
		ActiveMQComponent comp = new ActiveMQComponent();
		comp.setConfiguration(jmsConfiguration());
		return comp;
	}*/
	
	


}
