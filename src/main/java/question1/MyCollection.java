package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
	}

	public int search(int searchingNum) {
		int initialPosition=-1;
		for(int i=0;i < elementsAvailableInArray();i++) {
			if(numArray[i] == searchingNum) {
				initialPosition = i;
				break;
			}
		}
		return initialPosition;
	}

	public boolean add(int numberToAdd) {
		
		int size = elementsAvailableInArray();
	
		if(size!=numArray.length && search(numberToAdd) == -1) {
			numArray[size] = numberToAdd;
			return true;
		}
		else if(size == numArray.length) {
			doubleCapacity();
			size = elementsAvailableInArray();
			numArray[size] = numberToAdd;
			return true;
		}
		return false;
	}

	public void doubleCapacity() {
		int[] maxArray = new int[numArray.length*2];
		for(int i=0; i<numArray.length; i++) {
			maxArray[i] = numArray[i];
		}
		numArray = maxArray;
	}

	public boolean remove(int numberToRemove) {
		int index  =  search(numberToRemove);
		if(index!= -1) {
		for(int i = index; i < elementsAvailableInArray()-1;i++) {
			numArray[i]=numArray[i+1];
		}
		numArray[elementsAvailableInArray()- 1] = 0;
		return true;
		}
		return false;
	}

	public int getCount() {
		return elementsAvailableInArray();
	}

	public int[] rotate(int n) {
		int[] dummy_array =new int[n];
		
		for(int i=0;i<n;i++) {
			dummy_array[i]=numArray[i];
		}
		for(int i=n;i<elementsAvailableInArray();i++) {
			numArray[i-n]=numArray[i];
		}
		for(int i=0;i<n;i++) {
			numArray[elementsAvailableInArray()-n+i]=dummy_array[i];
		}
		
		
		return null;
	}
	
	public String toString() {
		String array="{";
		for(int i=0;i<elementsAvailableInArray();i++) {
			array=array+Integer.toString(numArray[i])+",";
		}
		if(array.charAt(array.length()-1)==',') {
			array=array.substring(0, array.length()-1);
		}
		array=array+"}";
		return array;
	}
	
	private int elementsAvailableInArray() {
		int count=0;
		for(int i=0;i<numArray.length;i++) {
			if(numArray[i]!= 0)
				count++;
		}
		return count;
	}
	

}
