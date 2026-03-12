//abstract keyword - we declare the method in the class and define the implementation in the subclass 
//so we make the declared method abstract
//an abstract method can only be declared in an abstract class so we make the class abstract as well
//if a subclass is extending an abstract class, the subclass HAS to define all the abstract methods of the abstract superclass
//otherwise it throws error (defining is compulsory)
//therefore we override the method
//we can never create objects of an abstract class
//we can create the reference variable of abstract class tho
//if any abstract superclass A has 2 abstract methods and the subclass defines only 1 abstract method out of 2,in that case, the subclass is also made abstract
//a class which is not abstract is called concrete class
//abstract sole purpose: subclass overriding all abstract methods

// abstract class Car
// {
// 	public abstract void drive();
// 	public abstract void fly();
	
// 	public void playMusic()
// 	{
// 		System.out.println("play music");
// 	}
// }

// abstract class WagnoR extends Car
// {
// 	public void drive()
// 	{
// 		System.out.println("Driving...");
// 	}
// }

// class UpdateWagnoR extends WagnoR   //concrete class
// {
// 	public void fly()
// 	{
// 		System.out.println("flying...");
// 	}
// }

// public class  Demo{
//     public static void main(String[] args) {
//     	Car obj=new UpdateWagnoR();
//     	obj.drive();
//     	obj.playMusic();
//     }
// }




//Innerclass - (inner)class inside (outer) class 
// if you want to create object of inner class,
// which is B in this case,
// you need to first specify where it belongs to.
// So B belongs to A,
// and then you need object of outer class,
// which is obj here to create object of inner class.

// class A{                  //outer class
// 	public void show(){
// 		System.out.println("in A show");
// 	}

// 	    class B{              //inner class
// 		public void config()
//        {
// 			System.out.println("in B config");
// 		  }
//  	}

// }

// public class Demo{
// 	public static void main(String[] args) {
// 		A obj = new A(); //outerclass object
// 		obj.show();

// 		//to make innerclass object
// 		//outerclass.innerclass objectofInner = objectofOuter.new Inner();
// 		A.B obj1 = obj.new B();
// 		obj1.config();
// 	}
// }



//to create innerclass object when inner class is static
// class A{ 
// 	public void show(){
// 		System.out.println("in A show");
// 	}

// 	static class B{ 
// 		public void config(){
// 			System.out.println("in B config");
// 		}
// 	}
// }
// public class Demo{
// 	public static void main(String[] args) {
// 		A obj = new A(); 
// 		obj.show();

// 		//outerclass.innerclass objectofInner = new outerclass.InnerClass();
// 		A.B obj1 = new A.B();
// 		obj1.config();
// 	}
// }
//static can only be used for inner class
//only public, abstract and final are permitted for outerclass




//Anonymous Inner class - when we know the class will run only for once then we create a class without a name(anonymous) inside our mainclass (therefore inner)

// class A{ 
// 	public void show(){
// 		System.out.println("in A show");
// 	}
// }
// public class Demo{
// 	public static void main(String[] args) 
// 	{
// 		A obj = new A() //now this is the object of anonymous inner class
// 		{ //anonymous inner class
// 			public void show()
// 			{
// 				System.out.println("in new show");
// 			}
// 		};

// 		obj.show();//in new show
// 	}
// }






//abstract class and anonymous inner class
// abstract class A
// {
// 	public abstract void show();
// 	public abstract void config();
// }

// public class  Demo{
//     public static void main(String[] args) {    	
//     	A obj=new A() //not an object of abstract A class infact an object of anonymous inner class
//     	{
//     		public void show()
//     		{
//     			System.out.println("in new show");
//     		}

// 			public void config() {
// 				System.out.println("in anon inner config");
// 			}
//     	};

//     	obj.show();
//     	obj.config();
//     }
// }
//here what we did:
// Creating a new unnamed subclass of A
// Immediately overriding all abstract methods
// Instantiating that subclass -> creating object 
// Storing its reference in obj
// Anonymous inner class is implicitly extending A

// Anonymous inner class =
// Extends a class OR
// Implements an interface
// Overrides required methods
// Has no name
// Used only once





//Interface
//interface methods are a public abstract
//interface variables are public static final
//Interfaces cannot have instance variables.
//interface is like abstract superclass, 
//the subclass inherits the interface by using keyword implements (just like extends)
//if the subclass fails to define all the interface methods (public abstract methods) the subclass itself becomes abstract then
//for a subclass to remain concrete it must define all the interface methods
//we can create refernce variable of the interface to create object of subclass
//all the varibles inside interface are by default final and static
//if i make a vriable final i have to initialise the moment i declare
//we directly access the static varibles by name, similar in interface 
//interfaces dont have memory in the heap


// interface A
// {
// //	public abstract void show();
// //	public abstract void config();
// 	int age=44;            // final and static 
// 	String area="Mumbai";
	
// 	void show();
// 	void config();
// }

// class B implements A
// {
// 	public void show()
// 	{
// 		System.out.println("in show");
// 	}
// 	public void config()
// 	{
// 		System.out.println("in cofing");
// 	}
// }

// public class Demo {
//     public static void main(String[] args) {
//     	A obj;
//     	obj=new B();
    	
//     	obj.show();
//     	obj.config();
//     	System.out.println(A.area);
//     }
// }




//if a class inherits another class we use extends
//if a class inherits an interface we use implements
//if an interface inherits another interface we use extends

//(unlike abstract class, in abstract class one class can extend only one class)
//a class can inherit multiple interfaces like
//class B implements X,Y
//{
// 
//}
//in such case the class has to override all the declared methods from both the inherited interfaces
//suppose there are 3 interfaces -> A, X, Y and 1 class B
//interface A, X -> individual, and Y extends X, class B implements A,Y, here class B has to override all the methods
//A has show() & config(), X has run()
//in main method we create a reference variable A pointing to object of B 
//now this can only call methods of A and i'll need a refernce variable X pointing to object of B in order to call method of X
//because ref var of interface A cannot recognise methods of other interfaces

//Because reference variable type decides what methods are visible at compile time.
//The object type matters only at runtime (for method overriding).

// interface A
// {
// 	int age=44;            
// 	String area="Mumbai";
// 	void show();
// 	void config();
// }

// interface X
// {
// 	void run();
// }

// interface Y extends X //Y inherits run()
// {
	
// }

// class B implements A,Y //class inheriting multiple interfaces
// {
//     //class B overriding all methods from inherited parents
// 	public void show()
// 	{
// 		System.out.println("in show");
// 	}
// 	public void config()
// 	{
// 		System.out.println("in cofing");
// 	}
// 	public void run()
// 	{
// 		System.out.println("running...");
// 	}
// }

