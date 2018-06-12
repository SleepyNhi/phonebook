package phonedir;

public class contacts {
	
	
private String fName, lName, phoneNum;

//constructors
public contacts (String fname,String lname,String pNum) {
	fName = fname;
	lName = lname;
	phoneNum = pNum;
}

public String getFirstName(){
	return fName; 
}

public String getLastName(){
	return lName;
}

public String getPhoneNum(){
	return formatNum(phoneNum);
}

public void changeFirst(String fname){
	fName = fname;
}
public void changeLast(String lname){
	lName = lname;
}
public void changeNum(String num){
	phoneNum = num;
}
public String formatNum(String num){
	return num.substring(0, 3) + "-" + num.substring(3, 6) + "-" + num.substring(6, 10);
	
}
public String toString(){
	return fName + "\t\t" + lName + "\t\t" + getPhoneNum();
}
}
