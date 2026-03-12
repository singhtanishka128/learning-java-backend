
//  class Hello{
//     public static void main(String args[]){
        
//     }
// }

// print something:
//  class Hello{
//     public static void main(String a[]){
//         System.out.println("hey");
//     }
// }


// //literals: 
// class Hello{
//     public static void main(String a[]){
//         int x = 0b101; //using binary to print integer 5
//         int y = 0x7E; //hexadecimal 
//         int z = 100_00_00; //java allows this to ease the counting of 0 for devs
//         System.out.println(x);
//         System.out.println(y);
//         System.out.println(z);
//         char c = 'a';
//         c++;  //integer operation on character
//         System.out.println(c);
//     }
// }


// //explicit & implicit type conversion:
//  class Hello{
//     public static void main(String args[]){
//         int a = 9;
//         byte b = 66;
//         a = b; //implicit type-casting short range byte into big range int -> type conversion = automatic conversion
//         System.out.println(a); //66
//         int x = 2;
//         byte z = 24;
//         //z = x;
//         //System.out.println(z); //throws error - cant cast big range int into short range byte
//         z = (byte) x; //explicit type casting (specifying the type)- converting bigger range int into shorter range byte and then reassigning the value
//         System.out.println(z); //2
//         byte g = 10;
//         byte h = 30;
//         int p = g * h; //type promotion - when byte*byte it results into byte but when the outcome goes out of range java allows the type promotion
//         System.out.println(p);
//     }
// }


// // logical operators
//  class Hello{
//     public static void main(String args[]){
//         int x=7;
// 		int y=5;
// 		int a=5;
// 		int b=9;
//         boolean result= x<y || a<b || a>1 ;
// 		System.out.println(result); //true
//     }
// }


// //if else
//  class Hello{
//     public static void main(String a[]){
//         int x=8;
// 		int y=7;
// 		if(x>y) {
// 			System.out.println(x);
// 			System.out.println("Thankyou");
// 		}
// 		else
// 			System.out.println(y);	
//     }
// }


// //if else if
//  class Hello{
//     public static void main(String args[]){
//         int x=8;
// 		int y=7;
// 		int z=9;
// 		if(x>y && x>z)         //false
// 			System.out.println(x);
// 		else if(y>z)
// 			System.out.println(y);
// 		else
// 			System.out.println(z);//9
//     }
// }


// //ternary
//  class Hello{
//     public static void main(String args[]){
//         int n=5;
// 		int result=0;
// 		result = n%2==0 ? 10 : 20;
// 		System.out.println(result);
//     }
// }


// //switch case
//  class Hello{
//     public static void main(String args[]){
//     int n=3;
// 		switch(n) {
// 		case 1:
// 			System.out.println("Monday");
// 			break;
// 		case 2:
// 			System.out.println("Tuesday");
// 			break;
// 		case 3:
// 		System.out.println("Wednesday");
// 			break;
// 		case 4:
// 		System.out.println("Thursday");
// 			break;
// 		case 5:
// 		System.out.println("Friday");
// 			break;
// 		case 6:
// 		System.out.println("Saturday");
// 			break;
// 		case 7:
// 		System.out.println("Sunday");
// 			break;
// 		default:
// 			System.out.println("Enter a valid number");			
// 		}
//     }
// }


// //loops
//  class Hello{
//     public static void main(String args[]){
//         int i=1;
// 		while(i<=4)
// 		{
// 			System.out.println("Hi"+ i);
// 			i++;
// 		}
// 		System.out.println("Bye"+i);
//     }
// }
// Hi1
// Hi2
// Hi3
// Hi4
// Bye5



//  class Hello{
//     public static void main(String args[]){
//         int i=1;
//         while(i<=4)
// 		{
// 			System.out.println("Hi"+ i);
// 			int j=1;
// 			while(j<=3) {
// 				System.out.println("Hello"+j);
// 				j++;
// 			}
// 			i++;
// 		}
// 		System.out.println("Bye"+i);
//     }
// }
// Hi1
// Hello1
// Hello2
// Hello3
// Hi2
// Hello1
// Hello2
// Hello3
// Hi3
// Hello1
// Hello2
// Hello3
// Hi4
// Hello1
// Hello2
// Hello3
// Bye5


// public class Hello {
// 	public static void main(String[] args) {
// 		int i=1;
// 		do
// 		{
// 			System.out.println("Hi"+i);
// 			i++;
// 		}
// 		while(i<=4);
// 	}
// }
// Hi1
// Hi2
// Hi3
// Hi4



//  class Hello{
//     public static void main(String args[]){

// for(int i=1;i<=7;i++)
// 		{
// 			System.out.println("Day"+i);
// 			for(int j=1;j<=9;j++)
// 			{
// 				System.out.println(" "+(j+8)+"-"+(j+9));
// 			}
// 		}
        
