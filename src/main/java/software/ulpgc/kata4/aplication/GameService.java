package software.ulpgc.kata4.aplication;

import software.ulpgc.kata4.domain.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private final Map<String, Game> games = new HashMap<>();

    public List<Game> getAllGames() {
        return new ArrayList<>(games.values())
    }
}
