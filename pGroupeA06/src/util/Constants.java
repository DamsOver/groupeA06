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
	public static final List<Double> PLAYER_01_POSITIONS_X = new ArrayList<>(Arrays.asList(91.));
	public static final List<Double> PLAYER_01_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.));
	
	public static final List<Double> PLAYER_02_POSITIONS_X = new ArrayList<>(Arrays.asList(137.));
	public static final List<Double> PLAYER_02_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.));
	
	public static final List<Double> PLAYER_03_POSITIONS_X = new ArrayList<>(Arrays.asList(183.));
	public static final List<Double> PLAYER_03_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.));
	
	public static final List<Double> PLAYER_04_POSITIONS_X = new ArrayList<>(Arrays.asList(229.));
	public static final List<Double> PLAYER_04_POSITIONS_Y = new ArrayList<>(Arrays.asList(150.));
	
	public static final List<Double> PLAYER_05_POSITIONS_X = new ArrayList<>(Arrays.asList(91.));
	public static final List<Double> PLAYER_05_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.));
	
	public static final List<Double> PLAYER_06_POSITIONS_X = new ArrayList<>(Arrays.asList(137.));
	public static final List<Double> PLAYER_06_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.));
	
	public static final List<Double> PLAYER_07_POSITIONS_X = new ArrayList<>(Arrays.asList(183.));
	public static final List<Double> PLAYER_07_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.));
	
	public static final List<Double> PLAYER_08_POSITIONS_X = new ArrayList<>(Arrays.asList(229.));
	public static final List<Double> PLAYER_08_POSITIONS_Y = new ArrayList<>(Arrays.asList(200.));
	
}
