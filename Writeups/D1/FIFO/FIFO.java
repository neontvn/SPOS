import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FIFO
{
	private Scanner sc;
	
	public void execute()
	{
		sc = new Scanner(System.in);
		System.out.println("Enter the number of pages: ");
		int numPages=sc.nextInt();
		int pages[] = new int[numPages];
		System.out.println("Enter Reference String: ");
		for(int i=0; i<numPages; i++)
		{
			pages[i]=sc.nextInt();
		}
		
		System.out.println("Enter the number of frames: ");
		int capacity = sc.nextInt();
		
		HashSet<Integer> frames = new HashSet<>(capacity);	
		
		Queue<Integer> index = new LinkedList<>();	
		
		int pageFaults = 0;
		int hits = 0;
		for(int i=0; i<numPages; i++)
		{
			if(frames.size() < capacity)	
			{
				if(!frames.contains(pages[i]))	
				{
					frames.add(pages[i]);
					index.add(pages[i]);	
					pageFaults++;
					for(int j:index)
						System.out.print(j+"\t");
					System.out.println();
				}
				else
				{
					hits++;
				}
			}
			else	
			{
				if(!frames.contains(pages[i]))	
				{
					int val = index.peek();
					index.poll();
					frames.remove(val);
					
					frames.add(pages[i]);
					index.add(pages[i]);
					pageFaults++;
					for(int j:index)
						System.out.print(j+"\t");
					System.out.println();
				}
				else	
				{
					hits++;
				}
			}
		}
		
		System.out.println("Number of Page Faults: "+pageFaults);
		System.out.println("Hits:\t"+hits);
		System.out.println("Hit ratio: "+((double)hits/(double)numPages));
	}
	
	public static void main(String[] args)
	{
		FIFO fifo = new FIFO();
		fifo.execute();
	}
}
