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

    private String title;

    private String author;

    private String editor;

    private long exemplaires;

    private int releaseYear;




    public long getDocumentID() {
        return documentID;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
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



    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
