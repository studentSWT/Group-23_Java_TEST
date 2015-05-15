package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstName;
	public String lastName;
	public String address1;
	public String phoneHome;
	public String phoneMobile;
	public String phoneWork;
	public String email1;
	public String email2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String address2;
	public String phoneHome2;

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
		//if (phoneHome == null) {
		//	if (other.phoneHome != null)
		//		return false;
		//} else if (!phoneHome.equals(other.phoneHome))
		//	return false;
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
						//int comparePhoneHome = this.phoneHome.toLowerCase().compareTo(other.phoneHome.toLowerCase());
						//if (comparePhoneHome == 0) {
							return 0;
						//} else {
						//	return comparePhoneHome;
						//}
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
	
}