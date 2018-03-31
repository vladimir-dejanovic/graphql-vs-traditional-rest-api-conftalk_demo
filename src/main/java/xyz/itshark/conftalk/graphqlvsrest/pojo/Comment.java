package xyz.itshark.conftalk.graphqlvsrest.pojo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="comments")
public class Comment {

	@Id
	private final String id;
	
	@NotNull
	private final String authorId;
	
	@NotNull	
	private final String postId;
	
	private final String text;	
}
