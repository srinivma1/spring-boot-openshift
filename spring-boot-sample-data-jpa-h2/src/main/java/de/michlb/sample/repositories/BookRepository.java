package de.michlb.sample.repositories;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import de.michlb.sample.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	//In clause using multiple attributes within same ENtity
		List<Book> findByNameInAndIdIn(List<String> bookNames, List<Integer> bookIds);
	
		//In clause and LEFT Outer joins using Specifications
		List<Book> findAll(Specification<Book> s);
		
}
