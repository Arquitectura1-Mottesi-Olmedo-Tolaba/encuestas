package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.fakeData;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentOfferDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FakeData {

    private  Integer studentIndex = 1000;
    private Random random = new Random();

    public Degree degreeTPI(){
        List<Subject> subjects = this.subjects(this.subjectStringTpi());
        List<Professor> professors = this.professors();
        List<AcademicOffer> academicOffers = this.academicOffers(subjects, professors);
        Degree degree = new Degree("Tecnicatura Universitaria en Programacion Informatica", subjects, academicOffers);
        return degree;
    }

    public Degree degreeLICBIO(){
        List<Subject> subjects = this.subjects(this.subjectStringLICBIO());
        List<Professor> professors = this.professors();
        List<AcademicOffer> academicOffers = this.academicOffers(subjects, professors);
        Degree degree = new Degree("Licenciatura en Biotecnologia", subjects, academicOffers);
        return degree;
    }
    
    public Degree degreeArqNaval(){
    	List<Subject> subjects = this.subjects(this.subjectStringArqNaval());
        List<Professor> professors = this.professors();
        List<AcademicOffer> academicOffers = this.academicOffers(subjects, professors);
        Degree degree = new Degree("Arquitectura Naval", subjects, academicOffers);
        return degree;
    }

    /** STUDENTS **/

    public List<Student> studentsTPI(){
        return this.students(this.studentsStringTpi());
    }

    public List<Student> studentsLicBio(){
        return this.students(this.studentsStringLICBIO());
    }
    
    public List<Student> studentsArqNaval(){
    	return this.students(this.studentsStringArqNaval());
    }

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
    
    private List<String> studentsStringArqNaval(){
    	return Arrays.asList("Jack", "Lewis", "Ryan", "Cameron", "James", "Andrew", "Liam", "Matthew", "Jamie",
			"Callum", "Ross", "Jordan", "Daniel", "Kieran", "Connor", "Scott", "Kyle", "David", "Adam", "Dylan",
			"Michael", "Ben", "Thomas", "Craig", "Nathan", "Sean", "John", "Aaron", "Calum", "Christopher", "Alexander",
			"Robert", "Euan", "Joshua", "Declan", "Aidan", "Mark", "Robbie", "Luke", "Fraser", "Reece", "William", "Ewan",
			"Joseph", "Paul", "Brandon", "Lee", "Owen", "Josh", "Samuel", "Finlay", "Stuart", "Rhys", "Stephen", "Rory",
			"Jake", "Steven", "Sam", "Jay", "Benjamin", "Ethan", "Harry", "Shaun", "Aiden", "Darren", "Blair", "Marc", 
			"Dean", "Taylor", "Angus", "Gregor", "Conor", "Jonathan", "Patrick", "Ciaran", "Greg", "Jason", "George", 
			"Logan", "Peter", "Bradley", "Max", "Arran", "Mohammed", "Morgan", "Oliver", "Gary", "Murray", "Louis", 
			"Martin", "Alan", "Alistair", "Grant", "Joe", "Keir", "Duncan", "Leon", "Mitchell", "Nicholas");
    }

    /** PROFESSORS **/

    private List<Professor> professors() {
        return this.professorsString().stream()
                .map(Professor::new)
                .collect(Collectors.toList());
    }

    private List<String> professorsString() {
        return Arrays.asList("ACEVEDO JHONG, DANIEL", "AGURTO RONDOY, MIGUELVICENTE", "ALCALa NEGRoN, CHRISTIAN NELSON",
            "ALMORA HERNANDEZ, RAUL EDUARDO", "ALOSILLA VELAZCO VERA, JORGE ", "ALVA CAMPOS, VICTOR",
            "AREVALO LOPEZ, JAVIER", "ARIAS HERNANDEZ, ROSARIO", "ARROYO RAMiREZ, EFRAiN ",
            "ALOCEN BARRERA, MARCO TULIO", "BAIOCCHI URETA, CESAR", "BAYLoN ROJAS, ISELA FLOR",
            "BEDOYA CASTILLO, LEONCIA", "BEDREGAL CANALES, LUZ MARINA", "BEJAR TORRES, RAMIRO ALBERTO",
            "BENAVIDES ESPEJO, JAVIER", "BOZA SOLIS, NELSON", "CALLE BETANCOURT, CIELITO MERCEDES",
            "CARAZA VILLEGAS, ISABEL FLORISA", "CARRERA ABANTO, GIZELLA", "CARRILLO SEGURA, ESTALINS",
            "CARRIoN NEIRA, JORGE AUGUSTO", "CASAPIA VALDIVIA, GUILLERMO", "CHANCOS MENDOZA, ZARITA",
            "CHIRINOS LACOTERA, CARLOS", "CORES MORENO, DORIS", "CORTEZ LOZANO, MARIBEL CORINA",
            "CRISPIN QUISPE, ANGEL", "DE LOAYZA CONTERNO, ANTONIO");
    }

    /** SUBJECTS **/

    private List<Subject> subjects(List<String> list) {
        return list.stream().map(Subject::new).collect(Collectors.toList());
    }

    private List<String> subjectStringTpi() {
        return Arrays.asList("Lectura y escritura academica", "Matematica", "Elementos de programacion y logica",
            "Introduccion a la Programacion", "Organizacion de Computadoras", "Matematica I",
            "Programacion con Objetos I", "Bases de Datos", "Estructuras de Datos", "Programacion con Objetos II",
            "Redes de Computadoras", "Sistemas Operativos", "Programacion Concurrente", "Matematica II",
            "Elementos de Ingenieria de Software", "Construccion de Interfaces de Usuario", "Estrategias de Persistencia",
            "Programacion Funcional", "Desarrollo de Aplicaciones", "Laboratorio de Sistemas Operativos y Redes",
            "Seguridad Informatica", "Bases de Datos II", "Participacion y Gestion en Proyectos de Software Libre",
            "Introduccion a las Arquitecturas de Software", "Programacion con Objetos III",
            "Introduccion a la Bioinformatica", "Politicas Publicas en la Sociedad de la Informacion y la Era Digital",
            "Sistemas de Informacion Geografica", "Herramientas Declarativas en Programacion",
            "Introduccion al Desarrollo de Videojuegos", "Derechos de Autor y Derechos de Copia en la Era Digital");
    }

    private List<String> subjectStringLICBIO(){
        return Arrays.asList("Lectura y escritura academica","Matematica","Elementos de programacion y logica","Analisis Matematico I",
            "Algebra y Geometria Analitica","Biologia General","Quimica I","Analisis Matematico II" ,"Quimica Organica I",
            "Introduccion a la programacion","Ingles","Calculo Avanzado","Estructura de Datos","Bioquimica I","Probabilidad y Estadistica",
            "Taller de Trabajo Intelectual","Elementos de Fisica","Algoritmos","Taller de Trabajo Universitario","Estadistica Avanzada",
            "etica y Legislacion","Bioquimica II","Biologia Molecular y Celular","Biofisica","Fundamentos de Inmunologia",
            "Ingenieria Genetica I","Bioinformatica","Fisiologia y Genetica de Bacterias","Bases de Datos",
            "Orientacion Genomica Funcional","Orientacion Bases de Datos de Macromoleculas");
    }
    
    private List<String> subjectStringArqNaval(){
    	return Arrays.asList("Lectura y Escritura Academica", "Matematica", "Introduccion al Conocimiento de la Fisica y la Quimica", "algebra y Geometria Analitica", "Quimica I",
			"Analisis Matematico I", "Fisica I", "Intr. al Conoc. de la Fisica y la Quimica", "Estabilidad I", "Diseño Asistido", "Mecanica de Fluidos",
			"Arquitectura Naval I", "Analisis Matematico II", "Analisis Matematico III", "Dibujo Naval", "Sistema de Representacion", "Fisica II",
			"Analisis Matematico II", "Quimica II", "Metodos Numericos", "Geometria Descriptiva", "Taller de Dibujo y Maqueteria", "Sistemas de Representacion",
			"Electrotecnia General", "Taller de Arquitectura Naval", "Arquitectura Naval I", "Analisis Matematico IV", "algebra Lineal", "Probabilidad y Estadistica",
			"Matematica Avanzada", "Fisica III");
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
                new Course("Comision 1", this.getProfessor(professors), this.getTimelines1(),25),
                new Course("Comision 2", this.getProfessor(professors), this.getTimelines2(),25)
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

    public List<DegreeStudent> getDegreeStudentsOf(Degree degree, List<Student> students) {
        return students.stream()
                .map(student -> new DegreeStudent(student, degree))
                .collect(Collectors.toList());
    }

    public List<Survey> surveysFor(List<DegreeStudent> degreeStudents) {
        return degreeStudents.stream().map(degreeStudent -> this.surveyFor(degreeStudent))
                .collect(Collectors.toList());
    }

    private Survey surveyFor(DegreeStudent degreeStudent){
        AcademicOffer currentAcademicOffer =
                degreeStudent.getDegree().getAcademicOffers().stream()
                        .filter(AcademicOffer::isActive)
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("No se encontro ninguna activa"));
        return new Survey(degreeStudent.getStudent(), currentAcademicOffer);
    }

	public StudentSurvey createStudentSurvey(String code, StudentSurveyDTO surveyByCode) {
		return new StudentSurvey(code, this.createSurveyMatches(surveyByCode.getOffers()), surveyByCode.getMessage());
	}

	private List<SurveyMatch> createSurveyMatches(List<StudentOfferDTO> offers) {
		return offers.stream()
				.map(offer -> new SurveyMatch(this.getRandomOption(offer.getOptions()), offer.getSubject()))
				.collect(Collectors.toList());
	}

	private Option getRandomOption(List<Option> options) {
		return options.get(random.nextInt(options.size()));
	}
}
