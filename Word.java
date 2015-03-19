
public class Word {
	private String lemma;
	private String pos;
	private int counter;

	public Word(String _lemma, String _pos) {
		// TODO Auto-generated constructor stub
		
		lemma=_lemma;
		pos=_pos;
		counter=1;
		
		
	}
public void incrementCounter()
{
	counter++;
}
	public String getLemma()
	{
		return lemma;
		
	}
	
	public String getPos()
	{
		return pos;
		
	}
	
	public boolean equals(Object obj)
	{
		if (this.lemma.equals(((Word)obj).getLemma())){
			return true;
		}
		else return false;
	}
	
	//public boolean isCap()
	//{
	//	boolean character;
	//	return character;
	//}
	
	
	public int getCount()
	{
		return counter;
	}
	
	public boolean isCap()
	{
		
		return (Character.isUpperCase(lemma.charAt(0)));   //COOL
	}
		
	}
	

