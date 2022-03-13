package al420445.models.Users;

import al420445.models.Library.Dette;
import al420445.models.Library.Document;
import al420445.models.Library.Emprunt;
import al420445.models.Library.Livre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
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

    private boolean hasDebt;

    @OneToMany
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany
    private List<Dette> dettes = new ArrayList<>();








    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }


    public Emprunt borrowBook(Document document){
        if(verifyEnoughExemplaires(document) && !checkHasDebts()){
            Emprunt emprunt = Emprunt.builder().client(this).doc(document).build();
            emprunt.getDoc().setExemplaires(emprunt.getDoc().getExemplaires() - 1);
            emprunt.setDateRetour();
            emprunts.add(emprunt);
            return emprunt;
        }
        else return null;

    }

    private boolean verifyEnoughExemplaires(Document document){
        return document.getExemplaires() > 0;
    }


    public Dette returnBook(Livre livre){
        for(Emprunt e : emprunts){
            if(e.getDoc() == livre){
                return checkDetteEmprunt(e);
            }
        }
        return null;
    }

    private Dette checkDetteEmprunt(Emprunt emprunt){
        long amtOfDaysLate = emprunt.getDateDeRetour().until(LocalDate.now(), ChronoUnit.DAYS);
        return setNewDette(emprunt, amtOfDaysLate);
    }

    private Dette setNewDette(Emprunt e, long daysLate){
        Dette dette = Dette.builder().dette(daysLate * 0.25).client(this).build();
        dette.getEmpruntsEndettes().add(e);
        dettes.add(dette);
        return dette;
    }

    private boolean checkHasDebts(){
        return !this.dettes.isEmpty();
    }



}