// public class Demo {
//     public static void main(String[] args) {
//     	A obj;
//     	obj=new B();
//     	obj.show();
//     	obj.config();
//     	X obj1=new B();
//     	obj1.run(); 	    	
//     	System.out.println(A.area);
//     }
// }



//need of interface: eg,
//whenever we join a company we get either a laptop or a desktop.
// class Laptop{
//     public void code(){
//         System.out.println("code,test,run");
//     }
// }
// class Developer{
//     public void devApp(Laptop lap){ //passing lap object
//         lap.code();
//     }
// }
// public class Demo{
//     public static void main(String[] args) {
//         Developer tanishka = new Developer();
//         Laptop lap = new Laptop();
//         tanishka.devApp(lap);
//     }
// }


//compny gives me desktop but my application needs a laptop
// class Laptop{
//     public void code(){
//         System.out.println("code,test,run");
//     }
// }
// class Desktop{
//     public void code(){
//         System.out.println("code,test,run: faster");
//     }
// }
// class Developer{
//     public void devApp(Laptop lap){ //but i can only accept a laptop, to solve this issue 
//          //here the dev is dependent on a laptop, when he/she should only be dependent on a computer
//          lap.code();
//     }
// }
// public class Demo{
//     public static void main(String[] args) {
//         Laptop lap = new Laptop();
//         Desktop desk = new Desktop();

//         Developer tanishka = new Developer();
//         tanishka.devApp(desk);//error//here the cmpny passes desktop

//     }
// }


// class Computer{
//     public void code(){

//     }
// }
// //laptop is actually a computer
// class Laptop extends Computer{
//     public void code(){
//         System.out.println("code,test,run");
//     }
// }
// //so is a desktop
// class Desktop extends Computer{
//     public void code(){
//         System.out.println("code,test,run: faster");
//     }
// }
// class Developer{
//     public void devApp(Computer lap){ 
//         lap.code();
//     }
// }
// public class Demo{
//     public static void main(String[] args) {
//         Computer lap = new Laptop();
//         Computer desk = new Desktop();

//         Developer tanishka = new Developer();
//         //tanishka.devApp(desk); //code,test,run: faster
//         tanishka.devApp(lap); //code,test,run
//     }
// }
//we should always design the application such that it is loosely coupled
//where nothing is independent on a specialised thing, it should always be focused on generalised thing



//better version-> a method inside a class doing nothing? abstract behaviour

// abstract class Computer{
//     public abstract void code();
// }
// class Laptop extends Computer{
//     public void code(){
//         System.out.println("code,test,run");
//     }
// }
// class Desktop extends Computer{
//     public void code(){
//         System.out.println("code,test,run: faster");
//     }
// }
// class Developer{
//     public void devApp(Computer lap){ 
//         lap.code();
//     }
// }
// public class Demo{
//     public static void main(String[] args) {
//         Computer lap = new Laptop();
//         Computer desk = new Desktop();

//         Developer tanishka = new Developer();
//         //tanishka.devApp(desk); //code,test,run: faster
//         tanishka.devApp(lap); //code,test,run
//     }
// }


//make it even better-> 
// interface Computer{ //change
//     void code();
// }
// class Laptop implements Computer{  //change
//     public void code(){
//         System.out.println("code,test,run");
//     }
// }
// class Desktop implements Computer{    //change
//     public void code(){
//         System.out.println("code,test,run: faster");
//     }
// }
// class Developer{
//     public void devApp(Computer lap){ 
//         lap.code();
//     }
// }
// public class Demo{
//     public static void main(String[] args) {
//         Computer lap = new Laptop();
//         Computer desk = new Desktop();

//         Developer tanishka = new Developer();
//         tanishka.devApp(lap); //code,test,run
//     }
// }




//enums are named constants
// enum Status{ //status is a class 
//     Running, Faild, Pending, Success; //by default: 4 different objects
// } //indexing starts from 0

// public class Demo{
//     public static void main(String[] args) {
//         Status s = Status.Pending;

//         System.out.println(s); //Pending
//         System.out.println(s.ordinal()); //2
//         //s.ordinal() returns index of object

//         Status[] ss = Status.values();// classname.values() returns an array of type status
//         System.out.println(ss[0]);//Running

//         //to print all status objects with indexing
//         for(Status s1 : ss){
//             System.out.println(s1+" : "+s1.ordinal());
//         }
//     }
// }



//if else and switch case with enums
// enum Status{
// 	Running, Failed, Pending, Success;
// }
// public class Demo {
//     public static void main(String[] args) {
//     	Status s=Status.Pending;
//     	switch(s)
//     	{
//     		case Running:
//     			System.out.println("All Good");
//     			break;
//     		case Failed:
//     			System.out.println("Try Again");
//     			break;			
//     		case Pending:
//     			System.out.println("Please Wait");
//     			break; 		
//     		default:
//     			System.out.println("Done");
//     			break;
//     	}
    	
//     	if(s==Status.Running)
//     		System.out.println("All Good");
//     	else if(s==Status.Failed)
//     		System.out.println("Try Again");
//     	else if ( s==Status.Pending)
//     		System.out.println("Please Wait");
//     	else
//     		System.out.println("Done");
//     }
// }



//enum is just like a class
//we can create methods, constructors, variables
//but we can never extend an enum

// enum Laptop{
// //	Mackbook(2000), XPS(2200), Surface(1500), ThinkPad(1800);
// 	Macbook(2000), XPS(2200), Surface, ThinkPad(1800);
// 	private int price;
// 	private Laptop() //def const
// 	{
// 		price=500;
// 	}
	
// 	private Laptop(int price) //param const
// 	{
// 		this.price=price;
// 	}
	
// 	public int getPrice()
// 	{
// 		return price;
// 	}

// 	public void setPrice(int price)
// 	{
// 		this.price=price;
// 		System.out.println("in Laptop" + this.name());
// 	}
// }

// public class Demo {
//     public static void main(String[] args) {
// //    	Laptop lap=Laptop.Macbook;
// //    	System.out.println(lap+ " : "+lap.getPrice());
//     	for(Laptop lap : Laptop.values())
//     	{
//     		System.out.println(lap+" : "+lap.getPrice());
//     	}
//     }
// }



//Annotation -> supplying extra data such that compiler helps us debugging
//eg when we override any method just above it mention @Override so the compiler knows the intention and throws error if me mistype the name of common method
//specially in frameworks like hibernate, spring 
//in class, deprication to mark it @Depricated
//in methods, @SuppressWarnings to hide the warnings



//different types of interfaces: normal, functional(SAM), Marker
//normal-> an interface with 2 or more methods 
//functional / (SAM- single abstract method interface) -> interface which has only 1 method also known as functional interface
//marker-> interface which has zero methods, a blank interface, this is to update something to a compiler
//      ->"It is used to mark a class to indicate that it has a special property or capability. It does not define methods but enables special behavior through runtime checks."
//@FunctionalInterface annotation for sam/functional interface to draw importance to single method intention

