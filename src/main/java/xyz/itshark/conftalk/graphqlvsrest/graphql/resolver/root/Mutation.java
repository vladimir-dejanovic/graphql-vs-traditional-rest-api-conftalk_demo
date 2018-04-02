package xyz.itshark.conftalk.graphqlvsrest.graphql.resolver.root;

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

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.conftalk.graphqlvsrest.excpetion.NotFoundException;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Author;
import xyz.itshark.conftalk.graphqlvsrest.repository.AuthorRepository;

@RequiredArgsConstructor
public class Mutation implements GraphQLRootResolver {
	
	private final AuthorRepository authRepo;

	public Author addAuthor(String name) {
		return authRepo.save(new Author(null, name));
	}
	
	public Author removeAuthour(String id) {
		Author auth = authRepo.findById(id).orElseThrow(() -> new NotFoundException());
		authRepo.delete(auth);
		return auth;
	}
}
