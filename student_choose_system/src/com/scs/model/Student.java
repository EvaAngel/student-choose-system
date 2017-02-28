package com.scs.model;

import java.util.Date;

public class Student
{
private int id;
private String username;
private String password;
private int age;
private String sex;  //这个地方变成string类型吧，因为jdbc获取的时候还是要string的。
private Date zhucetime;
private Date lastrepairtime;
private String address;
private int tele;
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id = id;
}
public String getUsername()
{
	return username;
}
public void setUsername(String username)
{
	this.username = username;
}
public String getPassword()
{
	return password;
}
public void setPassword(String password)
{
	this.password = password;
}
public int getAge()
{
	return age;
}
public void setAge(int age)
{
	this.age = age;
}
public String getSex()
{
	return sex;
}
public void setSex(String string)
{
	this.sex = string;
}
public Date getZhucetime()
{
	return zhucetime;
}
public void setZhucetime(Date zhucetime)
{
	this.zhucetime = zhucetime;
}
public String getAddress()
{
	return address;
}
public void setAddress(String address)
{
	this.address = address;
}
public int getTele()
{
	return tele;
}
public void setTele(int tele)
{
	this.tele = tele;
}
public Date getLastrepairtime() {
	return lastrepairtime;
}
public void setLastrepairtime(Date lastrepairtime) {
	this.lastrepairtime = lastrepairtime;
}


}