// @FunctionalInterface
// interface A{
//     void show();
// }

// public class Demo{
//     public static void main(String[] args) {
//         A obj = new A(){  //instantiating the subclass of A
//             public void show(){
//                 System.out.println("in show");
//             }
//         };
//         obj.show();
//     }
// }


//java 8 introduced lamda expressions
//Lambda expressions: shortening the "too verbose" code 
//A lambda expression is a shorter way to implement a functional interface.
//if we have 1 statement under lambda expression then curly braces are optinal
//lamda expression works only with the functional interface

// @FunctionalInterface
// interface A{
//     void show();
// }

// public class Demo{
//     public static void main(String[] args) {
//         A obj = () ->
//         {
//            System.out.println("in show");
//         }
//         ;
//         obj.show();
//     }
// }


//if we pass value in abstract method then:
//without lambda 

// @FunctionalInterface
// interface A{
//     void show(int i);
// }
// public class Demo{
//     public static void main(String[] args) {
//         A obj = new A() {
//             public void show(int i){
//                 System.out.println("in show "+ i );
//             }
//         };
//         obj.show(5);
//     }
// }

//with lamda
// @FunctionalInterface
// interface A{
//     void show(int i);
// }
// public class Demo{
//     public static void main(String[] args) {
//         A obj = (int i)-> {
//             System.out.println("in show "+ i );
//         };
//         obj.show(5);
//     }
// }

// or

// @FunctionalInterface
// interface A{
//     void show(int i);
// }
// public class Demo{
//     public static void main(String[] args) {
//         A obj = i-> System.out.println("in show "+ i );
//         obj.show(5);
//     }
// }



//lambda with returns:
//without lambdas, anonyyyyyyyyymous innerclass
// @FunctionalInterface
// interface A{
//     int add(int i, int j);
// }
// public class Demo{
//     public static void main(String[] args) {
//         A obj = new A(){
//             public int add(int i, int j){
//                 return i+j;
//             }
//         };
//         int result = obj.add(5,4);
//         System.out.println(result);
//     }
// }


// @FunctionalInterface
// interface A{
//     int add(int i, int j);
// }
// public class Demo{
//     public static void main(String[] args) {
//         A obj = (i,j) -> i+j;
//         int result = obj.add(5,4);
//         System.out.println(result);
//     }
// }
//whenever we have 1 statement and its a return type, we'll remove return word too




//types of errors:
//compile time error
//logical error
//runtime error

//compile time error examples:
//spelling mistake/syntactical mistakes

//logical error:
//bugs in code

//runtime errors: exceptions
//execution stops in between

//EXCEPTION HANDLING:
//a statement can be normal or critical
//example: dividing a number by zero throws arithmetic exception
// public class Demo{
//     public static void main(String[] args) {
//         int i=0;
//         int j=0;
//         j=18/i;  //this is the critical statement here
//         System.out.println(j);  //throws arithmetic exception
//         System.out.println("bye");
//     }
// }

//how to handle such exceptions? using try catch blocks 
//we write criticle statements under try catch blocks
// public class Demo{
//     public static void main(String[] args) {
//         int i=0;
//         int j=0;
//         // tries to execute the statement, if something goes wrong, flow reaches the catch block
//         try 
//         {
//             j=18/i; //if this works, great

//         }
//         catch(Exception e){ //it throws error/exception, java here creates an object belonging to the Exception class and catches the error and handles it using the catch block 
//             System.out.println("error: something went wrong");
//         }

//         System.out.println(j);  
//         System.out.println("bye");
//     }
// }



//trying to print exception

// public class Demo{
//     public static void main(String[] args) {
//         int i=0;
//         int j=0;

//         try 
//         {
//             j=18/i; 
//         }
//         catch(Exception e){ 
//             System.out.println("error: something went wrong" + e);
//         } //arithmetic exception

//         System.out.println(j);  
//         System.out.println("bye");
//     }
// }


// public class Demo{
//     public static void main(String[] args) {
//         int i=10;
//         int j=0;

//         int a[] = new int[5]; //last index 4

//         try 
//         {
//             j=48/i; 
//             System.out.println(a[1]); //0
//             System.out.println(a[5]); //going out of bound

//         }
//         catch(Exception e){ 
//             System.out.println("error: something went wrong" + e); 
//         } //ArrayIndexOutOfBoundsException

//         System.out.println(j);  //4
//         System.out.println("bye");
//     }
// }




// public class Demo{
//     public static void main(String[] args) {
//         int i=0;
//         int j=0;

//         int a[] = new int[5]; 

//         try 
//         {
//             j=48/i; //something by 0 //arithmetic exception //doesnt proceed further in the block
//             System.out.println(a[1]);
//             System.out.println(a[5]); 
//         }
//         catch(Exception e){ 
//             System.out.println("error: something went wrong" + e); 
//         } // arithmetic Exception

//         System.out.println(j);  
//         System.out.println("bye");
//     }
// }





// public class Demo{
//     public static void main(String[] args) {
//         int i=2;
//         int j=0;

//         int a[] = new int[5]; 

//         try 
//         {
//             j=10/i; //5
//             System.out.println(a[1]); //0
//             System.out.println(a[5]); //going out of bound //ArrayIndexOutOfBound
//         }

//         catch(ArithmeticException e){ //only catching arithmetic exception
//             System.out.println("cannot divide by 0"); 
//         } 
//         System.out.println(j);  
//         System.out.println("bye");
//     }
// }//execution stops in middle, bye never gets printed since no catch block to catch ArrayIndexOutOfBoundException



//so we keep multiple catch blocks

// public class Demo{
//     public static void main(String[] args) {
//         int i=2;
//         int j=0;
//         int a[] = new int[5]; 
//         try 
//         {
//             j=10/i; //5
//             System.out.println(a[1]); //0
//             System.out.println(a[5]); //going out of bound //ArrayIndexOutOfBound
//         }
//         catch(ArithmeticException e){ 
//             System.out.println("cannot divide by 0"); 
//         } 
//         catch(ArrayIndexOutOfBoundsException e){
//             System.out.println("stay in your limits");
//         }
//         System.out.println(j);  
//         System.out.println("bye");
//     }
// }

// 0
// stay in your limits
// 5
// bye


//Exception is the parent class which handles all the kinds of exceptions 

