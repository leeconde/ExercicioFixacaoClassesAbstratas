package entities;

public class NormalPerson extends Person {

    private Double healthExpenditure;

    public NormalPerson() {
    }

    public NormalPerson(Double healthExpenditure, String name, Double annualIncome) {
        super(name, annualIncome);
        this.healthExpenditure = healthExpenditure;
    }

    public Double getHealthExpenditure() {
        return healthExpenditure;
    }

    public void setHealthExpenditure(Double healthExpenditure) {
        this.healthExpenditure = healthExpenditure;
    }

    @Override
    public Double taxCal() {
        Double tax = 0.0;

        if (getAnnualIncome() > 20000.00 && healthExpenditure > 0) {
            tax = ((getAnnualIncome() * 25) / 100) - ((healthExpenditure * 50) / 100);
        } else if (getAnnualIncome() > 20000.00 && healthExpenditure <= 0 ) {
            tax = (getAnnualIncome() * 25) / 100;
        } else if (getAnnualIncome() <= 20000.00 && healthExpenditure > 0) {
            tax = ((getAnnualIncome() * 15) / 100) - ((healthExpenditure * 50) / 100);
        } else if (getAnnualIncome() <= 20000.00 && healthExpenditure <= 0) {
            tax = (getAnnualIncome() * 15) / 100;
        }
        return tax;
    }

}
