package al420445.models.Users;

import al420445.models.Library.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employe {


    @Id
    @GeneratedValue
    private int id;

    private String user;

    private String password;

    Role role;



    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void viewUserList(Client c){
        if(isAdmin()){
            for(Document document : c.getDocuments()){
                System.out.println(document.toString());
            }
        }
    }

    private boolean isAdmin(){
        return this.getRole() == Role.ADMIN;
    }
}
