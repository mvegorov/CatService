package org.example;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String breed;

    @Enumerated(EnumType.STRING)
    private CatColor color;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @ManyToMany
    @JoinTable(
            name = "cat_friends",  // Указываем промежуточную таблицу
            joinColumns = @JoinColumn(name = "cat_id1"),  // Связь с текущим котом
            inverseJoinColumns = @JoinColumn(name = "cat_id2")  // Связь с его друзьями
    )
    private List<Cat> friends;

    public Cat(String name, CatColor color, Owner owner) {
        this.name = name;
        this.color = color;
        this.owner = owner;
    }

    public Cat() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public CatColor getColor() { return color; }
    public void setColor(CatColor color) { this.color = color; }

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public List<Cat> getFriends() { return friends; }
    public void setFriends(List<Cat> friends) { this.friends = friends; }
}