/*exception hierarchy - general idea
(then means below)

on top object class
then throwable 
then we have error and exception (runtime, Sql execpion, io exception,)

object -> throwable -> error and exception
error(thread death, IOerror, virtual machine errr, out of memory)
exception(runtimeException[arithmetic, arrayindexoutofbound,nullPointerExcep], sqlExcep, IoExcp)

under exception-> all runtime exceptions are called unchecked exceptions, and other types of exceptions are called check excpetions
all checked exceptions are compulsory to handle

Checked = external problems (file missing, DB down, network error)
Unchecked = coding mistakes (null, bad index, divide by zero)


(exception class extends throwable
most of the names which ends with '-able' are interfaces -> runnable, serializable, cloneable, 
RuntimeException is something we can handle
exception can and should be handled, errors cannot be handled)
as a good programmer, we should always handle the exceptions */



/*
Exception throw keyword 
used to throw the exception, 
creates an object and catch block catches it
we can also pass the message inside the thrown exception
*/
//    public class Demo {
//     public static void main(String[] args) {
//     	int i=20;
//     	int j=0;

//     	try
//     	{
//     		j=18/i;
//     		if(j==0)
//     			throw new ArithmeticException("I don't want to print zero");
//     	}     

//     	catch(ArithmeticException e)
//     	{
//     		System.out.println("that is default output" + e);
//     	}    
    	
//     	catch(Exception e)
//     	{
//     		System.out.println("Something went wrong."+e);
//     	}    
//     	System.out.println(j);
//     	System.out.println("Bye");
//     }    
// }



/*Custom Exception

to create a custom exception, we create a custom exception class which inherits the parent Exception or the RubtimeException
we write a condition, if this happens we then throw our customised exception and pass a message if we want
now this message is sent to the custom excpeyion class we created and it must pass the message to the constructor of the super class
only then can the message be visible
*/

// class NavinException extends Exception
// {
// 	public NavinException(String string)
// 	{
// 		super(string);
// 	}
// }

// public class Demo {
//     public static void main(String[] args) {
//     	int i=20;
//     	int j=0;
    	
//     	try
//     	{
//     		j=18/i;
//     		if(j==0)
//     			throw new NavinException("I don't want to do print zero");
//     	}

//     	catch(NavinException e)
//     	{
//     		j=18/i;
//     		System.out.println("that is default output : " + e.getMessage());
//     	}
    	
//     	catch(Exception e)
//     	{
  
//     		System.out.println("Something went wrong." + e.getMessage);
//     	}
//     	System.out.println(j);
//     	System.out.println("Bye");
//     }
// }
// that is default output : NavinException: I don't want to do print zero
// 0
// Bye

//import java.util.Arrays;
//import java.util.List;

//// TODO: Define custom exception InvalidAgeException extending Exception
// class InvalidAgeException extends Exception{
//         InvalidAgeException(String message){
//         super(message);
//         }
//     }
    
    
// public class Exercise {
    
    
//     public static void checkAge(int age) throws InvalidAgeException{
//         // TODO: Throw custom exception if age < 18, else print "Access granted"
//         if(age<18){
//             throw new InvalidAgeException("Age must be 18 or older");
//         }else{
//             System.out.println("Access granted");
//         }
        
//     }
    
//     public static void main(String[] args) {
//         // TODO: Call checkAge(16) and checkAge(21) inside separate try-catch blocks
//         try{
//             checkAge(16);
//         }catch(InvalidAgeException e){
//             System.out.println("Exception caught: " + e.getMessage());
//         }
        
//         try{
//             checkAge(21);
//         }catch(InvalidAgeException e){
//             System.out.println("Exception caught: " + e.getMessage());
//         }
        
//     }
// }




/* Ducking Exception using throws keyword 

suppose we have a critical statement so we put it in the try catch, we all this are happening inside method D()
and theres another similar fn/method E(). both have a critical statement
either we can write write try catch in each of the methods 

OR 

we create C() which calls D and E inside a try block and catch the exception all at once 
while we do "throws exception" in each of D and E. 

whatever problem arises in d and e,
they will not handle it,
they will just send the exception to the method
who is calling it?
Sometime we just call ducking the exception
because we are ducking it, we are not handling it

Even main can have a try catch.
So basically you can go up the ladder
and you can write try catch
in whatever method you want to write.
So if you write, try catch in main, now all those methods which have been ducking it would
"throws Exception" 
all these are specially done for checked exceptions

never write throws in main method-> jvm stops the execution
we can throws in other methods

printStackTrace prints the entire method calls which method is calling which method
*/

/* 
class A
{
	public void show() throws ClassNotFoundException
	{

//    	try
//    	{
//    		Class.forName("Calc");
//    	}
//    	catch(ClassNotFoundException e)
//    	{
//    		System.out.println("Not able to find the class");
//    	}


		Class.forName("Calc");
	}
}

public class Demo {
	
	static {
		System.out.println("Class Loader");
	}
    public static void main(String[] args) {
    	
//    	try
//    	{
//    		Class.forName("Class");
//    	}
//    	catch(ClassNotFoundException e)
//    	{
//    		System.out.println("Not able to find theh class");
//    	}
    	
    	A obj=new A();
    	try {
    		obj.show();
    	}catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    }
}

*/
//whichever method we are calling which throws some checked exception, we need to call that under try catch 



/*
Taking input from user

for printing:
System.out.println("somwthing");

System is a class
out is a static object of printstream so we access it statically (System.out)
println is a method of class PrintStream

experiment:
System.in.read(); gives the ascii valueof character

every character in keyboard has its ASCII value
A = 65
a = 97
0 = 48

its always a good practise to close the resources -> file, database, network
eg) bf.close(); 

InputStreamReader in=new InputStreamReader(System.in);
BufferedReader bf=new BufferedReader(in);
int num=Integer.parseInt(bf.readLine());
bf.close();

if we use BufferedReader we hve to throws IO Exception
before version 1.5 we had this above lengthy form, later came:

Scanner sc = new Scanner(System.in); //we have to mention here where we are getting the input from
int num = sc.nextInt();  */



/*
finally block:

irrespective of whether theres an exception or not, finally blocks are always executed
finally blocks are used to close the resources -> file, input, connections
so in such cases we use try with finally
*/

//alternate
//whenever theres a class or interface which is Autocloseable, it means that will be closed automatically with the help of try block
/*
try(resources){
  heiuhdfiwhbv
  hjsbjgbucdsg
}  */


/* Thread - smallest unit of execution inside a program / smallest working unit 
   If a process is a whole app (like your Java program),
   a thread is a worker inside it doing a specific task.
*/

//multi-threading : making different tasks run parallely using time sharing concept and multi-threading
// class A{
//     public void show(){
//         for(int i=0;i<5;i++){
//         System.out.println("Hi");}
//     }
// }

// class B{
//     public void show(){
//         for(int i=0;i<5;i++){
//         System.out.println("Hello");}
//     }
// }

