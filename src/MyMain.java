import Controller.PokePongController;
import Model.PokePongModel;
import View.PokePongView;
import processing.core.PApplet;

public class MyMain {
    public  static  void main(String[] args){

        final int GAME_WIDTH = 900;
        final int GAME_HEIGHT = 600;

        var model = new PokePongModel(GAME_WIDTH,GAME_HEIGHT);
        var view = new PokePongView(GAME_WIDTH,GAME_HEIGHT);
        var controller = new PokePongController();



        // Connect M, V and C
        controller.setPokePongModel(model);
        controller.setPokePongView(view);
        view.setPokePongController(controller);


        PApplet.runSketch( new String[]{"PokePongView"},view);
    }
}
