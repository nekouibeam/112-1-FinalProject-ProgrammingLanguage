import java.util.ArrayList;

public class NCCUStudent {
	private int stdID, grade, department, sportCredit, coreSelected, totalGeneralCredit;
	private int[] generalCredit;
	private boolean[] coreCheck;
	private ArrayList<Course> generalSelected;
	private ArrayList<Course> sportSelected;

	public int getStdId() {
		return this.stdID;
	}

	public int getGrade() {
		return this.grade;
	}

	public NCCUStudent(int stdID, int grade, int department) {
		this.stdID = stdID;
		this.grade = grade;
		this.department = department;
		this.sportCredit = 0;
		this.coreSelected = 0;
		this.generalCredit = new int[6];
		this.generalSelected = new ArrayList<Course>();
		this.sportSelected = new ArrayList<Course>();
		this.totalGeneralCredit = 0;
		this.coreCheck = new boolean[3];
		for (int i = 0; i < this.coreCheck.length; i++) {
		    this.coreCheck[i] = false;
		}
	}
	

	public void addGeneralCourse(Course c) {
		if (!(c.checkSelected())) {
			this.generalSelected.add(c);
			c.setSelected(true);
			int index = (c.getID()) / 100 - 200 - 1;
			if (index < 2) {
				if (this.generalCredit[index] < 6) {
					this.generalCredit[index] += c.getCredit();
					this.totalGeneralCredit += c.getCredit();
				} else {
					this.generalCredit[index] += c.getCredit();
				}
			} else if (index >= 2 && index < 5) {
				if (c.checkCore() && this.coreCheck[index - 2] == false) {
					this.coreCheck[index - 2] = true;
					this.coreSelected++;
				}
				if (this.generalCredit[index] < 7) {
					this.generalCredit[index] += c.getCredit();
					this.totalGeneralCredit += c.getCredit();
				} else {
					this.generalCredit[index] += c.getCredit();
				}
			} else {
				if (this.generalCredit[index] < 3) {
					this.generalCredit[index] += c.getCredit();
					this.totalGeneralCredit += c.getCredit();
				} else {
					this.generalCredit[index] += c.getCredit();
				}
			}
		}

	}

	public void addSportCourse(Course c) {
		this.sportSelected.add(c);
		c.setSelected(true);
		if (this.sportCredit == 0) {
			this.sportCredit = 1;
		}else {
			this.sportCredit = 1;
		}
	}

	public void selectedList(int misSelectedCredit, boolean[] misCheck, MISCourses misCourses) {
		String format1 = "%-15s\t%8s\t%12s\t%-10s\t%-10s\n";
		String format2 = "%-15s\t%8d\t%12s\t%-10s\t%-10d\n";
		String format3 = "%-15s\t\t%8d\t%12s\t%-10s\t%-10d\n";
		System.out.printf("\n已選通識:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		if (!this.generalSelected.isEmpty()) {
			for (Course c : generalSelected) {
				System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
						c.getID());
			}
		} else {
			System.out.printf("未選擇課程\n");
		}
		System.out.println("-".repeat(100));

		System.out.printf("\n已選體育:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		if (!this.sportSelected.isEmpty()) {
			for (Course c : sportSelected) {
				System.out.printf(format3 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(),
						c.getID());
			}
		} else {
			System.out.printf("未選擇課程\n");
		}
		System.out.println("-".repeat(100) + "\n");
		System.out.println("目前已追蹤之必修科目的累計學分: " + misSelectedCredit);
		System.out.println("目前已追蹤之通識科目的累計學分: " + totalGeneralCredit);
		System.out.println("體育學分: " + sportCredit);
		System.out.printf("目前已追蹤之總學分: %d\n", sportCredit + totalGeneralCredit + misSelectedCredit);
		// 可列印各類通識的學分，已存在generalCredit
		System.out.println("-".repeat(100));
		System.out.println("未選之必修:");
		System.out.printf("課程名稱	               學分   \n");
		
		
		
		//最後沒追蹤到的必修課程
		ArrayList<Course> misList = misCourses.getCourseList();
		ArrayList<Course> noSelectCourse = new ArrayList<>();
		String prevElement = null;

		for (Course c : misList) {
		    int index = (c.getID()) / 100 - 100 - 1;
		    if (misCheck[index] == false) {
		        if (!c.getName().equals(prevElement)) {
		            noSelectCourse.add(c);
		            System.out.printf("%-20s\t%-6d\n", c.getName(), c.getCredit());
		        }
		        prevElement = c.getName();
		    }
		}

        
       
        
        
		System.out.println("-".repeat(100));
		System.out.println("學分尚不足之通識類別:");
		if (this.generalCredit[0] < 3) {
			System.out.println("中國語文:\t" + (3 - this.generalCredit[0]));
		}
		if (this.generalCredit[1] < 6) {
			System.out.println("外國語言:\t" + (6 - this.generalCredit[1]));
		}
		if (this.generalCredit[2] < 3) {
			System.out.println("人文學:\t" + (3 - this.generalCredit[2]));
		}
		if (this.generalCredit[3] < 3) {
			System.out.println("社會科學:\t" + (3 - this.generalCredit[3]));
		}
		if (this.generalCredit[4] < 3) {
			System.out.println("自然科學:\t" + (3 - this.generalCredit[4]));
		}
		if (this.generalCredit[5] < 2 && this.department != 306) {
			System.out.println("資訊:\t" + (3 - this.generalCredit[5]));
		}
		if (this.coreSelected < 2) {
			System.out.print("核心通識還缺: " + (2 - this.coreSelected) + "門,\n	可選擇:");
			if (this.coreCheck[0] == false) {
				System.out.print(" 人文核通");
			}
			if (this.coreCheck[1] == false) {
				System.out.print(" 社會核通");
			}
			if (this.coreCheck[2] == false) {
				System.out.print(" 自然核通");
			}
			System.out.print("\n");
		}
		if (this.totalGeneralCredit < 28) {
			System.out.println("合計通識學分還缺: " + (28 - this.totalGeneralCredit));
		} else {
			System.out.println("合計通識學分還缺: 0");
		}

	}
	
	
	// overload selectedList
	public void selectedList(int misGraduateSelectedCredit, boolean[] misGraduateCheck, GraduateMISCourses graduatemisCourses) {
		GraduateStudent s = new GraduateStudent(stdID, grade, department);
		System.out.println("總學分費: " + misGraduateSelectedCredit * s.getCreditFee());
		System.out.println("目前已追蹤之累計學分: " + misGraduateSelectedCredit);
		System.out.println("-".repeat(100));
		System.out.println("未選之研究所課程:");
		System.out.printf("課程名稱	             學分   \n");
		
		//最後沒追蹤到的研究生課程
		ArrayList<Course> misList = graduatemisCourses.getGraduateMISCourses();
		ArrayList<Course> noSelectCourse = new ArrayList<>();
		String prevElement = null;

		for (Course c : misList) {
		    int index = (c.getID()) / 100 - 300 - 1;
		    if (misGraduateCheck[index] == false) {
		        if (!c.getName().equals(prevElement)) {
		            noSelectCourse.add(c);
		            System.out.printf("%-20s%-6d\n", c.getName(), c.getCredit());
		        }
		        prevElement = c.getName();
		    }
		}				
		

        
		System.out.println("-".repeat(100));
	}
	
	
	
	
}
