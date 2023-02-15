package codeReview;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

	/*Q066.java

	[요구사항] 배열: 로또
	중복되지 않는 임의의 숫자 6개를 만드시오.(로또)

	조건
	 - 숫자의 범위: 1 ~ 45
	 - 오름차순 정렬
	*/

	int[] nums = new int[6];

	for (int i = 0; i < nums.length; i++) {
		nums[i] = (int)(Math.random() * 45) + 1;
		//System.out.printf("%d, ", nums[i]);

		for (int j = 0; j < i; j++) {
			if (nums[i] == nums[j]) {
				i--;
			}
		}
	}

	Arrays.sort(nums);

	String txt = "[";

	for (int i = 0; i < nums.length; i++) {
		txt += nums[i];

		if (i == nums.length - 1) {
			break;
		}

		txt += ", ";
	}

	String txt2 = "]";

	System.out.print(txt + txt2);
}


}
