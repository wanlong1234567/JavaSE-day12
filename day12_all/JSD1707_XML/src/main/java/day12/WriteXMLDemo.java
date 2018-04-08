package day12;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * ʹ��DOM����XML�ĵ�
 * @author adminitartor
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		/*
		 * ����XML�ĵ��Ĵ��²���:
		 * 1:����һ��Document�����ʾһ���հ��ĵ�
		 * 2:��Document����Ӹ�Ԫ��
		 * 3:����XML�ĵ��Ľṹ�������Ԫ��
		 * 4:����XmlWriter����
		 * 5:��Documentд��
		 * 6:�ر�XmlWriter
		 *  
		 */
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1,"����",22,"��",3000));
		list.add(new Emp(2,"����",23,"Ů",4000));
		list.add(new Emp(3,"����",24,"��",5000));
		list.add(new Emp(4,"����",25,"Ů",6000));
		list.add(new Emp(5,"Ǯ��",26,"��",7000));
		
		try {
			//1
			Document doc = DocumentHelper.createDocument();
			
			/*
			 * 2
			 * Document�ṩ����Ӹ�Ԫ�صķ���
			 * Element addElement(String name)
			 * ���ָ�����ֵĸ�Ԫ�أ���������Element
			 * ��ʵ����ʽ�����Ա�Ը�Ԫ�ؼ���������
			 * ��Ҫע�⣬�÷���ֻ�ܵ���һ�Ρ�
			 */
			Element root = doc.addElement("list");
			
			//�������е�ÿ��Ա����<emp>��ǩ��ʽ��ӵ���Ԫ��
			for(Emp emp : list){
				/*
				 * Element�ṩ��������������Ϣ
				 * �ķ���
				 * 1:Element addElement(String name)
				 *   ��ǰ��ǩ����Ӹ������ֵ��ӱ�ǩ
				 *   
				 * 2:Element addText(String text)
				 *   ��ǰ��ǩ������ı���Ϣ
				 *   
				 * 3:Element addAttribute(String name,String value)
				 *   ��ǰ��ǩ�����ָ�������Լ���Ӧֵ������    
				 */
				//���Ԫ�������<emp>
				Element empEle = root.addElement("emp");
				
				//���<name>
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");
				
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary()+"");
				
				empEle.addAttribute("id", emp.getId()+"");
				
			}
			
			FileOutputStream fos 
				= new FileOutputStream("myemp.xml");
			XMLWriter writer 
				= new XMLWriter(fos,OutputFormat.createPrettyPrint());
			
			writer.write(doc);
			System.out.println("д�����!");
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}








