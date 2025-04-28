import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	static int P, N, count;

	static int[] accessory;

	

	public static void main(String[] args) throws IOException {

		String[] input = br.readLine().split(" ");

		P = Integer.parseInt(input[0]);

		N = Integer.parseInt(input[1]);

		accessory = new int[N];

		String[] accessories = br.readLine().split(" ");

		

		for(int i = 0; i < N; i++) {

			accessory[i] = Integer.parseInt(accessories[i]);

		}

		

		Arrays.sort(accessory);

		count = 0;

		

		for(int i = 0; i < N; i++) {

			if(P >= 200) {

				break;

			}

			

			P += accessory[i];

			count++;

		}

		

		System.out.println(count);

	}

}