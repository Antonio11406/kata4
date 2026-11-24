package software.ulpgc.kata4.aplication;

import software.ulpgc.kata4.domain.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameService {
    Map<String, Game> games = new HashMap<>();

    public Optional<Game> getGameById(String id){
        return Optional.ofNullable(games.get(id));
    }

    public Game add(Game game){
        if (game.getId() == null || game == null) throw new IllegalArgumentException("no juego");
        if (games.containsKey(game.getId())) throw new IllegalArgumentException("repetido");
        games.put(game.getId(), game);
        return game;
    }
}
