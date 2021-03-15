package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constants {
	public static final double 	INITIAL_VOLUME = 0,
								VOLUME_FACTOR = 0.001;
	
	public static final int NB_QUESTIONS_MAX = 4,
							SIZE_MAX_QUESTION = 65,
							ANIMATION_TIME_START = 1000, //3000
							ANIMATION_TIME_RATING = 1000,//2500
							ANIMATION_TIME_ERROR = 1000, //3000
							ANIMATION_TIME_TURN = 1000, 
							TIMER_START = 35,
							TIMER_LIMIT = 5,
							STRING_PERCENTAGE_ERROR_ANSWER=20,
							NUMBER_PERCENTAGE_ERROR_ANSWER=2; 
	
	public static final String 	DECK_PATH = "deck.JSON",
								BOARD_PATH= "board.JSON";
	
	// Size Players	
	public static final double 	PLAYER_HEIGHT = 100, PLAYER_WIDTH = 100;
	
	// Position Players
	public static final List<Double> PLAYER_01_POSITIONS_X = new ArrayList<>(Arrays.asList(091.,091.,091.,091.,091.,111.,341.,341.,341.,341.,361.,595.,595.,595.,595.,625.,845.,845.,845.,845.,0875.,1097.,1097.,1097.,1097.,1127.,1347.,1347.,1347.,1347.,1367.,1599.,1599.,1599.,1599.,1649.));
	public static final List<Double> PLAYER_01_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.,290.,430.,580.,730.,880.,880.,730.,580.,430.,290.,290.,430.,580.,730.,880.,880.,730.,580.,430.,0290.,0290.,0430.,0580.,0730.,0880.,0880.,0730.,0580.,0430.,0290.,0290.,0430.,0580.,0730.,0880.));
	
	public static final List<Double> PLAYER_02_POSITIONS_X = new ArrayList<>(Arrays.asList(137.,137.,137.,137.,137.,157.,387.,387.,387.,387.,407.,641.,641.,641.,641.,671.,891.,891.,891.,891.,0921.,1143.,1143.,1143.,1143.,1173.,1393.,1393.,1393.,1393.,1413.,1645.,1645.,1645.,1645.,1695.));
	public static final List<Double> PLAYER_02_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.,290.,430.,580.,730.,880.,880.,730.,580.,430.,290.,290.,430.,580.,730.,880.,880.,730.,580.,430.,0290.,0290.,0430.,0580.,0730.,0880.,0880.,0730.,0580.,0430.,0290.,0290.,0430.,0580.,0730.,0880.));
	
	public static final List<Double> PLAYER_03_POSITIONS_X = new ArrayList<>(Arrays.asList(183.,183.,183.,183.,183.,203.,433.,433.,433.,433.,453.,687.,687.,687.,687.,717.,937.,937.,937.,937.,0967.,1189.,1189.,1189.,1189.,1219.,1439.,1439.,1439.,1439.,1459.,1691.,1691.,1691.,1691.,1741.));
	public static final List<Double> PLAYER_03_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.,290.,430.,580.,730.,880.,880.,730.,580.,430.,290.,290.,430.,580.,730.,880.,880.,730.,580.,430.,0290.,0290.,0430.,0580.,0730.,0880.,0880.,0730.,0580.,0430.,0290.,0290.,0430.,0580.,0730.,0880.));
	
	public static final List<Double> PLAYER_04_POSITIONS_X = new ArrayList<>(Arrays.asList(229.,229.,229.,229.,229.,249.,479.,479.,479.,479.,499.,733.,733.,733.,733.,763.,983.,983.,983.,983.,1013.,1235.,1235.,1235.,1235.,1265.,1485.,1485.,1485.,1485.,1505.,1737.,1737.,1737.,1737.,1787.));
	public static final List<Double> PLAYER_04_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.,290.,430.,580.,730.,880.,880.,730.,580.,430.,290.,290.,430.,580.,730.,880.,880.,730.,580.,430.,0290.,0290.,0430.,0580.,0730.,0880.,0880.,0730.,0580.,0430.,0290.,0290.,0430.,0580.,0730.,0880.));
	
	public static final List<Double> PLAYER_05_POSITIONS_X = new ArrayList<>(Arrays.asList(091.,091.,091.,091.,091.,111.,341.,341.,341.,341.,361.,595.,595.,595.,595.,625.,845.,845.,845.,845.,0875.,1097.,1097.,1097.,1097.,1127.,1347.,1347.,1347.,1347.,1367.,1599.,1599.,1599.,1599.,1649.));
	public static final List<Double> PLAYER_05_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.,340.,480.,630.,780.,930.,930.,780.,630.,480.,340.,340.,480.,630.,780.,930.,930.,780.,630.,480.,0340.,0340.,0480.,0630.,0780.,0930.,0930.,0780.,0630.,0480.,0340.,0340.,0480.,0630.,0780.,0930.));
	
	public static final List<Double> PLAYER_06_POSITIONS_X = new ArrayList<>(Arrays.asList(137.,137.,137.,137.,137.,157.,387.,387.,387.,387.,407.,641.,641.,641.,641.,671.,891.,891.,891.,891.,0921.,1143.,1143.,1143.,1143.,1173.,1393.,1393.,1393.,1393.,1413.,1645.,1645.,1645.,1645.,1695.));
	public static final List<Double> PLAYER_06_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.,340.,480.,630.,780.,930.,930.,780.,630.,480.,340.,340.,480.,630.,780.,930.,930.,780.,630.,480.,0340.,0340.,0480.,0630.,0780.,0930.,0930.,0780.,0630.,0480.,0340.,0340.,0480.,0630.,0780.,0930.));
	
	public static final List<Double> PLAYER_07_POSITIONS_X = new ArrayList<>(Arrays.asList(183.,183.,183.,183.,183.,203.,433.,433.,433.,433.,453.,687.,687.,687.,687.,717.,937.,937.,937.,937.,0967.,1189.,1189.,1189.,1189.,1219.,1439.,1439.,1439.,1439.,1459.,1691.,1691.,1691.,1691.,1741.));
	public static final List<Double> PLAYER_07_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.,340.,480.,630.,780.,930.,930.,780.,630.,480.,340.,340.,480.,630.,780.,930.,930.,780.,630.,480.,0340.,0340.,0480.,0630.,0780.,0930.,0930.,0780.,0630.,0480.,0340.,0340.,0480.,0630.,0780.,0930.));
	
	public static final List<Double> PLAYER_08_POSITIONS_X = new ArrayList<>(Arrays.asList(229.,229.,229.,229.,229.,249.,479.,479.,479.,479.,499.,733.,733.,733.,733.,763.,983.,983.,983.,983.,1013.,1235.,1235.,1235.,1235.,1265.,1485.,1485.,1485.,1485.,1505.,1737.,1737.,1737.,1737.,1787.));
	public static final List<Double> PLAYER_08_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.,340.,480.,630.,780.,930.,930.,780.,630.,480.,340.,340.,480.,630.,780.,930.,930.,780.,630.,480.,0340.,0340.,0480.,0630.,0780.,0930.,0930.,0780.,0630.,0480.,0340.,0340.,0480.,0630.,0780.,0930.));
	
}
