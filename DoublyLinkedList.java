class DoublyLinkedList {


    class Node {
        Node next;
        Node prev;
        String data;
        Node(String data){
            this.data=data;
        }
    }

    Node tail,head;
    int size;
    public void addLast(String data){
        Node current = new Node(data);
        if (tail==null){
            tail=current;
            head=current;
            size++;
        }else{
            tail.next=current;
            current.prev=tail;
            tail=current;
            size++;
        }
    }
    public void addFirst(String data){
        Node current = new Node(data);
        if(head==null){
            tail=current;
            head=current;
            size++;
        }else{
            head.prev=current;
            current.next=head;
            head=current;
            size++;
        }
    }
    public void deleteFirst(){
        if(head!=null){
            Node current=head;
            head=current.next;
            current.prev=null;
            size--;
        }
    }
    public void deleteLast(){
        if(tail!=null){
            Node current =tail;
            tail=current.prev;
            current.next=null;
            size--;
        }
    }
    public void deleteOneElement(int index){

        if(index ==0){
            deleteFirst();
        }if (index==size){
            deleteLast();
        }if(index>0 && index<size){
            Node current = head;
            for (int i=0;i<index;i++){
                current=current.next;
            }
            current.next.prev=current.prev;
            current.prev.next=current.next;
            size--;
        }
    }


    public int getSize(){
        return size;
    }

    public String toString(){
        if(head==null){
            return null;
        }
        Node current = head;
        String tmpString = "[" + current.data ;
        while (current != tail){
            current = current.next;
            tmpString = tmpString.concat(", " + current.data);


        };
        tmpString = tmpString.concat("]");

        return tmpString;
    }


}