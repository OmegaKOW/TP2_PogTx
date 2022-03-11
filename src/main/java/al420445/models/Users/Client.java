package al420445.models.Users;

import al420445.models.Library.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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








    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public double getDebt() {
        return debt;
    }

    public boolean isHasDebt() {
        return hasDebt;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void setHasDebt(boolean hasDebt) {
        this.hasDebt = hasDebt;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    private void addDocument(Document document) {
        this.documents.add(document);
    }

    private void removeDocument(Document d){
        this.documents.remove(d);
    }

    public void rentDocument(Document d){
        if(checkHasDebt()){
            printInDebtRental();
        }
        else{
            setDocumentRentedBy(d);
            addDocument(d);
        }
    }

    private int getPeriod(LocalDate from, LocalDate to){
        Period period = Period.between(from, to);
        return period.getDays();
    }

    private void setDocumentRentedBy(Document d) {
        d.setRentedBy(this);
    }


    private void printInDebtRental(){
        System.out.println("Location Impossible. Vous avez une dette de : " + getDebt());
    }

    private boolean checkHasDebt(){
        return isHasDebt();
    }


}
