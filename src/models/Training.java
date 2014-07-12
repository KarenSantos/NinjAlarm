package models;

import java.util.List;

public class Training {
	
	private StopButton stopButton;
	private List<Match> rank;
	
	public Training (StopButton stopButton) {
		this.stopButton = stopButton;
	}
	
	public void addMatch(Match match) {
		rank.add(match);
	}

	public List<Match> getRank() {
		return rank;
	}

	public void setRank(List<Match> rank) {
		this.rank = rank;
	}

	public StopButton getStopButton() {
		return stopButton;
	}

	public void setStopButton(StopButton stopButton) {
		this.stopButton = stopButton;
	}
	
	

}
