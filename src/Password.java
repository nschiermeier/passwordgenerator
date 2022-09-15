import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Password {

    private int length;
    private boolean symbols;
    private boolean numbers;
    private String letterCase;



    public Password(int length, boolean symbols, boolean numbers, String letterCase) {
        this.length = length;
        this.symbols = symbols;
        this.numbers = numbers;
        this.letterCase = letterCase;
    }

    public String generatePassword() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        String password = "";
        int randomChar = 0;
        char tempChar = ' ';
        int randomNum = 0;
        int randomSymbols = 0;
        int i = 0;
        while (i < length) {
            int randomInt = rand.nextInt(3);
            if (randomInt == 0) {
                switch (letterCase) {
                    case ("Uppercase"):
                        randomChar = rand.nextInt(26);
                        randomChar += 65;
                        tempChar = (char) randomChar;
                        password = password.concat(String.valueOf(tempChar));
                        i++;
                        break;
                    case ("Lowercase"):
                        randomChar = rand.nextInt(26);
                        randomChar += 97;
                        tempChar = (char) randomChar;
                        password = password.concat(String.valueOf(tempChar));
                        i++;
                        break;
                    case ("Both"):
                        int randomInt2 = rand.nextInt(2);
                        randomChar = rand.nextInt(26);
                        if (randomInt2 == 0) {
                            randomChar += 65;
                        }
                        else {
                            randomChar += 97;
                        }
                        tempChar = (char) randomChar;
                        password = password.concat(String.valueOf(tempChar));
                        i++;
                        break;
                }
            } else if (randomInt == 1) {
                if (numbers) {
                    randomNum = rand.nextInt(10);
                    password = password.concat(String.valueOf(randomNum));
                    i++;
                }

            } else if (randomInt == 2) {
                if (symbols) {
                    ArrayList<String> symbols = new ArrayList<String>();
                    String[] symbolList = new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_",
                            "=", "+", "[", "{", "]", "}", ",", "<", ".", ">", "/", "?"};
                    randomSymbols = rand.nextInt(24);
                    password = password.concat(symbolList[randomSymbols]);
                    i++;
                }
            }

        }
        return password;
    }
}
