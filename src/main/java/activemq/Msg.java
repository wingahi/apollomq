package activemq;

import java.io.Serializable;

import javax.jms.Message;

public class Msg implements Serializable {
	private String contents;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Msg [contents=" + contents + "]";
	}
	
}
