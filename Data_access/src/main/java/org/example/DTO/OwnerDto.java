package org.example.DTO;


import org.example.Owner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OwnerDto {

    private String name;
    private LocalDate birthDate;
    private List<CatDto> cats;

    public OwnerDto(Owner owner) {
        this.id = owner.getId();
        this.name = owner.getName();
        this.birthDate = owner.getBirthDate();
        this.cats = owner.getCats().stream()
                .map(CatDto::new)
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<CatDto> getCats() {
        return cats;
    }

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCats(List<CatDto> cats) {
        this.cats = cats;
    }
}
