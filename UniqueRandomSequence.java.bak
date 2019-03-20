package com.jrj.util.random;

/**
 * 32位唯一随机数序列生成器java实现
 *<link>http://preshing.com/20121224/how-to-generate-a-sequence-of-unique-random-integers/</link>
 */
public class UniqueRandomSequence {
	public static final int MAX_PRIME = Integer.MAX_VALUE;
	public static final int INIT_OFFSET = 0x682f0161;
	public static final int XOR_FACTOR = 0x5bf03635;
	public static final int BITS_LENGTH = 268435456;
	private byte[] bitSet = new byte[BITS_LENGTH];
	private final int initSeed;
	private int counter;

	public UniqueRandomSequence() {
		this.initSeed = mod(System.nanoTime());
	}

	public UniqueRandomSequence(int seed) {
		this.initSeed = seed;
	}

	public int nextInt() {
		int seed = mod(permute(initSeed) + counter + INIT_OFFSET);
		seed = mod(seed ^ XOR_FACTOR);
		int result = permute(seed);
		counter += 1;
		if (counter > Integer.MAX_VALUE) {
			throw new RuntimeException("Can't generate more than " + Integer.MAX_VALUE + " random numbers!");
		}
		return result;
	}

	private int permute(int num) {
		if (num >= MAX_PRIME)
			return num;
		int residue = mod((long) num * (long) num);
		return (num <= MAX_PRIME / 2) ? residue : MAX_PRIME - residue;
	}

	private int mod(long value) {
		return (int) (value % MAX_PRIME);
	}

	private void dump() {
		do {
			System.out.println(counter + ":" + nextInt());
		} while (counter != Integer.MAX_VALUE);
	}

	private void verifyUnique() {
		boolean success = true;
		do {
			int rd = nextInt();
			int byte_index = rd >> 3;
			int residue = rd & 7;
			int unit_byte = bitSet[byte_index];
			int bit = 1 << residue;
			if ((unit_byte & bit) != 0) {
				System.out.println(counter + ": " + rd + " have a collision!");
				success = false;
				break;
			}
			bitSet[byte_index] = (byte) (unit_byte | bit);
		} while (counter != Integer.MAX_VALUE);
		if (success)
			System.out.println(" Congratulations! all numbers are unique!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueRandomSequence urs = new UniqueRandomSequence();
		System.out.println(urs.nextInt());
		// urs.verifyUnique();
	}

}
