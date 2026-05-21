package lv.venta.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Table(name = "GradeTable")
@Entity
public class Grade {

	@Column(name = "Gid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gid;
	
	
	@Min(0)
	@Max(10)
	@Column(name = "GradeValue")
	private int gradeValue;
	
	
	@ManyToOne
	@JoinColumn(name = "Cid")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "Sid")
	private Student student;
	
	
	
	
	public int getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(int gradeValue) {
		this.gradeValue = gradeValue;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getGid() {
		return gid;
	}

	public Grade() {
		
	}
	
	public Grade(int gradeValue, Course course, Student student) {
		setGradeValue(gradeValue);
		setCourse(course);
		setStudent(student);

	}
	
	public String toString() {
		return "" + gradeValue + " (" + student.getName() + "" + student.getSurname()+ "), " +course.getTitle();
	}
}
