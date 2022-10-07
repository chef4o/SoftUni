import java.util.*;
import java.util.stream.Collectors;

public class OlympicsImpl implements Olympics {

    Map<Integer, Competition> competitions;
    Map<Integer, Competitor> competitors;

    public OlympicsImpl() {
        this.competitors = new TreeMap<>();
        this.competitions = new TreeMap<>();
    }

    @Override
    public void addCompetitor(int id, String name) {
        validate(this.competitors.get(id) == null);
        this.competitors.put(id, new Competitor(id, name));
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        validate(this.competitions.get(id) == null);
        this.competitions.put(id, new Competition(name, id, score));
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        Competition competition = getCompetition(competitionId);
        Competitor competitor = getCompetitor(competitorId);

        competition.getCompetitors().add(competitor);
        competitor.setTotalScore(competitor.getTotalScore() + competition.getScore());
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {
        Competition competition = getCompetition(competitionId);
        Competitor competitor = this.competitors.get(competitorId);

        if (!competition.getCompetitors().contains(competitor)) {
            throw new IllegalArgumentException();
        }

        competitor.setTotalScore(competitor.getTotalScore() - competition.getScore());
        competition.getCompetitors().remove(competitor);
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        return this.competitors.values()
                .stream()
                .filter(c -> c.getTotalScore() > min && c.getTotalScore() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Competitor> getByName(String name) {
        List<Competitor> competitors = this.competitors.values()
                .stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList());
        if (competitors.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return competitors;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        return this.competitors.values()
                .stream()
                .filter(c -> c.getName().length() >= minLength && c.getName().length() <= maxLength)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        return getCompetition(competitionId).getCompetitors().contains(comp);
    }

    @Override
    public int competitionsCount() {
        return this.competitions.size();
    }

    @Override
    public int competitorsCount()    {
        return this.competitors.size();
    }

    @Override
    public Competition getCompetition(int id) {
        validate(this.competitions.get(id) != null);
        return this.competitions.get(id);
    }

    public Competitor getCompetitor(int id) {
        validate(this.competitors.get(id) != null);
        return this.competitors.get(id);
    }

    private void validate(boolean isTrue) {
        if (!isTrue) {
            throw new IllegalArgumentException();
        }
    }

}
