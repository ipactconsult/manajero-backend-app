package com.example.litigerecouvrement.entites;

import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="categories")

public class CategorieDoc {

    @Id
    private String id;
    private List<Loi> lois ;
    private String categoriename ;
    private String description ;
    private String archive;








}
