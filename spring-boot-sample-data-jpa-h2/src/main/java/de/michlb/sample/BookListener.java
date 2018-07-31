/**
 * 
 */
package de.michlb.sample;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PostPersist;

import org.apache.camel.ProducerTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.michlb.sample.domain.Book;

/**
 * @author mahesh.srinivas
 *
 */
public class BookListener {
	
@PostPersist
public void postPersist(Book book)throws Exception {
	
	System.out.println("*****In the post persist method of book***"+book.getBookCategoryId());
	ObjectMapper objMapper = new ObjectMapper();
	String jsonString = objMapper.writeValueAsString(book);
	System.out.println("JSON String is "+jsonString);
	Map m = new HashMap();
	m.put("payload", "Book");
	m.put("actionType", "Inserted");
		ProducerTemplate producerTemplate = BeanUtils.getBean(ProducerTemplate.class);
		producerTemplate.sendBodyAndHeaders("direct:message",jsonString,m);
	
}

	
}
