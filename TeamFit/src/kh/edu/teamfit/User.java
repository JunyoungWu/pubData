package kh.edu.teamfit;

public class User extends People  {

	String teacherName;

	

	public User(String name, String pnum, String id, String password, boolean teacher, String teacherName) {
		super(name, pnum, id, password, teacher);
		this.teacherName=teacherName;
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getPnum() {
		return super.getPnum();
	}

	@Override
	public void setPnum(String pnum) {
		super.setPnum(pnum);
	}

	@Override
	public String getId() {
		return super.getId();
	}

	@Override
	public void setId(String id) {
		super.setId(id);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}


	

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		
		return super.toString()
		+"teacherName = "+teacherName;
	}
	
	
	
	
	

}
