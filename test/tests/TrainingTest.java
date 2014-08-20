package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.Round;
import models.StopButton;
import models.Training;

public class TrainingTest {
	
	Training training;
	final int time = 10;
	StopButton stopButton;
	
	@Before
	public void setUp() {
		training = new Training();
		stopButton = new StopButton();
	}
	
	@Test
	public void ShouldBeAbleToAddRoundToRounds() {
		Round round1 = new Round(time, stopButton);
		training.addRound(round1);
		Round round2 = new Round(time, stopButton);
		training.addRound(round2);
		assertEquals(2, training.getRounds().size());
	}

	@Test
	public void ShouldAddAccordingTheCapacity() {
		Round round3 = new Round(time, stopButton);
		training.addRound(round3);
		Round round4 = new Round(time, stopButton);
		training.addRound(round4);
		Round round5 = new Round(time, stopButton);
		training.addRound(round5);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		training.addRound(round3);
		assertEquals(15, training.getRounds().size());
	}

}
