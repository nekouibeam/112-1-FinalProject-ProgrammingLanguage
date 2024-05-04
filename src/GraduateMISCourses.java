import java.util.ArrayList;

public class GraduateMISCourses {

	private ArrayList<Course> graduateMISCourses;
    private CourseFactory courseFactory;


    public GraduateMISCourses() {
        graduateMISCourses = new ArrayList<>();
        courseFactory = new CourseFactory();
        
        
        graduateMISCourses.add(courseFactory.createCourse("決策科學", 3, 30101, "四234", "莊皓鈞"));
        graduateMISCourses.add(courseFactory.createCourse("研究方法", 3, 30201, "三D56", "周彥君"));
        graduateMISCourses.add(courseFactory.createCourse("資料模式", 3, 30301, "四D56", "洪為璽"));
    }
    
    public ArrayList<Course> getGraduateMISCourses() {
        return graduateMISCourses;
    }
    
    public void courseList() {
    	String format1 = "%-15s\t%8s\t%12s\t%-10s\t%-10s\n";
		String format2 = "%-15s\t%8d\t%12s\t%-10s\t%-10d\n";
        System.out.printf("\n資管所必修:\n");
        System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
        for (Course course : graduateMISCourses) {
        	System.out.printf(format2 , 
                course.getName(), course.getCredit(), course.getTime(),
                course.getTeacher(), course.getID());
        }
        System.out.println("-".repeat(100));
        System.out.println("請輸入想追蹤的研究所課程代碼:(結束時輸入任意非數字鍵)");
    }
    

    
    public Course findCourse(int id) {
        for (Course course : graduateMISCourses) {
            if (course.getID() == id) {
                if (!course.checkSelected()) {
                    return course;
                } else {
                    break;
                }
            }
        }
        return new Course(true);
    }
    
    
    
}
