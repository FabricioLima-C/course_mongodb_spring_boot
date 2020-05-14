package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Long>{
	
	// O framework cria o método para consulta no banco de dados
	// O IgnoreCase ignora letras maiúsculas e minúsculas, o framework tem essas funções prontas
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	// Query personalizada
	// ?0 pega o valor passado pelo parâmetro
	// Mais informações sobre a personalização das queries, https://docs.mongodb.com/manual/reference/operator/query/regex/
	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);
}
