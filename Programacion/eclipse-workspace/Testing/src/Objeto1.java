
public class Objeto1 {

	String name, hairColor;
	int age;
	boolean isMarried;
	public Objeto1(String name, String hairColor, int age, boolean isMarried) {
		this.name = name;
		this.hairColor = hairColor;
		this.age = age;
		this.isMarried = isMarried;
	}
	public Objeto1() {
	}
	public Objeto1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		this.name = _name;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String _hairColor) {
		this.hairColor = _hairColor;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int _age) {
		this.age = _age;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean _isMarried) {
		
		this.isMarried = _isMarried;
	}
	
	public String toString() {
		System.out.println();
		return "Objeto con nombre " + name + ", color de pelo " + hairColor + ", edad " + age + ", casado " + isMarried;
	}
	 
	
}
