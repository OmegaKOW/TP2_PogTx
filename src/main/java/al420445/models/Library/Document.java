package al420445.models.Library;

import al420445.models.Users.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class Document {
    @Id
    @GeneratedValue
    long documentID;

    private int documentType; //1 for Livre, 2 for Media

    private String title;

    private String author;

    private String editor;

    private long exemplaires;

    private int releaseYear;

    private Client rentedBy;



    public long getDocumentID() {
        return documentID;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }


    private LocalDate checkDocumentType() {
        if(this.documentType == 1){
            return LocalDate.now().plusDays(21);
        }
        else{
            return LocalDate.now().plusDays(checkMediaType());
        }
    }

    private int checkMediaType() {
        if(this.getClass() == Media.class){
            MediaType mt = ((Media) this).getType();
            if(mt == MediaType.DVD){
                return 7;
            }else{
                return 14;
            }
        }
        return 0;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    public Client getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(Client rentedBy) {
        this.rentedBy = rentedBy;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", documentType=" + documentType +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentedBy=" + rentedBy +
                '}';
    }
}
