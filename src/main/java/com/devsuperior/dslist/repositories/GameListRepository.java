//Camada de acesso a dados, faz a ocnsulta do banco de dados e devolve para  aclasse do services

package com.devsuperior.Dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.Dslist.Entities.Game;
import com.devsuperior.Dslist.Entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
