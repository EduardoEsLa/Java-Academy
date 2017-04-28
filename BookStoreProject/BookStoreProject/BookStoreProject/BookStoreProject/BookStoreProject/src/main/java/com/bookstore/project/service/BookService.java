package com.bookstore.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.project.model.BookEntity;
import com.bookstore.project.repository.BookRepository;

/**
 * Service class for the BookRepository
 * @author eduardo.espinoza
 */
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	/**
	 * Method to register a new Book
	 * @author eduardo.espinoza
	 * @param bookEntity
	 */
	public void registerNewBook(final BookEntity bookEntity){
		bookRepository.createBook(bookEntity);
		System.out.println("[SERV] Created book successfully");
	}

	
	/**
	 * Method to remove a Book
	 * @author eduardo.espinoza
	 * @param Id
	 */
	public void removeBook(final Integer Id){
		bookRepository.deleteBook(Id);
		System.out.println("[SERV] Deleted book successfully");
	}
	
	
	/**
	 * Method to update a book's Price given by Id
	 * @author eduardo.espinoza
	 * @param Price
	 * @param Id
	 */
	public void updatingBook(final BookEntity bookEntity){
		bookRepository.updateBook(bookEntity);
		System.out.println("[SERV] Updated book successfully");
	}
	
	
	/**
	 * Method to get all the books
	 * @author eduardo.espinoza
	 * @return List of books
	 */
	public List<BookEntity> getAllBooks(){
		final List<BookEntity> booksList = bookRepository.findAllBooks();
		System.out.println("[SERV] Found books successfully");
		return booksList;
	}

	
	/**
	 * Method to get a book given by a Id
	 * @author eduardo.espinoza
	 * @param Id
	 * @return Book by Id
	 */
	public BookEntity getBookById(final Integer Id){
		final BookEntity bookId = bookRepository.findBookById(Id);
		System.out.println("[SERV] Found book by Id successfully");
		return bookId;
	}

	
	/**
	 * Method to get a book given by an Title
	 * @author eduardo.espinoza
	 * @param Title
	 * @return Book by Title
	 */
	public BookEntity getBookByTitle(final String Title){
		final BookEntity bookTitle = bookRepository.findBookByTitle("Title");
		System.out.println("[SERV] Found books by title successfully");
		return bookTitle;
	}
	
	
	/**
	 * Method to get a book given by a Category
	 * @author eduardo.espinoza
	 * @param Category
	 * @return Books by Category
	 */
	public List<BookEntity> getBookByCategory(final String Category){
		final List<BookEntity> booksCategory = bookRepository.findBooksByCategory("Category");
		System.out.println("[SERV] Found books by category successfully");
		return booksCategory;
	}

}
