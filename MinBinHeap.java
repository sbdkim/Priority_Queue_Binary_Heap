package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private int position;
  private static final int arraySize = 10000; 

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); 
    int position = 0;
  }
    
  void siftUP(EntryPair entry){
	  int blank = size;
	  for (array[0] = entry;
		  entry.getPriority() < (array[blank/2].getPriority());
			  blank /= 2 ){
		  
		  array[blank] = array[blank/2];
	  }
	  array[blank] = entry;	  
  }
  
  public void siftDown(int blank){
	  EntryPair temp = array[blank];
	  int child;
	  for( ;blank*2 <=size; blank = child){
		  child =blank*2;
		  if(child != size && array[child+1].getPriority()<array[child].getPriority()){
			child++;
		  }
		  if(array[child].getPriority()<temp.getPriority()){
			  array[blank] = array[child];
		  }
		  else
			  break;
	  }
	  array[blank] = temp;
  }
  
  
@Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

@Override
public void insert(EntryPair entry) {
	size++;
	position++;
	array[size]=entry;
	siftUP(entry);
}

@Override
public void delMin() {
	// TODO Auto-generated method stub
	if(array[1] == null){
		return;
	}
	array[1] = array[size];
	array[size] = null;
	size--;
	position--;
	siftDown(1);
}

@Override
public EntryPair getMin() {
	return array[1];
}

@Override
public int size() {
	return size;
}

@Override
public void build(EntryPair[] entries) {
	for(int i=1; i <= entries.length; i++){
		array[i] = entries[i-1];
		size++;
		position++;
	}
	for(int i = size/2; i > 0; i--){
		siftDown(i);
	}
}

}