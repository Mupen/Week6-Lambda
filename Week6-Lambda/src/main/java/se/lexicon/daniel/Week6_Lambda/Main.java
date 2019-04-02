package se.lexicon.daniel.Week6_Lambda;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.Week6_Lambda.utility.CSVReader;
import se.lexicon.daniel.Week6_Lambda.utility.NameService;
import se.lexicon.daniel.Week6_Lambda.utility.Person;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	 //Getting the names from file
        List<String> femaleFirstNames = CSVReader.getFemaleFirstNames();
        List<String> maleFirstNames = CSVReader.getMaleFirstNames();
        List<String> lastNames = CSVReader.getLastNames();
        List<Person> persons = new ArrayList<Person>();
        
        //Instantiating a NameService object
        NameService ns = new NameService(maleFirstNames,femaleFirstNames,lastNames);

        //Creating 250 elements and add them to the list
        for(int i=0; i<250;i++){persons.add(ns.getNewRandomPerson());}

        Exercises test = new Exercises(persons);
        
        test.exercise1();
        test.exercise2();
        test.exercise3();
        test.exercise4();
        test.exercise5();
        test.exercise6();
        test.exercise7();
        test.exercise8();
        test.exercise9();
        test.exercise10();
        test.exercise11();
    }
}