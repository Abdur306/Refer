package edu.disease.asn5;

public class Container<T> {
	/**
	 * By declaring the property using generic type, the class can be made specific during
	 * the time of usage.
	 */
	T[] t;
	
	/**
	 * 
	 * The container is generic, which means, this constructor is capable to accepting 
	 * any java data type as parameter.
	 * and more over it is declared as varargs, which means it can accept any number of arguments.
	 */
public Container(T... t) {
	// TODO Auto-generated constructor stub
	if(t.length==0) {
		throw new IllegalArgumentException("No constructor argument supplied in container class...");
	}
	this.t=t;
	
}
/**
 * This method return the size of the parameters supplied in the constructor
 * @return
 */
public int size() {
	return this.t.length;
}
/**
 * This method returns the value associated with the array using the index supplied.
 * @param i
 * @return
 */
public T get(int i) {
	if(i>=t.length) {
		throw new IllegalArgumentException("supply a value lesser than..."+t.length);
	}
	return t[i];
}


}
