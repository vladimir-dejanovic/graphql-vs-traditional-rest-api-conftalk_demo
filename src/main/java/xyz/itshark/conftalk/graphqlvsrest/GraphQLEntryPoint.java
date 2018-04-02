package xyz.itshark.conftalk.graphqlvsrest;

/*     
Code used in demo for my talk GraphQL vs REST API
Copyright (C) 2018  Vladimir Dejanović

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/


import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.ql.AuthorResolver;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.ql.CommentResolver;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.ql.PostResolver;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.root.Mutation;
import xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.root.Query;
import xyz.itshark.conftalk.graphqlvsrest.repository.AuthorRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.CommentRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(PostRepository postRepository, AuthorRepository authRepository, CommentRepository commentRepository) {
		super(buildSchema(postRepository,authRepository, commentRepository));
	}

	private static GraphQLSchema buildSchema(PostRepository postRepository, AuthorRepository authRepository, CommentRepository commentRepository) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository, authRepository),
						new Mutation(authRepository),						
						new PostResolver(authRepository,commentRepository),
						new AuthorResolver(postRepository),
						new CommentResolver(authRepository,postRepository))
				.build()
				.makeExecutableSchema();
	}	

}
