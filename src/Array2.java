import java.util.Scanner;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
	private long[] a; // ref to array a
	private int nElems; // number of data items

	// -----------------------------------------------------------

	public HighArray(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// -----------------------------------------------------------
	public boolean find(long searchKey) { // find specified value
		int j;
		for (j = 0; j < nElems; j++)
			// for each element,
			if (a[j] == searchKey) // found item?

				break; // exit loop before end
		if (j == nElems) // gone to end?
			return false; // yes, can’t find it
		else
			return true; // no, found it
	} // end find()

	// -----------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// -----------------------------------------------------------
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			// look for it
			if (value == a[j])
				break;
		if (j == nElems) // can’t find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++)
				// move higher ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// ------------------------------------------------------------

	public void bubbleSort() {

		long temp = 0;
		for (int i = nElems; i > 0; i--) {
			for (int j = 0; j < nElems - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}// end Bubble Sort()

	public void selectionSort() {
		int out, in, min;
		for (out = 0; out < nElems - 1; out++) // outer loop
		{
			min = out; // minimum
			for (in = out + 1; in < nElems; in++)
				// inner loop
				if (a[in] < a[min]) // if min greater,
					min = in; // we have a new min
			swap(out, min);
		}
	}

	// ------------------------------------------------------------

	private void swap(int one, int two) {
		long temp;
		temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

	// -----------------------------------------------------------

	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++)
			// for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println(" ");
	}
	// -----------------------------------------------------------
} // end class HighArray
// //////////////////////////////////////////////////////////////

class Array2 {
	public static void main(String[] args)

	{
		int maxSize = 100; // array size
		HighArray arr; // reference to array
		arr = new HighArray(maxSize); // create the array
		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display(); // display items

		System.out
				.println(" Which sort \n 1. Selection Sort \n    Or \n 2. Bubble Sort"
						+ "kar diya \n");

		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		switch (input) {
		case 1:
			System.out.println("Sorted Array using Selection sort: ");
			arr.selectionSort();
			arr.display();
			System.out.println(" ");
			break;

		case 2:
			System.out.println("Sorted Array using Bubble sort: ");
			arr.bubbleSort();
			arr.display();
			System.out.println(" ");

			break;

		default:
			break;
		}

		int searchKey = 35; // search for item
		if (arr.find(searchKey))
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can’t find " + searchKey);
		arr.delete(00); // delete 3 items
		arr.delete(55);
		arr.delete(99);
		arr.display(); // display items again
	} // end main()
} // end class HighArrayApp
// /////////////////////////////////////////////////////////////