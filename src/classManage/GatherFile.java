package classManage;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class GatherFile {
	int inputNum;
	String path = "D:/整理/17软工1 形势政策";
	ArrayList<File> list;
	
	public GatherFile() {
        int folderNum = 0;
        File file = new File(path);
        list = new ArrayList<File>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    folderNum++;
                } else {
                	list.add(file2);
                    inputNum++;
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
	
	public void show() {
		File temp;
		Iterator it = list.iterator();
		while(it.hasNext()) {
			temp = (File) it.next();
			System.out.println(temp.getName());
		}
	}
	
	public void formatRename(NameList numeList) {
		File road;
		Student base = null;
		File check = null;
		Iterator<Student> inner = numeList.copy.iterator();
		Iterator<File> outer = list.iterator();
		String head = path + '\\';
		StringBuffer load;
		
		while(outer.hasNext()) {
			check = outer.next();
			while(inner.hasNext()) {
				base = inner.next();			
				if(check.getName().contains(base.name) || check.getName().contains(base.no + "")) {
					load = new StringBuffer(head);
//					load.append(base.no + " " + base.name);
//					load.append(" " + numeList.className + " 实验八");
					//load.append(numeList.className + " ");
					load.append(base.no + " " + base.name);
					load.append(check.getName().substring(check.getName().indexOf('.'), check.getName().length()));
					road = new File(load.toString());
					check.renameTo(road);
					inner.remove();
					break;
				}
			}
			inner = numeList.copy.iterator();
		}
	}
}