//     }
// }
// Day1
//  9-10
//  10-11
//  11-12
//  12-13
//  13-14
//  14-15
//  15-16
//  16-17
//  17-18
// Day2
//  9-10
//  10-11
//  11-12
//  12-13
//  13-14
//  14-15
//  15-16
//  16-17
//  17-18
// Day3
//  9-10
//  10-11
//  11-12
//  12-13
//  13-14
//  14-15
//  15-16
//  16-17
//  17-18
// Day4
//  9-10
//  10-11
//  11-12
//  12-13
//  13-14
//  14-15
//  15-16
//  16-17
//  17-18
// Day5
//  9-10
//  10-11
//  11-12
//  12-13
//  13-14
//  14-15
//  15-16
//  16-17
//  17-18
// Day6
//  9-10
//  10-11
//  11-12
//  12-13
//  13-14
//  14-15
//  15-16
//  16-17
//  17-18
// Day7
//  9-10
//  10-11
//  11-12
//  12-13
//  13-14
//  13-14
//  14-15
//  13-14
//  13-14
//  14-15
//  13-14
//  13-14
//  13-14
//  13-14
//  13-14
//  13-14
//  14-15
//  13-14
//  14-15
//  15-16
//  16-17
//  14-15
//  15-16
//  16-17
//  15-16
//  16-17
//  16-17
//  17-18



//  class Hello{
//     public static void main(String args[]){
// 		int i=1;
// 		for(;i<=5;)
// 		{
// 			System.out.println("DAY"+i);
// 			i++;
// 		}

//     }
// }
// DAY1
// DAY2
// DAY3
// DAY4
// 

// int add(int n, int m){
//     return n+m;
// }
// class Hello{
//     public static void main(String args[]){
//         int num1=8;
//         int num2=9;
//         int res= add(num1,num2);
//         System.out.println(res);
//     }
// } //now this throws error, main method here is static, our add fn is non static


// class Calc{
//     public int Add(int a, int b){
//         return a+b;
//     }
// }

//  class Hello{
//     public static void main(String args[]){
//         Calc obj = new Calc();// obj object of class Calc can access any method of class Calc
//         int res= obj.Add(1,2);
//         System.out.println(res); //3
//     }
// }



//  class Hello{
//     public static void main(String args[]){
//         //int arr[] = {1,2,3,4,5,};//static array allocation
//         int arr[] = new int[5]; //total 5 zeroes stored 
//         for(int i=0;i<arr.length;i++){ //arr.size(), arr.length() doesnt work.
//             System.out.println(arr[i]);
//         }
    
//     }
// }


// //2D array
//  class Hello{
//     public static void main(String args[]){
//         int nums[][] = new int[3][4]; //row size=3, col size=4
//         for(int i=0;i<3;i++){
//             for(int j=0;j<4;j++){
//                 nums[i][j]= (int)(Math.random() * 10); //Math.random always return 0.smthng value
//             }
//         }
//          for(int i=0;i<3;i++){
//             for(int j=0;j<4;j++){
//                 System.out.print(nums[i][j] + "  ");
//             }
//             System.out.println();
//          }
//     }
// }


// //in 2Darray/matrix when the number of columns varies in each row, we call it a jagged array
//  class Hello{
//     public static void main(String args[]){
//         int nums[][] = new int[3][]; //jagged
//         //specifying no of cols for each row
//         nums[0]= new int[3];//3 cols
//         nums[1]= new int[4];//4 cols
//         nums[2]= new int[2];//2 cols
//           for(int i=0;i<3;i++){
//             for(int j=0;j<nums[i].length;j++){
//                 nums[i][j]= (int)(Math.random() * 10); //Math.random always return 0.smthng value
//             }
//         }
//          for(int i=0;i<3;i++){
//             for(int j=0;j<nums[i].length;j++){
//                 System.out.print(nums[i][j] + "  ");
//             }
//             System.out.println();
//          }
//         }
// }
// 9  7  3  
// 5  2  5  2  
// 7  4  

// //3d array
// int nums[][][] = new int[3][4][5]; 
// in 2d we access the element like (0,3)-> 0th row, 3rd col,,in 3d we do (0,3,2)-> 0th row, 3rd col, element at 2nd index of embedded subarray 

//drawbacks of arrays=>
//  cant expand/resize,
//  always have to traverse to fetch an element consuming time and space,
//  new keyword = object creation consuming space



// //array of objects
// class Student{
//     int roll;
//     String name;
//     int marks;
// }
// class Hello{
//     public static void main(String args[]){
//         Student s1 = new Student();
//         s1.roll=1;
//         s1.name= "harsh";
//         s1.marks= 90;
//         Student s2 = new Student();
//         s2.roll=3;
//         s2.name="tanishka";
//         s2.marks= 91;
//         Student s3 = new Student();
//         s3.roll=6;
//         s3.name="sara";
//         s3.marks=90;
//         Student studentsarray[] = new Student[3]; //array size 3
//         studentsarray[0]=s1;
//         studentsarray[1]=s2;
//         studentsarray[2]=s3;
//         for(int i=0;i<studentsarray.length;i++){
//             System.out.println("name: "+studentsarray[i].name+ " and roll: "+studentsarray[i].roll+ " and marks: "+studentsarray[i].marks);
//         }
//     }
// }
// name: harsh and roll: 1 and marks: 90
// name: tanishka and roll: 3 and marks: 91
// name: sara and roll: 6 and marks: 90