// public class Demo{
//     public static void main(String[] args) {
// 		A obj = new A();
// 		B obj2 = new B();
// 		obj.show();
// 		obj2.show();
// 	}
// }

//the above code first execeutes obj.show(), when its done then it moves on to obj2.show()
//threads can make run things in parallel
//how can i make normal objects as threads? inherit from Thread class
//every thread must have a run method
//object.start() starts executing the run method
//its schedular's job to allow which os to execute which task first

// class A extends Thread
// {
// 	public void run()
// 	{
// 		for(int i=1;i<=5;i++)
// 		{
// 			System.out.println("Hi");
// 		}
// 	}
// }

// class B extends Thread
// {
// 	public void run()
// 	{
// 		for(int i=1;i<=6;i++)
// 		{
// 			System.out.println("Hello");
// 		}
// 	}
// }

// public class Demo {
//     public static void main(String[] args) throws NumberFormatException {   
//     	A obj1=new A();
//     	B obj2=new B();
//     	obj1.start();
//     	obj2.start();
//     }
// }


// Hello
// Hello
// Hi
// Hi
// Hi
// Hi
// Hi
// Hello
// Hello
// Hello
// Hello



/*threads priority:
ranges from [1 to 10]
1 = least , 10 = highest priority, 5 = default

setting priority-> (MIN_PRIORITY, MAX_PRIORITY, NORMAL_PRIORITY) or give priority number
obj.setPriority(Thread.MAX_PRIORITY); //suggesting the scheduler to give this task the highest prioprity, we can only suggest the order of execution, cant control

asking the thread to wait->
Thread.sleep(10); //this sleep comes with a checked exception so we either throws or try catch (InterruptedException)
method goes into waiting stage for 10 ms
*/

// class A extends Thread
// {
// 	public void run()
// 	{
// 		for(int i=1;i<=10;i++)
// 		{
// 			System.out.println("Hi");
// 			try {
// 				Thread.sleep(10);
// 			}catch(InterruptedException e) {
// 				e.printStackTrace();
// 			}
// 		}
// 	}
// }

// class B extends Thread
// {
// 	public void run()
// 	{
// 		for(int i=1;i<=10;i++)
// 		{
// 			System.out.println("Hello");
// 			try {
// 				Thread.sleep(10);
// 			}catch(InterruptedException e) {
// 				e.printStackTrace();
// 			}

// 		}
// 	}
// }

// public class Demo {
//     public static void main(String[] args) throws NumberFormatException {   
    	
//     	A obj1=new A();
//     	B obj2=new B();
 
//     	obj2.setPriority(Thread.MAX_PRIORITY);//10
//     	System.out.println(obj1.getPriority()); //5
    	
//     	obj1.start();

//     	try {  //main thread goes to sleep for 2ms
// 			Thread.sleep(2);
// 		}catch(InterruptedException e) {
// 			e.printStackTrace();
// 		}

//     	obj2.start();
//     }
    
// }


/*Runnable vs Thread:

java doesnt support multiple ineritance but
i want A to be the parent, B to be the subclass as well as the thread

i can either implement Runnable or extend Thread (both have run methods)
but the start method belongs to Thread class only 
so we create Threads and call start method with thread objects
how do we link the objects to these thread objects? by passing the (runnable reference, object of class) objects inside Thread constructor
so we can either extend a Thread class or implement a Runnable interface, incase of runnable interface we create thread objects explicitly and pass obj inside the thread constructor 

Runnable interface is a functional interface so we can also convert the anonymous class (instantiating runnable interface with the help of anon) into a lambda expression

*/


// class A implements Runnable
// {
// 	public void run()
// 	{
// 		for(int i=1;i<=5;i++)
// 		{
// 			System.out.println("Hi");
// 			try {
// 				Thread.sleep(10);
// 			}catch(InterruptedException e) {
// 				e.printStackTrace();
// 			}
// 		}
// 	}
// }

// class B implements Runnable
// {
// 	public void run()
// 	{
// 		for(int i=1;i<=5;i++)
// 		{
// 			System.out.println("Hello");
// 			try {
// 				Thread.sleep(10);
// 			}catch(InterruptedException e) {
// 				e.printStackTrace();
// 			}
// 		}
// 	}
// }

// public class Demo {
//     public static void main(String[] args) {   
    	
// //    	A obj1=new A();
// //    	B obj2=new B();
// //    	Runnable obj1=new A();
// //    	Runnable obj2=new B();
    	

// //anonymous class of Runnable interface  	
// //    	Runnable obj1=new Runnable() 
// //    	{
// //    		public void run()
// //    		{
// //    			for(int i=1;i<=5;i++)
// //    			{
// //    				System.out.println("Hello");
// //    				try {
// //    					Thread.sleep(10);
// //    				}catch(InterruptedException e) {
// //    					e.printStackTrace();
// //    				}
// //    			}
// //    		}
// //
// //     };
    	
//     	Runnable obj1=()-> //lambda expression
//     	{
//     		for(int i=1;i<=5;i++)
//     		{
//     			System.out.println("Hi");
//     			try {Thread.sleep(10);}catch(InterruptedException e) {e.printStackTrace();}
//     		}
//     	};
    	
//     	Runnable obj2=()->
//     	{
//     		for(int i=1;i<=5;i++)
//     		{
//     			System.out.println("Hello");
//     			try {Thread.sleep(10);}catch(InterruptedException e) {e.printStackTrace();}
//     		}
//     	};
    	
//     	Thread t1=new Thread(obj1);
//     	Thread t2=new Thread(obj2);
    	 	
//     	t1.start();
//     	t2.start();
//     }
    
// }

//above code is just an illustration of we first create all the classes then we how replace them by anonymous classes then how can we replace all this by lambda expressions
//(fundamentals -> anonymous class -> lambda expression)

//code using fundamentals (classes implementing runnable) :
// class A implements Runnable {

//     @Override
//     public void run() {
//         for (int i = 1; i <= 5; i++) {
//             System.out.println("Hi");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 Thread.currentThread().interrupt();
//             }
//         }
//     }
// }

// class B implements Runnable {

//     @Override
//     public void run() {
//         for (int i = 1; i <= 5; i++) {
//             System.out.println("Hello");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 Thread.currentThread().interrupt();
//             }
//         }
//     }
// }

// public class Demo {
//     public static void main(String[] args) {

//         Runnable obj1 = new A();
//         Runnable obj2 = new B();

//         Thread t1 = new Thread(obj1);
//         Thread t2 = new Thread(obj2);

//         t1.start();
//         t2.start();
//     }
// }



//code using anonymous classes:
// public class Demo {
//     public static void main(String[] args) {

//         Runnable obj1 = new Runnable() {
//             @Override
//             public void run() {
//                 for (int i = 1; i <= 5; i++) {
//                     System.out.println("Hi");
//                     try {
//                         Thread.sleep(10);
//                     } catch (InterruptedException e) {
//                         Thread.currentThread().interrupt();
//                     }
//                 }
//             }
//         };

