package OneThousand;
import java.util.Scanner;

public class littleprincess1004 {
    public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int length = scanner.nextInt();
		scanner.nextLine();

	    for (int i = 0; i < length; i++){
		String base = scanner.nextLine();
			
		int x_start = Integer.parseInt(base.split(" ")[0]);
		int y_start = Integer.parseInt(base.split(" ")[1]);
		
		int x_end = Integer.parseInt(base.split(" ")[2]);
		int y_end = Integer.parseInt(base.split(" ")[3]);
			
			int count = scanner.nextInt();
			scanner.nextLine();

            int through = 0;
			
			for (int j = 0; j < count; j++){
				String circle = scanner.nextLine();
				
			    int x = Integer.parseInt(circle.split(" ")[0]);
			    int y = Integer.parseInt(circle.split(" ")[1]);
				int r = Integer.parseInt(circle.split(" ")[2]);
				
				boolean hasStartContain = hasContain(x_start, y_start, x, y, r);
			    boolean hasEndContain = hasContain(x_end, y_end, x, y, r);
				
				if (!(hasStartContain && hasEndContain) && (hasStartContain || hasEndContain)){
				    through++;
				}
			}
			
		System.out.println(through);
		}
		
		scanner.close();
	}
	private static boolean hasContain(int xo, int yo, int x, int y, int r)
	{
		return Math.sqrt(Math.pow(x - xo, 2) + Math.pow(y - yo, 2)) < r;
	}
}