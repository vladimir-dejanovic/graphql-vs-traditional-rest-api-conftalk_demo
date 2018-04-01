package xyz.itshark.conftalk.graphqlvsrest;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.root.Query;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(PostRepository postRepository) {
		super(buildSchema(postRepository));
	}

	private static GraphQLSchema buildSchema(PostRepository postRepository) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository))
				.build()
				.makeExecutableSchema();
	}	

}
