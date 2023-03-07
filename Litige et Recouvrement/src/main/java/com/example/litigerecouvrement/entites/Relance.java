package com.example.litigerecouvrement.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "relance")
public class Relance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private Invoice invoice ;
    private Instant premierrelance ;
    private List<Mail> email ;
    private List<Comment> comment ;
    private List<CallRapport> call ;
    private Promise promise ;
    private List<SMS> sms ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datecloture ;
    private Boolean cloture ;
    private String archive;
    @Column(name = "modified_at")
    private Instant modifiedAt;
    private float penalty ;



}
