package xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.root;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Post;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

	private final PostRepository postRepository;

    public List<Post> allPosts() {
        return postRepository.findAll();
    }   
}
