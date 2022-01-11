package com.lendingpoint.atbsimulator.parser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.lendingpoint.atbsimulator.entity.DataSourceInputsEntity;

public class ParseXMLDocument {
	private String lookupValue = null;

	public String readXml(Document doc) {

		try {
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("datasource_inputs");

			ArrayList<DataSourceInputsEntity> arrayList = new ArrayList<DataSourceInputsEntity>();

			// nodeList is not iterable, so we are using for loop

			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					DataSourceInputsEntity applicantdetail = new DataSourceInputsEntity();
					
					applicantdetail.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
					applicantdetail.setValue(eElement.getElementsByTagName("value").item(0).getTextContent());

					arrayList.add(applicantdetail);

				}
			}

			arrayList.forEach(std -> {
				if (std.getName().equals("first_name")) {
					lookupValue = std.getValue();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lookupValue;
	}

}