//  class Hello{
//     public static void main(String args[]){
//         int arr[] = new int [3];
//         arr[0]=29;
//         arr[1]=40;
//         arr[2]=50;
//         // for(int i=0; i<arr.length; i++){
//         //     System.out.println(arr[i]);
//         // }
//         //instead of this we can use for-each loop which means iterate the whole array and give me 1 value at a time;
//         for(int i : arr){ //for-each loop / enhanced for loop
//             System.out.println(i);
//         }
//     }
// }


//String comes with a captital S -> its a class
//stack and heap memory management for string literals -> open notion

// stringbuffer
//  class Hello{
//     public static void main(String args[]){
//         StringBuffer sb = new StringBuffer("");
//         System.out.println(sb.length());//0
//         System.out.println(sb.capacity());//16  default capacity = 16 characters
//         StringBuffer sb2 = new StringBuffer("tanishka");
//         System.out.println(sb2.length());//8
//         System.out.println(sb2.capacity());//24 

//         StringBuffer sb3 = new StringBuffer("ladies and gentlemen");
//         String s = sb.toString(); //storing string buffer into string

//         sb3.deleteCharAt(0);
//         System.out.println(sb3); //adies and gentlemen
//     }
// }




// class Identity{
//     private String name = "tishu";
//     private int age = 22;

//     public String getname(){
//         return name;
//     }

//     public int getage(){
//         return age;
//     }
// }

//  class Hello{
//     public static void main(String args[]){
//         Identity p1 = new Identity();
//         System.out.println("name: " + p1.getname() + " age: " + p1.getage());
//     }
// }




// class Identity{
//     //private data can never be accessible by outerclass members (only inner class elements can access it)
//     private String name;
//     private int age;
    
//     //anything made public can be accessed by anyone from anywhere
//     public void setName(String firstname){
//         name = firstname;
//     }

//     public void setAge(int years){
//         age = years;
//     }

//     public String getName(){
//         return name;
//     }

//     public int getAge(){
//         return age;
//     }
// }
 
// //here getAge fn could also have been named something else but as a developer its a standard notion to
// //make the variables/methods as self descriptive as it can 
// //thereby we use such getters and setters to fetch & set private data members

//  class Hello{
//     public static void main(String args[]){
//         Identity p1 = new Identity();
//         //p1.name= "kjbfkj"; //error -> cannot set name directly since its private but if name was made public then there would have been no error
//         p1.setName("kenny");
//         p1.setAge(22);
//         System.out.println("name: " + p1.getName() + " age: " + p1.getAge());
//     }
// }
// name: kenny age: 22




// class Identity{
//     private String name;
//     private int age;
    
//     public void setName(String name){
//         name = name;
//     }

//     public void setAge(int age){
//         age = age;
//     }

//     public String getName(){
//         return name;
//     }

//     public int getAge(){
//         return age;
//     }
// }
 
//  class Hello{
//     public static void main(String args[]){
//         Identity p1 = new Identity();
//         p1.setName("kenny");
//         p1.setAge(22);
//         System.out.println("name: " + p1.getName() + " age: " + p1.getAge()); 
//     }
// }

// name: null age: 0
// here java fails to identify which variable is instance and which is local since both have the same name





// class Identity{
//     private String name;
//     private int age;
    
//     public void setName(String name){
//         this.name = name;
//     }

//     public void setAge(int age){
//         this.age = age;
//     }

//     public String getName(){
//         return name;
//     }

//     public int getAge(){
//         return age;
//     }
// }
 
//  class Hello{
//     public static void main(String args[]){
//         Identity p1 = new Identity();
//         p1.setName("kenny");
//         p1.setAge(22);
//         System.out.println("name: " + p1.getName() + " age: " + p1.getAge()); 
//     }
// }

// name: kenny age: 22
// this keyword represents the current object, makes sure the instance variable of the current object is assigned the value of local variable passed



// In Java, default values are automatically assigned only to instance and static variables; local variables must be initialized explicitly.
//  class Hello{
//     public static void main(String args[]){
//         int x;
//         System.out.println(x);  // error
//     }
// }



// //in java if we want to perform some operations luike assignment or calculations, always do in methods
// class House{
//     private String flat;

//     //constructor:
//     //same name as the class name 
//     //automatically called the moment object is created
//     //has no return type
//     //used to initialise objects 
//     public House(){
//         flat = "4bhk";
//     }

//     public String getFlat(){
//         return flat;
//     }
// }

//  class Hello{
//     public static void main(String args[]){
//         House home = new House();
//         System.out.println(home.getFlat() + " housing"); //4bhk housing
//     }
// }




// //when we have a number of methods with the same name and different parameters(type/order/number), we call it method overloading
// //same for constructor overloading
//  class House{
//     private String flat;
//     private String condition;
//     private String location;

//    //default constructor
//     public House(){
//         flat = "4bhk";
//     }
   
//     //parameterised constructor
//     public House(String furnish, String direction){ 
//         flat = "4bhk";
//         condition = furnish; //if condition and furnish had been named same, we would have used this keyword
//         location = direction;
//     }
//     /*
//     eg,

//      public House(String condition, String location){ 
//         flat = "4bhk";
//         this.condition = condition; 
//         this.location = location;
//     */

//     public String getFlat(){
//         return flat;
//     }

