package fr.insalyon.telecom.mgl.RomanNumberConverter;

public class RomanNumberConverter{
	//http://stackoverflow.com/questions/9073150/converting-roman-numerals-to-decimal
    int convert(String romanNumber){
		
		if (romanNumber == null) {
			throw new IllegalArgumentException("who cannot be null");
		}
        int decimal = 0;
		int lastNumber = 0;
		String romanNumeral = romanNumber.toUpperCase();

		for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
            case 'M':
                decimal = processDecimal(1000, lastNumber, decimal);
                lastNumber = 1000;
                break;

            case 'D':
                decimal = processDecimal(500, lastNumber, decimal);
                lastNumber = 500;
                break;

            case 'C':
                decimal = processDecimal(100, lastNumber, decimal);
                lastNumber = 100;
                break;

            case 'L':
                decimal = processDecimal(50, lastNumber, decimal);
                lastNumber = 50;
                break;

            case 'X':
                decimal = processDecimal(10, lastNumber, decimal);
                lastNumber = 10;
                break;

            case 'V':
                decimal = processDecimal(5, lastNumber, decimal);
                lastNumber = 5;
                break;

            case 'I':
                decimal = processDecimal(1, lastNumber, decimal);
                lastNumber = 1;
                break;
                
             default :
				throw new IllegalArgumentException("Number unreckognized");
        }
    }
		return decimal;

    }
    
    private int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		}
		else {
			return lastDecimal + decimal;
		}
	}
	
    String convert(int number){
		String huns[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

		StringBuilder result= new StringBuilder();
		int it=0;
		
		while(number >= 1000){
			result.append("M");
			number-=1000;
			}
		result.append(huns[number/100]); number=number%100;
		result.append(tens[number/10]); number=number%10;
		result.append(ones[number]);
			
        return result.toString();
    }

}
