import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoyaleArena implements IArena {

    private Map<Integer, Battlecard> cardsByIds;
    private Map<CardType, Set<Battlecard>> cardsByType;

    public RoyaleArena() {
        this.cardsByIds = new LinkedHashMap<>();
        this.cardsByType = new LinkedHashMap<>();
    }

    @Override
    public void add(Battlecard card) {
        this.cardsByIds.putIfAbsent(card.getId(), card);
        this.cardsByType.putIfAbsent(card.getType(), new TreeSet<>(Battlecard::compareTo));
        this.cardsByType.get(card.getType()).add(card);
    }

    @Override
    public boolean contains(Battlecard card) {
        return this.cardsByIds.containsKey(card.getId());
    }

    @Override
    public int count() {
        return this.cardsByIds.size();
    }

    @Override
    public void changeCardType(int id, CardType type) {
        Battlecard current = this.cardsByIds.get(id);
        if (current == null) {
            throw new IllegalArgumentException("No card with ID: " + id);
        }
        current.setType(type);
    }

    @Override
    public Battlecard getById(int id) {
        Battlecard current = this.cardsByIds.get(id);
        if (current == null) {
            throw new UnsupportedOperationException();
        }
        return current;
    }

    @Override
    public void removeById(int id) {
        Battlecard battlecard = this.cardsByIds.remove(id);
        if (battlecard == null) {
            throw new UnsupportedOperationException();
        }
        this.cardsByType.get(battlecard.getType()).remove(battlecard);
    }

    @Override
    public Iterable<Battlecard> getByCardType(CardType type) {
        return getBattleCardsByType(type);
    }

    @Override
    public Iterable<Battlecard> getByTypeAndDamageRangeOrderedByDamageThenById
            (CardType type, int lo, int hi) {
        Set<Battlecard> battleCards = getBattleCardsByType(type);

        List<Battlecard> result = battleCards.stream()
                .filter(c -> c.getDamage() > lo && c.getDamage() < hi)
                .sorted(Battlecard::compareTo)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> getByCardTypeAndMaximumDamage(CardType type, double damage) {
        Set<Battlecard> battleCards = getBattleCardsByType(type);
        List<Battlecard> result = battleCards.stream()
                .filter(c -> c.getDamage() <= damage)
                .sorted(Battlecard::compareTo)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> getByNameOrderedBySwagDescending(String name) {
        List<Battlecard> battleCards = getBattleCardsByPredicate(c -> c.getName().equals(name));

        if (battleCards.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        battleCards.sort(Comparator.comparingDouble(Battlecard::getSwag).reversed()
                .thenComparing(Battlecard::getId));

        return battleCards;
    }

    @Override
    public Iterable<Battlecard> getByNameAndSwagRange(String name, double lo, double hi) {
        List<Battlecard> battleCards = getBattleCardsByPredicate(
                b -> b.getDamage() >= lo && b.getDamage() < hi && b.getName().equals(name)
        );
        if (battleCards.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        battleCards.sort(Comparator.comparingDouble(Battlecard::getSwag).reversed()
                .thenComparing(Battlecard::getId));
        return battleCards;
    }

    @Override
    public Iterable<Battlecard> getAllByNameAndSwag() {
        Map<String, Battlecard> battleCards = new LinkedHashMap<>();

        for (Battlecard battlecard : cardsByIds.values()) {
            if (!battleCards.containsKey(battlecard.getName())) {
                battleCards.put(battlecard.getName(), battlecard);
            } else {
                double oldSwag = battleCards.get(battlecard.getName()).getSwag();
                double newSwag = battlecard.getSwag();
                if (newSwag > oldSwag) {
                    battleCards.put(battlecard.getName(), battlecard);
                }
            }
        }

        return battleCards.values();
    }

    @Override
    public Iterable<Battlecard> findFirstLeastSwag(int n) {
        if (n > this.count()) {
            throw new UnsupportedOperationException();
        }

        List<Battlecard> battleCards = this.cardsByIds.values().stream()
                .sorted(Comparator.comparingDouble(Battlecard::getSwag))
                .collect(Collectors.toList());

        return battleCards.stream()
                .limit(n)
                .sorted(Comparator.comparingDouble(Battlecard::getSwag)
                        .thenComparing(Battlecard::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Battlecard> getAllInSwagRange(double lo, double hi) {
        return getBattleCardsByPredicate(c -> c.getSwag() >= lo && c.getSwag() <= hi)
                .stream()
                .sorted(Comparator.comparingDouble(Battlecard::getSwag))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Battlecard> iterator() {
        return this.cardsByIds.values().iterator();
    }

    private List<Battlecard> getBattleCardsByPredicate(Predicate<Battlecard> predicate) {
        List<Battlecard> battleCards = new ArrayList<>();

        for (Battlecard battlecard : cardsByIds.values()) {
            if (predicate.test(battlecard)) {
                battleCards.add(battlecard);
            }
        }
        return battleCards;
    }

    private Set<Battlecard> getBattleCardsByType(CardType type) {
        Set<Battlecard> battleCards = this.cardsByType.get(type);
        if (battleCards == null || battleCards.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        return battleCards;
    }
}
