package com.example.litigerecouvrement.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="scenario")
public class Scenario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String nomScenario ;
    private List<ActionScenario> actions ;



}
