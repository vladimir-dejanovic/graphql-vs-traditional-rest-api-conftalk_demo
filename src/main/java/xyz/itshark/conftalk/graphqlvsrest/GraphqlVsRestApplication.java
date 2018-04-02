package xyz.itshark.conftalk.graphqlvsrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import xyz.itshark.conftalk.graphqlvsrest.pojo.Author;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Comment;
import xyz.itshark.conftalk.graphqlvsrest.pojo.Post;
import xyz.itshark.conftalk.graphqlvsrest.repository.AuthorRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.CommentRepository;
import xyz.itshark.conftalk.graphqlvsrest.repository.PostRepository;

@SpringBootApplication
public class GraphqlVsRestApplication {

	@Autowired
	AuthorRepository arep;
	
	@Autowired
	PostRepository prep;
	
	@Autowired
	CommentRepository crep;
	
	@Bean
	public CommandLineRunner initData() {
		return (args) -> {
			if (args.length > 0) {
				// Initialize some dummy data to be used in demo :)
				arep.save(new Author("123", "Ed Wong IV"));
				arep.save(new Author("345", "Son Goku"));

				prep.save(new Post("321","123", "Who is Radial Edward", "Edward Wong Hau Pepelu Tivrusky IV (エドワード・ウォン・ハウ・ペペル・チブルスキー4世 Edowādo Won Hau Peperu Chiburusukī 4-sei?), commonly called Ed, colloquially known as Radical Edward and born on January 1, 2058 as Françoise Appledelhi, is a child prodigy skilled in hacking originally from Earth. She is a comically-eccentric teenager around 13 years of age."));
				prep.save(new Post("543","345","Who is Son Goku","Son Goku (孫悟空 Son Gokū), born Kakarot (カカロット Kakarotto), is a male Saiyan and the main protagonist of the Dragon Ball meta-series created by Akira Toriyama. Cheerful, tenacious, and also a bit naïve, Goku is a Saiyan originally sent to Earth as an infant with the mission to destroy it. However, an accident alters his memory, causing him to grow up pure-hearted and later become Earth's greatest defender, as well as the informal leader of the Dragon Team. Throughout his life, he trains hard and constantly strives to be the greatest warrior possible and to fight stronger opponents, which has kept the Earth and the Universe safe from destruction many times"));
				
				crep.save(new Comment("1", "123", "543", "Wow you are strong!!!!"));
				crep.save(new Comment("2", "345", "321", "You are really clever :)"));				
			}
		};
	}
	
	@Bean
	public ServletRegistrationBean graphQLServlet(PostRepository postRepository,AuthorRepository authRepository) {
		return new ServletRegistrationBean(new GraphQLEntryPoint(postRepository,authRepository),"/graphql");
	}

	
	public static void main(String[] args) {
		SpringApplication.run(GraphqlVsRestApplication.class, args);
	}
}
