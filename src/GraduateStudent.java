import java.util.ArrayList;

public class GraduateStudent extends NCCUStudent {
    private int CreditFee = 1655 ; // 研究生每學分的費用
    private int totalCreditFee; // 總學分費
    private int misGraduateSelectedCredit;
	private boolean[] misGraduateCheck;
	private ArrayList<Course> misGraduateSelected;
	private String departmentName;
	
    // 建構子: 初始化研究生基本資料和學分費用
    public GraduateStudent(int stdID, int grade, int department) {
        super(stdID, grade, department);
        this.totalCreditFee = 0;
        this.misGraduateSelectedCredit = 0;
		this.misGraduateCheck= new boolean[6];
		this.misGraduateSelected = new ArrayList<Course>();
		this.departmentName = "資訊管理學系";
    }
	
    public int getCreditFee() {
    	return this.CreditFee;
    }
    
    // 計算學分費: 根據課程學分和每學分費用計算總學分費
    public void calculateCreditFee() {
        this.totalCreditFee += this.getCreditFee() * this.misGraduateSelectedCredit;
    }
    
    // 獲取總學分費
    public int getTotalCreditFee() {
        return this.totalCreditFee;
    }

	public void addGraduateCourse(Course c) {
		this.misGraduateSelected.add(c);
		c.setSelected(true);
	}

	public void selectedList(GraduateMISCourses graduatemisCourses) {
		String format1 = "%-15s\t%8s\t%12s\t%-10s\t%-10s\n";
		String format2 = "%-15s\t%8d\t%12s\t%-10s\t%-10d\n";
		System.out.printf("學號:%d 系級:%s %d年級", super.getStdId(), this.departmentName, super.getGrade());
		System.out.printf("\n已選必修:\n");
		System.out.printf(String.format(format1,"課程名稱", "學分", "開課時間", "老師", "選課代碼"));
		System.out.println("-".repeat(100));
		if(!misGraduateSelected.isEmpty()) {
		for(Course c: misGraduateSelected) {
			System.out.printf(format2 , c.getName(), c.getCredit(), c.getTime(), c.getTeacher(), c.getID());

		}
		}else {
			System.out.printf("未選擇課程\n");
		}
		System.out.println("-".repeat(100));
		super.selectedList(this.misGraduateSelectedCredit, this.misGraduateCheck, graduatemisCourses);
	}
 
	public void addGraduateMisCredit(Course c) {
		int index = (c.getID()) / 100 - 300 -1;
		if(this.misGraduateCheck[ index ] == false ) {
			this.misGraduateCheck[ index ] = true;
			misGraduateSelectedCredit += c.getCredit();
		}
	}


   
}
