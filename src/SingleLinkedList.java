
public class SingleLinkedList {
	private Node head;
	
	public SingleLinkedList() {
		head=null;
	}
	
	public void addFirst(Object dataToAdd) {
		//insert first
		if(head==null) {
			Node newnode=new Node(dataToAdd);
			head=newnode;
		}
		//insert first
	}
	
	public void addFront(Object dataToAdd) {
		//insert to front
		if((int)dataToAdd<(int)head.getData()) {
			Node newnode=new Node(dataToAdd);
			newnode.setLink(head);
			head=newnode;
		}
		//insert to front
	}
	
	public void addLast(Object dataToAdd) {
		//insert to last
		Node temp=head;
		while(temp.getLink()!=null)
			temp=temp.getLink();
		if(temp.getLink()==null) {
			Node newnode=new Node(dataToAdd);
			temp.setLink(newnode);
		}
		//insert to last
	}
	
	public void addBetween(Object dataToAdd) {
		//insert between
		Node temp=head;
		Node previous=null;
		while(temp!=null && (Integer)dataToAdd > (Integer)temp.getData()) {
			previous=temp;
			temp=temp.getLink();
		}
		if(temp==null) {
			Node newnode=new Node(dataToAdd);
			previous.setLink(newnode);
		}
		else {
			Node newnode=new Node(dataToAdd);
			newnode.setLink(temp);
			previous.setLink(newnode);
		}
		//insert between
	}
	
	public void add(Object dataToAdd) {
		boolean flag=true;
		//insert first
			if(head==null && flag) {
				Node newnode=new Node(dataToAdd);
				head=newnode;
				flag=false;
			}
		//insert first
			else {
		//insert to front
			if((int)dataToAdd<(int)head.getData() && flag) {
				Node newnode=new Node(dataToAdd);
				newnode.setLink(head);
				head=newnode;
				flag=false;
			}
			
		//insert to front
			
		
			
		//insert between
			if(flag) {
			Node temp1=head;
			Node previous=null;
			while(temp1!=null && ((Integer)dataToAdd > (Integer)temp1.getData() || (Integer)dataToAdd == (Integer)temp1.getData())) {
				previous=temp1;
				temp1=temp1.getLink();
			}
			if(temp1==null) {//insert last
				Node newnode1=new Node(dataToAdd);
				previous.setLink(newnode1);
				flag=false;
			}
			else {//insert between
				Node newnode1=new Node(dataToAdd);
				newnode1.setLink(temp1);
				previous.setLink(newnode1);
				flag=false;
			}
		//insert between	
		}
	}
}
	//delete
	public void delete(Object dataToDelete) {
		/*if(head==null)
			System.out.println("Linked list is empty");
		else {*/
			Node temp=head;
			Node previous=null;
			
			if(temp!=null && (int)temp.getData()==(int)dataToDelete) {
				head=temp.getLink();
				return;
			}
			while(temp!=null && (int)temp.getData()!=(int)dataToDelete) {
				previous=temp;
				temp=temp.getLink();
			}
			if(temp==null) {
				return;
			}
			previous.setLink(temp.getLink());
		
	}
	//delete
	
	//search
	public boolean search(Object data) {
		boolean flag=false;
		/*if(head==null)
			System.out.println("Linked list is empty");
		else {*/
			Node temp=head;
			while(temp!=null) {
				if((int)data==(int)temp.getData())
					flag=true;
				temp=temp.getLink();
			}
		
		return flag;
	}
	//search
	
	//size
	public int size() {
		int count=0;
		/*if(head==null) {
			System.out.println("Linked list is empty");
		}
		else {*/
			Node temp=head;
			while(temp!=null) {
				count++;
				temp=temp.getLink();
			}
		
		return count;
	}
	//size
	
	//display
	public void display() {
		/*if(head==null)
			System.out.println("Linked List is empty");
		else {*/
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.getData()+" ");
				temp=temp.getLink();
			}
		
	}
	//display
}
