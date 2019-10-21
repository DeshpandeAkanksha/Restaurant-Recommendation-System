package mining;

public class Cosine {
	String[] line;
	Float result;
	
	public Cosine(String[] line, Float result){
		this.line = line;
		this.result = result;
	}

	public String[] getLine() {
		return line;
	}

	public void setLine(String[] line) {
		this.line = line;
	}

	public Float getResult() {
		return result;
	}

	public void setResult(Float result) {
		this.result = result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return line[2] + " result=" + result;
	}
	
}
