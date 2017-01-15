package it.uniroma1.dis.wsngroup.gexf4j.examples;

public class EdgeMsg {

	private String source;
	private String target;
	private String relation;
	
	public EdgeMsg(String source, String target, String relation) {
		this.source = source;
		this.target = target;
		this.relation = relation;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
}
