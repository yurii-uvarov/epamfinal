package ua.nure.uvarov.Practice6.part1;

public class Word implements Comparable<Word> {
	private String word;
	
	private int frequency;

	public Word(String word) {
		this.word = word;
		frequency = 1;
	}
	public String getWord() {
		return word;
	}
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	@Override
	public int compareTo(Word o) {
		return frequency - o.getFrequency();
	}
	public boolean equals(Word o){
		return word.equals(o.getWord());
	}

}
