package it.uniroma1.dis.wsngroup.gexf4j.examples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDBS {

//	public ArrayList<NodeMsg> nodeArr=new ArrayList<NodeMsg>();
//	public  ArrayList<Edge> edgeArr=new ArrayList<Edge>();
	private static String sql = null;
	private static DBHelper db1 = null;
	private static ResultSet ret = null;
	
	
	public static ArrayList<NodeMsg> QueryNode() {
		ArrayList<NodeMsg> nodeArr=new ArrayList<NodeMsg>();
		sql = "select * from node";//SQL���
		db1 = new DBHelper(sql);//����DBHelper����

		try {
			ret = db1.pst.executeQuery();//ִ����䣬�õ������
			while (ret.next()) {
				NodeMsg node=new NodeMsg(ret.getString(2), ret.getString(3));
				nodeArr.add(node);
			}//��ʾ����
			ret.close();
			db1.close();//�ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nodeArr;
	}
	
	public static  ArrayList<EdgeMsg> QueryEdge() {
		ArrayList<EdgeMsg> edgeArr=new ArrayList<EdgeMsg>();
		sql = "select * from relation";//SQL���
		db1 = new DBHelper(sql);//����DBHelper����

		try {
			ret = db1.pst.executeQuery();//ִ����䣬�õ������
			while (ret.next()) {
				EdgeMsg edge=new EdgeMsg(ret.getString(2), ret.getString(3),ret.getString(4));
				edgeArr.add(edge);
			}//��ʾ����
			ret.close();
			db1.close();//�ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return edgeArr;
	}

}

