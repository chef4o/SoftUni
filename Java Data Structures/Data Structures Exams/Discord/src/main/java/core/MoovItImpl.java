package core;

import models.Route;

import java.util.*;
import java.util.stream.Collectors;

public class MoovItImpl implements MoovIt {

    Map<String, Route> routeMap;
    Set<Route> routes;

    public MoovItImpl() {
        this.routeMap = new LinkedHashMap<>();
        this.routes = new HashSet<>();
    }

    @Override
    public void addRoute(Route route) {
        if (this.routes.contains(route)) {
            throw new IllegalArgumentException();
        }
        this.routes.add(route);
        this.routeMap.put(route.getId(), route);
    }

    @Override
    public void removeRoute(String routeId) {
        Route current = this.routeMap.get(routeId);
        if (current == null) {
            throw new IllegalArgumentException();
        }
        this.routes.remove(current);
        this.routeMap.remove(routeId);
    }

    @Override
    public boolean contains(Route route) {
        return this.routes.contains(route);
    }

    @Override
    public int size() {
        return this.routeMap.size();
    }

    @Override
    public Route getRoute(String routeId) {
        Route current = this.routeMap.get(routeId);
        if (current == null) {
            throw new IllegalArgumentException();
        }
        return current;
    }

    @Override
    public void chooseRoute(String routeId) {
        Route current = this.routeMap.get(routeId);
        if (current == null) {
            throw new IllegalArgumentException();
        }
        current.setPopularity(current.getPopularity() + 1);
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        return this.routeMap.values().stream()
                .filter(r -> r.getLocationPoints().contains(startPoint) &&
                        r.getLocationPoints().contains(endPoint))
                .sorted((a,b) -> {
                    int comparator = Boolean.compare(b.getIsFavorite(), a.getIsFavorite());

                    if (comparator == 0) {
                        int routeASize = a.getLocationPoints().indexOf(endPoint) - a.getLocationPoints().indexOf(startPoint);
                        int routeBSize = b.getLocationPoints().indexOf(endPoint) - a.getLocationPoints().indexOf(startPoint);

                        if (routeASize == routeBSize) {
                            return b.getPopularity() - a.getPopularity();
                        }

                        return routeASize - routeBSize;
                    }

                    return comparator;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        return this.routes.stream()
                .filter(f -> f.getIsFavorite() &&
                        !f.getLocationPoints().get(0).equals(destinationPoint))
                .sorted((a,b) -> {
                    int comparator = Double.compare(a.getDistance(), b.getDistance());
                    if (comparator == 0) {
                        return b.getPopularity() - a.getPopularity();
                    }

                    return comparator;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getTop5RoutesByPopularityThenByDistanceThenByCountOfLocationPoints() {
        return this.routes.stream()
                .sorted((a,b) -> {
                    int comparator = b.getPopularity() - a.getPopularity();
                    if (comparator == 0) {
                        int distanceComparator = Double.compare(a.getDistance(), b.getDistance());
                        if (distanceComparator == 0) {
                            return a.getLocationPoints().size() - b.getLocationPoints().size();
                        }

                        return distanceComparator;
                    }

                    return comparator;
                })
                .limit(5)
                .collect(Collectors.toList());
    }
}
