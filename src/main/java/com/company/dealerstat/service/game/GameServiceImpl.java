package com.company.dealerstat.service.game;

import com.company.dealerstat.database.repository.game.GameRepository;
import com.company.dealerstat.entity.Game;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService{

    public GameRepository gameRepository;

    @Override
    public List<Game> findAllGames() {
        return gameRepository.getAllGames();
    }

    @Override
    public Game findGame(int gameId) {
        return gameRepository.getGame(gameId);
    }

    @Override
    public void addGame(Game game) {
        gameRepository.addGame(game);
    }
}