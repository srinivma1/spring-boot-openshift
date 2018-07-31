/**
 * 
 */
package de.michlb.sample;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Id;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;




/**
 * @author mahesh.srinivas
 *
 */


@Component
public class EntityListenerAspect {
	
	/*@Autowired
	private ProducerTemplate producerTemplate;
	
	private Object id;*/
/*
	@Before("execution(public * org.springframework.data.repository.Repository+.*(..))")
	public void logAdvice(JoinPoint joinPoint) throws NoSuchMethodException,IllegalAccessException {
		
		 MethodSignature signature = (MethodSignature) joinPoint.getSignature();

	    
	        if (!signature.getName().contains("saveAndFlush")) {
	            return;
	        }

		 Object entity = joinPoint.getArgs()[0];
	      for (Field f : entity.getClass().getDeclaredFields()) {

	             if(f.isAnnotationPresent(Id.class)) {
	        	 f.setAccessible(true);
	        	id = f.get(entity);
	        	break;

	         
	  }
	      }
	}

	@AfterReturning(pointcut="execution(public * org.springframework.data.repository.Repository+.*(..))",returning="result")
    public void setMessageHeaders(JoinPoint joinPoint,Object result) throws NoSuchMethodException,IllegalAccessException,JsonProcessingException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // only intercept save calls - that's when timestamp setting should happen
        if (!signature.getName().contains("saveAndFlush")) {
            return;
        }

        // need to go through target.class as Spring Data repositories will be proxied
  
    
     
ObjectMapper objectMapper = new ObjectMapper();
String personString = objectMapper.writeValueAsString(result);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte [] yourBytes = null;
			ObjectOutput out = null;
				try {
						out = new ObjectOutputStream(bos);   
						out.writeObject(result);
						out.flush();
						 yourBytes = bos.toByteArray();
 
				}catch(IOException ex) {
					ex.printStackTrace();
				}	
	finally {

  try {
    bos.close();
  } catch (IOException ex) {
    // ignore close exception
  }
}
        
		Map<String,Object> headers = new HashMap<String,Object>();
		if(id!=null)
			headers.put("actionType", "Update");
		else {
			headers.put("actionType", "Create");
		}
		headers.put("payload", result.getClass().getSimpleName());
		
		producerTemplate.sendBodyAndHeaders("direct:message",ExchangePattern.InOnly,yourBytes,headers);

        // save (single object or iteralbe of objects)
        

    

	}*/

}


