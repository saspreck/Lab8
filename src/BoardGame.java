import java.util.LinkedHashMap;
import javax.tools.DocumentationTool.Location;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Class to define a board game. Contains methods to add a player, get players and their pieces, 
 * move players, and get the locations of the players and their pieces 
 * @author skylersprecker
 * @version 2019-03-20
 *
 */
public class BoardGame {
	
	//Hash map to store the names of the players and the pieces assigned to them
	protected LinkedHashMap<String, GamePiece> playerPieces;
	
	//Hash map to store the locations of the players
	protected LinkedHashMap<String, Location> playerLocations;
	
	/**
	 * Constructor for the BoardGame class. Initializes the playerPieces and playerLocations hash maps.
	 */
	public BoardGame() {
		playerPieces = new LinkedHashMap<String, GamePiece>();
		
		playerLocations = new LinkedHashMap<String, Location>();
	}
	
	/**
	 * Method to add a player to the game and assign them a game piece and starting location
	 * Checks to see if the game piece is not already taken. If it is the method returns false, otherwise it returns true
	 * @param playerName
	 * @param gamePiece
	 * @param initialLocation
	 * @return gamePieceTaken
	 */
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation) {
		
		boolean gamePieceTaken;
		
		//checks to see if the hash map already contains the game piece and if it doesn't adds the player and game piece
		if(!playerPieces.containsValue(gamePiece)) {
			playerPieces.put(playerName, gamePiece);
			gamePieceTaken = true;
			//puts the player in their initial location
			playerLocations.put(playerName, initialLocation);
		}
		else {
			gamePieceTaken = false;
		}
		
		return gamePieceTaken;
	}
	
	/**
	 * Method to get the game piece associated with a player given their name
	 * @param playerName
	 * @return playerPieces.get(playerName)
	 */
	public GamePiece getPlayerGamePiece(String playerName) {
		return playerPieces.get(playerName);
	}
	/**
	 * Method to return the player assigned with a game piece given the game piece.
	 * @param gamePiece
	 * @return name
	 */
	public String getPlayerwithGamePiece(GamePiece gamePiece) {
		
		//iterates through the set of the player names
		for(String name : this.playerPieces.keySet()) {
			//get the piece assigned to the player and checks to see if it matches the given one
			if(this.playerPieces.get(name).equals(gamePiece)) {
				return name;
			}
		}
		return null;	
	}
	
	/**
	 * Method to move a player to a new location, replaces their location in the hash map
	 * @param playerName
	 * @param newLocation
	 */
	public void movePlayer(String playerName, Location newLocation) {
		playerLocations.replace(playerName, newLocation);
	}
	
	/**
	 * Compares the player's game pieces and determines which one should move first.
	 * Return an array with the order they were moved in.
	 * @param playerNames
	 * @param newLocations
	 * @return moveOrder
	 */
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations) {
		
		//string array to store the order the players are moved in
		String[] moveOrder = new String[2];
		
		//get the pieces associated with the player names
		GamePiece player1Piece = playerPieces.get(playerNames[0]);
		GamePiece player2Piece = playerPieces.get(playerNames[1]);
		
		//determines which piece should move first
		GamePiece firstMove = GamePiece.movesFirst(player1Piece, player2Piece);
		
		//checks if the first player's piece should move first or not
		if(firstMove.equals(player1Piece)) {
			//moves players in the correct order and returns the order they were moved in
			playerLocations.replace(playerNames[0], newLocations[0]);
			playerLocations.replace(playerNames[1], newLocations[1]);
			return playerNames;
		}
		else {
			//moves players in the correct order, adds their names to the string array, and returns the array
			playerLocations.replace(playerNames[1], newLocations[1]);
			playerLocations.replace(playerNames[0], newLocations[0]);
			moveOrder[0] = playerNames[1];
			moveOrder[1] = playerNames[0];
			return moveOrder;
		}
	}
	
	/**
	 * Gets the current location of the player's game piece
	 * @param player
	 * @return playerLocations.get(player)
	 */
	public Location getPlayersLocation(String player) {
		return playerLocations.get(player);
	}
	
	/**
	 * Method to get the players that are at a certain location
	 * @param loc
	 * @return  playersAtLocation
	 */
	public ArrayList<String> getPlayersAtLocation(Location loc){
		//ArrayList to store the players at the location
		ArrayList<String> playersAtLocation = new ArrayList<String>();
		
		//iterates through set of player names
		for(String name : this.playerLocations.keySet()) {
			//adds the player to the arraylist if their location matches the given one
			if(this.playerLocations.get(name).equals(loc)) {
				playersAtLocation.add(name);
			}
		}
		return playersAtLocation;
	}
	
	/**
	 * Method to get the game pieces at a certain location
	 * @param loc
	 * @return piecesAtLocation
	 */
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc){
		//ArrayList to store the game pieces
		ArrayList<GamePiece> piecesAtLocation = new ArrayList<GamePiece>();
		
		//iterates through the set of player names
		for(String name : this.playerLocations.keySet()) {
			//adds the game piece to the arraylist if the player it is assigned to is at the given location
			if(this.playerLocations.get(name).equals(loc)) {
				piecesAtLocation.add(playerPieces.get(name));
			}
		}
		return piecesAtLocation;
	}
	
	/**
	 * Method to get the players of the game
	 * @return playerPieces.keySet()
	 */
	public Set<String> getPlayers() {
		return playerPieces.keySet();
	}
	
	/**
	 * Method to get the locations of the players
	 * @return a hashset with the players' locations
	 */
	public Set<Location> getPlayerLocations() {
		return new HashSet<Location>(playerLocations.values());
	}
	
	/**
	 * Method to get the game pieces of the players
	 * @return a hashset with the players' game pieces 
	 */
	public Set<GamePiece> getPlayerPieces() {
		return new HashSet<GamePiece>(playerPieces.values());
	}

}
