public class CourseFactory {
	
	// 建立非核心通識課程
	public Course createGeneralCourse(String name, int credit, int id, String time, String teacher) {
		return new Course(name, credit, id, time, teacher);
	}
	
	// 建立核心通識課程
	public Course createGeneralCourse(String name, int credit, int id, String time, String teacher, boolean isCore) {
		return new Course(name, credit, id, time, teacher, isCore);
	}
	
    // 生成必修課程
    public Course createRequiredCourse(String name, int credit, int id, String time, String teacher) {
        return new Course(name, credit, id, time, teacher, false); 
    }

    // 生成體育课程
    public Course createSportCourse(String name, int credit, int id, String time, String teacher) {
        return new Course(name, credit, id, time, teacher, false); 
    }

     // 所有课程皆適用(拿來生成研究生課程)
	public Course createCourse(String name, int credit, int id, String time, String teacher) {
		return new Course(name, credit, id, time, teacher);
	}

}
