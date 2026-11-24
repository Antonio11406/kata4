package software.ulpgc.kata4.adapter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import software.ulpgc.kata4.aplication.GameService;

import io.javalin.http.Context;
import software.ulpgc.kata4.domain.Game;

import java.util.Map;

public class GameController {
    private final GameService service;
    private final Gson gson;

    public GameController(GameService service) {
        this.service = service;
        this.gson = new Gson();
    }

    public void getAll(Context ctx){
        String json = gson.toJson(service.getAllGames());
        ctx.status(200).contentType("application/json").result(json);
    }

    public void getById(Context ctx){
        String id = ctx.pathParam("id");
        service.getGameById(id).ifPresentOrElse(
                game ->  ctx.status(200).contentType("application/json").result(gson.toJson(game)),
                () -> ctx.status(404).contentType("application/json").result(gson.toJson(Map.of("error", "juego no encontrado"))));
    }

    public void create(Context ctx){
        try{
            Game newGame = gson.fromJson(ctx.body(), Game.class);
            Game saved = service.addGame(newGame);
            ctx.status(201)
                .contentType("application/json")
                .result(gson.toJson(saved));

        } catch (JsonSyntaxException e) {
            ctx.status(400)
                .contentType("application/json")
                .result(gson.toJson(Map.of("error", "Formato JSON inválido")));
        } catch (IllegalArgumentException e) {
            ctx.status(400)
                .contentType("application/json")
                .result(gson.toJson(Map.of("error", e.getMessage())));
        }
    }
}
