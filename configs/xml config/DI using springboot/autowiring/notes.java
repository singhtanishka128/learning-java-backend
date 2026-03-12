// @SpringBootApplication
// → Marks the main class of Spring Boot.
// → Enables auto configuration + component scanning.

// @Component
// → Tells Spring to create and manage the object (bean) of that class.

// @Autowired
// → Automatically injects dependency (Spring provides the required object). 

// ApplicationContext
// → Spring container that stores all created beans.

// context.getBean(ClassName.class)
// → Used to get the object (bean) from the Spring container.

// Flow:
// Spring starts → scans for @Component → creates beans → @Autowired injects dependency → getBean() retrieves object.