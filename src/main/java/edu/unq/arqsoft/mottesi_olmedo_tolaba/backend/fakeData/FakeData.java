package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.fakeData;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FakeData {

    private  Integer studentIndex = 1000;

    public Degree degreeTPI(){
        List<Subject> subjects = this.subjects(this.subjectStringTpi());
        List<Professor> professors = this.professors();
        List<Student> students = students(this.studentsStringTpi());
        List<AcademicOffer> academicOffers = this.academicOffers(subjects, professors);
        Degree degree = new Degree("Tecnicatura Universitaria en Programacion Informatica", subjects, academicOffers);
        //academicOffers.stream().forEach(academicOffer -> degree.addAcademicOffer(academicOffer));
        return degree;
    }

    public Degree degreeLICBIO(){
        List<Subject> subjects = this.subjects(this.subjectStringLICBIO());
        List<Professor> professors = this.professors();
        List<Student> students = students(this.studentsStringLICBIO());
        List<AcademicOffer> academicOffers = this.academicOffers(subjects, professors);
        Degree degree = new Degree("Licenciatura en Biotecnología", subjects, academicOffers);
        //academicOffers.stream().forEach(academicOffer -> degree.addAcademicOffer(academicOffer));
        return degree;
    }

    /** STUDENTS **/
    private List<Student> students(List<String> studentsString) {

        return studentsString.stream()
                .map(nameStudent -> new Student(nameStudent, nameStudent, this.getStudentIndex(), this.mail(nameStudent), new ArrayList<>()))
                .collect(Collectors.toList());
    }

    private String mail(String nameStudent) {
        return nameStudent.replaceAll("\\s+", " ") + "@gmail.com";
    }

    private List<String> studentsStringTpi() {
        return Arrays.asList(
            "Michael", "James", "John", "Robert", "David", "William", "Mary", "Christopher", "Joseph", "Richard", "Daniel", "Thomas",
            "Matthew", "Jennifer", "Charles", "Anthony", "Patricia", "Linda", "Mark", "Elizabeth", "Joshua", "Steven", "Andrew",
            "Kevin", "Brian", "Barbara", "Jessica", "Jason", "Susan", "Timothy", "Paul", "Kenneth", "Lisa", "Ryan", "Sarah",
            "Karen", "Jeffrey", "Donald", "Ashley", "Eric", "Jacob", "Nicholas", "Jonathan", "Ronald", "Michelle", "Kimberly",
            "Nancy", "Justin", "Sandra", "Amanda", "Brandon", "Stephanie", "Emily", "Melissa", "Gary", "Edward", "Stephen",
            "Scott", "George", "Donna", "Jose", "Rebecca", "Deborah", "Laura", "Cynthia", "Carol", "Amy", "Margaret", "Gregory",
            "Sharon", "Larry", "Angela", "Maria", "Alexander", "Benjamin", "Nicole", "Kathleen", "Patrick", "Samantha",
            "Tyler", "Samuel", "Betty", "Brenda", "Pamela", "Aaron", "Kelly", "Heather", "Rachel", "Adam", "Christine",
            "Zachary", "Debra", "Katherine", "Dennis", "Nathan", "Christina", "Julie", "Jordan", "Kyle", "Anna"
        );
    }

    private List<String> studentsStringLICBIO(){
        return Arrays.asList("James","Josephine","Art","Lenna","Donette","Simona","Mitsue","Leota","Sage","Kris","Minna","Abel",
            "Kiley","Graciela","Cammy","Mattie","Meaghan","Gladys","Yuki","Fletcher","Bette","Veronika","Willard",
            "Maryann","Alisha","Allene","Chanel","Ezekiel","Willow","Bernardo","Ammie","Francine","Ernie","Albina",
            "Alishia","Solange","Jose","Rozella","Valentine","Kati","Youlanda","Dyan","Roxane","Lavera","Erick",
            "Fatima","Jina","Kanisha","Emerson","Blair","Brock","Lorrie","Sabra","Marjory","Karl","Tonette","Amber",
            "Shenika","Delmy","Deeanna","Blondell","Jamal","Cecily","Carmelina","Maurine","Tawna","Penney","Elly",
            "Ilene","Vallie","Kallie","Johnetta","Bobbye","Micaela","Tamar","Moon","Laurel","Delisa","Viva","Elza",
            "Devorah","Timothy","Arlette","Dominque","Lettie","Myra","Stephaine","Lai","Stephen","Tyra","Tammara",
            "Cory","Danica","Wilda","Elvera","Carma","Malinda","Natalie","Lisha");
    }

    /** PROFESSORS **/

    private List<Professor> professors() {
        return this.professorsString().stream()
                .map(Professor::new)
                .collect(Collectors.toList());
    }

    private List<String> professorsString() {
        return Arrays.asList("ACEVEDO JHONG, DANIEL", "AGURTO RONDOY, MIGUELVICENTE", "ALCALÁ NEGRÓN, CHRISTIAN NELSON",
            "ALMORA HERNANDEZ, RAUL EDUARDO", "ALOSILLA VELAZCO VERA, JORGE ", "ALVA CAMPOS, VICTOR",
            "AREVALO LOPEZ, JAVIER", "ARIAS HERNANDEZ, ROSARIO", "ARROYO RAMÍREZ, EFRAÍN ",
            "ALOCEN BARRERA, MARCO TULIO", "BAIOCCHI URETA, CESAR", "BAYLÓN ROJAS, ISELA FLOR",
            "BEDOYA CASTILLO, LEONCIA", "BEDREGAL CANALES, LUZ MARINA", "BEJAR TORRES, RAMIRO ALBERTO",
            "BENAVIDES ESPEJO, JAVIER", "BOZA SOLIS, NELSON", "CALLE BETANCOURT, CIELITO MERCEDES",
            "CARAZA VILLEGAS, ISABEL FLORISA", "CARRERA ABANTO, GIZELLA", "CARRILLO SEGURA, ESTALINS",
            "CARRIÓN NEIRA, JORGE AUGUSTO", "CASAPIA VALDIVIA, GUILLERMO", "CHANCOS MENDOZA, ZARITA",
            "CHIRINOS LACOTERA, CARLOS", "CORES MORENO, DORIS", "CORTEZ LOZANO, MARIBEL CORINA",
            "CRISPIN QUISPE, ANGEL", "DE LOAYZA CONTERNO, ANTONIO");
    }

    /** SUBJECTS **/

    private List<Subject> subjects(List<String> list) {
        return list.stream().map(Subject::new).collect(Collectors.toList());
    }

    private List<String> subjectStringTpi() {
        return Arrays.asList("Lectura y escritura académica", "Matemática", "Elementos de programación y lógica",
            "Introducción a la Programación", "Organización de Computadoras", "Matemática I",
            "Programación con Objetos I", "Bases de Datos", "Estructuras de Datos", "Programación con Objetos II",
            "Redes de Computadoras", "Sistemas Operativos", "Programación Concurrente", "Matemática II",
            "Elementos de Ingeniería de Software", "Construcción de Interfaces de Usuario", "Estrategias de Persistencia",
            "Programación Funcional", "Desarrollo de Aplicaciones", "Laboratorio de Sistemas Operativos y Redes",
            "Seguridad Informática", "Bases de Datos II", "Participación y Gestión en Proyectos de Software Libre",
            "Introducción a las Arquitecturas de Software", "Programación con Objetos III",
            "Introducción a la Bioinformática", "Políticas Públicas en la Sociedad de la Información y la Era Digital",
            "Sistemas de Información Geográfica", "Herramientas Declarativas en Programación",
            "Introducción al Desarrollo de Videojuegos", "Derechos de Autor y Derechos de Copia en la Era Digital");
    }

    private List<String> subjectStringLICBIO(){
        return Arrays.asList("Lectura y escritura académica","Matemática","Elementos de programación y lógica","Análisis Matemático I",
            "Algebra y Geometría Analítica","Biología General","Química I","Análisis Matemático II" ,"Química Orgánica I",
            "Introducción a la programación","Inglés","Cálculo Avanzado","Estructura de Datos","Bioquímica I","Probabilidad y Estadística",
            "Taller de Trabajo Intelectual","Elementos de Física","Algoritmos","Taller de Trabajo Universitario","Estadística Avanzada",
            "Ética y Legislación","Bioquímica II","Biología Molecular y Celular","Biofísica","Fundamentos de Inmunología",
            "Ingeniería Genética I","Bioinformática","Fisiología y Genética de Bacterias","Bases de Datos",
            "Orientación Genómica Funcional","Orientación Bases de Datos de Macromoléculas");
    }

    /** ACADEMIC OFFERS **/

    private List<AcademicOffer> academicOffers(List<Subject> subjects, List<Professor> professors) {
        return Arrays.asList(
                this.createAcademicOffer(subjects, professors, new Period(2017, 1), false, "2017-03-01"),
                this.createAcademicOffer(subjects, professors, new Period(2017, 2), true, "2017-08-01")
        );
    }

    private AcademicOffer createAcademicOffer(List<Subject> subjects, List<Professor> professors, Period period, Boolean active, String endDay) {
        return new AcademicOffer(this.createOffers(subjects, professors), period, endDay, active);
    }

    private List<Offer> createOffers(List<Subject> subjects, List<Professor> professors) {
        return subjects.stream().map(subject -> new Offer(subject, this.createCourse(professors))).collect(Collectors.toList());
    }

    private List<Course> createCourse(List<Professor> professors) {
        return Arrays.asList(
                new Course("Comision 1", this.getProfessor(professors), this.getTimelines1()),
                new Course("Comision 2", this.getProfessor(professors), this.getTimelines2())
        );
    }

    private Professor getProfessor(List<Professor> professors) {
        return professors.get(new Random().nextInt(professors.size()));
    }

    private List<Timeline> getTimelines1() {
        return Arrays.asList(
                new Timeline("lunes", "12:00", "16:00"),
                new Timeline("martes", "15:00", "20:00")
        );
    }

    private List<Timeline> getTimelines2() {
        return Arrays.asList(
                new Timeline("miercoles", "18:00", "22:00"),
                new Timeline("jueves", "18:00", "22:00")
        );
    }

    public Integer getStudentIndex() {
        studentIndex++;
        return studentIndex;
    }
}
