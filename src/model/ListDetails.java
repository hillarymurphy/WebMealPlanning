package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="MEAL_PLAN_DATE")
	private LocalDate mealPlanDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="PLANNER_ID")
	private Planner planner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
			name="meals_on_list",
			joinColumns= { @JoinColumn(name="LIST_ID",
			referencedColumnName="LIST_ID") },
			inverseJoinColumns= { @JoinColumn(name="MEAL_ID",
			referencedColumnName="ID", unique=true)}
				)
	private List<ListMeal> listOfMeals;
	
	public ListDetails() {
		super();
		// TODO Auto - generated constructor stub
	}
	
	public ListDetails(int id, String listName, LocalDate mealPlanDate, Planner planner, List<ListMeal> listOfMeals) {
		super();
		this.id = id;
		this.listName = listName;
		this.mealPlanDate = mealPlanDate;
		this.planner = planner;
		this.listOfMeals = listOfMeals;
	}

	public ListDetails(String listName, LocalDate mealPlanDate, Planner planner, List<ListMeal> listOfMeals) {
		super();
		this.listName = listName;
		this.mealPlanDate = mealPlanDate;
		this.planner = planner;
		this.listOfMeals = listOfMeals;
	}

	public ListDetails(String listName, LocalDate mealPlanDate, Planner planner) {
		super();
		this.listName = listName;
		this.mealPlanDate = mealPlanDate;
		this.planner = planner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getMealPlanDate() {
		return mealPlanDate;
	}

	public void setMealPlanDate(LocalDate mealPlanDate) {
		this.mealPlanDate = mealPlanDate;
	}

	public Planner getPlanner() {
		return planner;
	}

	public void setPlanner(Planner planner) {
		this.planner = planner;
	}

	public List<ListMeal> getListOfMeals() {
		return listOfMeals;
	}

	public void setListOfMeals(List<ListMeal> listOfMeals) {
		this.listOfMeals = listOfMeals;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", mealPlanDate=" + mealPlanDate + ", planner="
				+ planner + ", listOfMeals=" + listOfMeals + "]";
	}
	
}

