package j8;

import java.util.Arrays;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		list.forEach(System.out::println);

		System.out.println(list.stream().map(e -> e * 2)
				.reduce(0, (c, e) -> c + e));
	}
}
