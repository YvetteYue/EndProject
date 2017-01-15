package it.uniroma1.dis.wsngroup.gexf4j.examples;

import it.uniroma1.dis.wsngroup.gexf4j.core.EdgeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;
import it.uniroma1.dis.wsngroup.gexf4j.core.Graph;
import it.uniroma1.dis.wsngroup.gexf4j.core.Mode;
import it.uniroma1.dis.wsngroup.gexf4j.core.Node;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeClass;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeList;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.GexfImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.StaxGraphWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.data.AttributeListImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.NodeShape;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;


public class TestStatic {

	public static void main(String[] args) {
		ArrayList<NodeMsg> nodeArr=QueryDBS.QueryNode();
		ArrayList<EdgeMsg> edgeArr=QueryDBS.QueryEdge();
		Gexf gexf = new GexfImpl();
		Calendar date = Calendar.getInstance();
		
		gexf.getMetadata()
			.setLastModified(date.getTime())
			.setCreator("Gephi.org")
			.setDescription("A Web network");
		gexf.setVisualization(true);

		Graph graph = gexf.getGraph();
		graph.setDefaultEdgeType(EdgeType.UNDIRECTED).setMode(Mode.STATIC);
		
		AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
		graph.getAttributeLists().add(attrList);
		
		Attribute attTrans = attrList.createAttribute("0", AttributeType.STRING, "trans");
		int i=0;
		Hashtable<String,String> hashId=new Hashtable<String,String>();
		Hashtable<String,Node> hashNode=new Hashtable<String,Node>();
		for (NodeMsg nodeMsg:nodeArr){
			hashId.put(nodeMsg.getName(), "No"+i);
			
			Node gephi = graph.createNode("No"+i);
			gephi
				.setLabel(nodeMsg.getName())
				.setSize(20)
				.getAttributeValues()
					.addValue(attTrans, nodeMsg.getTrans());
			gephi.getShapeEntity().setNodeShape(NodeShape.DIAMOND);
			hashNode.put("No"+i, gephi);
			i++;
		}
		int num=1;
		for(EdgeMsg edgeMsg:edgeArr){
			String sourceId=hashId.get(edgeMsg.getSource());
			Node source=hashNode.get(sourceId);
			String targetId=hashId.get(edgeMsg.getTarget());
			System.out.println(edgeMsg.getSource()+" "+edgeMsg.getTarget());
			System.out.println(sourceId+" "+targetId);
			Node target=hashNode.get(targetId);
			source.connectTo(num+" ",edgeMsg.getRelation(),target);
			num++;
		}
		//Ð´ÈëÎÄ¼þ
		StaxGraphWriter graphWriter = new StaxGraphWriter();
		File f = new File("graph.gexf");
		Writer out;
		try {
			out =  new FileWriter(f, false);
			graphWriter.writeToStream(gexf, out, "UTF-8");
			System.out.println(f.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
