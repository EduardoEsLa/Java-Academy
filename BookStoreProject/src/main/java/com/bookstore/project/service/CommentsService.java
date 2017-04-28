package com.bookstore.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.project.model.CommentsEntity;
import com.bookstore.project.repository.CommentsRepository;

/**
 * Service class for the CommentsRepository
 * @author eduardo.espinoza
 */
@Service
public class CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;
	
	
	/**
	 * Method to add a comment
	 * @author eduardo.espinoza
	 * @param comments
	 */
	public void addComment(final CommentsEntity comments){
		commentsRepository.insertComment(comments);
	}


	/**
	 * Method to get a list of comments 
	 * @author eduardo.espinoza
	 */
	public List<CommentsEntity> viewComment(){
		final List<CommentsEntity> comments = commentsRepository.getAllComments();
		return comments;
	}
}
