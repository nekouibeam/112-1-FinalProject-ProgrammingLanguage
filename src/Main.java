import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.printf("請輸入學號、年級、系所代號(用空白隔開)");
		System.out.printf("\n系所代號備註 \n資管系: 306\n資管所: 356\n");
		try {
			Scanner sc = new Scanner(System.in);
			MISStudent misStd;
			GraduateStudent graduatemisStd;
			SelectMenu menu = new SelectMenu();

			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("請按指示輸入!");
			}
			int stdID = sc.nextInt();

			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("請按指示輸入!");
			}
			int grade = sc.nextInt();

			boolean notFindD = true;
			while (notFindD) {
				while (!sc.hasNextInt()) {
					sc.next();
					System.out.println("請按指示輸入!");
				}
				int department = sc.nextInt();

				if (department == 306) {
					misStd = new MISStudent(stdID, grade, department);
					System.out.println("-".repeat(40));
					menu.selectMenu(misStd, sc);
					notFindD = false;
				}else if (department == 356) {
					graduatemisStd = new GraduateStudent(stdID, grade, department);
					System.out.println("-".repeat(40));
					menu.selectMenu(graduatemisStd, sc);
					notFindD = false;
					
				} else {
					System.out.println("請輸入正確的學系代碼");
				}
			
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
