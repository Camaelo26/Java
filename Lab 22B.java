// Macarthur Diby
//lab 22B
//program that returns the differents substrings of a string and its longest string






class Main{
static String longestsubstringinside(String words ){
//declarea variable to create a string
String word1 = words.charAt(0)+"";
String word = word1;
//for loop to iterate through all the present characters
for(int i=1;i<words.length();i++){
//if statement to check if the actual character is big than the previous
if(words.charAt(i)>words.charAt(i-1)){
word1 = word1+words.charAt(i);
}
//Print the  substrings
else{
System.out.println("substring : "+word1);
word1 = words.charAt(i)+"";
}
// if statement to update the maximum word 
if(word1.length()>word.length()){
word = word1;
}
}

System.out.println("substring : "+word1);
return word;
}
public static void main(String[] args) {
System.out.println("The longest substring in the string (adgannoooqrbbrow) : "+longestsubstringinside("adgannoooqrbbrow\n"));
System.out.println("Our different substrings are  ");
System.out.println();
System.out.println("The longest substring in the string(Macarthurlechat) : "+longestsubstringinside("Macarthurlechat\n"));
}
}