//         Runnable obj2 = new Runnable() {
//             @Override
//             public void run() {
//                 for (int i = 1; i <= 5; i++) {
//                     System.out.println("Hello");
//                     try {
//                         Thread.sleep(10);
//                     } catch (InterruptedException e) {
//                         Thread.currentThread().interrupt();
//                     }
//                 }
//             }
//         };

//         Thread t1 = new Thread(obj1);
//         Thread t2 = new Thread(obj2);

//         t1.start();
//         t2.start();
//     }
// }



//code using lambda expressions:
// public class Demo {
//     public static void main(String[] args) {

//         Runnable obj1 = () -> {
//             for (int i = 1; i <= 5; i++) {
//                 System.out.println("Hi");
//                 try { Thread.sleep(10); }
//                 catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//             }
//         };

//         Runnable obj2 = () -> {
//             for (int i = 1; i <= 5; i++) {
//                 System.out.println("Hello");
//                 try { Thread.sleep(10); }
//                 catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//             }
//         };

//         Thread t1 = new Thread(obj1);
//         Thread t2 = new Thread(obj2);

//         t1.start();
//         t2.start();
//     }
// }





/*
RACE CONDITIONS:
mutation means something changeable.

when working with threads, always make sure the data im dealing with is immutable (string, Integer, final, object without setters)
or in case of mutation, make it thread safe.

thread + mutation -> suppose thread uses t1 and t2 both have the access to show() and i try to modify show(), both the threads reach show() together simulataneously at the same time causing the modification twice.
we dont want that. to make sure only one thread can access the method at one time we use "synchronised" keyword
this is how we make a thread safe
*/

// class Counter
// {
// 	int count;
// 	public synchronized void increment() //Only one thread at a time can execute this method
// 	{
// 		count++;
// 	}
// }

// public class Demo {
//     public static void main(String[] args) throws InterruptedException{   
    	
//     	Counter c=new Counter();
    	
//     	Runnable obj1=()->
//     	{
//     		for(int i=1;i<=10000;i++)
//     		{
//     			c.increment();
//     		}
//     	};
    	
//     	Runnable obj2=()->
//     	{
//     		for(int i=1;i<=10000;i++)
//     		{
//     			c.increment();
//     		}
//     	};
    	
//     	Thread t1=new Thread(obj1);
//     	Thread t2=new Thread(obj2);
    	 	
//     	t1.start();
//     	t2.start();
    	
//     	t1.join();  //This makes main thread wait until t1, t2 finishes
//     	t2.join();
    	
//     	System.out.println(c.count);
//     }
// }

//why do we need synchronised here?
//Because increment is not atomic and can cause race conditions when multiple threads modify shared state. Synchronization ensures mutual exclusion and maintains data consistency.

    


/* thread states:
start() - it goes into runnable state
run() - running state
sleep() - keep on hold for sometime
wait() - waiting state
notify() - to come back from waiting and go into runnable
stop() - to stop the thread (deprecated)
*/

//Thread.currentThread() - calling the current thread statically
//Thread.currentThread().getName() - gives the name of current thread
//Thread t1 = new Thread(obj, "name of thread"); - passing name of thread

// Using .start():
// Creates new thread
// Executes run() in that new thread
// Runs concurrently

// We use synchronized when:
// Multiple threads are accessing shared data
// and at least one thread is modifying it.




/* 
Collection API: concept
Collection: interface
Collections: class

array -> comes with a fixed size, cant expand size
Collection belongs to util package therefore use " import java.util.Collection"
API means a library or some feature which we can use, we dont have to implement them

Collection -> List [ArrayList, LinkedList] , Queue [Dequeue], Set [HashSet, LinkedHashSet]
for printing an array we need a loop, but for collections, we can directlt print without using a loop

*/

// import java.util.Collection;
// import java.util.ArrayList;

// public class Demo{
// 	public static void main(String[] args) {
// 		Collection nums = new ArrayList();
// 		nums.add(6);
// 		nums.add(0);
// 		nums.add(8);
// 		nums.add(7);
// 		nums.add(5);

// 		System.out.println(nums); //[6, 0, 8, 7, 5]
		
// 	}
// }





// import java.util.Collection;
// import java.util.ArrayList;

// public class Demo{
// 	public static void main(String[] args) {
// 		Collection <Integer> nums = new ArrayList();
// 		nums.add(6);
// 		nums.add(0);
// 		nums.add(8);
// 		nums.add(7);
// 		nums.add(5);
		
// 		for(int n : nums){
// 			System.out.println(n);
// 		}
// 	}
// }
// 6
// 0
// 8
// 7
// 5

//Collection doesnt support indexing, List does.

// import java.util.List;
// import java.util.ArrayList;

// public class Demo{
// 	public static void main(String[] args) {
// 		List <Integer> nums = new ArrayList();
// 		nums.add(6);
// 		nums.add(0);
// 		nums.add(8);
// 		nums.add(7);
// 		nums.add(5);
// 		nums.add(7);
		
// 		System.out.println(nums.get(2)); //index accessing //8
// 		System.out.println(nums.indexOf(7)); //gives the index of first occurrence of value //3
// 	}
// }
//ArrayList is the class which implements Collection and List


//Set
// set stores unique values 
// no indexing
// HashSet - random order, maintains no sequence
// if we want values in sorted order we use TreeSet


// import java.util.Set;
// import java.util.HashSet;
// public class Demo{
// 	public static void main(String[] args) {
// 		Set<Integer> nums= new HashSet<Integer>();
// 		nums.add(6);
// 		nums.add(0);
// 		nums.add(0);
// 		nums.add(0);
// 		nums.add(9);
// 		nums.add(7);
// 		nums.add(7);

// 		for(int n : nums){
// 			System.out.println(n);
// 		}
// 	}
// }
// 0
// 6
// 7
// 9

// how do we iterate in set?

// Iterator <Integer> values = nums.iterator();
// while(values.hasNext()){
// 	System.out.println(values.next());
// }




//Map -> key-value pair
//keys cannot be repeated 
//different keys might have same same values
//keys are set, values are list here
//mapName.get("key"); -> gives corresponding value
//mapName.keySet() -> to get all the keys
//hashmap = hashtable, if youre using synchronised, use HashTable otherwise HashMap

// import java.util.Map;
// import java.util.HashMap;
// public class Demo{
// 	public static void main(String[] args) {
// 		Map<String, Integer> students = new HashMap<>();
// 		students.put("Tanishka", 91);
// 		students.put("Sara", 98);
// 		students.put("Cherry", 99);
// 		students.put("Chad", 2);

