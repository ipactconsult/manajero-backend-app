package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.Scenario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActionScenarioDTO {
    private String id;
    private String actionename ;
    private int nbrjr ;
    private String typeaction ;
    @DocumentReference
    private Scenario sce;


}
