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
		sql = "select * from node";//SQL语句
		db1 = new DBHelper(sql);//创建DBHelper对象

		try {
			ret = db1.pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {
				NodeMsg node=new NodeMsg(ret.getString(2), ret.getString(3));
				nodeArr.add(node);
			}//显示数据
			ret.close();
			db1.close();//关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nodeArr;
	}
	
	public static  ArrayList<EdgeMsg> QueryEdge() {
		ArrayList<EdgeMsg> edgeArr=new ArrayList<EdgeMsg>();
		sql = "select * from relation";//SQL语句
		db1 = new DBHelper(sql);//创建DBHelper对象

		try {
			ret = db1.pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {
				EdgeMsg edge=new EdgeMsg(ret.getString(2), ret.getString(3),ret.getString(4));
				edgeArr.add(edge);
			}//显示数据
			ret.close();
			db1.close();//关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return edgeArr;
	}

}

