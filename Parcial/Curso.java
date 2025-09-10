import java.util.ArrayList;

public class Curso {
    private String nombreCurso;
    private ArrayList<Estudiante> estudiantes;

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void mostrarEstudiantes() {
        System.out.println("Curso: " + nombreCurso);
        for (Estudiante e : estudiantes) {
            System.out.println(" - " + e);
        }
    }
}
