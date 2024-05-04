import java.util.Scanner;

public class SelectMenu {
	private MISCourses misCourses = new MISCourses();
	private GeneralCourses generalCourses = new GeneralCourses();
	private SportCourses sportCourses = new SportCourses();
	private GraduateMISCourses graduatemisCourses = new GraduateMISCourses();
	
	public void selectMenu(MISStudent misStd, Scanner sc) {
		try {
			System.out.printf("\n請輸入想查看的課程類別(必修打1，通識打2，體育打3，看完打0):	\n");
			while (!sc.hasNextInt()) {
	            sc.next(); // 清除錯誤輸入
	            System.out.println("請按指示輸入!");
	        }
			int input = sc.nextInt();
			switch (input) {
			case 1:
				misCourses.courseList();
				while(sc.hasNextInt()) {
					int courseInput = sc.nextInt();
					Course getC; 
					getC = misCourses.findCourse(courseInput);
					if(getC.checkEmpty()) {
						continue;
					}else {
						misStd.addMisCourse(getC);
						misStd.addMisCredit(getC);
					}
				}
				sc.next();
				selectMenu(misStd, sc);
				break;
			case 2:
				generalCourses.courseList();
				while(sc.hasNextInt()) {
					int courseInput = sc.nextInt();
					Course getC; 
					getC = generalCourses.findCourse(courseInput);
					if(getC.checkEmpty()) {
						continue;
					}else {
						misStd.addGeneralCourse(getC);
					}
				}
				sc.next();
				selectMenu(misStd, sc);
				break;
			case 3:
				sportCourses.courseList();
				while(sc.hasNextInt()) {
					int courseInput = sc.nextInt();
					Course getC; 
					getC = sportCourses.findCourse(courseInput);
					if(getC.checkEmpty()) {
						continue;
					}else {
						misStd.addSportCourse(getC);
					}
				}
				sc.next();
				selectMenu(misStd, sc);
				break;
			case 0:
				misStd.selectedList(misCourses);
				System.out.printf("是否要繼續選課(是打1, 否按任意鍵): ");
			    if(!sc.hasNextInt()) {
			    	System.out.printf("系統已關閉, 感謝使用本系統!");
			    	break;
			    }
				int con = sc.nextInt();
				if(con == 1) {
					selectMenu(misStd, sc);
				}else {
					System.out.printf("系統已關閉, 感謝使用本系統!");
				}
				break;
				
			default:
				System.out.println("請按指示輸入!");
				selectMenu(misStd, sc);
				break;
		
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectMenu(GraduateStudent graduatemisStd, Scanner sc) {
		try {
			System.out.printf("\n請輸入想查看的課程類別(查看研究生課程打1，看完打0):	\n");
			while (!sc.hasNextInt()) {
	            sc.next(); // 清除錯誤輸入
	            System.out.println("請按指示輸入!");
	        }
			int input = sc.nextInt();
			switch (input) {
			case 1:
				graduatemisCourses.courseList();
				while(sc.hasNextInt()) {
					int courseInput = sc.nextInt();
					Course getC; 
					getC = graduatemisCourses.findCourse(courseInput);
					if(getC.checkEmpty()) {
						continue;
					}else {
						graduatemisStd.addGraduateCourse(getC);
						graduatemisStd.addGraduateMisCredit(getC);
					}
				}
				sc.next();
				selectMenu(graduatemisStd, sc);
				break;
				
			case 0:
				graduatemisStd.selectedList(graduatemisCourses);
				System.out.printf("是否要繼續選課(是打1, 否按任意鍵): ");
			    if(!sc.hasNextInt()) {
			    	System.out.printf("系統已關閉, 感謝使用本系統!");
			    	break;
			    }
				int con = sc.nextInt();
				if(con == 1) {
					selectMenu(graduatemisStd, sc);
				}else {
					System.out.printf("系統已關閉, 感謝使用本系統!");
				}
				break;
				
			default:
				System.out.println("請按指示輸入!");
				selectMenu(graduatemisStd, sc);
				break;
			}
		sc.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
