package com.lstop.pojo;

public class User {
    private Integer uid;

    private String upassword;

    private Byte uissupper;

    private String uaddress;

    private String utel;

    private Byte uage;

    private Byte usex;

    private String uname;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public Byte getUissupper() {
        return uissupper;
    }

    public void setUissupper(Byte uissupper) {
        this.uissupper = uissupper;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress == null ? null : uaddress.trim();
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel == null ? null : utel.trim();
    }

    public Byte getUage() {
        return uage;
    }

    public void setUage(Byte uage) {
        this.uage = uage;
    }

    public Byte getUsex() {
        return usex;
    }

    public void setUsex(Byte usex) {
        this.usex = usex;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", upassword=" + upassword + ", uissupper=" + uissupper + ", uaddress=" + uaddress
				+ ", utel=" + utel + ", uage=" + uage + ", usex=" + usex + ", uname=" + uname + "]";
	}
    
}