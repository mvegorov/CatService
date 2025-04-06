package org.example.DTO;


import org.example.CatColor;

public class FriendDto {
    private int id;
    private String name;
    private CatColor color;

    public FriendDto(int id, String name, CatColor color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
