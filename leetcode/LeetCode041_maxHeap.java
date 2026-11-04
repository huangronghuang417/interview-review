public class LeetCode041_maxHeap {
    class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }

        // 插入
        public void push(int val) {
            if (size == capacity) {
                throw new RuntimeException("Heap full");
            }
            heap[size] = val;
            heapifyUp(size);
            size++;
        }

        // 删除堆顶
        public int pop() {
            if (size == 0) {
                throw new RuntimeException("Heap empty");
            }
            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return max;
        }

        public int peek() {
            if (size == 0) throw new RuntimeException("Heap empty");
            return heap[0];
        }

        // 上浮：和父节点比，大了就交换
        private void heapifyUp(int idx) {
            while (idx > 0) {
                int parent = (idx - 1) / 2;
                if (heap[idx] <= heap[parent]) break;
                swap(idx, parent);
                idx = parent;
            }
        }

        // 下沉：和两个孩子比，和大的交换
        private void heapifyDown(int idx) {
            while (true) {
                int left = 2 * idx + 1;
                int right = 2 * idx + 2;
                int largest = idx;

                if (left < size && heap[left] > heap[largest]) {
                    largest = left;
                }
                if (right < size && heap[right] > heap[largest]) {
                    largest = right;
                }
                if (largest == idx) break;

                swap(idx, largest);
                idx = largest;
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        public int size() { return size; }
    }
}
