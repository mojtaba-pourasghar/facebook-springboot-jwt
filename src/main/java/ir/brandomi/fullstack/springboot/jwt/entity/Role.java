package ir.brandomi.fullstack.springboot.jwt.entity;

import ir.brandomi.fullstack.springboot.jwt.model.ERole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

    public ERole getName() {
        return name;
    }
}
