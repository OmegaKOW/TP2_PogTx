package al420445.models.Library;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Livre extends Document {

    private int nbPages;

    private String genre;



    public int getNbPages() {
        return nbPages;
    }
}