//     public String getFurnish(){
//         return condition;
//     }

//     public String getDirection(){
//         return location; //whatevr we return HAS to be an instance variable i.e declared under class (not a local varibale-> declared even under class method )
//     }
// }

//  class Hello{
//     public static void main(String args[]){
//         House home = new House();
//         House home2 = new House("furnished", "south-facing");
//         System.out.println(home.getFlat() + " housing"); //4bhk housing
//         System.out.println(home2.getFlat() + " housing, Condition: "+home2.getFurnish()+", Location: "+home2.getDirection()); //4bhk housing, Condition: furnished, Location: south-facing
//         System.out.println(home.getFlat() + " housing, Condition: "+home.getFurnish()+", Location: "+home.getDirection()); //4bhk housing, Condition: null, Location: null
//     }
// }




// class Mobile{
// 	String brand;
// 	int price;
// 	String network;
// //	String name;
// 	static String name; //static variable
	
// 	public void show() {
// 		System.out.println(brand+" : "+price+" : "+name);
// 	}
	
// }

// public class Hello {
// 	public static void main(String[] args) 
// 	{
// 		Mobile obj1=new Mobile();
// 		obj1.brand="Apple";
// 		obj1.price=1500;
// 		//obj1.name="SmartPhone";  //bad way
// 		Mobile.name="SmartPhone"; //static way of calling static variables
		
// 		Mobile obj2=new Mobile();
// 		obj2.brand="Samsung";
// 		obj2.price=1700;
// 		//obj2.name="SmartPhone"; 
// 		Mobile.name="SmartPhone";
		
// 		//obj1.name="Phone";
// 		Mobile.name="Phone";// value persists
		
// 		obj1.show();
// 		obj2.show();
// 	}
// }
// a static variable is always shared by all the objects.
// we will not be having individual static variable for each object.
// static variable is a common variable shared by all the objects.
// the value of static variable persists.
// static variables are called by classname (static way) , not the object name.
// we can use static variables in non static methods directly.



// all instance variables public
// class Mobile{
// 	static String brand;
// 	String color;
// 	String space;
// 	String name;
// 	Mobile(String color, String space){
// 		this.color=color;
// 		this.space=space;
// 	}
// 	public String getColor(){
// 		return color;
// 	}
// 	public String getSpace(){
// 		return space;
// 	}
// 	public void show(){
// 		System.out.println("product: "+Mobile.brand+" "+this.name+" details: "+this.color+", "+this.space); 
// 	}
// }

// public class Hello{
// 	public static void main(String args[]){
// 		Mobile iphone11 = new Mobile("black", "128GB");
// 		iphone11.name="iphone11";
// 		Mobile iphone13 = new Mobile("white", "256GB");
// 		iphone13.name="iphone13";
// 		Mobile iphone8 = new Mobile("rose gold", "128GB");
// 		iphone8.name="iphone8";
// 		Mobile.brand="Apple";
// 		iphone11.show();
// 		iphone13.show();
// 		iphone8.show();
		
// 		System.out.println("product: "+Mobile.brand+" "+iphone11.name+" details: "+iphone11.color+", "+iphone11.space); //can do this since all are public
		
// 	}
// }
// product: Apple iphone11 details: black, 128GB
// product: Apple iphone13 details: white, 256GB
// product: Apple iphone8 details: rose gold, 128GB
// product: Apple iphone11 details: black, 128GB




// all private except static
// class Mobile{
// 	 static String brand;
// 	private String space;
// 	private String color;
// 	public String name;
// 	Mobile(String color, String space){
// 		this.color=color;
// 		this.space=space;
// 	}
// 	public String getColor(){
// 		return color;
// 	}
// 	public String getSpace(){
// 		return space;
// 	}
// 	// public void show(){
// 	// 	System.out.println("product: "+Mobile.brand+" "+this.name+" details: "+this.color+", "+this.space); //fetching data in 1 line
// 	// }
// }

// public class Hello{
// 	public static void main(String args[]){
// 		Mobile iphone11 = new Mobile("black", "128GB");
// 		iphone11.name="iphone11";
// 		Mobile iphone13 = new Mobile("white", "256GB");
// 		iphone13.name="iphone13";
// 		Mobile iphone8 = new Mobile("rose gold", "128GB");
// 		iphone8.name="iphone8";
// 		Mobile.brand = "Apple";
// 		//iphone11.show();
// 		//iphone13.show();
// 		//iphone8.show();
		
// 		System.out.println("product: "+Mobile.brand+" "+iphone11.name+" details: "+iphone11.getColor()+", "+iphone11.getSpace()); 
// 		System.out.println("product: "+Mobile.brand+" "+iphone8.name+" details: "+iphone8.getColor()+", "+iphone8.getSpace()); 
// 		System.out.println("product: "+Mobile.brand+" "+iphone13.name+" details: "+iphone13.getColor()+", "+iphone13.getSpace()); 
// 	}
// }
// // product: Apple iphone11 details: black, 128GB
// // product: Apple iphone8 details: rose gold, 128GB
// // product: Apple iphone13 details: white, 256GB




// Static method, how to access instance variables inside static methods?
// static methods can be called with the help of classname (statically)
// static methods in interfaces belong ONLY to the interface itself.
// They are not passed down to the implementing class.
// Static methods are not overridden.

