public class CheckPerfectNumber {
 
    public static void main(String[] args) {
        
        int x=1, y=22;
        int[] result = new int[y];
		int index = 0;
		for(int i=x; i <= y ; i++){
			if(isPerfect(i)){
				result[index++] = i;		
			}
		}
        for(int i=0; i < y ; i++){
            System.out.print(result[i]+" , ");
        }

    }

    private static boolean isPerfect(int num){
		boolean isPerfect = true;
		String strNumber = Integer.toString(num);
		char[] chars = strNumber.toCharArray();
		for(int i=0; i<chars.length; i++){
			int numiricValue = Character.getNumericValue(chars[i]);
			if(numiricValue != 0 && num % numiricValue != 0){
				isPerfect = false;
			}
		}
		return isPerfect;
	}

}
