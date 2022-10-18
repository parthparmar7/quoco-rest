package service.core;

/**
 * Interface to define the state to be stored in ClientInfo objects
 * 
 * @author Rem
 *
 */
public class ClientInfo {

	private static final char MALE = 'M';
	private static final char FEMALE = 'F';
	private String name;
	private char gender;
	private int age;
	private int points;
	private int noClaims;
	private String licenseNumber;

	public ClientInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getNoClaims() {
		return noClaims;
	}

	public void setNoClaims(int noClaims) {
		this.noClaims = noClaims;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

}


//
//	public ClientInfo(String name, char sex, int age, int points, int noClaims, String licenseNumber) {
//		this.name = name;
//		this.gender = sex;
//		this.age = age;
//		this.points = points;
//		this.noClaims = noClaims;
//		this.licenseNumber = licenseNumber;
//	}

