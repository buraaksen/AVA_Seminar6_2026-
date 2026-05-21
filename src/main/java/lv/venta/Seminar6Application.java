package lv.venta;

import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;

@SpringBootApplication
public class Seminar6Application {

	private final ICourseRepo ICourseRepo;
	private final IGradeRepo IGradeRepo;
	private final IStudentRepo IStudentRepo;

	Seminar6Application(IStudentRepo IStudentRepo, IGradeRepo IGradeRepo, ICourseRepo ICourseRepo) {
		this.IStudentRepo = IStudentRepo;
		this.IGradeRepo = IGradeRepo;
		this.ICourseRepo = ICourseRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testData(IProfessorRepo profRepo,IStudentRepo studRepo, ICourseRepo courseRepo, IGradeRepo gradeRepo
			) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student st1 = new Student("John" , "Sarfo");
				Student st2 = new Student("Davyd" , "Akimov");
				studRepo.saveAll(Arrays.asList(st1,st2));
				
				Professor pr1 = new Professor("Karina", "Skirmante", Degree.master);
				Professor pr2 = new Professor("Karina", "Skirmante", Degree.master);
				profRepo.saveAll(Arrays.asList(pr1,pr2));
				
				Course c1 = new Course("Java", 6 , pr1);
				Course c2 = new Course("Operating systems", 6 , pr2);
				courseRepo.saveAll(Arrays.asList(c1,c2));
				
				Grade g1 = new Grade(10,c1,st1); 
				Grade g2 = new Grade(7,c2,st1);
				Grade g3 = new Grade(8,c1,st1); 
				Grade g4 = new Grade(10,c2,st2); 
				gradeRepo.saveAll(Arrays.asList(g1,g2,g3,g4));
				
				

				
			
			}
		};
	}

}
