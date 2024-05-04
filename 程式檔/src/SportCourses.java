import java.util.ArrayList;

public class SportCourses {
	
	private ArrayList<Course> sport;
    private CourseFactory courseFactory;
    
    public SportCourses() {
        sport = new ArrayList<>();
        courseFactory = new CourseFactory();

         // 使用 CourseFactory 來創建體育課程
        sport.add(courseFactory.createSportCourse("籃球", 1, 301, "週一", "孫教練"));
        sport.add(courseFactory.createSportCourse("羽球", 1, 302, "週二", "周教練"));
        
    }
    
	
	public void courseList() {
		String format1 = "%-15s\t%8s\t%12s\t%-10s\t%-10s\n";
		String format2 = "%-15s\t%8d\t%12s\t%-10s\t%-10d\n";
		System.out.printf("\n體育必修:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		for(Course c: sport) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(), c.getID());
		}
		System.out.println("-".repeat(100));
		System.out.println("請輸入想追蹤的體育課程代碼:(結束時輸入任意非數字鍵)");
	}
	
	public Course findCourse(int id) {
		for(Course c: sport) {
			if(c.getID() == id) {
				if (c.checkSelected() == false) {
					return c;
				}else {
					break;
				}
			}
		}
		Course empty = new Course(true);
		return empty;
	}
}
