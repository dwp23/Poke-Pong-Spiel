package Controller;

import Model.GameState;
import Model.PokePongModel;
import Model.PongData;
import View.IPokePongView;

public class PokePongController implements  IPokePongController{
    private IPokePongView view;
    private PokePongModel model;



    public void setPokePongView(IPokePongView view){
        this.view = view;
    }
    public void setPokePongModel(PokePongModel model){
        this.model = model;
    }


    public void nextFrame(){

    }

    public void handleDisplay(){
        switch (model.getData().getState()){
            case START ->{
                view.drawStartScreen();
            }
            case PLAYING -> {

                model.initialisePlayer();

                view.drawPlayer1((float) (model.getPlayer1().getPosition().getX()-model.p1.getSize()/2.0 - model.getPADDLE_WIDTH()),model.getPlayer1().getPosition().getY(),model.getPlayer1().getSize(),model.getPlayer1().getSize());
                view.drawPaddle1(model.getPlayer1().getPosition().getX() - model.getPADDLE_WIDTH(),(float)( model.getPlayer1().getPosition().getY()- model.p1.getSize()/2.0),model.getPADDLE_WIDTH(),model.getPlayer1().getSize());
                view.drawPlayer2((float) (model.getPlayer2().getPosition().getX() + model.p2.getSize()/2.0 + model.getPADDLE_WIDTH()),model.getPlayer2().getPosition().getY(),model.getPlayer2().getSize(),model.getPlayer2().getSize());
                view.drawPaddle2(model.getPlayer2().getPosition().getX(),(float) (model.getPlayer2().getPosition().getY() - model.p2.getSize()/2.0),model.getPADDLE_WIDTH(),model.getPlayer2().getSize());
                view.drawBallImage(model.getData().getBall().getPosition().getX(),model.getData().getBall().getPosition().getY(),model.getData().getBall().getRotationAngle(),model.getData().getBall().getSize());

                model.handleCollisions();
                updateBallPosition();




            }
            case GAME_OVER -> {
                view.drawGameOverScreen();
                model.startNewGame();
            }
            default -> throw new IllegalStateException("Unexcepted value: " + model.getState());


        }




    }

    public void getStartGame(){
        model.startNewGame();
    }

    private void updateBallPosition() {
        model.getData().getBall().updateBallPosition(1.0 / view.getFramerate());
    }

    public void handleUserInput(){
    }


    public void movePlayer1Up(){
        double b = Math.max((double) (model.getPlayer1().getSize()/2.0), (double)model.getPlayer1().getPosition().getY() - 10);
        model.getPlayer1().getPosition().setY((float) b);
        System.out.println(model);
    }




    public void movePlayer1Down(){
        double   a = Math.min((double) (model.height - model.p1.getSize()/2.0),(double) (model.p1.getPosition().getY() + 10));
     model.getPlayer1().getPosition().setY((float) a);
        System.out.println(model.toString());

    }

    public void movePlayer2UP(){

        double c = Math.max(model.p2.getSize()/2.0,model.p2.getPosition().getY() - 10);
        model.getPlayer2().getPosition().setY((float) c);
        System.out.println(model.toString());

    }

    public void movePlayer2Down(){

        double d = Math.min(model.height -  model.getPlayer2().getSize()/2.0,model.getPlayer2().getPosition().getY() + 10);
        model.getPlayer2().getPosition().setY((float) d);
        System.out.println(model.toString());

    }

    public PokePongModel getModel(){
        return model;
    }


    public PongData getData(){
        return model.getData();
    }


    public void handleUserInput(char key1 , int key2){
        switch (model.getData().getState()) {
            case START, GAME_OVER -> {
                if(key1  == ' ') {

                    model.getData().setState(GameState.PLAYING);
                    getStartGame();
                }
            }
            case PLAYING -> {
                // Player 1: w = up and s = down
                if(key1 == 'w') {
                    movePlayer1Up();
                }
                if(key1 == 's'){
                    movePlayer1Down();
                }

                // Player 2: Up-key = up and Down-key = down
                if(key2 == 38) {
                    movePlayer2UP();
                }

                if(key2 == 40) {
                    movePlayer2Down();
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + model.getData().getState());
        }

    }
}
