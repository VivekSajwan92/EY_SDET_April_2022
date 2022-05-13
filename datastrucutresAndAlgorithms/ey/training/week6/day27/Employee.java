package datastrucutresAndAlgorithms.ey.training.week6.day27;

public class Employee implements Comparable<Employee>{

	private String name;
	private Integer empID;
	
	public Employee(String name, Integer empID) {
		super();
		this.name = name;
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmpID() {
		return empID;
	}
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empID=" + empID + "]";
	}
	@Override
	public int compareTo(Employee o) {
//		if(this.getName().compareTo(o.getName()) == 0) {
//			if(this.getEmpID()>o.getEmpID()) {
//				return 1;
//			}else if(this.getEmpID()<o.getEmpID()){
//				return -1;
//			}
//			return 0;
//		}else {
			return this.getName().compareTo(o.getName());
//		}
	}
	
}
