/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebacuenta;

/**
 *
 * @author Wesly
 */
public class CuentaCorriente extends Cuenta {
    private float sobregiro;

    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
        sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {
        float resultado = saldo - cantidad;
        if (resultado < 0) {
            sobregiro -= resultado;
            saldo = 0;
        } else {
            super.retirar(cantidad);
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            float residuo = sobregiro - cantidad;
            if (residuo > 0) {
                sobregiro = residuo;
            } else {
                sobregiro = 0;
                saldo = -residuo;
            }
        } else {
            super.consignar(cantidad);
        }
    }

    public void imprimir() {
        System.out.println("Saldo = $" + saldo);
        System.out.println("Cargo mensual = $" + comisionMensual);
        System.out.println("Número de transacciones = " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Valor de sobregiro = $" + sobregiro);
        System.out.println();
    }
}

