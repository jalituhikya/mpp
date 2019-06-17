package lab9.prob9;
import java.util.*;
import java.util.stream.Collectors;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                           new Dish("beef", false, 700, Dish.Type.MEAT),
                           new Dish("chicken", false, 400, Dish.Type.MEAT),
                           new Dish("french fries", true, 530, Dish.Type.OTHER),
                           new Dish("rice", true, 350, Dish.Type.OTHER),
                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
                           new Dish("pizza", true, 550, Dish.Type.OTHER),
                           new Dish("prawns", false, 400, Dish.Type.FISH),
                           new Dish("salmon", false, 450, Dish.Type.FISH));
    
    public static boolean isVegetarianAvailable() {
    	return menu.stream().anyMatch(Dish::isVegetarian);
    }
    
    public static boolean isAnyHealthy() {
    	return menu.stream().anyMatch((x)->x.getCalories() < 1000);
    	
    }
    
    public static boolean isAnyUnHealthy() {
    	return menu.stream().anyMatch((x)->x.getCalories() > 1000);
    }
    
    public static Optional<Dish> getMeatMeal(){
    	return menu.stream().filter((x)->x.getType().equals(Type.MEAT))
    			.findFirst();
    	
    }
    
    public static int calculateTotalCalories() {
    	return menu.stream().map((x) -> x.getCalories()).reduce(0,(x,y) -> x+y);
    	
    }
    
    public static int calculateTotalCaloriesMethodReference() {
    	return menu.stream().collect(Collectors.summingInt(Dish::getCalories));
    	
    }
    
    public static void main(String[] args) {
    	
    	System.out.println("part a");
    	System.out.println("Is there any Vegetarian meal available "+ Dish.isVegetarianAvailable());
    	
    	
    	System.out.println("\npart b");
    	System.out.println("Is there any healthy menu have calories less than 1000 "+Dish.isAnyHealthy());
    	
    	System.out.println("\npart c");
    	System.out.println(" Is there any unhealthy menu have calories greater than 1000 "+Dish.isAnyUnHealthy());
    
    
    	System.out.println("\npart d");
    	System.out.println(" find and return the first item for the type of MEAT "+Dish.getMeatMeal().get());
    
    	System.out.println("\npart e");
    	System.out.println(" calculateTotalCalories() in the menu using reduce. "+Dish.calculateTotalCalories());
    
    	System.out.println("\npart f");
    	System.out.println("  calculateTotalCaloriesMethodReference()in the menu using MethodReferences. "+Dish.calculateTotalCaloriesMethodReference());
    
    }
}