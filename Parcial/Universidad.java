import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private ArrayList<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void mostrarCursos() {
        System.out.println("Universidad: " + nombre);
        for (Curso c : cursos) {
            c.mostrarEstudiantes();
        }
    }
}
