import java.util.HashMap;
import java.util.Map;
public class LeetCode035_LRU {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode() {}
        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    class LRUCache {
        private final Map<Integer, DLinkedNode> cache = new HashMap<>();
        private final DLinkedNode head, tail; // 哨兵节点
        private int size;
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        // 访问节点：移到头部
        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {
                // 新增
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;

                if (size > capacity) {
                    DLinkedNode tailNode = removeTail();
                    cache.remove(tailNode.key); // 同步删 map
                    size--;
                }
            } else {
                // 更新
                node.value = value;
                moveToHead(node);
            }
        }

        // ===== 链表原语 =====
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode node = tail.prev;
            removeNode(node);
            return node;
        }
    }
}
