package util;

import java.util.Comparator;

import model.Question;

public class DifficultyComparator implements Comparator<Question> {

	@Override
	public int compare(Question q1, Question q2) {
		if(q1.getDifficulty()>q2.getDifficulty())
			return 1;
		if(q1.getDifficulty()==q2.getDifficulty())
			return 0;
		return -1;
	}

}
