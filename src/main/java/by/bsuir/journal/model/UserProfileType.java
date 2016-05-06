package by.bsuir.journal.model;

public enum UserProfileType {
	USER("USER"),
	MANAGER("MANAGER"),
	EMPLOYEE("EMPLOYEE");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
