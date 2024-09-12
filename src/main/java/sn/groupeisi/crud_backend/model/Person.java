package sn.groupeisi.crud_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String  id;
    private String name;
    private String email;
    private String password;
}
