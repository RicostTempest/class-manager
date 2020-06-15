package classManage;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Manage {
	public static void main(String args[]) {
		NameList test = new NameList();
		new DataBaseRoad().roading(test);
		GatherFile input = new GatherFile();
		
		test.serch(input);
		
		
		test.show();
		
		input.formatRename(test);
		
//		for(Student item : test.show) {
//			switch(item.no%10) {
//			case 1:System.out.println(item.name  + " " + item.no);break;
//			case 4:System.out.println(item.name  + " " + item.no);break;
//			case 7:System.out.println(item.name  + " " + item.no);break;
//			}
//		}
	}
	
}
class NameList{
	//存放学号+姓名的List
	ArrayList<Student> list;
	ArrayList<Student> copy;
	ArrayList<Student> show;
	//班级人数
	int num;
	//班级
	String className;
	
	public NameList() {
		list = new ArrayList<Student>();
		copy = new ArrayList<Student>();
		show = new ArrayList<Student>();
		
	}
	
	public void show() {
		Object temp;
		Iterator it = list.iterator();
		while(it.hasNext()) {
			temp = it.next();
			System.out.println(temp.toString());
		}
		System.out.println(this.className);
		System.out.println(list.size());
	}
	
	void serch(GatherFile input) {
		Student base = null;
		File check = null;
		Iterator<Student> inner = this.list.iterator();
		Iterator<File> outer = input.list.iterator();
		
		while(outer.hasNext()) {
			check = outer.next();
			while(inner.hasNext()) {
				base = inner.next();
				if(check.getName().contains(base.name)) {
					inner.remove();
					break;
				}else if(check.getName().contains(base.no + "")) {
					inner.remove();
					break;
				}
			}
			inner = this.list.iterator();
		}				
	}
}
class Student{
	int no;
	String name;
	
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public String toString() {
		return this.no + " " + this.name;
	}
	
}
