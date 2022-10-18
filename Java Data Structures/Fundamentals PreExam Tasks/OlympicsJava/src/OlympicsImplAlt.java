import java.util.*;
import java.util.stream.Collectors;

public class OlympicsImplAlt implements Olympics {

    Set<Competition> competitions;
    Set<Competitor> competitors;

    public OlympicsImplAlt() {
        this.competitors = new HashSet<>();
        this.competitions = new HashSet<>();
    }

    @Override
    public void addCompetitor(int id, String name) {
        for (Competitor competitor : this.competitors) {
            if (competitor.getId() == id) {
                throw new IllegalArgumentException();
            }
        }
        this.competitors.add(new Competitor(id, name));
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        for (Competition competition : this.competitions) {
            if (competition.getId() == id) {
                throw new IllegalArgumentException();
            }
        }
        this.competitions.add(new Competition(name, id, score));
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
        Competitor competitor = null;
        for (Competitor current : competition.getCompetitors()) {
            if (current.getId() == competitorId) {
                competitor = current;
                break;
            }
        }
        if (competitor == null) {
            throw new IllegalArgumentException();
        }

        competitor.setTotalScore(competitor.getTotalScore() - competition.getScore());
        competition.getCompetitors().remove(competitor);
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        return this.competitors
                .stream()
                .filter(c -> c.getTotalScore() > min && c.getTotalScore() <= max)
                .sorted(Comparator.comparingInt(Competitor::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Competitor> getByName(String name) {
        List<Competitor> competitors = this.competitors
                .stream()
                .filter(c -> c.getName().equals(name))
                .sorted(Comparator.comparingInt(Competitor::getId))
                .collect(Collectors.toList());
        if (competitors.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return competitors;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        return this.competitors
                .stream()
                .filter(c -> c.getName().length() >= minLength && c.getName().length() <= maxLength)
                .sorted(Comparator.comparingInt(Competitor::getId))
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
    public int competitorsCount() {
        return this.competitors.size();
    }

    @Override
    public Competition getCompetition(int id) {
        for (Competition competition : this.competitions) {
            if (competition.getId() == id) {
                return competition;
            }
        }
        throw new IllegalArgumentException();
    }

    public Competitor getCompetitor(int id) {
        for (Competitor competitor : this.competitors) {
            if (competitor.getId() == id) {
                return competitor;
            }
        }
        throw new IllegalArgumentException();
    }

}
