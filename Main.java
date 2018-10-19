public class Main {

    public static double lat1, lat2, lon1, lon2;

    public static double earthRadius = 6371;

    public static void main(String[] args) {

        // Set position 1: Paris
        lat1 = 48.8567;
        lon1 = 2.3508;

        // Set position 2: San Francisco
        lat2 = 37.783333;
        lon2 = -122.416667;

        System.out.println("Distance from Paris to SF: " + globeDistance(lat1,lon1,lat2,lon2));

        double totalDistance = 0;

        totalDistance += globeDistance(25,-15,23,-20);
        totalDistance += globeDistance(23,-20,21,-24);
        totalDistance += globeDistance(21,-24,20,-27);
        totalDistance += globeDistance(20,-27,19,-35);
        totalDistance += globeDistance(19,-35,21,-46);
        totalDistance += globeDistance(21,-46,23,-56);
        totalDistance += globeDistance(23,-56,25,-65);
        totalDistance += globeDistance(25,-65,28,-70);
        totalDistance += globeDistance(28,-70,32,-73);
        totalDistance += globeDistance(32,-73,34,-74);
        totalDistance += globeDistance(34,-74,36,-74);
        totalDistance += globeDistance(36,-74,39,-74);

        System.out.println("Total distance travelled: " + totalDistance);
    }

    public static double globeDistance(double la1, double lo1, double la2, double lo2) {

        double la1R = Math.toRadians(la1);
        double la2R = Math.toRadians(la2);

        double laDeltaR = Math.toRadians(la2-la1);
        double loDeltaR = Math.toRadians(lo2-lo1);

        double a = Math.sin(laDeltaR/2) * Math.sin(laDeltaR/2) +
                   Math.cos(la1R) * Math.cos(la2R) *
                   Math.sin(loDeltaR/2) * Math.sin(loDeltaR/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double dist = earthRadius * c;

        return dist;
    }
}