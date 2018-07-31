/**
 * 
 */
package de.michlb.sample;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PostPersist;

import org.apache.camel.ProducerTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.michlb.sample.domain.BookCategory;

/**
 * @author mahesh.srinivas
 *
 */
public class BookCategoryListener {
	
@PostPersist
public void postPersist(BookCategory bookCategory)throws Exception {
	System.out.println("*****In the post persist method of book category**"+bookCategory.getName());
	ObjectMapper objMapper = new ObjectMapper();

	String jsonString = objMapper.writeValueAsString(bookCategory);
	System.out.println("JSON String is "+jsonString);
Map m = new HashMap();
m.put("payload", "BookCategory");
m.put("actionType", "Inserted");
	ProducerTemplate producerTemplate = BeanUtils.getBean(ProducerTemplate.class);
	producerTemplate.sendBodyAndHeaders("direct:message",jsonString,m);
}

	
}
