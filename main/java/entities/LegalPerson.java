package entities;

public class LegalPerson extends Person {

    private Integer numberOfEmployee;

    public LegalPerson() {
    }

    public LegalPerson(Integer numberOfEmployee, String name, Double annualIncome) {
        super(name, annualIncome);
        this.numberOfEmployee = numberOfEmployee;
    }

    public Integer getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(Integer numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public Double taxCal() {
        Double tax = 0.0;
        if (numberOfEmployee > 10) {
            tax = (getAnnualIncome() * 14) / 100;
        } else if (numberOfEmployee <= 10) {
            tax = (getAnnualIncome() * 16) / 100;
        }

        return tax;
    }

}
