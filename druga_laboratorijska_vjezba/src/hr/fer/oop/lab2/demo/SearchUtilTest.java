package hr.fer.oop.lab2.demo;
import hr.fer.oop.lab2.FootballPlayer;
import hr.fer.oop.lab2.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;
import hr.fer.oop.lab2.SearchUtil;



public class SearchUtilTest {
	public static void main(String[] args) {

		final int TEST_MAX_SIZE = 14;
		SimpleFootballPlayerCollection collection = new SimpleFootballPlayerCollectionImpl(TEST_MAX_SIZE);

		for (int i = 0; i < TEST_MAX_SIZE -2 ; i++) {
			if( i % 4 == 0 ) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 1, 1, PlayingPosition.GK);
				collection.add(sequentialPlayer);
			}
			if( i % 4 == 1 ) {
				FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 2, 2, PlayingPosition.DF);
					collection.add(sequentialPlayer);
			}
			if( i % 4 == 2 ) {
				FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 3, 3, PlayingPosition.FW);
					collection.add(sequentialPlayer);
			}
			if( i % 4 == 3 ) {
				FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 4, 4, PlayingPosition.MF);
					collection.add(sequentialPlayer);
			}
		}
		
		printPlayerNames(collection);
		SimpleFootballPlayerCollection collection2 = SearchUtil.retirevePlayingPositionPlayers(collection, PlayingPosition.DF);
		System.out.println("igraci koji igraju na poziciji DF" + "\n");
		printPlayerNames(collection2);
		collection2 = SearchUtil.retriveAboveMedianSkillPlayers(collection);
		System.out.println("ovo su igraci bolji od madiana" + "\n");
		printPlayerNames(collection2);
		FootballPlayer p = SearchUtil.retrieveLowSkilledPlayer(collection, PlayingPosition.DF);
		System.out.println("najgori igrac koji igra na poziciji DF je " + p.getName() + "\n");
		
	}
	
	
	public static void printPlayerNames(SimpleFootballPlayerCollection players) {
		String output = "";
		for (FootballPlayer player : players.getPlayers()) {
			if(player!=null)
			output += player.getName() + " " + player.getPlayingPosition() + " " + player.getPlayingSkill() + "\n";
		}
		System.out.println(output);
	}
}

