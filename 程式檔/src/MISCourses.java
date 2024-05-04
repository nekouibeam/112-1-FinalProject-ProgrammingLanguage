import java.util.ArrayList;

public class MISCourses {
	
	private ArrayList<Course> required;
    
    private CourseFactory courseFactory;
	
    
    public MISCourses() {
     // 初始化必修課程列表
        required = new ArrayList<>();
     // 建立課程工廠
        courseFactory = new CourseFactory();

     // 使用 CourseFactory 來建立必修課程
        required.add(courseFactory.createRequiredCourse("初級會計學（一）", 3, 10101, "一D56", "徐愛恩"));
        required.add(courseFactory.createRequiredCourse("初級會計學（一）", 3, 10102, "一D56", "何怡澄"));
        required.add(courseFactory.createRequiredCourse("初級會計學（一）", 3, 10103, "一D56", "林禹銘"));
        required.add(courseFactory.createRequiredCourse("計算機概論", 2, 10201, "五23", "簡士鎰"));
        required.add(courseFactory.createRequiredCourse("計算機概論", 2, 10202, "五D5", "簡士鎰"));
        required.add(courseFactory.createRequiredCourse("程式設計一", 2, 10301, "一56", "林怡伶"));
        required.add(courseFactory.createRequiredCourse("程式設計一", 2, 10302, "二23", "林怡伶"));
        required.add(courseFactory.createRequiredCourse("經濟學", 3, 10401, "五56", "廖仁哲"));
        required.add(courseFactory.createRequiredCourse("經濟學", 3, 10402, "四D56", "莊奕琦"));
        required.add(courseFactory.createRequiredCourse("經濟學", 3, 10403, "五234", "王信實"));
        
        required.add(courseFactory.createRequiredCourse("管理學", 3, 10501, "一EFG", "林呈欣"));
        required.add(courseFactory.createRequiredCourse("管理學", 3, 10502, "五D56", "林介勝"));
        required.add(courseFactory.createRequiredCourse("管理學", 3, 10503, "一567", "張聰本"));
        
    }
    
    public ArrayList<Course> getCourseList() {
        return required;
    }
    

    
    public void courseList() {
    	String format1 = "%-15s\t%8s\t%12s\t%-10s\t%-10s\n";
		String format2 = "%-15s\t%8d\t%12s\t%-10s\t%-10d\n";
        System.out.printf("\n資管系必修:\n");
        System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
        for (Course course : required) {
        	System.out.printf(format2 , 
                course.getName(), course.getCredit(), course.getTime(),
                course.getTeacher(), course.getID());
        }
        System.out.println("-".repeat(100));
        System.out.println("請輸入想追蹤的必修課程代碼:(結束時輸入任意非數字鍵)");
    }
    


    
    
    
    public Course findCourse(int id) {
        for (Course course : required) {
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