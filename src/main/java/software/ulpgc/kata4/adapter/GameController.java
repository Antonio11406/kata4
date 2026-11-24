package software.ulpgc.kata4.adapter;

import com.google.gson.Gson;
import io.javalin.http.Context;
import software.ulpgc.kata4.aplication.GameService;

import java.util.Map;

public class GameController {
    private final GameService service;
    private final Gson gson;

    public GameController(GameService service) {
        this.service = service;
        this.gson = new Gson();
    }

    public void getGameById(Context ctx){
        String id = ctx.pathParam("id");
        service.getGameById(id).ifPresentOrElse(game ->
            ctx.status(200).contentType("application/json").result(gson.toJson(game)),
            () -> ctx.status(404)
                    .contentType("application/json")
                    .result(gson.toJson(Map.of("error", "juego no encontrado")))
        );
    }
}
