import java.util.Scanner;

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			Scanner input = new Scanner(line);
			String encode = "";
			int index = 0;
			while(input.hasNext()){
				String word = input.next();
				int spaces = 0;
				for(int i = index; line.charAt(i) == ' '; i++){
					spaces++;
				}
				index += word.length() + spaces;  

				if(check(word)){
					encode += addSpace(spaces) + vowel(word);
				}else if(!check(word) && word.matches("^[a-zA-Z0-9]+[^a-zA-Z0-9]*$")){
					encode += addSpace(spaces) + nonVowel(word);
				}else{
					encode += addSpace(spaces) + word;
				}
			}

			System.out.println(encode);
		}
	}

	public static boolean check(String s){
		return s.matches("^[aeiouAEIOU][a-zA-Z0-9]*$");
	}

	public static String vowel(String s){
		if(checkEnd(s)){
			return s.substring(0, s.length() - 1) + "ay" + s.charAt(s.length() - 1);
		}

		return s + "ay";
	}

	public static String nonVowel(String s){
		if(checkEnd(s)){
			return s.substring(1, s.length() - 1) + s.charAt(0) + "ay" + s.charAt(s.length() - 1);
		}

		return s.substring(1, s.length()) + s.charAt(0) + "ay";
	}

	public static boolean checkEnd(String s){
		return s.matches("^[a-zA-Z0-9]+[^a-zA-Z0-9]$");
	}

	public static String addSpace(int spaces){
		if(spaces <= 0){
			return "";
		}

		return " " + addSpace(spaces - 1);
	}
}