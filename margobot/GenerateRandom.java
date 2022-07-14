import java.util.Random;

public class GenerateRandom {
    public static int main(int x, int y) {
      Random rand = new Random();
      int random = rand.nextInt(y-x+1)+x; 
      return random;
    }
}