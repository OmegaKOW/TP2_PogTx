package al420445.models.Library;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class Livre extends Document {

    private int nbPages;

    private String genre;

    public Livre() {

    }


    public int getNbPages() {
        return nbPages;
    }
}
