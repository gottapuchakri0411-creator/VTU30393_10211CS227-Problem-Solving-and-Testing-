class UndergroundSystem {
    private class CheckInRecord {
        String stationName;
        int t;
        
        public CheckInRecord(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }
    
    private class RouteStats {
        long totalTime;
        int trips;
        
        public RouteStats(long totalTime, int trips) {
            this.totalTime = totalTime;
            this.trips = trips;
        }
    }
    
    private Map<Integer, CheckInRecord> checkIns;
    private Map<String, RouteStats> routeStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInRecord(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInRecord record = checkIns.get(id);
        if (record != null) {
            String routeKey = record.stationName + "->" + stationName;
            int travelTime = t - record.t;
            
            RouteStats stats = routeStats.get(routeKey);
            if (stats == null) {
                routeStats.put(routeKey, new RouteStats(travelTime, 1));
            } else {
                stats.totalTime += travelTime;
                stats.trips++;
            }
            
            checkIns.remove(id);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = routeStats.get(routeKey);
        if (stats == null || stats.trips == 0) {
            return 0.0;
        }
        return (double) stats.totalTime / stats.trips;
    }
}



Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
