import java.lang.Math;

public class Hashtable 
{
	
	private Node[] arr;
	
	public Hashtable() 
	{

		this.arr = new Node[100000]; //initiates the array

	} //constructor

	class Node 
	{
		private String key; 
		private String value;
		private Node next;
		
		public Node(String key, String value)
		{

			this.key = key;

			this.value = value;

			this.next = null;

		} // node

	} //class node

	//puts the string in the position
	public void put(String key, String val) 
	{
		int pos = Math.abs(key.hashCode()) % arr.length; //gets position

		Node h = arr[pos]; //gets the head

		Node s = new Node(key, val); 

		s.next = h;

		arr[pos] = s;

	} //put

	//removes the string and returns the string that is being removed
	public String remove(String key) 
	{

		int pos = Math.abs(key.hashCode()) % arr.length;

		Node h = arr[pos]; //head
		
		if(h == null) 
		{

			return null;

		} //if
		
		if(h.key.equals(key)) 
		{

			arr[pos] = h.next;
			return h.value;

		} //if
		
		Node p = h;

		while(h != null) 
		{

			if(h.key.equals(key)) 
			{
				p.next = h.next;

				return h.value;
			} //if

			p = h;
			
			h = h.next;

		} //while

		return null;
		
	} //remove

	public boolean containsKey(String key) 
	{
		if(arr[Math.abs(key.hashCode()) % arr.length] == null)
		{

			return false;

		}

		return true;

	} //containsKey

	public String get(String key) 
	{
		int pos = Math.abs(key.hashCode()) % arr.length;

		Node h = arr[pos];

		if(h == null)
		{ 

			return null;

		} //if

		while(h != null) 
		{

			if(h.key.equals(key))
			{

				return h.value;

			} //if

			h = h.next;
 
		} //while

		return null;
	} //get

} //Hashtable



