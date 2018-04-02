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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.itshark.conftalk.graphqlvsrest.excpetion.NotFoundException;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Author;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Comment;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Post;
import xyz.itshark.conftalk.graphqlvsrest.repository.AuthorRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.CommentRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

@RestController
public class DemoRestController {

	
	@Autowired
	AuthorRepository authR;
	
	@Autowired
	PostRepository postR;
	
	@Autowired
	CommentRepository commentR;
	
	
	@RequestMapping(path="/authors")
	public List<Author> getAllAuthors() {
		return authR.findAll();
	}

	@RequestMapping(path="/authors/{id}")
	public Author getAuthorById(@PathVariable String id) {
		return authR.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	@RequestMapping(path="/posts")
	public List<Post> getAllPosts(@RequestParam(value="author_id",required = false) String authId) {
		if(authId == null) 
			return postR.findAll();
		else 
			return postR.findByAuthorId(authId);
	}

	@RequestMapping(path="/comments")
	public List<Comment> getAllComments(@RequestParam(value="post_id",required = false) String postId) {
		if(postId == null)
			return commentR.findAll();
		else
			return commentR.findByPostId(postId);
	}

}
