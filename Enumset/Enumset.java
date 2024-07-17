package project1;
	import java.util.EnumSet;
	import java.util.Set;
 public class SeasonalActivityOrganizer{
	    
	      //creating enumset()  of each season
	        private EnumSet<Activity> springActivities = EnumSet.noneOf(Activity.class);
	        private EnumSet<Activity> summerActivities = EnumSet.noneOf(Activity.class);
	        private EnumSet<Activity> autumnActivities = EnumSet.noneOf(Activity.class);
	        private EnumSet<Activity> winterActivities = EnumSet.noneOf(Activity.class);
	    
	    //enum fo season
	    public enum Season {
	        SPRING,
	        SUMMER,
	        AUTUMN,
	        WINTER
	    }

	    // enum for Activity
	    public enum Activity {
	        HIKING,
	        SWIMMING,
	        SKIING,
	        PUMPKIN_CARVING,
	        ICE_SKATING,
	        BUILDING_A_SNOWMAN,
	        LEAF_PEEPING,
	        BEACH_TRIP,
	        GARDENING
	    }

	    
	    //fuction to get activities for a season
	    public Set<Activity> getActivitiesForSeason(Season season) {
	        switch (season) {
	            case SPRING:
	                return springActivities;
	            case SUMMER:
	                return summerActivities;
	            case AUTUMN:
	                return autumnActivities;
	            case WINTER:
	                return winterActivities;
	            default:
	                throw new IllegalArgumentException("Unknown season: " + season);
	        }
	    }

	    
	    //function to add activity for season
	    public Set<Activity> addActivityForSeason(Activity activity, Season season) {
	        switch (season) {
	            case SPRING:
	                springActivities.add(activity);
	                return springActivities;
	            case SUMMER:
	                summerActivities.add(activity);
	                return summerActivities;
	            case AUTUMN:
	                autumnActivities.add(activity);
	                return autumnActivities;
	            case WINTER:
	                winterActivities.add(activity);
	                return winterActivities;
	            default:
	                throw new IllegalArgumentException("Unknown season: " + season);
	        }
	    }

	    
	    //funtion to remove activity from all seasons
	     public Set<Activity> removeActivityFromAllSeasons(Activity activity) {
	        springActivities.remove(activity);
	        summerActivities.remove(activity);
	        autumnActivities.remove(activity);
	        winterActivities.remove(activity);

	        Set<Activity> allActivities = EnumSet.allOf(Activity.class);
	        allActivities.removeAll(springActivities);
	        allActivities.removeAll(summerActivities);
	        allActivities.removeAll(autumnActivities);
	        allActivities.removeAll(winterActivities);
	        return allActivities;
	    }

	    //function to get all activities of a season
	    public Set<Activity> getAllActivities() {
	        Set<Activity> allActivities = EnumSet.allOf(Activity.class);
	        allActivities.removeAll(springActivities);
	        allActivities.removeAll(summerActivities);
	        allActivities.removeAll(autumnActivities);
	        allActivities.removeAll(winterActivities);

	        allActivities.addAll(springActivities);
	        allActivities.addAll(summerActivities);
	        allActivities.addAll(autumnActivities);
	        allActivities.addAll(winterActivities);
	        return allActivities;
	    }

	    
	    //main() method
	     public static void main(String[] args) {
	         SeasonalActivityOrganizer organizer = new SeasonalActivityOrganizer();
	         organizer.addActivityForSeason(Activity.HIKING, Season.SPRING);
	         organizer.addActivityForSeason(Activity.SWIMMING, Season.SUMMER);
	         organizer.addActivityForSeason(Activity.SKIING, Season.WINTER);
	         organizer.addActivityForSeason(Activity.PUMPKIN_CARVING, Season.AUTUMN);
	         organizer.addActivityForSeason(Activity.LEAF_PEEPING, Season.AUTUMN);
	         organizer.addActivityForSeason(Activity.GARDENING, Season.SPRING);
	         organizer.addActivityForSeason(Activity.BEACH_TRIP, Season.SUMMER);
	         organizer.addActivityForSeason(Activity.BEACH_TRIP, Season.AUTUMN);
	         organizer.addActivityForSeason(Activity.BEACH_TRIP, Season.SPRING);
	         organizer.addActivityForSeason(Activity.ICE_SKATING, Season.WINTER);
	         
	         

	        // Get activities for each season
	        System.out.println("All Activities: " + organizer.getAllActivities());
	        System.out.println("Spring Activities: " + organizer.getActivitiesForSeason(Season.SPRING));
	        System.out.println("Summer Activities: " + organizer.getActivitiesForSeason(Season.SUMMER));
	        System.out.println("Autumn Activities: " + organizer.getActivitiesForSeason(Season.AUTUMN));
	        System.out.println("Winter Activities: " + organizer.getActivitiesForSeason(Season.WINTER));

	        // Remove beach trip from all seasons
	        System.out.println("\nRemoving Beach Trip...");
	        organizer.removeActivityFromAllSeasons(Activity.BEACH_TRIP);

	        // Check activities after removal
	        System.out.println("All Activities (after removal): " + organizer.getAllActivities());
	        System.out.println("Summer Activities (after removal): " + organizer.getActivitiesForSeason(Season.SUMMER));
	    }
	        
	  }
