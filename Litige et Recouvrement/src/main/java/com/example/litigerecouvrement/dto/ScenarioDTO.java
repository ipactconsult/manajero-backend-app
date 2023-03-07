package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.ActionScenario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScenarioDTO {
    private String id;
    private String nomScenario ;
    private List<ActionScenario> actions ;



}
