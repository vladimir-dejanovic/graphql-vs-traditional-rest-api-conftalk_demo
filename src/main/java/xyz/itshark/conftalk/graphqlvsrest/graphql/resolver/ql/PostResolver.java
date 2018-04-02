package xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.ql;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.conftalk.graphqlvsrest.excpetion.NotFoundException;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Author;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Post;
import xyz.itshark.conftalk.graphqlvsrest.repository.AuthorRepository;

@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<Post> {
	
	private final AuthorRepository authRepository;	
	
	public Author createdBy(Post post) {
		return authRepository.findById(post.getAuthorId()).orElseThrow(() -> new NotFoundException());
	}	
}
