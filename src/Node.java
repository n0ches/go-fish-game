
public class Node {
	private Object data;
	private Node link;
	
	public Node(Object dataToAdd) {
		data=dataToAdd;
		link=null;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the link
	 */
	public Node getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(Node link) {
		this.link = link;
	}
	
}
