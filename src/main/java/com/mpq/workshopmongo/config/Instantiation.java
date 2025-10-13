package com.mpq.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mpq.workshopmongo.domain.Post;
import com.mpq.workshopmongo.domain.User;
import com.mpq.workshopmongo.repository.PostRepository;
import com.mpq.workshopmongo.repository.UserRepository;

@Configuration 
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post = new Post(null, sdf.parse("23/01/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("24/03/2018"), "Bom dia", "Acordei feliz hoje! :)", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post, post2));
	}
	

}
