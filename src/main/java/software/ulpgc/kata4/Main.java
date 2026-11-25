package software.ulpgc.kata4;

import io.javalin.Javalin;
import software.ulpgc.kata4.adapter.GameController;
import software.ulpgc.kata4.aplication.GameService;
import software.ulpgc.kata4.domain.Game;
import software.ulpgc.kata4.domain.Genre;
import software.ulpgc.kata4.domain.Platform;

public class Main {
    static void main() {
        GameService gameService = new GameService();
        gameService.addGame(new Game("1", "Super Mario 64", Platform.N64, 1996, Genre.PLATFORMER));

        // 2. Creamos el adaptador web
        GameController controller = new GameController(gameService);

        // 3. Arrancamos Javalin y registramos las rutas
        Javalin app = Javalin.create().start(8080);

        app.get("/games", controller::getAll);
        app.get("/games/{id}", controller::getById);
        app.post("/games", controller::create);
    }
}
