package com.example.demo.sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {5,4,9,3,6,1};
	    new QuickSort().Qsort(a, 0, 5);		
	}
	void Qsort(int [] a,int low,int high){ 
		if(low<high){
			int index = Split(a,low,high);
			Qsort(a, low,index-1);//方法递归的调用，每次调用Qsort(a, low,index-1)，都会调用Qsort(a, index+1, high)
			//当Qsort(a, index+1, high)只调用一次时，Qsort(a, low,index-1)调用几次，那么后者都以第一次的顺序传入，
			Qsort(a, index+1, high);
		}
		
	}
     int Split(int[] a, int low, int high) {
		int data= a[low];//将需要首次排定的元素赋值给一个变量储存,此操作：当从数组最右端找到比基点小的元素，
		//就要把小的元素赋给基点所在,所以一直排的最后一次完，整个数组中是不存在该基点元素，所以在最后排完后
		//只剩下当前的high值，所以确定该high值a[high]=data，完成一次基点的排序，确定基点的正确位置		
		while(low<high){//只有当索引到该元素本身是最大时，循环结束
			while(high>low&&a[high]>=data)//先由基点找右边比他小的，小的赋给它，然后low+1；high来到比基点小的该处，
			//又从low+1处找比a[high]大的，然后把该值赋给a[high];完成此操作后，high-1了，
			//无论是最后一次操作比较最中间的两个值，判断右边的是否不左边的小，若小，则把右边的赋值给左边，同时high不变
			//high所在地
				high--;
				if(high!=low){
					a[low]=a[high];
					low++;
					while(low<high&&a[low]<=data){
						low++;
					}
					if(low!=high){
						a[high]=a[low];
						high--;
					}
				}							
		}
		a[high]=data;//为什么能确定最后这个high点就是基点所应该放的地方，因为，从第一次从后找比基点
		//小的值，然后把小的值赋到基点所在地，这步操作其实就是把这个数和基点交换了，换句话说，每一次的交换都是拿基点在交换
		//知道最后一步中间两个值的交换，最后当基点为high时，发现左边的比他大，那么就把那个值和high交换
		//交换完后high--,正好是基点应该放的地方，如果此时基点放在low处，那么跟他右边的比，如果比他小，
		//那么就把小的移过来，把自己放到high位，也正好是high所在地，所以任何情况，基点都能放在正确的位置，实现的基点的在最终
		//的有序序列的正确位置
		for(int k:a){System.out.print(k);}
		System.out.println("===============");
		return high;
	}
}
