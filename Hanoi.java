public class TowerOfHanoi {

  
    public static void hanoi(int n, char source, char auxiliary, char destination) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

      
        hanoi(n - 1, source, destination, auxiliary);

        
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        
        hanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; 
        hanoi(numberOfDisks, 'A', 'B', 'C');
    }
}
