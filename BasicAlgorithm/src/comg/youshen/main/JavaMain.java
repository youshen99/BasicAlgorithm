package comg.youshen.main;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.YouCompare;
import com.youshen.sortclass.BubblSort;
import com.youshen.sortclass.HeapSort;
import com.youshen.sortclass.InsertSort;
import com.youshen.sortclass.QuickSort;
import com.youshen.sortclass.SelectSort;
import com.youshen.sortclass.ShellSort;
import com.youshen.sortclass.TwoWayMergeSort;

import comg.youshen.testclass.Car;
import comg.youshen.youenum.Sortord;

public class JavaMain {
	public static void main(String[] args) {
		ArrayList<Car> arrayList = new ArrayList<Car>();
		arrayList.add(new Car(8, 6));
		arrayList.add(new Car(4, 6));
		arrayList.add(new Car(7, 6));
		arrayList.add(new Car(48, 6));
		arrayList.add(new Car(10, 6));
		arrayList.add(new Car(39, 6));
		arrayList.add(new Car(9, 6));
		arrayList.add(new Car(12, 6));
		arrayList.add(new Car(11, 6));
		arrayList.add(new Car(35, 6));
		arrayList.add(new Car(40, 6));

		System.out.println("ð������");
		List<Car> newBubblSort = new BubblSort<Car>().sort(arrayList,
				Sortord.ASCE, new PrintTime() {

					public void println(Object[] t, int time) {
						// TODO Auto-generated method stub
						if (t == null) {
							System.out.println("null");
							return;
						}
						System.out.print("������" + time + "�ɣ�");
						for (int i = 0; i < t.length; i++) {
							System.out.print((Car) t[i] + " ");

						}
						System.out.println();
					}
				});
		System.out.println("������");
		List<Car> newHeapSort = new HeapSort<Car>().sort(arrayList,
				Sortord.ASCE, new PrintTime() {

					public void println(Object[] t, int time) {
						// TODO Auto-generated method stub
						if (t == null) {
							System.out.println("null");
							return;
						}
						System.out.print("������" + time + "�ɣ�");
						for (int i = 0; i < t.length; i++) {
							System.out.print((Car) t[i] + " ");

						}
						System.out.println();
					}
				});
		System.out.println("��������");
		List<Car> newQuickSort = new QuickSort<Car>().sort(arrayList,
				Sortord.ASCE, new PrintTime() {

					public void println(Object[] t, int time) {
						// TODO Auto-generated method stub
						if (t == null) {
							System.out.println("null");
							return;
						}
						System.out.print("������" + time + "�ɣ�");
						for (int i = 0; i < t.length; i++) {
							System.out.print((Car) t[i] + " ");

						}
						System.out.println();
					}
				});
		System.out.println("ѡ������");
		List<Car> newListChoose = new SelectSort<Car>().sort(arrayList,
				Sortord.ASCE, new PrintTime() {

					public void println(Object[] t, int time) {
						// TODO Auto-generated method stub
						if (t == null) {
							System.out.println("null");
							return;
						}
						System.out.print("������" + time + "�ɣ�");
						for (int i = 0; i < t.length; i++) {
							System.out.print((Car) t[i] + " ");

						}
						System.out.println();
					}
				});
		System.out.println("ϣ������");
		List<Car> newShellSort = new ShellSort<Car>().sort(arrayList,
				Sortord.ASCE, new PrintTime() {

					public void println(Object[] t, int time) {
						// TODO Auto-generated method stub
						if (t == null) {
							System.out.println("null");
							return;
						}
						System.out.print("������" + time + "�ɣ�");
						for (int i = 0; i < t.length; i++) {
							System.out.print((Car) t[i] + " ");

						}
						System.out.println();
					}
				});
		System.out.println("��·�鲢����");
		List<Car> newTwoWayMergeSort = new TwoWayMergeSort<Car>().sort(arrayList,
				Sortord.ASCE, new PrintTime() {

					public void println(Object[] t, int time) {
						// TODO Auto-generated method stub
						if (t == null) {
							System.out.println("null");
							return;
						}
						System.out.print("������" + time + "�ɣ�");
						for (int i = 0; i < t.length; i++) {
							System.out.print((Car) t[i] + " ");

						}
						System.out.println();
					}
				});
		System.out.println("��������");
		List<Car> newInsertSort = new InsertSort<Car>().sort(arrayList,
				Sortord.ASCE, new PrintTime() {

					public void println(Object[] t, int time) {
						// TODO Auto-generated method stub
						if (t == null) {
							System.out.println("null");
							return;
						}
						System.out.print("������" + time + "�ɣ�");
						for (int i = 0; i < t.length; i++) {
							System.out.print((Car) t[i] + " ");

						}
						System.out.println();
					}
				});

	}

}
