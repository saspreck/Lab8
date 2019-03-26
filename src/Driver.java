import java.util.Arrays;
public class Driver {
	
	public static void main (String [] args) {
		BoardGame clue = new BoardGame();
				
		clue.addPlayer("John", GamePiece.BLUE_BOOT, Location.BALLROOM);
		clue.addPlayer("Alexa", GamePiece.RED_RACER, Location.DINING_ROOM);
		
		//prints outcome of adding player with same game piece as existing player
		System.out.println(clue.addPlayer("Bill", GamePiece.BLUE_BOOT, Location.BILLIARD_ROOM));
		
		//prints the game piece assigned to John
		System.out.println(clue.getPlayerGamePiece("John"));
		
		//prints the player assigned to red racer
		System.out.println(clue.getPlayerwithGamePiece(GamePiece.RED_RACER));
		
		//prints the location of Alexa
		System.out.println(clue.getPlayersLocation("Alexa"));
		
		clue.movePlayer("Alexa", Location.HALL);
		//prints Alexa's new location
		System.out.println(clue.getPlayersLocation("Alexa"));
		
		String[] playerNames = {"John", "Alexa"};
		Location[] newLocations = {Location.CONSERVATORY, Location.STUDY};
		String[] moveOrder = clue.moveTwoPlayers(playerNames, newLocations);
		
		//prints the array containing the order in which the players were moved
		System.out.println(Arrays.toString(moveOrder));
		
		clue.addPlayer("Matt", GamePiece.BLUE_RACER, Location.CONSERVATORY);
		
		//prints all players at the conservatory
		System.out.println(clue.getPlayersAtLocation(Location.CONSERVATORY));
		
		//prints the game pieces at the conservatory
		System.out.println(clue.getGamePiecesAtLocation(Location.CONSERVATORY));
		
		//prints out all the players in the game
		System.out.println(clue.getPlayers());
		
		//prints out the locations of all the players in the game
		System.out.println(clue.getPlayerLocations());
		
		//prints out the game pieces of all the players in the game
		System.out.println(clue.getPlayerPieces());
	}

}
