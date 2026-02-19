package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private final List<HourContract> hourContractList = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
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
}