// class A {
//     static void show() {
//         System.out.println("A");
//     }
// }

// class B extends A {
//     static void show() {
//         System.out.println("B");
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         A obj = new B();
//         obj.show();
//     }
// }
//output A

// static methods only use static vars
// we cannot use instance variables inside static methods directly. we can do it indirectly by passing the object inside static method. 

// class Water{
// 	int price;
// 	String taste;
// 	static String edition;
// 	Water(int price, String taste){
// 		this.price=price;
// 		this.taste=taste;
// 	}
// 	public static void show(Water sample){
// 		System.out.println("this water comes in "+edition+" edition & this sample tastes "+sample.taste+" costing price $"+sample.price);
// 	}
// }
// public class Hello{
// 	public static void main(String args[]){
// 		Water water1 = new Water(30, "expensive");
// 		Water water2 = new Water(20, "cheap");
// 		Water.edition="limited";
// 		Water.show(water1); //this water comes in limited edition & this sample tastes expensive costing price $30
// 		Water.show(water2); //this water comes in limited edition & this sample tastes cheap costing price $20
// 	}
// }



// class Water{
// 	int price;
// 	String taste;
// 	static String edition;
// 	  Water(int price, String taste){
// 		this.price=price;
// 		this.taste=taste;
// 		System.out.println("1 -> inside Constructor");
// 	  }

// 	static{  //static block for initialising static variables, is called only once no matter how many different objects call it whatever times.
// 		edition="limited";
// 		System.out.println("2 -> inside static");
// 	}

// 	public static void show(Water sample){
// 		System.out.println("3 -> this water comes in "+edition+" edition & this sample tastes "+sample.taste+" costing price $"+sample.price);
// 	}
// }
// public class Hello{
// 	public static void main(String args[]){
// 		Water water1 = new Water(30, "expensive");
// 		Water water2 = new Water(20, "cheap");
// 		//Water.edition="limited"; initialising this in class
// 		Water.show(water1); 
// 		Water.show(water2); 
// 	}
// }



// //when we want the class to load irrespective of object creation
// class Hey{
// 	static int kids;
	
// 		Hey(){
// 			System.out.println("inside constructor"); //never called since no object creation
// 		}

// 	static{
// 		kids = 3;
// 		System.out.println("inside static block");
// 	}
// }

// public class Hello{
// 	public static void main(String[] args) throws ClassNotFoundException {
// 		Class.forName("Hey");
// 	}
// }
// output-> inside static block



// Naming Conventions: 
// classes and interfaces = Data   (first letter capital)
// variables and methods = data, data()  (all small)
// constants = DATA  (all capital)

// for multiple words java developers use camelCasing like
// showMyMarks() - method
// MyData - could be class/interface 
// MyData() - constructor
// MYDATA - constant




// class A{
//     A(){
//         System.out.println("object created");
//     }

//     public void show(){
//         System.out.println("obj for A");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         A obj = new A(); //referenced object
//         obj.show();
//     }
// }
// object created
// obj for A

//here obj is not the object. obj is a reference variable. object creation happens in new A().
//this reference variable from the stack points to the address of the object created in the heap memory.
//object with a reference variable - referenced object




//when we dont create a reference variable and still do object creation then that object in the heap memory is called an
//anonymous object
//object without a reference variable
// class A{
//     A(){
//         System.out.println("object created");
//     }

//     public void show(){
//         System.out.println("obj for A");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         new A(); //anonymous object
//     }
// }
// object created

//cannot be reused again, we can do new A().show() but this creates another new object while calling the show



//inheritance
//upper class = parent class = super class
//derived class = child class = sub class
//redundancy = repeatition of code
//redundancy is a crime

//keyword for inheriting -> extends
// class Child extends Parent{

// }



//single level inheritance: father-> son
// class School{
// public void subjects(){
//     System.out.println("total 10 subjects");
// }
// }

// class Student extends School{
// public void identify(){
//     System.out.println("1 id card for each");
// }
// }

// public class Hello{
//     public static void main(String[] args) {
//         Student obj = new Student();
//             obj.subjects();
//             obj.identify();
//     }
// }
// total 10 subjects
// 1 id card for each



//multi level inheritance : grandfather-> father-> son
// class School{
// public void subjects(){
//     System.out.println("total 10 subjects");
// }
// }

// class Student extends School{
// public void identify(){
//     System.out.println("1 id card for each");
// }
// }

// class Tiffin extends Student{
//     public void tiffin(){
//         System.out.println("we love break times");
//     }
// }

// public class Hello{
//     public static void main(String[] args) {

//         Tiffin obj2 = new Tiffin();
//             obj2.tiffin();
//             obj2.subjects();
//             obj2.identify();
//     }
// }
// we love break times
// total 10 subjects
// 1 id card for each



// multiple inheritance: 2 fathers -> 1 son
// java doesnt support multiple inheritance





// this and super method

// class A{
//     public A(){
//         System.out.println("in A"); //1. calls this first
//     }
// }
// class B extends A {
//     public B(){ 
//         System.out.println("in B");// 2. then this
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B();
//     }
// }
// in A
// in B



