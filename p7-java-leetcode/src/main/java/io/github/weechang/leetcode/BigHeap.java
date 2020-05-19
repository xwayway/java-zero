package io.github.weechang.leetcode;

/**
 * 大根堆
 *
 * @author zhangwei
 * date 2020/5/20
 * time 6:57
 */
public class BigHeap {

    public int left(int i) {
        return (i + 1) * 2 - 1;
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

    public int parent(int i) {
        // i为根结点
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public void heapify(Integer[] a, int i, int heapLength) {
        int l = left(i);
        int r = right(i);
        int largest = -1;
        /**
         * 下面两个if条件句用来找到三个元素中的最大元素的位置largest；
         * l < heapLength说明l在数组内，i非叶子结点；
         */
        if (l < heapLength && a[i].compareTo(a[l]) < 0) {
            largest = l;
        } else {
            largest = i;
        }
        // r < heapLength说明r在数组内
        if (r < heapLength && a[largest].compareTo(a[r]) < 0) {
            largest = r;
        }
        // 如果i处元素不是最大的，就把i处的元素与最大处元素交换，交换会使元素下降
        if (i != largest) {
            Integer temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            // 交换元素后，以a[i]为根的树可能不在满足大根堆性质，于是递归调用该方法
            heapify(a, largest, heapLength);
        }
    }

    public void buildHeap(Integer[] a, int heapLength) {
        // 从后往前看，lengthParent - 1处的元素是第一个有孩子节点的节点
        int lengthParent = parent(heapLength - 1);
        // 最初，parent(length)之后的所有元素都是叶子结点；
        // 因为大于length/2处元素的孩子节点如果存在，那么
        // 它们的数组下标值必定大于length，这与事实不符；
        // 在数组中，孩子元素必定在父亲元素的后面，从后往前
        // 对元素调用maxHeapify，保证了元素的孩子都是
        // 大根堆
        for (int i = lengthParent; i >= 0; i--) {
            heapify(a, i, heapLength);
        }
    }

    public static void main(String[] args) {
        BigHeap bigHeap = new BigHeap();
        Integer[] a = {7, 8, 9, 11, 12, 13};
        bigHeap.buildHeap(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
