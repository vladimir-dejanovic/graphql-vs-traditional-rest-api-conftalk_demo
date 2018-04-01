package xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.root;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Post;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

@RequiredArgsConstructor
public class Query implements GraphQLRootResolver {

	private final PostRepository postRepository;

    public List<Post> allPosts() {
        return postRepository.findAll();
    }   
}
