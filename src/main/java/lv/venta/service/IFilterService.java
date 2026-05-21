package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;

public interface IFilterService {
	public abstract ArrayList<Grade> filterGradesByStudentId(int id)
		throws Exception;
	
	public abstract ArrayList<Grade> filterGradesByCourseTitle(String title) 
			throws Exception;
	
	public abstract ArrayList<Course> filterCoursesByProfessorId(int id) 
			throws Exception;
	
	
}