// class A{
//     public A(){
//         System.out.println("in A"); 
//     }
// }
// class B extends A {
//     public B(){
//         System.out.println("in B");
//     }
//     public B(int n){
//         System.out.println("in B int");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B(5);
//     }
// }
// in A
// in B int
// how?



// class A{
//     public A(){
//         System.out.println("in A"); 
//     }
//     public A(int n){
//         System.out.println("in A int"); 
//     }
// }
// class B extends A {
//     public B(){
//         System.out.println("in B");
//     }
//     public B(int n){
//         System.out.println("in B int");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B(5);
//     }
// }
// in A
// in B int

// every constructor in Java has a method which is there,
// even if you don't mention
// that method is super 
// super method more like john cena we cant see it



// class A{
//     public A(){ //
//         super();
//         System.out.println("in A"); 
//     }
//     public A(int n){
//         super();
//         System.out.println("in A int"); 
//     }
// }
// class B extends A {
//     public B(){
//         super();
//         System.out.println("in B");
//     }
//     public B(int n){ //
//         super(); //
//         System.out.println("in B int");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B(5);
//     }
// }

//in A
//in B int
//super() methods means call the default constructor of the super class



// class A{
//     public A(){
//         super();
//         System.out.println("in A"); 
//     }
//     public A(int n){ //
//         super();
//         System.out.println("in A int"); 
//     }
// }
// class B extends A {
//     public B(){
//         super();
//         System.out.println("in B");
//     }
//     public B(int n){ //
//         super(n);  //
//         System.out.println("in B int");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B(5);
//     }
// }
// in A int
// in B int
//if we want to call the parameterised constructor of superclass, then pass a parameter in the super class



// class A{
//     public A(){ //
//         super();
//         System.out.println("in A"); 
//     }
//     public A(int n){
//         super();
//         System.out.println("in A int"); 
//     }
// }
// class B extends A {
//     public B(){ //
//         super(); //
//         System.out.println("in B");
//     }
//     public B(int n){
//         super(n);
//         System.out.println("in B int");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B();
//     }
// }
// in A
// in B 

// but now i want (in A int) first then (in B) 




// class A extends Object{
//     public A(){
//         super(); // -> this calls the default constructor of object class
//         System.out.println("in A"); 
//     }
//     public A(int n){ //
//         super();
//         System.out.println("in A int"); 
//     }
// }
// class B extends A {
//     public B(){ //
//         super(5); //
//         System.out.println("in B");
//     }
//     public B(int n){
//         super(n);
//         System.out.println("in B int");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B();
//     }
// }
// in A int
// in B

// every class in java extends the Object class, this Object class is again inbuilt/invisible/john cena, its there even if even if we dont mention



// i want to call both the constructors of B class? we'll use this() method
// class A extends Object{
//     public A(){
//         super(); 
//         System.out.println("in A"); 
//     }
//     public A(int n){ 
//         super();
//         System.out.println("in A int"); 
//     }
// }
// class B extends A {
//     public B(){ 
//         super(); 
//         System.out.println("in B");
//     }
//     public B(int n){
//         this();
//         System.out.println("in B int");
//     }
// }
// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B(8);
//     }
// }
// in A
// in B
// in B int



// class A{
//     public void show(){
//         System.out.println("in A show");
//     }

//     public void config(){
//         System.out.println("in A config");
//     }
// }

// class B extends A{
//     public void show1(){
//         System.out.println("in B show");
//     }
// }

// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B();
//         obj.show();
//         obj.show1();
//         obj.config();
//     }
// }
// in A show
// in B show
// in A config
//now i want both A and B class to have same name for show()




// //method overriding
// class A{
//     public void show(){
//         System.out.println("in A show");
//     }

//     public void config(){
//         System.out.println("in A config");
//     }
// }

// class B extends A{
//     public void show(){
//         System.out.println("in B show");
//     }
// }

// public class Hello{
//     public static void main(String[] args) {
//         B obj = new B();
//         obj.show(); //here B's show overrides A's show
//         obj.config();
//     }
// }
// //method overriding -> same name, same parameter, different behaviour




//package: 


// class Calc{
//     public int add(int n1, int n2){
//         return n1 + n2;
//     }
//     public int sub(int n1, int n2){
//         return n1 - n2;
//     }
// }

// class AdvCalc extends Calc{
//     public int multi(int n1, int n2){
//         return n1 * n2;
//     }
//     public int div(int n1, int n2){
//         return (int) n1 / n2;
//     }
// }

// public class Sample{
//     public static void main(String[] args) {
//         AdvCalc obj = new AdvCalc();
//         int res = obj.add(10,5);
//         System.out.println(res);
//         int res2 = obj.sub(10,5);
//         System.out.println(res2);
//         int res3 = obj.multi(10,5);
//         System.out.println(res3);
//         int res4 = obj.div(10,5);
//         System.out.println(res4);
//     }
// }
//suppose i have these code in Sample.java, im easily able to perform inheritance
//but what if i just have 

