package xyz.itshark.conftalk.graphqlvsrest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.itshark.conftalk.graphqlvsrest.pojo.Post;

public interface PostRepository extends MongoRepository<Post,String> {
	List<Post> findByAuthorId(String authorId);

}
