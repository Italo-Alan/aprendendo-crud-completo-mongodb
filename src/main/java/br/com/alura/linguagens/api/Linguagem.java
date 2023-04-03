package br.com.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//Declara como um documento no banco de dados do MongoDB
//Adicionamos a coleção logo depois
@Document(collection = "Linguagens")
public class Linguagem {
    
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    public String getTitle() {
        return title;
    }
    public String getId() {
        return id;
    }
    public String getImage() {
        return image;
    }
    public int getRanking() {
        return ranking;
    }

    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public Linguagem(){

    }

    public void setId(String id){
        this.id = id;
    }
    
}
