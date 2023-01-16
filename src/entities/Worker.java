package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double salary, Department department) {
		this.name = name;
		this.level = level;
		baseSalary = salary;
		this.department = department;
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

	public Double getSalary() {
		return baseSalary;
	}

	public void setSalary(Double salary) {
		baseSalary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
	
	//calcula o valor dos contratos dependendo do ano e data
	public double income(int year, int month){ 
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate()); //pega a data do contrato e define como a data do calendario
			int c_year = cal.get(Calendar.YEAR); //pega o ano do contrato c
			int c_month = 1 + cal.get(Calendar.MONTH); //pega o mes do contrato c
			//verifica se o contrato é desse mes/ano
			if(year == c_year && month == c_month) {
				sum += c.totalValue();			}
		}
		return sum;
	}
}
