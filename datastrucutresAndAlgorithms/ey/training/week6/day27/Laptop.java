package datastrucutresAndAlgorithms.ey.training.week6.day27;

public class Laptop implements Comparable<Laptop>{

	private String brand;
	private Integer ram;
	private Integer price;
	
	public Laptop(String brand, Integer ram, Integer price) {
		super();
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", ram=" + ram + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Laptop lap) {
		return this.getBrand().compareTo(lap.getBrand());
	}
}
