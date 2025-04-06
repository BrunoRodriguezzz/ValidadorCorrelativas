package org.example;

import domain.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Crear materias con sus correlativas
        Materia algoritmos = new Materia("Algoritmos", Collections.emptyList());
        Materia paradigmas = new Materia("Paradigmas", Arrays.asList(algoritmos));
        Materia diseno = new Materia("Diseño de Sistemas", Arrays.asList(paradigmas));
        Materia analisis1 = new Materia("Análisis 1", Collections.emptyList());
        Materia algebra = new Materia("Álgebra", Collections.emptyList());
        Materia analisis2 = new Materia("Análisis 2", Arrays.asList(analisis1, algebra));
        Materia fisica1 = new Materia("Física 1", Collections.emptyList());
        Materia fisica2 = new Materia("Física 2", Arrays.asList(fisica1));
        Materia ingSociedad = new Materia("Ingeniería y Sociedad", Collections.emptyList());

        // Crear alumno con materias aprobadas
        Alumno alumno = new Alumno("12345", Arrays.asList(algoritmos, analisis1), Collections.emptyList());

        // Crear inscripciones
        Inscripcion inscripcion1 = new Inscripcion("001", alumno, Arrays.asList(diseno)); // Rechazada
        Inscripcion inscripcion2 = new Inscripcion("002", alumno, Arrays.asList(analisis2)); // Rechazada
        Inscripcion inscripcion3 = new Inscripcion("003", alumno, Arrays.asList(ingSociedad)); // Aceptada
        Inscripcion inscripcion4 = new Inscripcion("004", alumno, Arrays.asList(ingSociedad, paradigmas));

        // Verificar inscripciones
        System.out.println("Inscripción 1 (Diseño de Sistemas): " + (inscripcion1.aprobada() ? "Aceptada" : "Rechazada"));
        System.out.println("Inscripción 2 (Análisis 2): " + (inscripcion2.aprobada() ? "Aceptada" : "Rechazada"));
        System.out.println("Inscripción 3 (Ingeniería y Sociedad): " + (inscripcion3.aprobada() ? "Aceptada" : "Rechazada"));
        System.out.println("Inscripción 4 (Paradigmas y Ingeniería y Sociedad): " + (inscripcion4.aprobada() ? "Aceptada" : "Rechazada"));
    }
}