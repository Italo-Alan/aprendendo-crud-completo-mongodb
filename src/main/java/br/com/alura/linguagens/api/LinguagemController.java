package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;
        
    //@ são mecanismos de anotações/metadados
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    //Request body passa a informação que será enviado para o body
    @PostMapping("/linguagens")
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem){
        //O ".save" grava no nosso banco os dados
        //O return abaixo determina que o status que retornará é o 201, e não o 200
        return new ResponseEntity(repositorio.save(linguagem), HttpStatus.CREATED) ;
    }

    @GetMapping("/linguagens/{id}")
    public Linguagem obterLinguagemPorId(@PathVariable String id){
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/linguagens/{id}")
    public Linguagem atualizarLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem){
        if(!repositorio.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        linguagem.setId(id);
        return repositorio.save(linguagem);
    }

    @DeleteMapping("/linguagens/{id}")
    public void deletaLinguagem(@PathVariable String id){
        repositorio.deleteById(id);
    }
}
