package spring.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TheEntity {
    @Id
    Integer id;
}
