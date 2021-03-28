package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constants {
	public static final double 	INITIAL_VOLUME = 50,
								VOLUME_FACTOR = 0.001,
								INITIAL_VOLUME_EFFECTS = 50,
								VOLUME_EFFECTS_FACTOR = 0.004;
	
	public static final int NB_QUESTIONS_MAX = 4,
							SIZE_MAX_QUESTION = 65,
							NB_PLAYER = 8,
							ANIMATION_TIME_START = 1000, //3000
							ANIMATION_TIME_RATING = 1000,//2500
							ANIMATION_TIME_ERROR = 1000, //3000
							ANIMATION_TIME_TURN = 3000,
							ANIMATION_TIME_MESSAGE = 3500,
							ANIMATION_TIME_ANSWER=1500,
							ANIMATION_MOVEMENT = 750,
							TIMER_START = 35,
							TIMER_LIMIT = 10,
							STRING_PERCENTAGE_ERROR_ANSWER=20,
							NUMBER_PERCENTAGE_ERROR_ANSWER=2; 
	
	public static final String 	DECK_PATH = "deck.JSON",
								BOARD_PATH= "board.JSON",
								RULE_PATH= "/res/GameRule.txt",
								MUSIC_1_PATH= "musics/bensound-hipjazz.wav",
								CORRECT_ANSWER= "musics/CorrectAnswer.wav",
								INCORRECT_ANSWER= "musics/InCorrectAnswer.wav";
	
	// Size Players	
	public static final double 	PLAYER_HEIGHT = 100, PLAYER_WIDTH = 100;
	
}