// public class Sample{
//     public static void main(String[] args) {
//         AdvCalc obj = new AdvCalc();
//         int res = obj.add(10,5);
//         System.out.println(res);
//         int res2 = obj.sub(10,5);
//         System.out.println(res2);
//         int res3 = obj.multi(10,5);
//         System.out.println(res3);
//         int res4 = obj.div(10,5);
//         System.out.println(res4);
//     }
// }

//this in Sample.java and

// class AdvCalc extends Calc{
//     public int multi(int n1, int n2){
//         return n1 * n2;
//     }
//     public int div(int n1, int n2){
//         return (int) n1 / n2;
//     }
// }

//this in AdvCalc.java and 

// class Calc{
//     public int add(int n1, int n2){
//         return n1 + n2;
//     }
//     public int sub(int n1, int n2){
//         return n1 - n2;
//     }
// }

//this in Calc.java,
//since AdvCalc and Calc are made public we would still be able to perform inheritance but 
//in complex projects where codes are placed in different files
//we place them inside one folder to ease the complexity of the project so we decide to shift AdvCalc.java and Calc.java inside 
//tools folder such that
//   tools-->
//          |
//          ---> AdvCalc.java 
//          ---> Calc.java 
//   Hello.java

// then we need to add package nameOfFolder;

// AdvCalc.java:

// package tools;

// public class AdvCalc extends Calc{
//     public int multi(int n1, int n2){
//         return n1 * n2;
//     }
//     public int div(int n1, int n2){
//         return (int) n1 / n2;
//     }
// }


// Calc.java:

// package tools;

// public class Calc{
//     public int add(int n1, int n2){
//         return n1 + n2;
//     }
//     public int sub(int n1, int n2){
//         return n1 - n2;
//     }
// }

   
// and in Hello.java:


// import tools.AdvCalc; (because we are using AdvCalc here)

// public class Sample{
//     public static void main(String[] args) {
//         AdvCalc obj = new AdvCalc();
//         int res = obj.add(10,5);
//         System.out.println(res);
//         int res2 = obj.sub(10,5);
//         System.out.println(res2);
//         int res3 = obj.multi(10,5);
//         System.out.println(res3);
//         int res4 = obj.div(10,5);
//         System.out.println(res4);
//     }
// }


//import.tools.*;  to import all the files from tools folder, not folders
//when we are creating a project,suppose im asked to create a package, 
//eg, if im making a library, i'll reverse the domain name to make it unique,
//let's say Google
//and I'm making a calculator or advanced calculator,
//I will say com.google.calculation.
//Now, this is my package name



//access modifiers:
//to access methods outside the package, it should always be made public
//within the same package, we can access methods without mentioning access modifier
//methods are generally made public majority of the times
//see table in notion
// The general idea is in one file you should have only one class.
// try to make your class public,
// try to keep your variables, the instance variables private.
// The methods most of the time will be public.
// But if you think there is a method or a variable which should be accessed only in the subclass
// of other packages, use protected,
// try to avoid default.
// Default is not something we should be using.



//Dynamic Method Dispatch
// class A {
//     public void show(){
//         System.out.println("in A show");
//     }
// }
// class B extends A {

// }

// public class Hello{
//     public static void main(String[] args) {
//         // B obj = new B();
//         // obj.show(); //in A show

//         A obj = new B(); //reference varible (obj) of type A, implementation is B (object of B)
//         obj.show(); // in A show
//     }
// }



// class A {
//     public void show(){
//         System.out.println("in A show");
//     }
// }
// class B extends A {
//      public void show(){
//         System.out.println("in B show");
//     }
// }

// public class Hello{
//     public static void main(String[] args) {
//         // B obj = new B();
//         // obj.show(); //in A show

//         A obj = new B(); 
//         obj.show(); // in B show
//     }
//}


//this is like
// A obj = new A(); //object A created in heap memory
// obj.show();

// obj = new B(); //new object created in heap memory, obj unlinks to object A and gets attatched to object B
// obj.show();

//so irrespective of what type of reference variable we have created, it all depends on what object we have
//this is run time polymorphism and can only happen in inheritance
//we can only have child objects for parent variable

// class A
// {
// 	public void show()
// 	{
// 		System.out.println("in A show");
// 	}
// }

// class B extends A
// {
// 	public void show()
// 	{
// 		System.out.println("in B show");
// 	}
// }

// class C extends A
// {
// 	public void show()
// 	{
// 		System.out.println("in C show");
// 	}
// }

// public class Hello{
// 	public static void main(String[] args) {
		
// 		A obj=new A();
// 		obj.show();
		
// 		obj=new B();
// 		obj.show();
		
// 		obj=new C();
// 		obj.show();
//     }
// }



//final keyword = 
// 1) to make values constant, 
// 2) stopping inheritance
// 3) stop method overriding

//final int num=8;
//num=9; //throws error

//  final class A{ //no one can extend it
//     public void show(){
//         System.out.println("in A");
//     }
//  }
//  class B extends A{ //throws error

//  }
//  public class Hello {
//     public static void main(String[] args) {
        
//     }
//  }




// class A{
//     public void show(){
//         System.out.println("by A show");
//     }

//     public void add(int n1, int n2){
//         System.out.println(n1 + n2);
//     }
// }

// class B extends A{
//     public void show(){
//         System.out.println("by B show");
//     }
// }

