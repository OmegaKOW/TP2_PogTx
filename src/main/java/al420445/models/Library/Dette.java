package al420445.models.Library;


import al420445.models.Users.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dette {

    @Id
    @GeneratedValue
    private long id;

    private double dette;

    @OneToMany
    private List<Emprunt> empruntsEndettes = new ArrayList<>();

    @ManyToOne
    private Client client;

}
