import java.util.ArrayList;

public class GeneralCourses {
	private ArrayList<Course> generalCH; // 中文通識
    private ArrayList<Course> generalEN; // 英文通識
    private ArrayList<Course> generalHumanities; // 人文通識
    private ArrayList<Course> generalSocial; // 社會通識
    private ArrayList<Course> generalScience; // 自然通識
    private ArrayList<Course> generalComputer; // 資訊通識
    
    // 課程工廠，用於建立新的課程
    private CourseFactory courseFactory;
    
    public GeneralCourses() {
        // 初始化各類別課程的列表
        generalCH = new ArrayList<>();
        generalEN = new ArrayList<>();
        generalHumanities = new ArrayList<>();
        generalSocial = new ArrayList<>();
        generalScience = new ArrayList<>();
        generalComputer = new ArrayList<>();

        // 創建課程工廠
        courseFactory = new CourseFactory();
        
        // 非核心通識課程
        generalCH.add(courseFactory.createGeneralCourse("國文－古典詩選讀", 3, 20101, "五234", "侯雅文"));
        generalCH.add(courseFactory.createGeneralCourse("國文－古典詩選讀", 3, 20102, "五D56", "侯雅文"));
	

        generalEN.add(courseFactory.createGeneralCourse("大學英文", 3, 20201, "四234", "趙宣彭"));
        generalEN.add(courseFactory.createGeneralCourse("大學英文", 3, 20202, "一D56", "王哲"));
        
        generalHumanities.add(courseFactory.createGeneralCourse("電影藝術", 2, 20301, "四78", "李福鐘"));
        generalHumanities.add(courseFactory.createGeneralCourse("歐洲政府與外交政策", 2, 20302, "五56", "陳美"));
        
        
        generalSocial.add(courseFactory.createGeneralCourse("社會學概論(核)", 3, 20401, "三234", "周公", true));//核心通識
        generalSocial.add(courseFactory.createGeneralCourse("經濟學原理", 3, 20402, "二234", "趙錢"));

        generalScience.add(courseFactory.createGeneralCourse("基礎物理(核)", 3, 20501, "一234", "錢多多", true));//核心通識
        generalScience.add(courseFactory.createGeneralCourse("普通化學", 3, 20502, "二234", "孫化學"));

        generalComputer.add(courseFactory.createGeneralCourse("資訊概論", 3, 20601, "五234", "李技術"));
        generalComputer.add(courseFactory.createGeneralCourse("資訊概論", 3, 20602, "五234", "張演算法"));
    }
    

	public void courseList() {
		String format1 = "%-15s\t%8s\t%12s\t%-10s\t%-10s\n";
		String format2 = "%-15s\t%8d\t%12s\t%-10s\t%-10d\n";
		System.out.printf("國文通識:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		for (Course c : generalCH) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
					c.getID());
		}
		System.out.println("-".repeat(100));

		System.out.printf("外文通識:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		for (Course c : generalEN) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
					c.getID());
		}
		System.out.println("-".repeat(100));

		System.out.printf("人文通識:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		for (Course c : generalHumanities) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
					c.getID());
		}
		System.out.println("-".repeat(100));

		System.out.printf("社會通識:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		for (Course c : generalSocial) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
					c.getID());
		}
		System.out.println("-".repeat(100));

		System.out.printf("自然通識:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		for (Course c : generalScience) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
					c.getID());
		}
		System.out.println("-".repeat(100));

		System.out.printf("資訊通識:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		for (Course c : generalComputer) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
					c.getID());
		}
		System.out.println("-".repeat(100));
        System.out.println("請輸入想追蹤的通識課程代碼:(結束時輸入任意非數字鍵)");
	}
	
	//可用ID優化過程
	public Course findCourse(int id) {
		for (Course c : generalCH) {
			if (c.getID() == id) {
				if (c.checkSelected() == false) {
					return c;
				} else {
					break;
				}
			}
		}
		for (Course c : generalEN) {
			if (c.getID() == id) {
				if (c.checkSelected() == false) {
					return c;
				} else {
					break;
				}
			}
		}
		for (Course c : generalHumanities) {
			if (c.getID() == id) {
				if (c.checkSelected() == false) {
					return c;
				} else {
					break;
				}
			}
		}
		for (Course c : generalSocial) {
			if (c.getID() == id) {
				if (c.checkSelected() == false) {
					return c;
				} else {
					break;
				}
			}
		}
		for (Course c : generalScience) {
			if (c.getID() == id) {
				if (c.checkSelected() == false) {
					return c;
				} else {
					break;
				}
			}
		}
		for (Course c : generalComputer) {
			if (c.getID() == id) {
				if (c.checkSelected() == false) {
					return c;
				} else {
					break;
				}
			}
		}
		Course empty = new Course(true);
		return empty;
	}
}
