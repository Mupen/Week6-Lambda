package se.lexicon.daniel.Week6_Lambda.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonListGenerator {
	
	private static final PersonListGenerator INSTANCE;
	private NameService nameService = new NameService(CSVReader.getMaleFirstNames(),
			CSVReader.getFemaleFirstNames(), CSVReader.getLastNames());
	
	static {
		INSTANCE = new PersonListGenerator();
	}
	
	private PersonListGenerator() {}
	
	public static PersonListGenerator getInstance() {
		return INSTANCE;
	}
	
	public List<Person> getListOfPersons(int amount){
		List<Person> persons = new ArrayList<>();
		
		for(int i = 0; i<amount; i++) {
			persons.add(nameService.getNewRandomPerson());
		}
		return persons;		
	}
	
	public Set<Person> getSetOfPersons(int amount){
		Set<Person> persons = new HashSet<>();
		
		for(int i = 0; i<amount; i++) {
			persons.add(nameService.getNewRandomPerson());
		}
		
		return persons;
		
	}

}