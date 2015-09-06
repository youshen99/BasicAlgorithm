package comg.youshen.testclass;

import com.youshen.interfacetest.YouCompare;

public class Car implements YouCompare<Car> {

	@Override
	public String toString() {
		
		return this.height+",";
	}

	private int height;
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private int weight;
	
	public Car(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}

	public boolean compare( Car compare2) {
		if(this.getHeight()>compare2.getHeight()){
			return true;
		}else if(this.getHeight()<compare2.getHeight()){
			return false;
		}else {
			if(this.getWeight()>=compare2.getWeight()){
				
				return true;
			}else {
				return false;
			}
		}
		
	}

}
