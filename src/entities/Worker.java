package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private List<HourContract> list = new ArrayList<>();
    private Department department;

    public Worker(){
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
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

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<HourContract> getList() {
        return list;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract(HourContract contract){
        list.add(contract);
    }

    public void removeContract(HourContract contract){
        list.remove(contract);
    }

    public Double income(Integer year, Integer month){
        Calendar calendar = Calendar.getInstance();
        double sum = baseSalary;
        for (HourContract c: list){
            calendar.setTime(c.getDate());
            int ano = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH) + 1; //no Calendar, os meses iniciam-se em zero 0
            if(year == ano && month == mes){
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
