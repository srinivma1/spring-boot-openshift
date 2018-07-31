package de.michlb.sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.michlb.sample.domain.Book;
import de.michlb.sample.domain.BookCategory;
import de.michlb.sample.repositories.BookRepository;
import de.michlb.sample.repositories.BookSpecification;
import de.michlb.sample.service.BookCategoryService;


/**
 * Created by mbart on 28.02.2016.
 */
@Controller
@RequestMapping("/books")
public class IndexController {

	@Autowired

	private BookCategoryService personService;

@Autowired
private BookRepository bookRepository;

	

	@RequestMapping("/")
	public String showIndex(Model model) {
		List<BookCategory> personList = personService.loadAll();
		List bookNames = new ArrayList();
		bookNames.add("BookA1");
		bookNames.add("BookA3");
		List bookIds = new ArrayList();
		bookIds.add(1);
		bookIds.add(2);
		bookIds.add(4);
		bookIds.add(5);
		
         List<Book> bookList = bookRepository.findAll(new BookSpecification());
         System.out.println(bookList.size());
		model.addAttribute("personList", personList);

		return "index"; // return index.html Template
	}

	@RequestMapping(value="/save", method = RequestMethod.GET)
	public String savePerson( Model model) {
		BookCategory categoryA = new BookCategory();
		categoryA.setName("Category A");
	     ArrayList<Book> bookAs = new ArrayList<Book>();
	     Book b = new Book();
	     b.setName("BookA1");
	     b.setBookCategory(categoryA);
	     Book c = new Book();
	     c.setName("BookA2");
	     c.setBookCategory(categoryA);
	     Book d = new Book();
	     d.setName("BookA3");
	     d.setBookCategory(categoryA);
	     bookAs.add(b);
	     bookAs.add(d);
	     bookAs.add(c);
	    categoryA.setBooks(bookAs);
	 personService.saveBookCategory(categoryA);
		
		Set<BookCategory> personList =personService.findBookCategoryByName("Category A");
		model.addAttribute("personList", personList);

		return "index"; // return index.html Template
	}
	
	@RequestMapping(value="/deleteList", method = RequestMethod.GET)
	public String deleteBookCategoryList( Model model) {
		List<Integer> idList = new ArrayList();
		idList.add(7);
		//idList.add(6);
	 personService.deleteBookCategoryList(idList);
	

		return "index"; // return index.html Template
	}
}
