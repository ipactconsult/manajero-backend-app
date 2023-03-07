package ipact.manazello.accounting.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.Instant;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "journallines")
public class JournalLines {
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

    private float debit= 0.0f;

    private float credit= 0.0f ;

    private float balance;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;


}
