package linkedlistt;

public class CopyListWithRandomPointer {
  public static void main(String args[]){
    NodeWithRandomPointer head = new NodeWithRandomPointer(5);
    head.next = new NodeWithRandomPointer(4);

    head.next.next = new NodeWithRandomPointer(3);
    head.next.next.next = new NodeWithRandomPointer(2);
    head.next.next.next.next = new NodeWithRandomPointer(1);

    // Setting up random references.
    head.random = head.next.next;
    head.next.random = head.next.next.next;
    head.next.next.random = head.next.next.next.next;
    head.next.next.next.random = head.next.next.next.next.next;
    head.next.next.next.next.random = head.next;
    CopyListWithRandomPointer copyListWithRandomPointer=new CopyListWithRandomPointer();
    NodeWithRandomPointer out= copyListWithRandomPointer.copyRandomList(head);
  }
  public NodeWithRandomPointer copyRandomList(NodeWithRandomPointer head) {
    NodeWithRandomPointer newNode= null;
    NodeWithRandomPointer te=head;
    NodeWithRandomPointer start=null;
    while(te!=null){
      NodeWithRandomPointer temp=new NodeWithRandomPointer(te.val);
      temp.next=te.next;
      temp.random=te.random;
      if(newNode==null){
        newNode=temp;
        start=newNode;
      }
      newNode.next=temp;
      newNode=newNode.next;
      te=te.next;

    }

    return start;

  }
}
