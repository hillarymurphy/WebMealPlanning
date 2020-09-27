package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meals")
public class ListMeal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="MAIN")
	private String main;
	@Column(name="VEGETABLE")
	private String vegetable;
	@Column(name="FRUIT")
	private String fruit;
	
	public ListMeal() {
		super();
	}
	
	public ListMeal(String main, String vegetable, String fruit) {
		super();
		this.main = main;
		this.vegetable = vegetable;
		this.fruit = fruit;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getVegetable() {
		return vegetable;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public String returnMealDetails( ) {
		return "Meal: " + main + ", " + vegetable + ", " + fruit;
		}
}
