package arc.mirim.domain;

public class Criteria {
	private String type;
	private String keword;
	
	@Override
	public String toString() {
		return "Criteria [type=" + type + ", keword=" + keword + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeword() {
		return keword;
	}
	public void setKeword(String keword) {
		this.keword = keword;
	}
	
	
}
