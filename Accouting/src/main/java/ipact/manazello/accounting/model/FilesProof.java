package ipact.manazello.accounting.model;

import lombok.Getter;

import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Document(collection="filesProof")
public class FilesProof {
    @Id
    private String id;

    //@NotBlank
    private String title;

    //@NotBlank
    private Binary image;

    public FilesProof(String title) {
        this.title = title;
    }

    public FilesProof() {
    }



}
