package anstar.StepTrello.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Table(name = "role1")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue( strategy = AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

}
