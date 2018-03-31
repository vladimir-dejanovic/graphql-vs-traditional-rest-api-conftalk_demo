package xyz.itshark.conftalk.graphqlvsrest.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="authors")
public class Author {

	@Id
	private final String id;
	
	private final String name;
}