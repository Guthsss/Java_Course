package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private final String name;
    private final WorkerLevel level;
    private final Double baseSalary;
    private Department department;
    private final List<HourContract> hourContractList = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract(HourContract contract) {
        if (contract == null) {
            throw new IllegalArgumentException("Contract não pode ser null.");
        }
        hourContractList.add(contract);
    }
    public void removeContract(HourContract contract) {
        if (contract == null) {
            return;
        }
        hourContractList.remove(contract);
    }
    public Double income (Integer year, Integer month) {

        double sum = (baseSalary == null ? 0.0 : baseSalary);

        for (HourContract contract : hourContractList) {


            int cYear = contract.getDate().getYear();
            int cMonth = contract.getDate().getMonthValue();

            if (cYear == year && cMonth == month) {
               sum += contract.totalValue();
            }
        }
        return sum;
    }

    public List<HourContract> getHourContractList() {

        return hourContractList;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }
}
