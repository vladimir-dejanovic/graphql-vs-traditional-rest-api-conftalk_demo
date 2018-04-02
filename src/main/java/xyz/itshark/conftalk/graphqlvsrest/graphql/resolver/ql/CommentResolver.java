package xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.ql;

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


import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.conftalk.graphqlvsrest.excpetion.NotFoundException;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Author;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Comment;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Post;
import xyz.itshark.conftalk.graphqlvsrest.repository.AuthorRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

@RequiredArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {
	
	private final AuthorRepository authRepository;
	private final PostRepository postRepository;
	
	public Author createdBy(Comment comment) {
		// not best way to deal with optional, but I can't be bothered to do more for demo :)
		return authRepository.findById(comment.getAuthorId()).orElseThrow(() -> new NotFoundException());
	}
	
	public Post belongsTo(Comment comment) {
		// not best way to deal with optional, but I can't be bothered to do more for demo :)
		return postRepository.findById(comment.getPostId()).orElseThrow(() -> new NotFoundException());
	}

}
