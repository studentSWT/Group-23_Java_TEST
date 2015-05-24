package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String address1;
	private String phoneHome;
	private String phoneMobile;
	private String phoneWork;
	private String email1;
	private String email2;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String address2;
	private String phoneHome2;

	public ContactData(){ 
	}
	
	public ContactData(String firstName, String lastName, String address1,
			String phoneHome, String phoneMobile, String phoneWork,
			String email1, String email2, String birthDay, String birthMonth,
			String birthYear, String address2, String phoneHome2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.phoneHome = phoneHome;
		this.phoneMobile = phoneMobile;
		this.phoneWork = phoneWork;
		this.email1 = email1;
		this.email2 = email2;	
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.address2 = address2;
		this.phoneHome2 = phoneHome2;
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneHome=" + phoneHome + ", email1=" + email1
				+ ", email2=" + email2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
		//result = prime * result + ((email2 == null) ? 0 : email2.hashCode());
		//result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		//result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		//result = prime * result + ((phoneHome == null) ? 0 : phoneHome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email1 == null) {
			if (other.email1 != null)
				return false;
		} else if (!email1.equals(other.email1))
			return false;
		if (email2 == null) {
			if (other.email2 != null)
				return false;
		} else if (!email2.equals(other.email2))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneHome == null) {
			if (other.phoneHome != null)
				return false;
		} else if (!phoneHome.equals(other.phoneHome))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ContactData other) {
		int compareFirstName = this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
		if (compareFirstName == 0) {
			int compareLastName = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
			if (compareLastName == 0) {
				int compareEmail1 = this.email1.toLowerCase().compareTo(other.email1.toLowerCase());
				if (compareEmail1 == 0) {
					int compareEmail2 = this.email2.toLowerCase().compareTo(other.email2.toLowerCase());
					if (compareEmail2 == 0) {
						int comparePhoneHome = this.phoneHome.toLowerCase().compareTo(other.phoneHome.toLowerCase());
						if (comparePhoneHome == 0) {
							return 0;
						} else {
							return comparePhoneHome;
						}
					} else {
						return compareEmail2;
					}
				} else {
					return compareEmail1;
				}
			} else {
				return compareLastName;
			}
		} else {
			return compareFirstName;
		}
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress1(String address1) {
		this.address1 = address1;
		return this;
	}
	
	public ContactData withPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
		return this;
	}

	public ContactData withPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
		return this;
	}

	public ContactData withPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}

	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhoneHome2(String phoneHome2) {
		this.phoneHome2 = phoneHome2;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhoneHome2() {
		return phoneHome2;
	}
	
}