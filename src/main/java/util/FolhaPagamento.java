/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author EDUARDO
 */
public class FolhaPagamento {

    private float salario, inss, irrf, salarioliquido;

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getInss() {
        if (salario < 1751.82) {
            this.inss = (float) (salario * 0.08);
        } else if (salario > 1751.81 && salario < 2919.73) {
            this.inss = (float) (salario * 0.09);
        } else if (salario > 2919.72 && salario < 5839.46) {
            this.inss = (float) (salario * 0.11);
        } else if (salario > 5839.45) {
            this.inss = (float) 817.66;
        }
        return this.inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public float getIrrf() {
        float salarioSInss = salario - this.getInss();
        if (salarioSInss < 1903.99) {
            this.irrf = 0;
        } else if (salarioSInss > 1903.98 && salarioSInss < 2826.66) {
            this.irrf = (float) ((salarioSInss * 0.075) - 142.80);
        } else if (salarioSInss > 2826.65 && salarioSInss < 3751.06) {
            this.irrf = (float) ((salarioSInss * 0.15) - 354.8);
        } else if (salarioSInss > 3751.05 && salarioSInss < 4664.69) {
            this.irrf = (float) ((salarioSInss * 0.225) - 636.13);
        } else if (salarioSInss > 4664.68) {
            this.irrf = (float) ((salarioSInss * 0.275) - 869.36);
        }
        return this.irrf;
    }

    public void setIrrf(float irrf) {
        this.irrf = irrf;
    }

    public float getSalarioliquido() {
        this.salarioliquido = (float) (this.salario - (this.getIrrf() + this.getInss()));
        return salarioliquido;
    }

    public void setSalarioliquido(float salarioliquido) {
        this.salarioliquido = (float) salarioliquido;
    }

}
