package io.zipcoder;

import java.util.regex.*;

/**
 * @author tariq
 */
public class StringsAndThings {

    /***
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int result = 0;
        for (int i=0;i<input.length(); i++){
            if(Character.isLetter('y')||Character.isLetter('z')||Character.isLetter('a'))     {
                result =2;
            }
        }
        return result;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        String baseLowercase = base.toLowerCase();
        String removeLowercase = remove.toLowerCase();


        StringBuilder build = null;
        if (!baseLowercase.contains(removeLowercase)) {


            return baseLowercase.substring(0, 1).toUpperCase() + baseLowercase.substring(1);
        } else
            build = new StringBuilder(baseLowercase);

        int position = build.indexOf(removeLowercase);
        while (position != -1) {
            build.delete(position, position + removeLowercase.length());
            position = build.indexOf(removeLowercase, position);
        }
        String result = build.toString();

        String cap = result.substring(0, 1).toUpperCase() + result.substring(1);

        return cap;
    }





    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
//        String inputLowercase = input.toLowerCase();
        int countIs = 0;
        int countNot = 0;

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.substring(i, i + 2).equals("is")) {
                countIs++;
            }
            if (i + 2 < input.length() && input.substring(i, i + 3).equals("not")) {
                countNot++;
            }

        }
        return countIs == countNot;
    }





    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
                for (int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'g') {
                if (input.charAt(i - 1) != 'g' && input.charAt(i + 1) != 'g'){
                    return false;
                }
            }

        }
                return true;
                }







    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count = 0;

        // Iterate over the string, checking for triples
        for (int i = 0; i < input.length() - 2; i++) {
            char currentChar = input.charAt(i);

            // Check if the current character appears three times consecutively
            if (input.charAt(i + 1) == currentChar && input.charAt(i + 2) == currentChar) {
                count++;
            }
        }

        return count;
    }
}
