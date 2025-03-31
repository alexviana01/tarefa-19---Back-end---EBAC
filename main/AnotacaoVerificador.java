package main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnotacaoVerificador {
    public static void main(String[] args) {
        verificarAnotacoes(CadastroSwing.class);
    }

    public static void verificarAnotacoes(Class<?> clazz) {
        System.out.println("Analisando a classe: " + clazz.getName());
        
        // Verifica anotações na classe
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(" - Anotação encontrada na classe: " + annotation.annotationType().getName());
        }
        
        // Verifica anotações nos métodos
        System.out.println("\nAnotações nos métodos:");
        for (Method method : clazz.getDeclaredMethods()) {
            for (Annotation annotation : method.getAnnotations()) {
                System.out.println(" - Método " + method.getName() + " possui anotação: " + annotation.annotationType().getName());
            }
        }
        
        // Verifica anotações nos campos
        System.out.println("\nAnotações nos campos:");
        for (Field field : clazz.getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                System.out.println(" - Campo " + field.getName() + " possui anotação: " + annotation.annotationType().getName());
            }
        }
    }
}

