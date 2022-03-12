package al420445.models.Users;

import al420445.models.Library.Dette;
import al420445.models.Library.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue
    private int clientID;

    private String clientName;

    private String clientAddress;

    private double debt;

    private boolean hasDebt;

    @OneToMany
    private List<Document> documents = new ArrayList<>();

    @OneToMany
    private List<Dette> dette = new ArrayList<>();








    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }




}