// 		System.out.println(students); //{Tanishka=91, Cherry=99, Chad=2, Sara=98}
// 		System.out.println(students.get("Tanishka")); //91
// 	}
// }




//Comaparator vs comparable

// What is comparator?
// If you want to specify on which logic you want to sort the elements, you can use comparator.
// What is comparable?
// If you want to give a power to the class itself to compare itself or to compare its object to itself, we can use comparable there.

//normal sorting:

// import java.util.Collections;
// import java.util.List;
// import java.util.ArrayList;
// public class Demo{
// 	public static void main(String[] args) {
// 		List<Integer> nums = new ArrayList<>();
// 		nums.add(9);
// 		nums.add(7);
// 		nums.add(4);
// 		nums.add(3);

// 		Collections.sort(nums); //[3, 4, 7, 9]
// 		System.out.println(nums);
// 	}
// }


//modifying the style of sorting -> sort in the increasing order of second digit:

// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;
// import java.util.ArrayList;
// public class Demo{
// 	public static void main(String[] args) {

// 		//anonymous class
// 		Comparator<Integer> com = new Comparator<Integer>(){
// 			public int compare(Integer i, Integer j){  //collection works with wrapper classes
// 				if(i%10 > j%10){
// 					return 1;
// 				}else{
// 					return -1;
// 				}
// 			}
// 		};

// 		List<Integer> nums = new ArrayList<>();
// 		nums.add(91);
// 		nums.add(74);
// 		nums.add(43);
// 		nums.add(32);

// 		Collections.sort(nums, com); 
// 		System.out.println(nums);
// 	}
// }


//mix 

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Comparator;

// //class Student implements Comparable<Student>
// class Student
// {
// 	int age;
// 	String name;
	
// 	public Student(int age, String name)
// 	{
// 		this.age=age;
// 		this.name=name;
// 	}
	
// 	public String toString() {
// 		return "Student [age=" + age + ", name=" +name +"]";
// 	}
	
// //	public int CompareTo(Student that)
// //	{
// ////		return 0;
// //		if(this.age >that.age)
// //			return 1;
// //		else
// //			return -1;
// //	}
// }
	

// public class Demo {
//     public static void main(String[] args){   
    	
// //    	Comparator<Integer> com=new Comparator<Integer>()
// //    	{
// //    		public int compare(Integer i,Integer j)
// //    		{
// //    			if(i%10 >j%10)
// //    				return 1;
// //    			else
// //    				return -1;
// //    		}
// //    	};	
    	
// //    	List<Integer> nums= new ArrayList<>();
// //    	nums.add(43);
// //    	nums.add(31);
// //    	nums.add(72);
// //    	nums.add(29);
    	
// //    	Comparator<Student> com=new Comparator<Student>()
// //    	{
// //    		public int compare(Student i,Student j)
// //    		{
// //    			if(i.age >j.age)
// //    				return 1;
// //    			else
// //    				return -1;
// //    		}
// //    	};	
    	
//     	Comparator<Student> com=(i,j) -> i.age > j.age?1:-1;
     	
//     	List<Student> studs= new ArrayList<>();
//     	studs.add(new Student(21,"Navin"));
//     	studs.add(new Student(12,"John"));
//     	studs.add(new Student(18,"Parul"));
//     	studs.add(new Student(20,"Kiran"));
    	
// //    	Collections.sort(nums);
// //    	System.out.println(nums);
    	
//     	for(Student s:studs)
//     		System.out.println();
    	
//     	Collections.sort(studs);
//     	for(Student s: studs)
//     		System.out.println(s);
//     }
// }
//this above code is mixture of Comparator and Comparable all so messy
    
//using Comparator using anonymous class:

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;

// class Student {
//     int age;
//     String name;

//     public Student(int age, String name) {
//         this.age = age;
//         this.name = name;
//     }

//     public String toString() {
//         return "Student [age=" + age + ", name=" + name + "]";
//     }
// }

// public class Demo {
//     public static void main(String[] args) {

//         Comparator<Student> com = new Comparator<Student>() {
//             @Override
//             public int compare(Student i, Student j) {
//                 if (i.age > j.age)
//                     return 1;
//                 else if (i.age < j.age)
//                     return -1;
//                 else
//                     return 0;
//             }
//         };

//         List<Student> studs = new ArrayList<>();
//         studs.add(new Student(21, "Navin"));
//         studs.add(new Student(12, "John"));
//         studs.add(new Student(18, "Parul"));
//         studs.add(new Student(20, "Kiran"));

//         Collections.sort(studs, com);

//         for (Student s : studs)
//             System.out.println(s);
//     }
// }


//using Comparator using lambda:

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;

// class Student {
//     int age;
//     String name;

//     public Student(int age, String name) {
//         this.age = age;
//         this.name = name;
//     }

//     public String toString() {
//         return "Student [age=" + age + ", name=" + name + "]";
//     }
// }

// public class Demo {
//     public static void main(String[] args) {

//         Comparator<Student> com = (i, j) -> i.age > j.age ? 1 : -1;

//         List<Student> studs = new ArrayList<>();
//         studs.add(new Student(21, "Navin"));
//         studs.add(new Student(12, "John"));
//         studs.add(new Student(18, "Parul"));
//         studs.add(new Student(20, "Kiran"));

//         Collections.sort(studs, com);

//         for (Student s : studs)
//             System.out.println(s);
//     }
// }


//using Comparable :

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// class Student implements Comparable<Student> {
//     int age;
//     String name;

//     public Student(int age, String name) {
//         this.age = age;
//         this.name = name;
//     }

//     @Override
//     public int compareTo(Student that) {
//         if (this.age > that.age)
//             return 1;
//         else if (this.age < that.age)
//             return -1;
//         else
//             return 0;
//     }

//     public String toString() {
//         return "Student [age=" + age + ", name=" + name + "]";
//     }
// }

// public class Demo {
//     public static void main(String[] args) {

//         List<Student> studs = new ArrayList<>();
//         studs.add(new Student(21, "Navin"));
//         studs.add(new Student(12, "John"));
//         studs.add(new Student(18, "Parul"));
//         studs.add(new Student(20, "Kiran"));
//         Collections.sort(studs);
//         for (Student s : studs)
//             System.out.println(s);
//     }
// }


//asList is a method belonging to Arrays class which gives a list 
//3 ways of iterating through list
// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Stream;

// public class Demo {
//     public static void main(String[] args){   
    	
//     	List<Integer> nums= Arrays.asList(4,5,7,3,2,6);
// //using for loop:	
// //    	for(int i=0;i<nums.size();i++)
// //    	{
// //    		System.out.println(nums.get(i));
// //    	}
    	
// //using enhanced for
// //    	for(int n: nums)
// //    	{
// //    		System.out.println(n);
// //    	}
    	
