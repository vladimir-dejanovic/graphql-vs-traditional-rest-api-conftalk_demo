package xyz.itshark.conftalk.graphqlvsrest;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.ql.PostResolver;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.root.Query;
import xyz.itshark.conftalk.graphqlvsrest.repository.AuthorRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(PostRepository postRepository, AuthorRepository authRepository) {
		super(buildSchema(postRepository,authRepository));
	}

	private static GraphQLSchema buildSchema(PostRepository postRepository, AuthorRepository authRepository) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository),
						new PostResolver(authRepository))
				.build()
				.makeExecutableSchema();
	}	

}
