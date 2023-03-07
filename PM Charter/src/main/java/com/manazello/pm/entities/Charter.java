package com.manazello.pm.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.manazello.pm.entities.document.*;
import com.manazello.pm.entities.enumerations.StatusRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Charter {
    @Id
    private String id;
    private String title ;
    private List<ProjectCharterDocument> goal;
    private List<ProjectCharterDocument> mileStones;
    private List<ProjectCharterDocument> deliveryUnits;
    private List<ProjectCharterDocument> highRisk;
    private List<ProjectCharterDocument> keyStakeholder;
    private List<String> successCriteria;
    private ProjectCharterDocument problematic;
    private List<Are> are;
    private List<Budget> budget;
    private StatusRequest status;
    private String notes;
    private List<ResponsibilityCustomer> responsibilityCustomer;
    @DocumentReference
    private ProjectCategory projectCategory;
    private String statementWork;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateSubmited;
    private String projectDescription;
    private List<String> file ;
    private Employee projectManager;

}
