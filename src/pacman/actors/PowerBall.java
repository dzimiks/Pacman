package pacman.actors;

import java.awt.Rectangle;

import pacman.PacmanActor;
import pacman.PacmanGame;
import pacman.enums.State;

/**
 * @author dzimiks
 */
public class PowerBall extends PacmanActor {

	private int col;
    private int row;
    private boolean eated;
    
    public PowerBall(PacmanGame game, int col, int row) {
        super(game);
        this.col = col;
        this.row = row;
    }

    @Override
    public void init() {
        loadFrames("/res/powerBall.png");
        x = col * 8 + 1 - 32;
        y = (row + 3) * 8 + 1;
        collider = new Rectangle(0, 0, 4, 4);
        eated = true;
    }

    @Override
    public void update() {
        visible = !eated && (int) (System.nanoTime() * 0.0000000075) % 2 == 0;
        
        if (eated || game.getState() == State.PACMAN_DIED) 
            return;
        
        if (game.checkCollision(this, Pacman.class) != null) {
            eated = true;
            visible = false;
            game.addScore(50);
            game.startGhostVulnerableMode();
        }
    }
    
    @Override
    public void stateChanged() {
        if (game.getState() == State.TITLE ||
            game.getState() == State.LEVEL_CLEARED ||
            game.getState() == State.GAME_OVER) {
            eated = true;
        }
        else if (game.getState() == State.READY) {
            eated = false;
            visible = true;
        }
    }

    public void hideAll() {
        visible = false;
    }
}