package com.bookstore.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.project.model.CommentsEntity;

/**
 * Repository for CityEntity
 * @author eduardo.espinoza
 */
@Repository
@Transactional
public class CommentsRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Method to insert a comment
	 * @author eduardo.espinoza
	 * @param comments
	 */
	public void insertComment(final CommentsEntity comment){
		entityManager.persist(comment);
		entityManager.flush();
		System.out.println("[REPO] Saved comment: " + comment);
	}
	

	/**
	 * Method to get all comments
	 * @author eduardo.espinoza
	 * @return comments
	 */
	public List<CommentsEntity> getAllComments(){
		final List<CommentsEntity> comments = entityManager.createQuery("SELECT comments FROM CommentsEntity comments", CommentsEntity.class)
				.getResultList();
		System.out.println("[REPO] Found comments query success");
		return comments;
	}
}
