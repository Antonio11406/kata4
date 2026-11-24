package software.ulpgc.kata4.adapter;

import com.google.gson.Gson;
import io.javalin.http.Context;
import software.ulpgc.kata4.aplication.GameService;

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
}
