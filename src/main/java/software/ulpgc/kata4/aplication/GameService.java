package software.ulpgc.kata4.aplication;

import software.ulpgc.kata4.domain.Game;

import java.util.*;

public class GameService {
    Map<String, Game> games = new HashMap<>();

    public List<Game> getAllGames(){
        return new ArrayList<>(games.values());
    }

    public Optional<Game> getGameById(String id){
        return Optional.ofNullable(games.get(id));
    }

    public Game addGame(Game game){
        if(game == null || game.getId() == null || game.getTitle() == null) return
        if(games.get(game.getId())) {
            return
        }
        games.put(game.getId(), game);
        return game;
    }
}
