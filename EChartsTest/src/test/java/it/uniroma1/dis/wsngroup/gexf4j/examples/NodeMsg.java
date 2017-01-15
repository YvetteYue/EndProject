package it.uniroma1.dis.wsngroup.gexf4j.examples;

public class NodeMsg {

	private String name;
	private String trans;
	
	public NodeMsg(String name, String trans) {
		this.name = name;
		this.trans = trans;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrans() {
		if(trans==null)return " ";
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	
}
