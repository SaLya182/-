	public class IteratorSample1 {

	public static void main(String[] args) {

	BookListAggregate bookListAggregate = new BookListAggregate();
	Iterator iterator = bookListAggregate.createIterator();
	bookListAggregate.add(new Book("羅生門", 3200));
	bookListAggregate.add(new Book("蟹工船", 3000));
	bookListAggregate.add(new Book("100万回生きた猫", 1200));
	bookListAggregate.add(new Book("大きなカブ", 800));
	iterator.first(); // まず探す場所を先頭位置にしてもらう
	while ( ! iterator.isDone() ) { // まだある？ まだあるよ！
		Book book = (Book)iterator.getItem(); // はいどうぞ (と受取る)
		System.out.println(book.getName());
		iterator.next(); // 次を頂戴

		}
	}
	}
	class Book {
		private String name; // 名称
		private int price; // 価格
		public Book(String name, int price) { // コンストラクタ
		this.name= name;
		this.price = price;
		}
		public String getName() { // 名称を取得
		return name;
		}
		public int getPrice() { // 価格を取得
		return price;
		}
		}

	class BookListAggregate implements Aggregate {
		private Book[] list = new Book[20];
		private int numberOfStock;
		@Override
		public Iterator createIterator() {
		return new BookListIterator(this);
		}
		public void add(Book book) {
		list[numberOfStock] = book;
		numberOfStock += 1;
		}
		public Object getAt(int number) {
		return list[number];
		}
		public int getNumberOfStock() {
		return numberOfStock;
		}
		}


	interface Iterator {
		public void first(); // 取り出し位置を最初の要素へ変える
		public void next(); // 取り出し位置を次の要素へ変える
		public boolean isDone(); // 取り出し位置が最後を超えたか？
		public Object getItem(); // 現在の取り出し位置から取り出す
	}
	class BookListIterator implements Iterator {
		private BookListAggregate aggregate;
		private int current;
		public BookListIterator(BookListAggregate aggregate) {
		this.aggregate = aggregate;
		}
		@Override
		public void first() {
		current = 0;
		}
		@Override
		public void next() {
			current += 1;
			}
			@Override
			public boolean isDone() {
			if (current >= aggregate.getNumberOfStock()) {
			return true;
			}
			else {
			return false;
			}
			}
			@Override
			public Object getItem() {
			return aggregate.getAt(current);
			}
			}

	interface Aggregate {
		public Iterator createIterator();
		}
