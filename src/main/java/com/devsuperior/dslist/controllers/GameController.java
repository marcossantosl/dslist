//Responsável por controlar a API, ele expoe os endpoints para os elementos externos, ele chama o serviço que chama o repósito qu por ultimo chama o banco de dados


package com.devsuperior.Dslist.controllers;

import java.util.List;

import com.devsuperior.Dslist.Dto.GameMinDTO;
import com.devsuperior.Dslist.Entities.*;
import com.devsuperior.Dslist.Services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //A anotação @RestController é uma combinação das anotações @Controller e @ResponseBody. Ela é usada para definir uma classe como um controlador que lida com requisições HTTP e retorna dados diretamente no corpo da resposta, geralmente em formato JSON ou XML.
@RequestMapping(value = "/games") //Mapear o Recurso

public class GameController {
    
    @Autowired
    private GameService gameService;
    
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
                return result;  
    }
}
