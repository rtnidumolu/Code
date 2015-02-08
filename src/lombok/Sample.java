package lombok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lombok.extern.java.Log;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(exclude = { "id", "num" })
@Log
@RequiredArgsConstructor
public class Sample {

	@NonNull
	private String name;
	
	private int id;

	private int num;

	@SuppressWarnings("serial")
	public static void main(String[] args) throws Exception {
		log.info("Logging works");

		Sample sample = new Sample("a");
		System.out.println(sample);

		Sample sample2 = Sample.builder().name("a").id(2).num(3).build();
		System.out.println(sample2);

		System.out.println(sample.equals(sample2));
		System.out.println(sample == sample2);
		
		val example = new Delegation();
		example.add("c");
		sample.setName(example.get(0));
		System.out.println(sample);

		val example1 = new ArrayList<String>() {
			{
				add("Hello, World!");
			}
		};
		sample.setName(example1.get(0));
		System.out.println(sample);

		@Cleanup
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.print("enter name: ");
		sample.setName(bufferedReader.readLine());
		System.out.println(sample);

		sample.setName(null);
		System.out.println(sample);

	}
}

class Delegation {
	private interface SimpleCollection {
		boolean add(String string);

		boolean remove(String string);

		String get(int index);
	}

	@Delegate(types = SimpleCollection.class)
	private final ArrayList<String> collection = new ArrayList<String>();

}