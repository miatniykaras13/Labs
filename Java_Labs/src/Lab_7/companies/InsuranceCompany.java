package Lab_7.companies;

import java.util.Scanner;

public class InsuranceCompany extends Company {
    private int _policiesCount;
    private int _riskFactor;

    public InsuranceCompany()
    {
        super();
        _policiesCount = 0;
        _riskFactor = 0;
        this.setId(Company.getNumberOfCompanies());
    }


    public InsuranceCompany(String name, int income)
    {
        super(name, income);
        _policiesCount = 0;
        _riskFactor = 0;
        this.setId(Company.getNumberOfCompanies());
    }
    public InsuranceCompany(String name, int income, int policiesCount, int riskFactor)
    {
        super(name, income);
        _policiesCount = policiesCount;
        _riskFactor = riskFactor;
        this.setId(Company.getNumberOfCompanies());
    }

    public int getPoliciesCount() {
        return _policiesCount;
    }

    public void setPoliciesCount(int policiesCount){
        if(policiesCount <= 0)
        {
            System.out.println("Количество полисов должно быть больше 0.");
            return;
        }
        this._policiesCount = policiesCount;
    }

    public int getRiskFactor()
    {
        return _riskFactor;
    }

    public void setRiskFactor(int riskFactor){
        if(riskFactor < 0 || riskFactor > 100)
        {
            System.out.println("Фактор риска должен быть между 0 и 100.");
            return;
        }
        this._riskFactor = riskFactor;
    }
    public static InsuranceCompany update(Scanner scanner, InsuranceCompany company){
        System.out.println("Введите название страховой компании: ");
        String name = scanner.next();
        company.setName(name);

        System.out.println("Введите доход страховой компании: ");
        int income = scanner.nextInt();
        company.setIncome(income);

        System.out.println("Введите количество страховых полисов: ");
        int policies = scanner.nextInt();
        company.setPoliciesCount(policies);

        System.out.println("Введите фактор риска: ");
        int risk = scanner.nextInt();
        company.setRiskFactor(risk);

        return company;
    }

    public static InsuranceCompany set(Scanner scanner){
        InsuranceCompany insurance = new InsuranceCompany();

        System.out.println("Введите название страховой компании: ");
        String name = scanner.next();
        insurance.setName(name);

        System.out.println("Введите доход страховой компании: ");
        int income = scanner.nextInt();
        insurance.setIncome(income);

        System.out.println("Введите количество страховых полисов: ");
        int policies = scanner.nextInt();
        insurance.setPoliciesCount(policies);

        System.out.println("Введите фактор риска: ");
        int risk = scanner.nextInt();
        insurance.setRiskFactor(risk);

        return insurance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        if (!this.equals(o)) return false;
        InsuranceCompany that = (InsuranceCompany) o;
        return _policiesCount == that._policiesCount && _riskFactor == that._riskFactor;
    }

    @Override
    public String toString() {
        return "Страховая компания {" +
                "Id = "  + this.getId() +
                ", Название = '" + this.getName() + '\'' +
                ", Доход = " + this.getIncome() +
                ", Количество полисов = " + _policiesCount +
                ", Фактор риска = " + _riskFactor +
                '}';
    }
}
