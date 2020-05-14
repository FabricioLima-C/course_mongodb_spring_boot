package com.example.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.CommentDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/05/2020"), "Fed imprimindo dinheiro...", "Agora é a hora para guardar seu dinheiro em opções melhores", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/05/2020"), "Bitcoin em decisão...", "Vair subir ou vair cair para os 8 mil dólares", new AuthorDTO(bob));
		
		CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/03/2020"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Quero ir à academia", sdf.parse("14/05/2020"), new AuthorDTO(maria));
		CommentDTO c3 = new CommentDTO("Vamos comprar bitcoin", sdf.parse("15/02/2020"), new AuthorDTO(bob));
		
		post1.getList().addAll(Arrays.asList(c1, c2));
		post2.getList().add(c3);
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().add(post1);
		bob.getPosts().add(post2);
		
		userRepository.save(maria);
		userRepository.save(bob);
	}
	
}
