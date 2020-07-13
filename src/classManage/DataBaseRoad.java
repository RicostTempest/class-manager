package classManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseRoad {
	public void roading(NameList list){
        //����Connection����
        Connection con;
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
        String url = "jdbc:mysql://localhost:3306/class_manage";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "1722110122";
        //������ѯ�����
        try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            /*
             * ���� ��β�ֶ�Ϊ���ݱ������
             */
            String sql = "select * from 17softe1";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = statement.executeQuery(sql);

             
            int no = 0;
            String name = null;
            while(rs.next()){
                //��ȡno�ֶ�
                no = rs.getInt("no");
                //��ȡname�ֶ�
                name = rs.getString("name");
                
                list.list.add(new Student(no,name));
                list.copy.add(new Student(no,name));
                list.show.add(new Student(no,name));

                list.num = rs.getRow();
                list.className = rs.getString("class");
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }	
	}
}
