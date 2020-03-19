class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        String cleanedString = stringToVerify.replaceAll("-", "");

        if (cleanedString.length() != 10) return false;

        int checkCharacter = cleanedString.contains("X") ? 10 : Character.getNumericValue(cleanedString.charAt(9));

        if (checkCharacter > 9 && cleanedString.charAt(9) != 'X') {
            return false;
        }

        int checksum = 0;

        for (int i = 0, multiplier = 10; i < cleanedString.length(); i++, multiplier --) {
            
            int currentDigit = 0;
            
            if (i == 9) {
                currentDigit = checkCharacter;
            } else {
                currentDigit = Character.getNumericValue(cleanedString.charAt(i));
            }
            checksum += currentDigit * multiplier;
        }


        return checksum % 11 == 0;
    }

}
