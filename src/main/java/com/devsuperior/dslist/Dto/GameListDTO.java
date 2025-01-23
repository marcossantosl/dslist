package com.devsuperior.Dslist.Dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.Dslist.Entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;
    
    public GameListDTO() {
    }

    public GameListDTO(GameList entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
