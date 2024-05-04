import java.util.ArrayList;

public class MISStudent extends NCCUStudent {
	private int misSelectedCredit;
	private boolean[] misCheck;
	private ArrayList<Course> misSelected;
	private String departmentName;

	public MISStudent(int stdID, int grade, int department) {
		super(stdID, grade, department);
		this.misSelectedCredit = 0;
		this.misCheck = new boolean[13];
		this.misSelected = new ArrayList<Course>();
		this.departmentName = "資訊管理學系";
		
	}

	public void addMisCourse(Course c) {
		this.misSelected.add(c);
		c.setSelected(true);
	}

	public void selectedList(MISCourses misCourses) {
		String format1 = "%-15s\t%8s\t%12s\t%-10s\t%-10s\n";
		String format2 = "%-15s\t%8d\t%12s\t%-10s\t%-10d\n";
		System.out.printf("學號:%d 系級:%s %d年級", super.getStdId(), this.departmentName, super.getGrade());
		System.out.printf("\n已選必修:");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		if(!misSelected.isEmpty()) {
		for(Course c: misSelected) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(), c.getID());
		}
		}else {
			System.out.printf("未選擇課程\n");
		}
		System.out.println("-".repeat(100));
		super.selectedList(this.misSelectedCredit, this.misCheck, misCourses);
	}
	
	public void addMisCredit(Course c) {
		int index = (c.getID()) / 100 - 100 -1;
		if(this.misCheck[ index ] == false ) {
			this.misCheck[ index ] = true;
			misSelectedCredit += c.getCredit();
		}
	}
}
