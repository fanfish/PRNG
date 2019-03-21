
/**
 * 32位线性同余随机数序列生成器
 *<link>https://rosettacode.org/wiki/Linear_congruential_generator/</link>
 */
public class LCGRandomSequence {
	private int seed;
	private static final long MAX_BOUND=2147483648L;
	
	
	public LCGRandomSequence(int initSeed) {
		this.seed=initSeed;
	}
	
	public LCGRandomSequence() {
		this.seed = mod(System.nanoTime());
	}
	
	public int nextInt() {
		//BSD formula -- rand is in range 0 to 2147483647.
		int rand =(int) ((1103515245*(long)seed+12345) % MAX_BOUND);
		this.seed =rand ;
		return rand;
	}
	
	private void dump() {
		int counter = 0;
		do {
			int rd = nextInt();
			System.out.println(" rand: "+ rd);	
			counter++;
		} while (counter != 100000);
	}
	
	private int mod(long value) {
		return (int) (value % Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCGRandomSequence lcg = new LCGRandomSequence();
		lcg.dump();
	}

}
