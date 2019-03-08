package cn.fruit.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 与XML的接口类，使用Dom4j技术
 * @author zzshang
 *
 */
public class XmlUtils {
	private static String filepath;
	static{
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
	}
	
	/**
	 * 读取xml内容，返回对象
	 * @return
	 * @throws DocumentException
	 */
	public static Document getDocument() throws DocumentException{  //因为工具类是简化上一层的代码，所以异常往上抛即可
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filepath));
		return document;
	}
	
	/**
	 * 将对象写入xml
	 * @param document
	 * @throws Exception
	 */
	public static void write2Xml(Document document) throws Exception {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath), format);
		writer.write(document);
		writer.close();
	}
}
