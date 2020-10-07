package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planner")
public class Planner {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="PLANNER_ID")
		private int id;
		@Column(name="PLANNER_NAME")
		private String plannerName;
		public int getId() {
			return id;
		}	
		public Planner() {
			super();
			// TODO Auto - generated constructor stub
		}
		
		public Planner(int id, String plannerName) {
			super();
			this.id = id;
			this.plannerName = plannerName;
		}
		
		public Planner(String plannerName) {
			super();
			this.plannerName = plannerName;
		}
		
		
		
		public void setId(int id) {
			this.id = id;
		}
		public String getPlannerName() {
			return plannerName;
		}
		public void setPlannerName(String plannerName) {
			this.plannerName = plannerName;
		}
		@Override
		public String toString() {
			return "Planner [id=" + id + ", plannerName=" + plannerName + "]";
		}

}
