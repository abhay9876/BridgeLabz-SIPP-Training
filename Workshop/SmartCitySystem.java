import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class SmartCitySystem {
    public static void main(String[] args) {
        GeoUtils.Location a = new GeoUtils.Location("A", 28.7041, 77.1025);
        GeoUtils.Location b = new GeoUtils.Location("B", 28.5355, 77.3910);
        GeoUtils.Location c = new GeoUtils.Location("C", 28.4595, 77.0266);

        List<TransportService> services = Arrays.asList(
                new BusService("Bus-101", a, b, 30, 50.0),
                new BusService("Bus-102", a, c, 90, 40.0),
                new MetroService("Metro-Blue-1", a, b, 20, 30.0),
                new TaxiService("Taxi-2001", a, b, 10, 120.0),
                new AmbulanceService("Ambulance-1", a, c, 5, 0.0)
        );

        Passenger p = new Passenger("P001", "Rohit", "A", "B", LocalDateTime.now().plusMinutes(25));

        FareCalculator defaultFareCalc = (distanceKm, baseFare) -> baseFare + distanceKm * 1.5;

        List<TransportService> matched = services.stream()
                .filter(s -> s.canServe(p.getFrom(), p.getTo()))
                .sorted(Comparator.comparingInt(s -> s.etaMinutes(p.getFrom())))
                .collect(toList());

        matched.forEach(System.out::println);

        Dashboard.displayLiveSchedules(services);

        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip(p, matched.get(0), LocalDateTime.now(), defaultFareCalc.calculateFare(
                GeoUtils.calculateDistanceKm(a, b), matched.get(0).getBaseFare())));
        trips.add(new Trip(new Passenger("P002", "Meera", "A", "B", LocalDateTime.now().plusMinutes(5)),
                services.get(2), LocalDateTime.now().minusMinutes(30),
                defaultFareCalc.calculateFare(GeoUtils.calculateDistanceKm(a, b), services.get(2).getBaseFare())));
        trips.add(new Trip(new Passenger("P003", "Sana", "A", "C", LocalDateTime.now().minusHours(1)),
                services.get(1), LocalDateTime.now().minusHours(1),
                defaultFareCalc.calculateFare(GeoUtils.calculateDistanceKm(a, c), services.get(1).getBaseFare())));

        Map<String, List<Trip>> tripsByRoute = trips.stream()
                .collect(groupingBy(t -> t.getService().getName() + "-" + t.getPassenger().getFrom() + "->" + t.getPassenger().getTo()));

        tripsByRoute.forEach((route, list) -> {
            System.out.println("Route: " + route);
            list.forEach(System.out::println);
        });

        Map<Boolean, List<Trip>> partitioned = trips.stream()
                .collect(partitioningBy(t -> isPeakHour(t.getStartTime().toLocalTime())));

        System.out.println("Peak trips: " + partitioned.get(true).size());
        System.out.println("Off-peak trips: " + partitioned.get(false).size());

        DoubleSummaryStatistics stats = trips.stream()
                .collect(summarizingDouble(Trip::getFarePaid));

        System.out.println("Total revenue: " + stats.getSum());
        System.out.println("Average fare: " + stats.getAverage());
        System.out.println("Max fare: " + stats.getMax());

        List<TransportService> emergency = services.stream()
                .filter(s -> s instanceof EmergencyService)
                .sorted(Comparator.comparingInt(s -> s.etaMinutes(p.getFrom())))
                .collect(toList());

        System.out.println("Emergency services available:");
        emergency.forEach(System.out::println);

        TransportService newFerry = new FerryService("Ferry-1", a, c, 60, 25.0);
        services = Stream.concat(services.stream(), Stream.of(newFerry)).collect(toList());
        Dashboard.displayLiveSchedules(services);
    }

    static boolean isPeakHour(LocalTime t) {
        return (t.isAfter(LocalTime.of(7, 30)) && t.isBefore(LocalTime.of(10, 30)))
                || (t.isAfter(LocalTime.of(17, 30)) && t.isBefore(LocalTime.of(20, 30)));
    }

    public interface FareCalculator {
        double calculateFare(double distanceKm, double baseFare);
    }

    public interface EmergencyService {}

    public interface GeoUtils {
        static double calculateDistanceKm(Location l1, Location l2) {
            double lat1 = Math.toRadians(l1.lat);
            double lon1 = Math.toRadians(l1.lon);
            double lat2 = Math.toRadians(l2.lat);
            double lon2 = Math.toRadians(l2.lon);
            double dlat = lat2 - lat1;
            double dlon = lon2 - lon1;
            double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            return 6371.0 * c;
        }

        class Location {
            public final String name;
            public final double lat;
            public final double lon;
            public Location(String name, double lat, double lon) {
                this.name = name;
                this.lat = lat;
                this.lon = lon;
            }
            public String toString() {
                return name;
            }
        }
    }

    public interface TransportService {
        String getName();
        GeoUtils.Location getFrom();
        GeoUtils.Location getTo();
        int getEtaMinutes();
        double getBaseFare();
        default void printServiceDetails() {
            System.out.println(this);
        }
        static void log(String message) {
            System.out.println("LOG: " + message);
        }
        default boolean canServe(String from, String to) {
            return Objects.equals(getFrom().name, from) && Objects.equals(getTo().name, to);
        }
        default int etaMinutes(String from) {
            return getEtaMinutes();
        }
        default int etaMinutes(GeoUtils.Location from) {
            return getEtaMinutes();
        }
    }

    public static abstract class AbstractService implements TransportService {
        protected String name;
        protected GeoUtils.Location from;
        protected GeoUtils.Location to;
        protected int etaMinutes;
        protected double baseFare;
        public AbstractService(String name, GeoUtils.Location from, GeoUtils.Location to, int etaMinutes, double baseFare) {
            this.name = name;
            this.from = from;
            this.to = to;
            this.etaMinutes = etaMinutes;
            this.baseFare = baseFare;
        }
        public String getName() { return name; }
        public GeoUtils.Location getFrom() { return from; }
        public GeoUtils.Location getTo() { return to; }
        public int getEtaMinutes() { return etaMinutes; }
        public double getBaseFare() { return baseFare; }
        public String toString() {
            return String.format("%s [%s->%s] ETA:%d min BaseFare:%.2f", name, from, to, etaMinutes, baseFare);
        }
    }

    public static class BusService extends AbstractService {
        public BusService(String name, GeoUtils.Location from, GeoUtils.Location to, int etaMinutes, double baseFare) {
            super(name, from, to, etaMinutes, baseFare);
        }
    }

    public static class MetroService extends AbstractService {
        public MetroService(String name, GeoUtils.Location from, GeoUtils.Location to, int etaMinutes, double baseFare) {
            super(name, from, to, etaMinutes, baseFare);
        }
    }

    public static class TaxiService extends AbstractService {
        public TaxiService(String name, GeoUtils.Location from, GeoUtils.Location to, int etaMinutes, double baseFare) {
            super(name, from, to, etaMinutes, baseFare);
        }
    }

    public static class AmbulanceService extends AbstractService implements EmergencyService {
        public AmbulanceService(String name, GeoUtils.Location from, GeoUtils.Location to, int etaMinutes, double baseFare) {
            super(name, from, to, etaMinutes, baseFare);
        }
        public int etaMinutes(GeoUtils.Location from) {
            return Math.max(1, etaMinutes / 2);
        }
    }

    public static class FerryService extends AbstractService {
        public FerryService(String name, GeoUtils.Location from, GeoUtils.Location to, int etaMinutes, double baseFare) {
            super(name, from, to, etaMinutes, baseFare);
        }
    }

    public static class Passenger {
        private final String id;
        private final String name;
        private final String from;
        private final String to;
        private final LocalDateTime preferredTime;
        public Passenger(String id, String name, String from, String to, LocalDateTime preferredTime) {
            this.id = id;
            this.name = name;
            this.from = from;
            this.to = to;
            this.preferredTime = preferredTime;
        }
        public String getId() { return id; }
        public String getName() { return name; }
        public String getFrom() { return from; }
        public String getTo() { return to; }
        public LocalDateTime getPreferredTime() { return preferredTime; }
        public String toString() { return String.format("Passenger[%s:%s %s->%s at %s]", id, name, from, to, preferredTime); }
    }

    public static class Trip {
        private final Passenger passenger;
        private final TransportService service;
        private final LocalDateTime startTime;
        private final double farePaid;
        public Trip(Passenger passenger, TransportService service, LocalDateTime startTime, double farePaid) {
            this.passenger = passenger;
            this.service = service;
            this.startTime = startTime;
            this.farePaid = farePaid;
        }
        public Passenger getPassenger() { return passenger; }
        public TransportService getService() { return service; }
        public LocalDateTime getStartTime() { return startTime; }
        public double getFarePaid() { return farePaid; }
        public String toString() {
            return String.format("Trip[%s by %s on %s Fare:%.2f]", passenger.getId(), service.getName(), startTime, farePaid);
        }
    }

    public static class Dashboard {
        public static void displayLiveSchedules(Collection<TransportService> services) {
            System.out.println("=== LIVE SCHEDULES ===");
            services.stream()
                    .sorted(Comparator.comparing(TransportService::getName))
                    .forEach(TransportService::printServiceDetails);
            System.out.println("=======================");
        }
    }
}
