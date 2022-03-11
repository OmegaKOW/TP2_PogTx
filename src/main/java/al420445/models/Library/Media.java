package al420445.models.Library;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class Media extends Document {



    int id;

    String length;

    MediaType type;


    public Media() {

    }

    public int getId() {
        return id;
    }

    public String getLength() {
        return length;
    }

    public MediaType getType() {
        return type;
    }
}
