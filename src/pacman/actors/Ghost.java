package pacman.actors;

import pacman.PacmanActor;
import pacman.PacmanGame;
import pacman.view.ShortestPathFinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dzimiks
 */
public class Ghost extends PacmanActor {

	public Pacman pacman;
    public int type;
    public int cageUpDownCount;
    public Point[] initialPositions = {new Point(18, 11), new Point(16, 14), 
    								   new Point(18, 14), new Point(20, 14)};
    public static enum Mode { 
    	CAGE,
    	NORMAL,
    	VULNERABLE, 
    	DIED 
    }
    
    public Mode mode = Mode.CAGE;
    
    public int dx;
    public int dy;
    public int col;
    public int row;
    public int direction = 0;
    public int lastDirection;
    
    public List<Integer> desiredDirections = new ArrayList<Integer>();
    public int desiredDirection;
    public static final int[] backwardDirections = {2, 3, 0, 1};
    public long vulnerableModeStartTime;
    public boolean markAsVulnerable;
    
    // Using path finder just to return the ghost to the center (cage)
    public ShortestPathFinder pathFinder; 
	
	public Ghost(PacmanGame game, Pacman pacman, int type) {
        super(game);
        this.pacman = pacman;
        this.type = type;
        this.pathFinder = new ShortestPathFinder(game.maze);
    }
}