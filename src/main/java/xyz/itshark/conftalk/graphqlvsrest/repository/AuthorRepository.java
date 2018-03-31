package xyz.itshark.conftalk.graphqlvsrest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.itshark.conftalk.graphqlvsrest.pojo.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

}