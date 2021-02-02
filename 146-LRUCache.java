class LRUCache {

  Node head;
  Node tail;
  Map<Integer, Node> map;
  int capacity;

  public LRUCache(int capacity) {
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
    map = new HashMap<>();
    this.capacity = capacity;
  }

  public void addToHead(Node node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }

  public void removeNode(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
    node.next = null;
    node.prev = null;
  }

  public void update(Node node) {
    removeNode(node);
    addToHead(node);
  }

  public void print() {
    Node it = head.next;
    while (!it.equals(tail)) {
      System.out.printf(" %d ->", it.key);
      it = it.next;
    }
    System.out.println();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Node node = map.get(key);
    update(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      update(node);
    } else {
      Node node = new Node(key, value);
      map.put(key, node);
      addToHead(node);
      if (map.size() > capacity) {
        Node last = tail.prev;
        removeNode(last);
        map.remove(last.key);
      }
    }
  }

  class Node {

    Node prev;
    Node next;
    int key;
    int value;

    public Node(int k, int v) {
      key = k;
      value = v;
    }
  }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
