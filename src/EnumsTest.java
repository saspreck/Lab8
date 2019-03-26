import org.junit.Assert;
import org.junit.Test;


public class EnumsTest {
	
	@Test
	public void RedRacerTest() {
		GamePiece redRacer = GamePiece.RED_RACER;
		
		Assert.assertEquals("Incorrect color returned", Color.RED, redRacer.getColor());
		Assert.assertEquals("Incorrect shape returned", Shape.RACECAR, redRacer.getShape());
	}
	
	@Test
	public void BlueRacerTest() {
		GamePiece blueRacer = GamePiece.BLUE_RACER;
		
		Assert.assertEquals("Incorrect color returned", Color.BLUE, blueRacer.getColor());
		Assert.assertEquals("Incorrect shape returned", Shape.RACECAR, blueRacer.getShape());
	
	}
	
	@Test
	public void MagentaRacerTest() {
		GamePiece magentaRacer = GamePiece.MAGENTA_RACER;
		
		Assert.assertEquals("Incorrect color returned", Color.MAGENTA, magentaRacer.getColor());
		Assert.assertEquals("Incorrect shape returned", Shape.RACECAR, magentaRacer.getShape());
	}
	
	@Test
	public void RedThimbleTest() {
		GamePiece redThimble = GamePiece.RED_THIMBLE;
		
		Assert.assertEquals("Incorrect color returned", Color.RED, redThimble.getColor());
		Assert.assertEquals("Incorrect shape returned", Shape.THIMBLE, redThimble.getShape());
	}
	
	@Test
	public void BlueBootTest() {
		GamePiece blueBoot = GamePiece.BLUE_BOOT;
		
		Assert.assertEquals("Incorrect color returned", Color.BLUE, blueBoot.getColor());
		Assert.assertEquals("Incorrect shape returned", Shape.BOOT, blueBoot.getShape());
	}
	
	@Test
	public void GreenBootTest() {
		GamePiece greenBoot = GamePiece.GREEN_BOOT;
		
		Assert.assertEquals("Incorrect color returned", Color.GREEN, greenBoot.getColor());
		Assert.assertEquals("Incorrect shape returned", Shape.BOOT, greenBoot.getShape());
	}
	
	@Test
	public void YellowBootTest() {
		GamePiece yellowBoot = GamePiece.YELLOW_BOOT;
		
		Assert.assertEquals("Incorrect color returned", Color.YELLOW, yellowBoot.getColor());
		Assert.assertEquals("Incorrect shape returned", Shape.BOOT, yellowBoot.getShape());
	}
	
	@Test
	public void movesFirstTest() {
		Assert.assertEquals("Incorrect piece moved first", GamePiece.RED_RACER, GamePiece.movesFirst(GamePiece.RED_RACER, GamePiece.YELLOW_BOOT));
		Assert.assertEquals("Incorrect piece moved first", GamePiece.BLUE_RACER, GamePiece.movesFirst(GamePiece.GREEN_BOOT, GamePiece.BLUE_RACER));
		
	}
	
	@Test
	public void GamePieceToStringTest() {
		Assert.assertEquals("Incorrect toString", "RED_THIMBLE: a RED THIMBLE with priority 10", GamePiece.RED_THIMBLE.toString());
	}
}

