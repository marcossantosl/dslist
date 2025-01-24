//Responsável por controlar a API, ele expoe os endpoints para os elementos externos, ele chama o serviço que chama o repósito qu por ultimo chama o banco de dados


package com.devsuperior.Dslist.controllers;

import java.util.List;

import com.devsuperior.Dslist.Dto.GameListDTO;
import com.devsuperior.Dslist.Dto.GameMinDTO;
import com.devsuperior.Dslist.Entities.*;
import com.devsuperior.Dslist.Services.GameListService;
import com.devsuperior.Dslist.Services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //A anotação @RestController é uma combinação das anotações @Controller e @ResponseBody. Ela é usada para definir uma classe como um controlador que lida com requisições HTTP e retorna dados diretamente no corpo da resposta, geralmente em formato JSON ou XML.
@RequestMapping(value = "/lists") //Mapear o Recurso

public class GameListController {
    
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;
    
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll(); //Lista de objetos do tipo game list DTO
                return result;  
    }

      @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
                return result;  
    }
}
