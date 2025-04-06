package org.example.DTO;

import org.example.Cat;

import java.time.LocalDate;
import java.util.List;

public class CatDto {

    private int id;
    private String name;
    private LocalDate birthDate;
    private String breed;
    private String color;
    private OwnerDto owner;   // DTO для отображения информации о владельце
    private List<CatDto> friends;  // DTO для отображения информации о друзьях кота

    public CatDto() {}

    public CatDto(int id, String name, LocalDate birthDate, String breed, String color, OwnerDto owner, List<CatDto> friends) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
        this.friends = friends;
    }

    public CatDto(Cat cat) {
        this.id = cat.getId();
        this.name = cat.getName();
        this.birthDate = cat.getBirthDate();
        this.breed = cat.getBreed();
        this.color = cat.getColor().toString();
        this.owner = new OwnerDto(cat.getOwner());
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public OwnerDto getOwner() { return owner; }
    public void setOwner(OwnerDto owner) { this.owner = owner; }

    public List<CatDto> getFriends() { return friends; }
    public void setFriends(List<CatDto> friends) { this.friends = friends; }
}