// public class Hello {
//     public static void main(String[] args) {
//         B obj = new B();
//         obj.show(); //B uses A class implementation and steals the credit 
//         //with the help of method overriding
//         obj.add(2,3);
//     }
// }
//to stop this overrriding we can make the method final, 


// class A{
//     public final void show(){
//         System.out.println("by A show");
//     }

//     public void add(int n1, int n2){
//         System.out.println(n1 + n2);
//     }
// }

// class B extends A{
//     public void show(){//throws error
//         System.out.println("by B show");
//     }
// }

// public class Hello {
//     public static void main(String[] args) {
//         B obj = new B();
//         obj.show(); 
//         obj.add(2,3);
//     }
// }

// class Laptop{
//         String model;
//         int price;
// }

// public class Hello{
//     public static void main(String[] args) {
//         Laptop obj = new Laptop();
//         obj.model = "Lenevo yoga";
//         obj.price = 1000;
//         //System.out.println(obj);//Laptop@7344699f
//         System.out.println(obj.toString()); //Laptop@7344699f = classname + @ + hexadecimal hashcode
//     }
// }
//printing obj is same as printing obj.toString
//defaultly it looks up to the superclass and produces the hashcode but if we explicitly
//define the toString method then it will call this instead of superclass




// class Laptop{
//         String model;
//         int price;

//         public String toString(){
//            // return "hey";
//            return model+":"+price;
//         }
// }

// public class Hello{
//     public static void main(String[] args) {
//         Laptop obj = new Laptop();
//         obj.model = "Lenevo yoga";
//         obj.price = 1000;
//         //System.out.println(obj.toString());  //hey
//         System.out.println(obj); //Lenevo yoga:1000
//     }
// }

// class Laptop{
//         String model;
//         int price;

//         public String toString(){
//            return model+":"+price;
//         }

//         public boolean equals(Laptop otherObject){
//             if(otherObject.price==this.price && otherObject.model.equals(this.model)){
//                 return true;
//             }else{
//                 return false;
//             }

//         }
// }

// public class Hello{
//     public static void main(String[] args) {
//         Laptop obj1 = new Laptop();
//         obj1.model = "Lenevo yoga";
//         obj1.price = 1000;
//         Laptop obj2 = new Laptop();
//         obj2.model= "Lenevo yoga";
//         obj2.price= 1000;
//         //boolean result = obj1==obj2; false
//         boolean result = obj1.equals(obj2); //false since .equals compares objects by hexadecimal so we modify .equals
//         System.out.println(result); //true
//     }
// }
//when we compare objects, we compare the value as well as the hashcode so we shouldnt modify the equals method instead




// class Laptop{
//         String model;
//         int price;

//         public String toString(){
//            return model+":"+price;
//         }

        
//         public int hashCode() {
//             final int prime = 31;
//             int result = 1;
//             result = prime * result + ((model == null) ? 0 : model.hashCode());
//             result = prime * result + price;
//             return result;
//         }

        
//         public boolean equals(Object obj) {
//             if (this == obj)
//                 return true;
//             if (obj == null)
//                 return false;
//             if (getClass() != obj.getClass())
//                 return false;
//             Laptop other = (Laptop) obj;
//             if (model == null) {
//                 if (other.model != null)
//                     return false;
//             } else if (!model.equals(other.model))
//                 return false;
//             if (price != other.price)
//                 return false;
//             return true;
//         }
// }



// public class Hello{
//     public static void main(String[] args) {
//         Laptop obj1 = new Laptop();
//         obj1.model = "Lenevo yoga";
//         obj1.price = 1000;
//         Laptop obj2 = new Laptop();
//         obj2.model= "Lenevo yoga";
//         obj2.price= 1000;
//         boolean result = obj1.equals(obj2); 
//         System.out.println(result); 
//     }
// }
//to generate hashcodes, right click source action, generate hashcode 
//similar for toString


//typecasting
//upcasting and downcasting
// class A {
//     public void show1(){
//         System.out.println("in A show");
//     }
// }
// class B extends A {
//     public void show2(){
//         System.out.println("in B show");
//     }
// }
// public class Hello {
//     public static void main(String[] args) {
//         A obj = new B();
//         //A obj = (A) new B(); upcasting this happens implicitly behind the scene

//         obj.show1();
//         //obj.show2();//thrwos error, object belongs to B, but reference variable is of A so this doesnt recognise B
//         //to solve this, we do downcasting

//         B obj1 = (B)obj; //obj is initially of type A so convert/downcasting it to type B
//         obj1.show2();
//     }
// }



//wrapper class - wrapper around a primitive type
//java is not purely object oriented programming
//for every primite data type, we have a class for it. and this class extends the object class

//int num = 7; //primitive datatype
// Integer num1 = 8; //reference datatype

//assinging primitive to object type
//bts-> Integer num1 = new Integer(num); //boxing-> storing primitive in wrapper object
//Integer num1 = num; autoboxing

//assigning objecttype to primitive
// int num=7;
// Integer num1 = num;
// bts-> int num2= num1.intValue(); //unboxing
// int num2= num1; //auto-unboxing

// String str = "12";
// int num3 = Integer.parseInt(str); //12 converting string to integer
// System.out.println(num3 * 2); //24