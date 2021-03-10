class LRUCache {

  int capacity;
  int size;
  Node head;
  Node tail;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;

    this.size = 0;
    tail = new Node(0, 0);
    head = new Node(0, 0);
    head.next = tail;
    tail.prev = head;

    map = new HashMap<>();
  }

  private void removeNode(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    node.prev = node.next = null;
    prev.next = next;
    next.prev = prev;
  }

  private void addToHead(Node node) {
    node.next = head.next;
    node.prev = head;
    node.next.prev = node;
    head.next = node;
  }

  private void update(Node node) {
    removeNode(node);
    addToHead(node);
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      update(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.val = value;
      update(node);
    } else {
      Node node = new Node(key, value);
      map.put(key, node);
      addToHead(node);
      if (map.size() > capacity) {
        Node deleteNode = tail.prev;
        map.remove(deleteNode.key);
        removeNode(deleteNode);
      }
    }
  }

  class Node {

    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
