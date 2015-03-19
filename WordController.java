import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//Max Mattoon
//
public class WordController {

	private String fileName;
	private ArrayList<Word> words = new ArrayList<Word>();   //Casting 
	
	
	public WordController(String _fileName) {
		// TODO Auto-generated constructor stub
	
		fileName=_fileName;
		readFile();
		getUserInputWord();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordController controller = new WordController("F:/small.txt");
		
		
		
	}
	
	private void getUserInputWord()
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a word: ");
		
		String input = reader.nextLine();
		
		// int rowNumber=reader.nextInt();
		
		if (words.contains(new Word(input,"")))
		{
			System.out.println("Word found in ArrayList ");
			Word userWord= words.get(words.indexOf(new Word(input," " )));	
			System.out.println("The Lemma "+ userWord.getLemma() +"  appears  "+userWord.getCount()+" times");	
			System.out.println("Is the Lemma capitalized?  "+userWord.isCap());
					}
		else System.out.println("Not in Array List");
		

	}

	private void readFile()
	{
	System.out.println(fileName);
	BufferedReader br = null;
	 
	try {

		String sCurrentLine;

		br = new BufferedReader(new FileReader(fileName));

		
		while ((sCurrentLine = br.readLine()) != null) {
		StringTokenizer st=	new StringTokenizer(sCurrentLine,"/");
		
		String lemma = st.nextToken();
		String pos = st.nextToken();
		
		Word currentWord = new Word(lemma, pos);
		
		if (words.contains(currentWord))
		{
			int index= words.indexOf(currentWord);
			Word found =words.get(index);
			found.incrementCounter();
			
				}
		
		//else{
		
		
		
		words.add(currentWord);
	
	//code below used to check raw file data to see how many times the lemma appears to verify getUserInput value.
		
	//System.out.println("Current Lemma :  "+lemma + "   Current POS :  "+pos);
	//Word userWord= words.get(words.indexOf(new Word(lemma," " )));	
	//System.out.println("The Lemma "+ userWord.getLemma() +"  appears  "+userWord.getCount()+" times");	
	
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
	
	}
	

