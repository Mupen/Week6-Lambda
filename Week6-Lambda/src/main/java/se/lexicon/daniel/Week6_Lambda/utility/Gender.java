package se.lexicon.daniel.Week6_Lambda.utility;

public enum Gender {
    MALE,FEMALE;

    public String toString(){
        return this.name().toLowerCase();
    }


}