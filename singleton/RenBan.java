public class RenBan {

 public static void main(String[] args) {
  for(int i = 0; i < 9; i++) {
   SingletonTest singleton1 = SingletonTest.getInstance();
   singleton1.renban(1);
   singleton1.print();
  }
 }

}

class SingletonTest {
 private static SingletonTest jittai = new SingletonTest();
 private String seihin;
 private int num;
 private SingletonTest() {
  this.seihin = "a";
 }
 public static SingletonTest getInstance() {
  return jittai;
 }
 public void renban(int ban) {
  num += ban;
 }
 public void print() {
  System.out.println("製品" + seihin + "：  " + "番号:" + String.format("%04d", num));
 }

}