package ipact.manazello.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.Instant;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="journal")
public class Journal {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private int code;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    private boolean archived;


}
