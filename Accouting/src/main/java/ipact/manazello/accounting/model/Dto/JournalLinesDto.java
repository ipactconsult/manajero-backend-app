package ipact.manazello.accounting.model.Dto;

import ipact.manazello.accounting.model.Account;
import ipact.manazello.accounting.model.FilesProof;
import ipact.manazello.accounting.model.Journal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JournalLinesDto {

    @Id
    private String id;
    @Indexed(unique  = true)

    @NotBlank
    private String wording;

    @DocumentReference
    private Account account;

    @DocumentReference
    private Journal journal;

    @DocumentReference
    private FilesProof filesProof;

    private float debit= 0.0f;;

    private float credit= 0.0f ;

    private float balance;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

}
