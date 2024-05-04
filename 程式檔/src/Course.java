public class Course{
	private int credit, id;
	private String teacher, name, time;
	private boolean empty = false;
	private boolean selected = false;
	private boolean core = false;
	
	public Course(String name, int credit, int id, String time, String teacher) {
		this.name = name;
		this.credit = credit;
		this.id = id;
		this.teacher = teacher;
		this.time = time;
	}
	
	public Course(String name, int credit, int id, String time, String teacher, boolean core) {
		this.name = name;
		this.credit = credit;
		this.id = id;
		this.teacher = teacher;
		this.time = time;
		this.core = core;
	}
	
	public Course(boolean b) {
		this.empty = true;
	}
	
	public boolean checkCore() {
		return this.core;
	}
	
	public boolean checkEmpty() {
		return this.empty;
	}
	
	public boolean checkSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean b) {
		this.selected = b;
	}
	
	public int getCredit() {
		return this.credit;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public String getTeacher() {
		return this.teacher;
	}
	
	public String getTime() {
		return this.time;
	}
}
