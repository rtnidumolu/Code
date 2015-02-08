package lombok;

@Data
@AllArgsConstructor
public class Sample {

	private String name;

	private String doB;

	private int age;

	public static void main(String[] args) {
		Sample sample = new Sample("a", "b", 3);
		System.out.println(sample);

		sample.setAge(4);
		System.out.println(sample);
	}
}
