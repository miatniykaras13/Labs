package Lab_7.companies;

import java.util.Scanner;

public class InsuranceCompany extends Company {
    private int _policiesCount;
    private int _riskFactor;

    public InsuranceCompany()
    {
        super();
    }



    public int getPoliciesCount() {
        return _policiesCount;
    }

    public void setPoliciesCount(int policiesCount){
        if(policiesCount <= 0)
        {
            System.out.println("Количество полисов должно быть больше 0. Установлено значение 0.");
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
            System.out.println("Фактор риска должен быть между 0 и 100. Установлено значение 0.");
            return;
        }
        this._riskFactor = riskFactor;
    }

    @Override
    public String work()
    {
        return "Страховая компания работает.";
    }

    public void set(Scanner scanner){

        super.set(scanner);

        System.out.println("Введите количество страховых полисов: ");
        int policies = scanner.nextInt();
        this.setPoliciesCount(policies);

        System.out.println("Введите фактор риска: ");
        int risk = scanner.nextInt();
        this.setRiskFactor(risk);
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
                super.toString() +
                ", Количество полисов = " + _policiesCount +
                ", Фактор риска = " + _riskFactor +
                '}';
    }
}
