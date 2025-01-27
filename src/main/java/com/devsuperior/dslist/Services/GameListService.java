// Camada de serviço que faz a lógica do banco de dados como regra de negócios requisitos funcionais etc (devolve o DTO para o controlador)
//Retorna um DTO

package com.devsuperior.Dslist.Services;

import java.util.List;

import com.devsuperior.Dslist.Dto.GameDTO;
import com.devsuperior.Dslist.Dto.GameListDTO;
import com.devsuperior.Dslist.Entities.Game;
import com.devsuperior.Dslist.Entities.GameList;
import com.devsuperior.Dslist.projections.GameMinProjection;
import com.devsuperior.Dslist.repositories.GameListRepository;
import com.devsuperior.Dslist.repositories.GameRepository;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //componente, é necessário definir como componente. Ela é usada para indicar que uma classe é um "serviço" dentro da camada de negócios de uma aplicação.
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId,int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj); 

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? sourceIndex  : destinationIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i );
        }
    }
}
