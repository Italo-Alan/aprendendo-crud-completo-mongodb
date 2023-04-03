package br.com.alura.linguagens.api;

import org.springframework.data.mongodb.repository.MongoRepository;

//Especificamos do que se trata o repository(Linguagem) e qual o tipo do ID
// 
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    
}
