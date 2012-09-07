package sort;

public class Sort {
	public static void show(int[] nums) {
		for (int num : nums) {
			System.out.print(num + ", ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 2, 5, 6, 8, 9, 11, 13, 15 };
		show(nums);
		nums = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 2, 5, 6, 8, 9, 11, 13, 15 };
		show(QuickSort(nums));
		nums = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 2, 5, 6, 8, 9, 11, 13, 15 };
		show(BubbleSort(nums));
		nums = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 2, 5, 6, 8, 9, 11, 13, 15 };
		show(InsertSort(nums));
		nums = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 2, 5, 6, 8, 9, 11, 13, 15 };
		show(SelectSort(nums));
		nums = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 2, 5, 6, 8, 9, 11, 13, 15 };
		show(ShellSort(nums));
	}

	/**
	 * 插入排序
	 */
	public static int[] InsertSort(int... nums) {
		for (int i = 1; i < nums.length; i++) {// 每一个数据
			int num = nums[i]; // 等待插入的数据
			int j = i;// 插入位置
			while (j > 0 && nums[j - 1] > num) {// 如果前一位数更大
				nums[j] = nums[j - 1];// 将前面的数后移一位
				j--;
			}
			nums[j] = num; // 插入到合适的位置
		}
		return nums;
	}

	/**
	 * 希尔排序
	 */
	public static int[] ShellSort(int... nums) {
		int len = (int) nums.length / 2; // 初始集合间隔长度
		int num; // 暂存变量
		while (len != 0) { // 数列仍可进行分割
			for (int i = len; i < nums.length; i++) {// 对各个集合进行处理
				num = nums[i]; // 暂存nums[j]的值,待交换值时用
				int j = i - len; // 计算进行处理的位置
				while (num < nums[j] && j >= 0 && j <= nums.length) {// 进行集合内数值的比较与交换值
					nums[j + len] = nums[j];// 交换
					j = j - len;// 计算下一个欲进行处理的位置
					if (j < 0 || j > nums.length) {
						break;
					}
				}
				nums[j + len] = num;// 与最后的数值交换
			}
			len = len / 2; // 计算下次分割的间隔长度
		}
		return nums;
	}

	/**
	 * 选择排序
	 */
	public static int[] SelectSort(int... nums) {
		for (int i = 0; i < nums.length - 1; ++i) {
			int j = i;
			for (int k = i; k < nums.length; ++k) {
				if (nums[j] > nums[k]) {
					j = k;
				}
			}
			if (j != i) {// 交换元素
				int num = nums[i];
				nums[i] = nums[j];
				nums[j] = num;
			}
		}
		return nums;
	}

	/**
	 * 冒泡排序
	 */
	public static int[] BubbleSort(int... nums) {
		for (int i = 0; i < nums.length - 1; i++) { // 最多做n-1趟排序
			for (int j = 0; j < nums.length - i - 1; j++) { // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
				if (nums[j] > nums[j + 1]) { // 把小的值交换到后面
					int num = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = num;
				}
			}
		}
		return nums;
	}

	/**
	 * 快速排序
	 */
	public static int[] QuickSort(int... nums) {
		return nums;
	}
}