// //using forEach method from streamAPI
//     	nums.forEach(n -> System.out.println(n));
    	
//     	int sum=0;
//     	for(int n:nums)
//     	{
//     		if(n%2==0)
//     		{
//     			n=n*2;
//     			sum=sum+n;
//     		}
//     	}
    	
//     	System.out.println(nums);
//     	System.out.println(sum);
//     }
// }



//forEach method behind the scene:

// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Stream;
// import java.util.function.Consumer;

// public class Demo {
//     public static void main(String[] args){   
    	
//     	List<Integer> nums= Arrays.asList(4,5,7,3,2,6);
    	
// //    	Consumer<Integer> con=new Consumer<Integer>() {
// //    		public void accept(Integer n)
// //    		{
// //    			System.out.println(n);
// //    		}
// //    	};
// // 
// //      Consumer<Integer> con= n -> System.out.println(n);
 
//      	nums.forEach(n -> System.out.println(n));
   
//  //  	nums.forEach(null);
//  //   	nums.forEach(con);

//     	//nums.forEach(n -> System.out.println(n));
    	
//     }
// }



//streamAPI
//stream is a method of Stream interface 
//once used it cannot be reused. one time use only
//has methods like filter, map, reduce, forEach
//filter -> returns a new stream based on the specified condition
//map -> returns a new stream based on the specified condition
//reduce -> gives a single value 

// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Stream;

// public class Demo{
// 	public static void main(String[] args) {
// 		List<Integer> nums = Arrays.asList(4,5,6,8,7,6);
// 		Stream<Integer> s1 = nums.stream(); //stream s1 has the copy of all the values of list nums
// 		s1.forEach(n -> System.out.println(n));// if i modify stream, list is not affected
// 	}
// }

// 4
// 5
// 6
// 8
// 7
// 6




// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Stream;
// import java.util.function.Consumer;

// public class Demo {
//     public static void main(String[] args){   
    	
//     	List<Integer> nums=Arrays.asList(4,5,7,3,2,6);
    	
// //    	Stream<Integer> s1=nums.stream();
// //    	Stream<Integer> s2= s1.filter(n ->n%2==0);
// //    	Stream<Integer> s3= s2.map(n->n*2);
// //    	int result=s3.reduce(0,(c,e)->c+e);
// //    	
// //    	s2.forEach(n -> System.out.println(n));
// //    	s3.forEach(n -> System.out.println(n));
// //    	
// //    	s1.forEach(n-> System.out.println(n));
// //   	s1.forEach(n-> System.out.println(n));
    	
//     	int result=nums.stream()
//     					.filter(n-> n%2==0)
//     					.map(n->n*2)
//     					.reduce(0, (c,e)-> c+e);
//     	System.out.println(result);
//     }
// }

// map, filter, sorted

// import java.util.Arrays;
// import java.util.List;
// import java.util.function.Function;
// import java.util.function.Predicate;
// import java.util.stream.Stream;

// public class Demo {
//     public static void main(String[] args){   
    	
//     	List<Integer> nums=Arrays.asList(4,5,7,3,2,6);

// //how filter works
// //    	Predicate<Integer> p= new Predicate<Integer>() {
// //    		public boolean test(Integer n) {
// //    			return n%2==0;
// //    			if(n%2==0)
// //    				return true;
// //    			else
// //    				return false;
// //    		}
// //    	}; 	
// //    	Predicate<Integer> p= n-> n%2==0;
    	
// //how map works
// //    	Function<Integer, Integer> fun= new Function<Integer,Integer>() {
// //    		public Integer apply(Integer n) {
// //    			return n*2;
// //    		}
// //    	};  	
// //	Function<Integer,Integer> fun= n-> n*2;
 	
    	
// //    	int result=nums.stream()
// //    					.filter(n-> n%2==0)
// //    					.map(n->n*2)
// //    					.reduce(0, (c,e)-> c+e);
// //    	System.out.println(result);
    	
// //    	Stream<Integer> sortedValues = nums.stream()
// //    			.filter(n-> n%2==0)
// //    			.sorted();
    	
//     	Stream<Integer> sortedValues = nums.parallelStream() //parallelSttream for multiple threads but cant use sorted then
//     			.filter(n-> n%2==0)
//     			.sorted();
    	
//     	sortedValues.forEach(n -> System.out.println(n));
//     }
// }




//optional class -> if value exists store the value else throws noSuchElementException, used with findFirst()
//.findFirst() -> gives the first value that matches the condition
//.orElse("nnot found") -> if the string matches give the string if not return "nnot found"
//str.contains("x") -> checks if the string contains words with x letter
//open udemy pdf




//method reference
//.toUpperCase -> converts into uppercase
//.toList() -> converts into list

// import java.util.Arrays;
// import java.util.List;
// public class Demo{
// 	public static void main(String[] args) {
// 		List<String> names = Arrays.asList("Navin", "Harsh", "Rishi");
// 		List<String> uNames = names.stream()
// 		                    .map(name -> name.toUpperCase())
// 							.toList();
// 	    System.out.println(uNames);
// 	}
// }

// why toList()?
// map() does NOT store anything.
// map() doesn’t create a new list.
// It doesn’t modify the original list.
// It doesn’t “contain” values.
// It just creates a pipeline instruction.

// Intermediate operations:
// map()
// filter()
// sorted()
// distinct()
// These are just instructions.
// Terminal operations:
// toList()
// collect()
// forEach()
// reduce()
// count()
// These actually execute the pipeline.


//   .map(name -> name.toUpperCase()) instead of this we can directly 
//   .map(String::toUpperCase) //mentioning the mthod belong to String class (methodname inside method)
//   .forEach(n -> System.out.println(n))  instead of this we can
//   .forEach(System.out::println)

//Method reference simply means
// that you can pass a method name inside the method
// by specifying this method is responsible
// to do the work for you.
// The only thing you have to do is
// you have to mention the class name or the object name
// to use it.



//constructor refernce

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// class Student {
//     private String name;

//     public Student(String name) {
//         this.name = name;
//     }

//     @Override
//     public String toString() {
//         return name;
//     }
// }

// public class MethodRefEx {

//     public static void main(String[] args) {

//         List<String> names = Arrays.asList("Navin", "Harsh", "John");

//         List<Student> students = new ArrayList<>();

//         // Traditional way
//         /*
//         for (String name : names) {
//             students.add(new Student(name));
//         }
//         */

//         // Using lambda
//         /*
//         students = names.stream()
//                 .map(name -> new Student(name))
//                 .toList();
//         */

//         // Using Method Reference (Constructor Reference)
//         students = names.stream()
//                 .map(Student::new)
//                 .toList();

//         System.out.println("Students: " + students);
//     }
// }