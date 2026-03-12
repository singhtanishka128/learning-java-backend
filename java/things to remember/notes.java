/*

this keyword:
1. to refer to the current object


this():
1. calls another constructor of the same class
2. must be the first statement inside a constructor


static keyword variable:
1. the value of static variable persists
2. static varible is shared by all the objects
3. it is preferably called statically(by classname)
4. we can use static variables in non static methods directly.
5. Static variables belong to the class.


static() method:
1. Static methods can directly access only static members. They can access non-static members, but only through an object.
2. are called statically.
3. static methods are never overridden
4. static methods in interfaces belong ONLY to the interface itself. They are not passed down to the implementing class.


static{ } block:
1. Used to initialize static variables.
2. Runs once when class loads.
3. Can contain any logic (not just initialization).


super():
1. present in every constructor defaultly to call the default constructor of superclass
2. happens automatically, is invisible


final keyword:
1. to make values of variables constant
2. to stop overriding
3. to stop inheritance (no subclass allowed)
//if i make a variable final i must initialise it exactly once.


abstract keyword:
1. to declare a method in abstract class expecting subclass to define/override it.
2. if a class contains abstract method, that class itself becomes abstract class
3. if subclass fails to define/override abstract method, then subclass becomes abstract as well
4. abstract classes are never instantiated hence no objects of abstract class possible
5. we can create the reference variable of abstract class tho
//in abstract class one class can extend only one class
//Abstract class can have:
Concrete methods
Constructors
Instance variables


//Interface:
//interface methods are a public abstract
//interface variables are public static final
//Interfaces cannot have instance variables.
//Interfaces can have default and static methods
//interface is like abstract superclass, 
//the subclass inherits the interface by using keyword implements (just like extends)
//if the subclass fails to define all the interface methods (public abstract methods) the subclass itself becomes abstract then
//for a subclass to remain concrete it must define all the interface methods
//we can create refernce variable of the interface to create object of subclass
//a class can inherit multiple interfaces 

//if a class inherits another class we use extends
//if a class inherits an interface we use implements
//if an interface inherits another interface we use extends


//innerclasses:
why do we create innerclass?
If one class is used only by another class, we group them together.
Inner classes can access private members of the outer class directly.

//to make innerclass object
outerclass.innerclass objectofInner = objectofOuter.new Inner();
A.B obj1 = obj.new B();

//to create innerclass object when inner class is static
outerclass.innerclass objectofInner = new outerclass.InnerClass();
A.B obj1 = new A.B();

Only nested classes can be static.
Top-level classes cannot be static.only public, abstract and final are permitted for outerclass


// Anonymous inner class =
// Extends a class OR
// Implements an interface
// Overrides required methods
// Has no name
// Used only once


//why do we need anonymous innerclass?
// It’s:
// A class
// With no name
// Defined and instantiated in one step
// Used only once
// Example:
// A obj = new A() {
//     void show() {
//         System.out.println("Hello");
//     }
// };
// You just:
// Created a new subclass of A
// Overrode its method
// Instantiated it
// All in one expression
// Why do we need Anonymous Inner Classes?
// For one-time behavior customization
// Sometimes you don’t want to permanently create a new subclass.


//abstract class and anonymous inner class
// Creating a new unnamed subclass of A
// Immediately overriding all abstract methods
// Instantiating that subclass -> creating object 
// Storing its reference in obj
// Anonymous inner class is implicitly extending abstract class
all while keeping the illusion of an abstract class creating object,
Reference type → abstract class
Object type → anonymous subclass 
but this object actually belongs to anonymous inner class


Top-level classes can be:
public
default (no modifier)
final
abstract

They cannot be:
private
protected
static

suppse A has method 1,2. B has method 3. obj belongs to B and refernce var if of A. obj calls method 3. what happens since obj of type A can only see method 1,2
compilation error
reference variable type decides what methods are visible at compile time.


independent class loader:
public static void main(String[] args) throws ClassNotFoundException {
	Class.forName("Classname");
}
It triggers static block execution.


// Naming Conventions: 
// classes and interfaces = Data   (first letter capital)
// variables and methods = data, data()  (all small)
// constants = DATA  (all capital)

// for multiple words java developers use camelCasing like
// showMyMarks() - method
// MyData - could be class/interface 
// MyData() - constructor
// MYDATA - constant


every superclass in java extends the Object class


package: 
package foldername to specify xyz file is in this located folder  eg: package com.models; (folderName = com.models)
import foldername.filename to access from different folder        eg: import com.models.Student; (Student file lives inside com.models)

Classes inside the same package can directly access each other (if not private).

Same package → no import needed
Different package → import required

*/