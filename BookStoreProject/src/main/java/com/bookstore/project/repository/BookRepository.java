package com.bookstore.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.project.model.BookEntity;

/**
 * Repository for BookEntity
 * @author eduardo.espinoza
 */
@Repository
@Transactional
public class BookRepository {

	@PersistenceContext(unitName = "book_store_project")
	private EntityManager entityManager;
	
	
	/**
	 * Method to create a book
	 * @author eduardo.espinoza
	 */
	public void createBook(final BookEntity bookEntity){
		entityManager.persist(bookEntity);
		entityManager.flush();
		System.out.println("[REPO] Saved book: " + bookEntity);
	}

	
	/**
	 * Method to delete a book
	 * @author eduardo.espinoza
	 */
	public void deleteBook(final Integer Id){
		entityManager.remove(entityManager.find(BookEntity.class, Id));
		System.out.println("[REPO] Deleted book with Id: " + Id);
	}


	/**
	 * Method to update a book
	 * @author eduardo.espinoza
	 * @param bookEntity, Id
	 */
	public void updateBook(final BookEntity bookEntity){
		entityManager.merge(bookEntity);
		entityManager.flush();
		System.out.println("[REPO] Updated book: " + bookEntity);
	}
	
	
	/**
	 * Method to find all the books
	 * @author eduardo.espinoza
	 * @return List of books
	 */
	@SuppressWarnings("unchecked")
	public List<BookEntity> findAllBooks() {
		final List<BookEntity> allBooks = entityManager.createQuery("SELECT book FROM BookEntity book").getResultList(); 
		System.out.println("[REPO] Found books query success");
		return allBooks;
	}


	/**
	 * Method to find book given by Id
	 * @author eduardo.espinoza
	 * @param Id
	 * @return Book by Id
	 */
	public BookEntity findBookById(final Integer Id){
		final BookEntity bookId = entityManager.createQuery("SELECT book FROM BookEntity book WHERE Id = :Id", BookEntity.class)
			.setParameter("Id", Id)
			.getSingleResult();
		System.out.println("[REPO] Found book with Id: " + Id);
		return bookId; 
	}


	/**
	 * Method to find book given by Title
	 * @author eduardo.espinoza
	 * @param Title
	 * @return Book by Title
	 */
	public BookEntity findBookByTitle(final String Title){
		final BookEntity bookTitle = entityManager.createQuery("SELECT book FROM BookEntity book WHERE book.Title = :Title", BookEntity.class)
				.setParameter("Title", Title)
				.getSingleResult();
		System.out.println("[REPO] Found book with Title: " + Title);
		return bookTitle;
	}

	
	/**
	 * Method to find a books given by Category
	 * @author eduardo.espinoza
	 * @param Category
	 * @return Books by Category
	 */
	public List<BookEntity> findBooksByCategory(final String Category){
		final List<BookEntity> booksCat = entityManager.createQuery("SELECT book FROM BookEntity book WHERE book.Category= :Category", BookEntity.class)
				.setParameter("Category", Category)
				.getResultList();
		System.out.println("[REPO] Found books with Category: " + Category);
		return booksCat; 
	}
	
}
