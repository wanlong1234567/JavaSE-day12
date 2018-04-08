package day12;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DOM����XML�ĵ�
 * @author adminitartor
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		/*
		 * ����XML�ĵ�emplist.xml�������е�����
		 * Ա����Ϣת��Ϊ���ɸ�Empʵ�������뼯��
		 */
		List<Emp> list = new ArrayList<Emp>();
		
		/*
		 * ʹ��DOM����XML�Ĵ�������:
		 * 1:����SAXReader
		 * 2:ʹ��SAXReader��ȡҪ������XML�ĵ�
		 *   ������һ��Document����
		 *   ��һ������DOM��ʱ����Դ�ĵط�����Ϊ
		 *   Ҫ�Ƚ�XML�ĵ�ȫ����ȡ��ϲ����뵽һ
		 *   ��Document�����С�
		 * 3:����Document�����ȡ��Ԫ��
		 * 4:����XML�ĵ��Ľṹ�Ӹ�Ԫ�ؿ�ʼ�𼶻�
		 *   ȡ��Ԫ�أ��Ѵﵽ����XML�ĵ���ȡ����
		 *   ��Ŀ��  
		 */
		try {
			//1
			SAXReader reader = new SAXReader();
			/*
			 * 2 ����XML�ĵ�
			 * SAXReader�ṩ�˶�ȡ����ط���:
			 * Document read(File file)
			 * ����ָ��File��������ʾ��XML�ĵ�
			 * 
			 * Document read(InputStream is)
			 * �Ӹ������ֽ����ж�ȡXML�ĵ����ݲ�����
			 * 
			 * Document read(Reader reader)
			 * �Ӹ������ַ����ж�ȡXML�ĵ����ݲ�����
			 * 
			 * �������������������java�и߼�������
			 */
			Document doc = reader.read(
				new FileInputStream("emplist.xml")	
			);
			
			/*
			 * 3 ��ȡ��Ԫ��
			 * Document�ṩ�˻�ȡ��Ԫ�صķ���:
			 * Element getRootElement()
			 * 
			 * Element��ÿһ��ʵ�����ڱ�ʾXML�ĵ�
			 * �е�һ��Ԫ��(һ�Ա�ǩ).
			 * 
			 */
			Element root = doc.getRootElement();
			/*
			 * Element��ʾһ��XML�ĵ��е�һ��Ԫ��(��ǩ)
			 * ���ṩ�˻�ȡ��Ԫ�������Ϣ�ķ���:
			 * String getName()
			 * ��ȡ��ǰԪ�ص�����
			 * 
			 * Element element(String name)
			 * ��ȡ��ǰԪ����ָ�����ֵ���Ԫ��
			 * 
			 * List elements()
			 * ��ȡ��ǰԪ���е�������Ԫ��
			 * 
			 * List elements(String name)
			 * ��ȡ��ǰԪ��������ͬ����Ԫ��
			 * 
			 * String getText()
			 * ��ȡ��ǰԪ���е��ı�(��ʼ��ǩ�ͽ���
			 * ��ǩ�м���ı���Ϣ)
			 * 
			 * Attribute attribute(String name)
			 * ��ȡ��ǰԪ����ָ�����ֵ�����
			 * 
			 */
			List<Element> emplist = root.elements();
			
			for(Element empEle : emplist){
//				System.out.println(empEle.getName());
				
				//��ȡ����
				Element nameEle = empEle.element("name");
				String name = nameEle.getText();
				System.out.println(name);
				
				int age = Integer.parseInt(
					empEle.elementText("age")
				);
				
				String gender = empEle.elementText("gender");
				
				int salary = Integer.parseInt(
					empEle.elementText("salary")	
				);
				
				//��ȡid���Ե�ֵ
//				empEle.attributeValue("id");
				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(attr.getValue());
				
				Emp emp = new Emp(id, name, age, gender, salary);
				list.add(emp);
			}
			
			//�������
			System.out.println("�������");
			for(Emp emp : list){
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}









