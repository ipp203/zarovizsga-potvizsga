package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        long numberOfDigits = s.chars()
                .filter(Character::isDigit)
                .count();
        return numberOfDigits > (double) s.length() / 2;
    }

}
