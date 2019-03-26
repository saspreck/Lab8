import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BoardGameTest {
	
	BoardGame clue = new BoardGame();
	
	@Test
	public void addPlayerTest() {
		
		Assert.assertTrue("Player added incorrectly", clue.addPlayer("Alexa", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM));
		Assert.assertFalse("That game piece is already taken", clue.addPlayer("Alexa", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM));
	}
	
	@Test
	public void getPlayerGamePieceTest() {
		clue.addPlayer("John", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		
		Assert.assertEquals("Wrong game piece returned", GamePiece.MAGENTA_RACER, clue.getPlayerGamePiece("John"));
	}
	
	@Test
	public void getPlayerWithGamePieceTest() {
		clue.addPlayer("Ryan", GamePiece.RED_THIMBLE, Location.LOUNGE);
		
		Assert.assertEquals("Wrong player returned", "Ryan", clue.getPlayerwithGamePiece(GamePiece.RED_THIMBLE));
	}
	
	@Test
	public void movePlayerTest() {
		clue.addPlayer("Kate", GamePiece.YELLOW_BOOT, Location.LIBRARY);
		clue.movePlayer("Kate", Location.HALL);
		
		Assert.assertEquals("Player moved incorrectly", Location.HALL, clue.getPlayersLocation("Kate"));
	}
	
	@Test
	public void moveTwoPlayersTest() {
		clue.addPlayer("Jane", GamePiece.RED_THIMBLE, Location.DINING_ROOM);
		clue.addPlayer("James", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		String[] playerNames1 = {"Jane", "James"};
		Location[] newLocations1 = {Location.BILLIARD_ROOM, Location.CONSERVATORY};
		String[] expected1 = {"James", "Jane"};
	
		Assert.assertArrayEquals("Incorrect player moved first", expected1, clue.moveTwoPlayers(playerNames1, newLocations1));
		
		clue.addPlayer("Steve", GamePiece.RED_RACER, Location.BALLROOM);
		clue.addPlayer("Hannah", GamePiece.YELLOW_BOOT, Location.BILLIARD_ROOM);
		
		String[] playerNames2 = {"Steve", "Hannah"};
		Location[] newLocations2 = {Location.HALL, Location.KITCHEN};
		String[] expected2 = {"Steve", "Hannah"};
		
		Assert.assertArrayEquals("Incorrect player moved first", expected2, clue.moveTwoPlayers(playerNames2, newLocations2));
	}
	
	@Test
	public void getPlayersLocationTest() {
		clue.addPlayer("Joe", GamePiece.MAGENTA_RACER, Location.LIBRARY);
		
		Assert.assertEquals("Player at incorrect location", Location.LIBRARY, clue.getPlayersLocation("Joe"));
	}
	
	@Test
	public void getPlayersAtLocationTest() {
		clue.addPlayer("Steve", GamePiece.GREEN_BOOT, Location.BALLROOM);
		clue.addPlayer("Hannah", GamePiece.YELLOW_BOOT, Location.BILLIARD_ROOM);
		clue.addPlayer("Matt", GamePiece.BLUE_RACER, Location.BALLROOM);
		
		ArrayList<String> players = new ArrayList<String>();
		players.add("Steve");
		players.add("Matt");
		
		Assert.assertEquals("Incorrect players added to arraylist", players, clue.getPlayersAtLocation(Location.BALLROOM));
	}
	
	
	@Test
	public void getGamePiecesAtLocationTest() {
		clue.addPlayer("Steve", GamePiece.GREEN_BOOT, Location.BALLROOM);
		clue.addPlayer("Hannah", GamePiece.YELLOW_BOOT, Location.BILLIARD_ROOM);
		clue.addPlayer("Matt", GamePiece.BLUE_RACER, Location.BALLROOM);
		
		ArrayList<GamePiece> gamePieces = new ArrayList<GamePiece>();
		gamePieces.add(GamePiece.GREEN_BOOT);
		gamePieces.add(GamePiece.BLUE_RACER);
		
		Assert.assertEquals("Incorrect game pieces added to arraylist", gamePieces, clue.getGamePiecesAtLocation(Location.BALLROOM));
	}
	
	@Test
	public void getPlayersTest() {
		clue.addPlayer("Steve", GamePiece.GREEN_BOOT, Location.BALLROOM);
		clue.addPlayer("Hannah", GamePiece.YELLOW_BOOT, Location.BILLIARD_ROOM);
		clue.addPlayer("Matt", GamePiece.BLUE_RACER, Location.BALLROOM);
		
		Set<String> players = new HashSet<String>();
		players.add("Steve");
		players.add("Hannah");
		players.add("Matt");
		
		Assert.assertEquals("Incorrect players in game", players, clue.getPlayers());
	}
	
	@Test
	public void getPlayerLocationsTest() {
		clue.addPlayer("Steve", GamePiece.GREEN_BOOT, Location.BALLROOM);
		clue.addPlayer("Hannah", GamePiece.YELLOW_BOOT, Location.BILLIARD_ROOM);
		clue.addPlayer("Matt", GamePiece.BLUE_RACER, Location.BALLROOM);
		
		Set<Location> locations = new HashSet<Location>();
		locations.add(Location.BALLROOM);
		locations.add(Location.BILLIARD_ROOM);
		
		Assert.assertEquals("Incorrect locations", locations, clue.getPlayerLocations());
	}
	
	@Test
	public void getPlayerPiecesTest() {
		clue.addPlayer("Steve", GamePiece.GREEN_BOOT, Location.BALLROOM);
		clue.addPlayer("Hannah", GamePiece.YELLOW_BOOT, Location.BILLIARD_ROOM);
		clue.addPlayer("Matt", GamePiece.BLUE_RACER, Location.BALLROOM);
		
		Set<GamePiece> pieces = new HashSet<GamePiece>();
		pieces.add(GamePiece.GREEN_BOOT);
		pieces.add(GamePiece.YELLOW_BOOT);
		pieces.add(GamePiece.BLUE_RACER);
		
		Assert.assertEquals("Incorrect pieces", pieces, clue.getPlayerPieces());
	}
	

}
