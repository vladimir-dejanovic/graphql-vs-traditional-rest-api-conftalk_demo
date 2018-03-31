package xyz.itshark.conftalk.graphqlvsrest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.itshark.conftalk.graphqlvsrest.pojo.Comment;


public interface CommentRepository extends MongoRepository<Comment,String> {
	List<Comment> findByPostId(String postId);
}