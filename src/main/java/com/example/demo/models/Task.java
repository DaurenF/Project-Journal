package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "tasks")
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "Name must be filled")
    private String name;
    @Column(name = "month")
    private int month;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
