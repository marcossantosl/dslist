// Camada de serviço que faz a lógica do banco de dados como regra de negócios requisitos funcionais etc (devolve o DTO para o controlador)
//Retorna um DTO

package com.devsuperior.Dslist.Services;

import java.util.List;
import com.devsuperior.Dslist.Dto.GameMinDTO;
import com.devsuperior.Dslist.Entities.Game;
import com.devsuperior.Dslist.repositories.GameRepository;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service //componente, é necessário definir como componente. Ela é usada para indicar que uma classe é um "serviço" dentro da camada de negócios de uma aplicação.
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        var result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();//Cria uma lista do tipo game mindto que em que todo objeto que era x original que era game transforma em new gamemindto passando x como argumento e transforma em uma lista de dto
        return dto;
    }
}
