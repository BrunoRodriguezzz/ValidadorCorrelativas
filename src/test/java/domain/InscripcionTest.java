package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    @Test
    public void funcionamientoGeneral() {
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
        Inscripcion inscripcion4 = new Inscripcion("004", alumno, Arrays.asList(ingSociedad, paradigmas)); //Aceptada

        Assertions.assertFalse(inscripcion1.aprobada());
        Assertions.assertFalse(inscripcion2.aprobada());
        Assertions.assertTrue(inscripcion3.aprobada());
        Assertions.assertTrue(inscripcion4.aprobada());
    }

    @Test
    public void inscripcionVacia() {
        Alumno alumno = new Alumno("12345", List.of(), Collections.emptyList());
        Inscripcion inscripcion1 = new Inscripcion("001", alumno, List.of()); // Rechazada

        Assertions.assertFalse(inscripcion1.aprobada());
    }

    @Test
    public void inscripcionAMateriaQueYaTiene() {
        Materia algoritmos = new Materia("Algoritmos", Collections.emptyList());
        Alumno alumno = new Alumno("12345", Arrays.asList(algoritmos), Collections.emptyList());
        Inscripcion inscripcion1 = new Inscripcion("001", alumno, Arrays.asList(algoritmos)); // Rechazada

        Assertions.assertFalse(inscripcion1.aprobada());
    }
}