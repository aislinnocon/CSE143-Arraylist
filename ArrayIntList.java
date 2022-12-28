public class ArrayIntList { //implements IntList
   private int[] data; // array of integers
   private int size;   // current number of elements in the list

   public static final int CAPACITY = 20;
   
   public ArrayIntList() {
      data = new int[CAPACITY];
      size = 0; 
   }
   
   public void add(int value) {
      checkCapacity(size + 1);
      data[size] = value;
      size++;
   }   
   
   // toString - print out info
   public String toString() {
      if(size == 0) {
         return "[]";
      } else {
         String result = "[" + data[0];
         for(int i = 1; i < size; i++) {
            result += ", " + data[i];
         }
         result += "]";
         return result;
      }
   }
   	
   public int size() {
      return size;
   } 
   
   public int get(int index) {
      checkIndex(index);
      return data[index];
   } 
   
   public int indexOf(int value) {
      for(int i = 0; i < size; i++) {
         if(data[i] == value) {
            return i;
         }
      }
      return -1;
   }

   // Pre: Method called in Main to add a value at a specific index
   // Post: Throws the check capacity exception if the added value would exceed
   //       the array capacity
   public void add(int index, int value) {
      checkCapacity(size + 1);
      size++;
      for(int i = size; i > index; i--) {
         data[i] = data[i-1];
      }
      data[index] = value;     
   }
   
   // Pre: Method called in main to remove a value at a certain index
   // Post: Throws a check index exception if the index at which the value is going
   //       to be removed doesn't exist in this array
   public void remove(int index) {
      checkIndex(index);
      data[index] = 0;
      for(int i = index; i < size; i++) {
         data[i] = data[i +1];
      }  
      size--;
   }
   
   // post: throws an IndexOutOfBoundsException if the given index is
   //       not a legal index of the current list
   private void checkIndex(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("index: " + index);
      }
   }

   // post: checks that the underlying array has the given capacity,
   //       throwing an IllegalStateException if it does not
   private void checkCapacity(int capacity) {
      if (capacity > data.length) {
         throw new IllegalStateException("would exceed list capacity");
      }
   }
   
   public boolean equals(Object o) {
      // self check
      if (this == o) 
         return true; 
      // null check
      if (o == null)
         return false;
      // type check and cast
      if (getClass() != o.getClass())
         return false;
      ArrayIntList list = (ArrayIntList) o;
      // list size comparison
      if (size != list.size()) {
         return false;
      }
      // Value of each element comparison
      for (int x = 0; x < size; x++) {
         if (data[x] != list.get(x)) {
            return false;
         }
      }
      return true;
   
   } 
}