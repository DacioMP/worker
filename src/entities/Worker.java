package entities;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import entities.enums.WorkerLevel;


public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();  
	
	public Worker() {
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {
		double sum = baseSalary;
		
		for(HourContract c : contracts) {
			LocalDate c_date = c.getDate();
			int c_year = c_date.getYear();
			int c_month = c_date.getMonthValue();
			
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		
		return sum;
	}
}