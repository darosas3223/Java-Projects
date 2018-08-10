
public class TrimArray {
	
	/* This program removes elements from an array if an element is repeated more than n times.
	 * 
	 * If the program needs improvement, I'd like to hear what needs to be changed.
	 * 
	 *  - David Rosas
	 */
	
    public static int[] trim(int[] data, int n) {
    	
    	if(data.length > 99) {
    		return null;
    	}
    	
    	int[] tempData = data;
    	int[] newData = data;
    	int track = 0, check = 0, temp = 0, pos = 0;
    	boolean change = false;
    	
    	do {
    		temp = newData[check];
    		
    		for(int i = 0; i < newData.length; i++) {
    			if(temp == newData[i]) {
    				track++;
    			}
    		}
    		if(track > n) {
    			change = true;
    			for(int i = 0; i < newData.length; i++) {
    				if(temp != newData[i]) {
    					tempData[pos] = newData[i];
    					pos++;
    				}
    			}
				pos = 0;
    			newData = new int[newData.length - track];
    			for(int i = 0; i < newData.length; i++) {
    				newData[i] = tempData[i];
    			}
    		}
    		
			track = 0;
    		if(change) {
    			check = 0;
    			change = false;
    		}
    		else if(!change) {
    			check++;
    		}
    		if (check > newData.length - 1) {
    			change = true;
    		}
    	}while(!change);
    	for(int numb : newData) {
    		System.out.print(numb + ", ");
    	}
    	System.out.println();
    	return newData;
    }
    
    public static void main(String[] args) {
    	int[] data = { 
    			19, 60, 34, 10, 19, 54, 92, 28, 73, 43, 
    			54, 86, 87, 70, 84, 99, 65, 26, 30, 45, 
    			12, 7, 42, 76, 56, 8, 22, 5, 77, 14, 
    			52, 82, 37, 91, 54, 91, 8, 38, 34, 29, 
    			32, 24, 63, 50, 98, 66, 80, 50, 43, 35, 
    			36, 26, 86, 95, 100, 33, 89, 62, 28, 1, 
    			82, 93, 2, 11, 82, 78, 19, 50, 63, 59, 
    			29, 46, 83, 42, 26, 43, 62, 76, 4, 33, 
    			39, 37, 41, 64, 49, 1, 73, 17, 54, 63, 
    			65, 63, 33, 80, 26, 98, 45, 34, 75}; 
    	System.out.println(trim(data, 1));
    }
}