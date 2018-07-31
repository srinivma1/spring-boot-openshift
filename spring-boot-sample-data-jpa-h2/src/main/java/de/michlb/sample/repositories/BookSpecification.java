/**
 * 
 */
package de.michlb.sample.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import de.michlb.sample.domain.Book;

/**
 * @author mahes
 *
 */
public class BookSpecification implements Specification<Book> {

	

	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(33);
		
		List<String> names= new ArrayList<String>();
		names.add("BookA1");
		names.add("BookA2");
		names.add("BookA3");
		
		final Predicate p = root.join("bookCategory",JoinType.LEFT).get("id").in(ids);
		
		final Predicate p1 = root.get("name").in(names);
	
		return cb.and(p,p1);
		

	}

}
