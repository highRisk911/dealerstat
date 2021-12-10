package com.company.dealerstat.database.repository.game;

import com.company.dealerstat.entity.Game;

import java.util.List;

public interface GameRepository {

    List<Game> getAllGames();

    Game getGame(int gameId);

    void addGame(Game game);
}