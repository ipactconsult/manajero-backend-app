package com.manazello.pm.entities.document;

import com.manazello.pm.entities.enumerations.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCategory {

    private Level complexity;
    private Level impact;
    private Level strategicImportance ;
    private String duration;
    private int memberNb;

}
