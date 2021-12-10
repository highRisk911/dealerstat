package com.company.dealerstat.service.game;

import com.company.dealerstat.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> findAllGames();

    Game findGame(int gameId);

    void addGame(Game game);
}